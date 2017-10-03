package com.netcommunicationapp.grd.financial_rate.view;


import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
//import android.support.v4.app.ListFragment;
import android.app.ListFragment;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ListView;
import android.widget.Toast;


import com.netcommunicationapp.grd.financial_rate.helper.ParseTask;
import com.netcommunicationapp.grd.financial_rate.helper.ReloadTask;
import com.netcommunicationapp.grd.financial_rate.common.CommonResources;

import com.netcommunicationapp.grd.financial_rate.PreLoaderActivity;
import com.netcommunicationapp.grd.financial_rate.R;
import com.netcommunicationapp.grd.financial_rate.view.adapter.CustomListArrayAdapter;
import com.netcommunicationapp.grd.financial_rate.view.adapter.CustomListArrayAdapterHolder;
import com.netcommunicationapp.grd.financial_rate.view.dialogs.ReferenceDialogFragment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import static android.content.Context.MODE_PRIVATE;

public class CurrencyListFragment extends ListFragment implements IView {

    /*
    onAttach(Activity)
Вызывается, когда фрагмент связывается с активностью.
С этого момента мы можем получить ссылку на активность через метод getActivity()

onCreate()
В этом методе можно сделать работу, не связанную с интерфейсом. Например, подготовить адаптер.

onCreateView(LayoutInflater, ViewGroup, Bundle)
Вызывается для создания компонентов внутри фрагмента

onActivityCreated(Bundle)
Вызывается, когда отработает метод активности onCreate(), а значит фрагмент может обратиться к компонентам активности

onDestroyView()
Вызывается, когда набор компонентов удаляется из фрагмента

onDetach()
Вызывается, когда фрагмент отвязывается от активности
     */

    public static String LOG_TAG = "CurrencyListFrag_log";
    private final static String FILENAME = CommonResources.FILENAME;
    private final static String FILENAME2 = CommonResources.FILENAME2;
    private final static String FILENAME3 = CommonResources.FILENAME3;

    // --------------------------------------------------------------------------------------------

    ArrayList<HashMap<String, String>> myList = new ArrayList<HashMap<String, String>>();
    Timer timer;
    private int loop = 0;
    private int loopTimer = 0;
    private byte limitUpdates = 0; //restriction (limit) the updates manuall
    private Handler handler = new Handler();
    private SwipeRefreshLayout mSwipeRefreshLayout;

