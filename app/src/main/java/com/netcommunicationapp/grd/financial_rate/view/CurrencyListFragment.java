package com.netcommunicationapp.grd.financial_rate.view;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
//import android.support.v4.app.ListFragment;
import android.app.ListFragment;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;


import com.netcommunicationapp.grd.financial_rate.common.CommonResources;
import com.netcommunicationapp.grd.financial_rate.view.adapter.CustomListArrayAdapter;

import com.netcommunicationapp.grd.financial_rate.helper.ParserDateCurrency;
import com.netcommunicationapp.grd.financial_rate.R;

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
import static com.netcommunicationapp.grd.financial_rate.common.CommonResources.hostData;


//import android.support.v4.app.Fragment;
//import android.Fragment;

/* *
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
//Toast.makeText(getActivity(),getResources().getString(R.string.info_check_connection) , Toast.LENGTH_LONG).show();
public class CurrencyListFragment extends ListFragment {


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
    private int loop = 0;
    // --------------------------------------------------------------------------------------------
    private final static String FILENAME = CommonResources.FILENAME; // имя файла
    ArrayList<HashMap<String, String>> myList = new ArrayList<HashMap<String, String>>();
    Timer timer;
    int loopTimer = 0;
    private Handler handler = new Handler();
    private SwipeRefreshLayout mSwipeRefreshLayout;
    byte limitUpdates = 0; //restriction (limit) the updates manuall
    boolean readyLoadData = false;
    // --------------------------------------------------------------------------------------------
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //---------------------------------------------------------------
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
        View view = inflater.inflate(R.layout.list_fragment, null);
        //-----------------------------------------------------
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.setRefreshing(true);
                ( new Handler()).postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        limitUpdates++;

                        if(limitUpdates < 120){
                            //new ParserDateCurrency().doParceGSON
                           // if(checkInternet)
                            //-----------------------check internet-------------------------
                            ConnectivityManager cn=(ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
                             NetworkInfo nf=cn.getActiveNetworkInfo();
                            //---------------------------------------------------------------
                            if(nf != null && nf.isConnected()==true ) {

                                Log.d(LOG_TAG, " NetworkInfo ----------- "+nf);
                                Log.d(LOG_TAG, " nf.isConnected()------------ "+nf.isConnected());
                                //PreViewerActivity
                               // LoadData.getDataURL2(CommonResources.hostData);

                               // new ParserDateCurrency().doParceGSON(readJSONOfFile(FILENAME));

                                ReloadTask reloadTask = new ReloadTask();
                                reloadTask.execute();
                                reLoadList();
                                //reload
                                Toast.makeText(getActivity(),getResources().getString(R.string.reload),Toast.LENGTH_SHORT).show();
                                //showAttention();
                            }else {
                                Intent intent = new Intent(getActivity(), PreViewerActivity.class);
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

        //showAttention();

       // return inflater.inflate(R.layout.list_fragment, null);
        return view;
         //return inflater.inflate(R.layout.list_fragment, null);
    }

    /*
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Toast.makeText(getActivity(),
                getListView().getItemAtPosition(position).toString(),
                Toast.LENGTH_LONG).show();
    }
    */
    //===============================My mehods ==========================================

    //--------------------------------------------------------------------------------------
    public void startGetData(){
     // Организовать обновление в сервисе -  иначе при обновлении будет ссылка на несуществующий объект AndrodAOS убьет Activity
        // когда приложение будет не в фокусе
        //  вылетает после обновления таймера
        // java.lang.NullPointerException: Attempt to invoke virtual method 'void android.app.Activity.runOnUiThread(java.lang.Runnable)' on a null object reference

        //ВЫЛЕТАЕТ ПРИ ПОПЫТКЕ ОБНОВЛЕНИЯ!!!
       /* if(CommonResources.update_frequency > 300000) {
           //  if(CommonResources.update_frequency > 3000) {
            timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    loop++;
                    Log.d(LOG_TAG, " TimeTask попытка обновить  данные  = "+loop);
                    // https://developer.android.com/reference/android/app/Activity.html#runOnUiThread(java.lang.Runnable)
                    // getActivity().runOnUiThread(new Runnable() {
                    getActivity().runOnUiThread(new Runnable() { // !!!can fall- java.lang.NullPointerException: --- java.lang.NullPointerException: Attempt to invoke virtual method 'void android.app.Activity.runOnUiThread(java.lang.Runnable)' on a null object reference
                        @Override
                        public void run() {
                            loopTimer++;
                            ParseTask parseTask = new ParseTask();
                            parseTask.execute();

                        }
                    });
                    Log.d(LOG_TAG, " TimeTask  данные обновленны = "+loop);
                }
            };
            //15 min
            timer.schedule(task, 0, CommonResources.update_frequency);//lимит 2000 запросов!!!
            // onse on the hour 1 request for 60 min
            // timer.schedule(task, 0, 3600100);//lимит 2000 запросов!!!

        }else{
            Log.d(LOG_TAG, " Unacceptable update frequency! ");
            Toast.makeText(getActivity(), "Unacceptable update frequency!  \n Reload appilcation ", Toast.LENGTH_LONG).show();

        }
        */
        //-----------------------------------
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                loop++;
                Log.d(LOG_TAG, " TimeTask попытка получить   данные в потоке = "+loop);
                // https://developer.android.com/reference/android/app/Activity.html#runOnUiThread(java.lang.Runnable)
                // getActivity().runOnUiThread(new Runnable() {
                getActivity().runOnUiThread(new Runnable() { // !!!can fall- java.lang.NullPointerException: --- java.lang.NullPointerException: Attempt to invoke virtual method 'void android.app.Activity.runOnUiThread(java.lang.Runnable)' on a null object reference
                    @Override
                    public void run() {
                        loopTimer++;
                        ParseTask parseTask = new ParseTask();
                        parseTask.execute();

                    }
                });
                Log.d(LOG_TAG, " TimeTask  данные получены в потоке = "+loop);
            }
        };
        //15 min
        timer.schedule(task, 0);
    }
        //-----------------------------------------------
        public String readJSONOfFile(String file_data) {

            String res ="Something...";
            //проверка на существование записи в файле
            File f = getActivity().getFileStreamPath(file_data);//some FILENAME
            if (f.length() != 0) {
                try {
                    InputStream inputStream = getActivity().openFileInput(FILENAME);
                    InputStreamReader isr = new InputStreamReader(inputStream);
                    BufferedReader bfReader = new BufferedReader(isr);

                    StringBuffer buffer = new StringBuffer();
                    String line ="";

                    while ((line = bfReader.readLine()) != null) {
                        buffer.append(line);
                    }
                    res = buffer.toString();
                    bfReader.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else{

                Log.d(LOG_TAG, "Файл пустой ! Обновите данные из сети. ");
                res = null;
            }
            return res;
        }

    //--------------------------------------------------------------------------------------
    //============================== list =========================
    public void loadList() {


        CustomListArrayAdapter myListAdapter = new CustomListArrayAdapter(getActivity(),
                //or import static CommonResources.arrayDateTickers;
                R.layout.list_fragment_row, CommonResources.arrayNameTickers, CommonResources.arrayRateTickers, CommonResources.arrayDateTickers, CommonResources.arrrayTimeTickers);
        setListAdapter(myListAdapter);


        //Toast.makeText(getActivity(),getResources().getString(R.string.sory) , Toast.LENGTH_LONG).show();

        //--------------- Animation --------------------------

        if( CommonResources.showAnimation == true)
        {
            Animation animation = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.scaling2);
            LayoutAnimationController controller = new LayoutAnimationController(animation); //Заказать настройки дисплея управления
            controller.setOrder(LayoutAnimationController.ORDER_NORMAL); //Descend - step down - move down
            controller.setDelay((float) 0.7);
            getListView().setLayoutAnimation(controller);
            getListView().startLayoutAnimation();
        }
        //else {reLoadList();}

        // not using animation when app is running
        CommonResources.showAnimation = false;
        //---------------------------------------------
    }
    //------------------------------------2----------------------
    public void reLoadList(){

        CustomListArrayAdapter myListAdapter = new CustomListArrayAdapter(getActivity(),
                //or import static CommonResources.arrayDateTickers;
                R.layout.list_fragment_row,  CommonResources.arrayNameTickers, CommonResources.arrayRateTickers, CommonResources.arrayDateTickers, CommonResources.arrrayTimeTickers);
        setListAdapter(myListAdapter);

        //--------------- Animation --------------------------
        Animation animation= AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.scaling4);
        LayoutAnimationController controller = new LayoutAnimationController(animation); //Заказать настройки дисплея управления
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL); //Descend - step down - move down
        controller.setDelay((float) 0.4);
        getListView().setLayoutAnimation(controller);
        getListView().startLayoutAnimation();
        //---------------------------------------------
    }
    //===============================================================
    //--------------------------------------------------------------------------------------
    public void showNotice() {
        Log.d(LOG_TAG, " ========== Проверте подключение к интернет. =================");
        // U-------------------------
        handler.post(new Runnable() {
            @Override
            public void run() {
                //Toast.makeText(getActivity(), "Проверте подключение к интернет. \nOбновите данные", Toast.LENGTH_LONG).show();
                //info_check_connection
                Toast.makeText(getActivity(),getResources().getString(R.string.info_check_connection) , Toast.LENGTH_LONG).show();
            }

        });
    }
    // ================================ AsyncTask ==========================================
    private  class ParseTask extends AsyncTask<Void, Void, String> {
        // private static class ParseTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {


            String  localJson = readJSONOfFile(FILENAME);
            if(localJson == null)
            {
                Log.d(LOG_TAG, " doInBackground  localJson == null ");
                Log.d(LOG_TAG, " NO DATA ");
            }else{
                 new ParserDateCurrency().doParceGSON(localJson);
            }

            String resultJson = "";
            return resultJson ;
        }
        @Override
        protected void onPostExecute(String strJson) {
            super.onPostExecute(strJson);

            loadList();

            File f = getActivity().getFileStreamPath(FILENAME);//some FILENAME
            if(f.length() != 0) {

            }else{
                showNotice();

            }
        }

    }//end task

   // Log.d(LOG_TAG, " doInBackground  ----------------------------- ");
  //  getDataURL3(hostData);

    private  class ReloadTask extends AsyncTask<Void, Void, String> {
        // private static class ParseTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {

             Log.d(LOG_TAG, " doInBackground  -------ReloadTask---------------------- ");
              getDataURL3(hostData);

            String  localJson = readJSONOfFile(FILENAME);



                new ParserDateCurrency().doParceGSON(localJson);


            String resultJson = "";
            return resultJson ;
        }
        @Override
        protected void onPostExecute(String strJson) {
            super.onPostExecute(strJson);

        }

    }//end task

    //-----------------------repeat code (becouse work from UI----------------------------
    //-----------------------------------------------------
    public Boolean getDataURL3(String hostData){
        Log.d(LOG_TAG,"------==============----getDataURL3 = ");
        Boolean res=false;

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String resultJson = "";

        try {

            URL url = new URL(hostData);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            //...............................................................
            InputStream inputStream = urlConnection.getInputStream();
            readyLoadData=true;
            // accessUrlConnect2=true;
            StringBuffer buffer = new StringBuffer();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            //...............................................................
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
                //resultJson = line;
                Log.d(LOG_TAG,"%%%%%%%%###=line is  = "+line);

            }

            resultJson = buffer.toString();

            res = true;
            //---------------save in file (private_app_Storage)----------------------

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    getActivity().openFileOutput(FILENAME, MODE_PRIVATE)));


           //bw.write("");
           // bw.close();
           // Log.d(LOG_TAG,"----------bw.write clear = ");
            bw.write(resultJson.toString());
            //Log.d(LOG_TAG,"----------bw.write  = "+resultJson.toString());
            bw.flush();
            bw.close();
            Log.d(LOG_TAG,"---------to be up to date ");
            //---------------------------------------------------


        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "MalformedURLException: " + e.getMessage());
        } catch (ProtocolException e) {
            Log.e(LOG_TAG, "ProtocolException: " + e.getMessage());

            res = false;
            //    showNotice();
        } catch (IOException e) {
            Log.e(LOG_TAG, "IOException: " + e.getMessage());
            Log.d(LOG_TAG,"Данные не получены Exception loadJSONOfWeb() "+e.getMessage());

            res = false;

        } catch (Exception e) {
            Log.e(LOG_TAG, "Exception: " + e.getMessage());
            res = false;

        }

        return res;
    } //--End loadJSONOfWeb();
    //---------------------------------------------------
    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, " --- CurrencyListFragment   onResume() ");


    }

    public void onDestroyView() {
        super.onDestroyView();
        Log.d(LOG_TAG, "CurrencyListFragment onDestroyView");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "CurrencyListFragment onDestroy");
       // CommonResources.showAnimation = true;
    }

    public void onDetach() {
        super.onDetach();
        Log.d(LOG_TAG, "CurrencyListFragment onDetach");
    }

}