    boolean readyLoadData = false;
    // --------------------------------------------------------------------------------------------
    public boolean allowAnimation;
    SharedPreferences mySharedPreferences;
    private String listChooserItem;
    private int animId;
    // --------------------------------------------------------------------------------------------

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Thread t = new Thread(new Runnable() {
            public void run() {
                loopTimer++;
                startGetData();
                Log.d(LOG_TAG, " loadedURL "+loopTimer);
            }
        });
        t.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list_fragment, null);

        //----------------------Swipe-------------------------------
        mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.setRefreshing(true);
                ( new Handler()).postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        limitUpdates++;

                        if(limitUpdates < 120){

                            //-----------------------check internet-------------------------
                            NetworkInfo networkInfo =null;
                            try {
                                ConnectivityManager cn = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
                                networkInfo = cn.getActiveNetworkInfo();
                            }catch (Exception e){
                                System.out.println(e.getMessage());
                                System.out.println(e.getStackTrace());
                            }
                            //---------------------------------------------------------------
                            if(networkInfo != null && networkInfo.isConnected()==true ) {

                                ReloadTask reloadTask = new ReloadTask(getActivity());
                                reloadTask.execute();
                                reLoadList();
                                Toast.makeText(getActivity(),getResources().getString(R.string.reload),Toast.LENGTH_SHORT).show();

                            }else {
                                Intent intent = new Intent(getActivity(), PreLoaderActivity.class);
                                startActivity(intent);
                            }
                        }else {
                            Toast.makeText(getActivity(),"You used limit updates.\nPlease restart app.",Toast.LENGTH_SHORT).show();
                        }
                        Log.d(LOG_TAG, " limitUpdates "+limitUpdates+" times ");
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 4500);
            }
        });

        return rootView;

    }

    //=========================================================

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Toast.makeText(getActivity(),
                getListView().getItemAtPosition(position).toString(),
                Toast.LENGTH_SHORT).show();
        Log.d(LOG_TAG, " pos is "+position);

        DialogFragment referenceDialogFragment = new ReferenceDialogFragment().newInstance(position);
        referenceDialogFragment.show(getFragmentManager(), "RefDialog");


    }

    //--------------------------------------------------------------------------------------
    public void startGetData(){

        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                loop++;
                Log.d(LOG_TAG, " TimeTask попытка получить   данные в потоке = "+loop);
                getActivity().runOnUiThread(new Runnable() { // !!!can fall- java.lang.NullPointerException: --- java.lang.NullPointerException: Attempt to invoke virtual method 'void android.app.Activity.runOnUiThread(java.lang.Runnable)' on a null object reference
                    @Override
                    public void run() {
                        loopTimer++;
                        ParseTask parseTask = new ParseTask(getActivity(),CurrencyListFragment.this);
                        parseTask.execute();

                    }
                });
                Log.d(LOG_TAG, " TimeTask  данные получены в потоке = "+loop);
            }
        };
        //15 min
        timer.schedule(task, 0);
    }


    //--------------------------------------------------------------------------------------
    public  void loadSettingsAnimation() {

        loadPref();
        String listValue = mySharedPreferences.getString("list_chooser", "scaling_increase");

        listChooserItem =listValue;

        switch (listValue){
            case "1" :
                animId =  R.anim.scaling_increase;
                break;
            case "2":
                animId =  R.anim.scaling_protrusion;
                break;
            case "3":
                animId =  R.anim.scaling_descent;
                break;
            default:
                animId =  R.anim.scaling_increase;
        }
    }

    private  void loadPref(){
        mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        //boolean getBoolean(String key, boolean defValue);
        boolean my_checkbox_preference = mySharedPreferences.getBoolean("check_box", false);
        allowAnimation=my_checkbox_preference;
    }

    //============================== list =========================
    @Override
    public  void loadList() {
        CustomListArrayAdapterHolder arrayAdapter = new CustomListArrayAdapterHolder(getActivity(),
                R.layout.list_fragment_row, CommonResources.arrayNameTickers, CommonResources.arrayRateTickers, CommonResources.arrayDateTickers, CommonResources.arrrayTimeTickers);
        setListAdapter(arrayAdapter);

        //--------------restore  list positiom-----------------
      // /*
       if(CommonResources.index!=-1){

            this.getListView().setSelectionFromTop(CommonResources.index,CommonResources.top);
        }
        //--------------- Animation --------------------------

        if (CommonResources.repeatAnimation == true) {

            loadSettingsAnimation();
            Animation animation = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), animId);

            if (allowAnimation) {
                LayoutAnimationController controller = new LayoutAnimationController(animation);
                controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
                controller.setDelay((float) 0.7);
                getListView().setLayoutAnimation(controller);
                getListView().startLayoutAnimation();
            }

        }
        // not using animation when app is running
        CommonResources.repeatAnimation = false;
    }
    //------------------------------------2----------------------
    public void reLoadList(){

        CustomListArrayAdapter arrayAdapter = new CustomListArrayAdapter(getActivity(),
                R.layout.list_fragment_row,  CommonResources.arrayNameTickers, CommonResources.arrayRateTickers, CommonResources.arrayDateTickers, CommonResources.arrrayTimeTickers);
        setListAdapter(arrayAdapter);

        //--------------- Animation --------------------------
        Animation animation= AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.scaling4);
        LayoutAnimationController controller = new LayoutAnimationController(animation);
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
        controller.setDelay((float) 0.4);
        getListView().setLayoutAnimation(controller);
        getListView().startLayoutAnimation();
        //---------------------------------------------
    }
    //===============================================================


    //--------------------------------------------------------------------------------------
    @Override
    public  void showNotice() {

        handler.post(new Runnable() {
            @Override
            public void run() {

                Toast.makeText(getActivity(),getResources().getString(R.string.info_check_connection) , Toast.LENGTH_LONG).show();
            }

        });
    }

    //---------------------------------------------------
    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, " --- CurrencyListFragment -- onResume() ");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "--CurrencyListFragment----onPause() ");

        CommonResources.index = this.getListView().getFirstVisiblePosition();
        View v = this.getListView().getChildAt(0);
        CommonResources.top = (v == null) ? 0 : v.getTop();

    }

    public void onDestroyView() {
        super.onDestroyView();
        Log.d(LOG_TAG, "--CurrencyListFragment --onDestroyView");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "--CurrencyListFragment ---onDestroy");

    }

    public void onDetach() {
        super.onDetach();
        Log.d(LOG_TAG, "--CurrencyListFragment ---onDetach");
    }

}
