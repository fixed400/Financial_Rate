package com.netcommunicationapp.grd.financial_rate;

import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.netcommunicationapp.grd.financial_rate.common.CommonResources;
import com.netcommunicationapp.grd.financial_rate.helper.URLHelper;
import com.netcommunicationapp.grd.financial_rate.view.dialogs.AlertDialogFragment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public final  class PreLoaderActivity extends AppCompatActivity {

    private String LOG_TAG = "PreViewerActivity_log";
    private final static String FILENAME = "my_sample.txt";
    private  boolean visibleOnScreen = false;
    ProgressDialog PD;
    ProgressBar progressBarCircle;
    boolean readyLoadData = false;
    Boolean accessUrlConnect = null;
    int inspectionTime =2100;
    TextView textView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_pre_viewer);

        context = PreLoaderActivity.this;

        progressBarCircle = (ProgressBar) findViewById(R.id.pbc);
        progressBarCircle.setVisibility(View.VISIBLE);

        textView =(TextView) findViewById(R.id.textView);

        CommonResources.visibleOnScreen=true;


    }//--End onCreate

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart()");
        new WaiterAsync().execute();

    }
    @Override
    protected void onPause() {
        super.onPause();
        CommonResources.visibleOnScreen = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume()");
        CommonResources.visibleOnScreen = true;
    }

    public void checkNetCommunication(){
        Intent i = new Intent(PreLoaderActivity.this, MainNavigationDrawerActivity.class);
        startActivity(i);

        finish();
    }


    public void tryAgainToGetConnection() {
        new WaiterAsync().execute();
    }

    public void closeApp() {

        Toast.makeText(this,"Cloce ",Toast.LENGTH_LONG).show();
        progressBarCircle.setVisibility(View.VISIBLE);
        finish();
    }

// --------------------------------------------------------------------
    private class WaiterAsync extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            try {
                int num =5;
                if (accessUrlConnect != null || true && num == 4) {
                    PD = new ProgressDialog(PreLoaderActivity.this);
                    PD.setTitle("Please Wait..");
                    PD.setMessage("Loading...");
                    PD.setCancelable(false);
                    PD.show();
                }
            }catch (RuntimeException e){
                System.out.printf("RunTIME EXCEPTION"+e.getMessage());
                e.printStackTrace();
                Log.d(LOG_TAG,"Boolean is NULL");

            }catch (Exception e){
                System.out.printf(" Common EXCEPTION"+e.getMessage());
                e.printStackTrace();
            }
        }

        @Override
        protected Boolean doInBackground(Void... params) {

            Boolean answer =null;
            try {
                answer= new URLHelper(context).getDataURL1(CommonResources.hostDataCurrency);
                answer= new URLHelper(context).getDataURL2(CommonResources.hostDataCommodities);
                answer= new URLHelper(context).getDataURL3(CommonResources.hostDataShares);
                //Pause for repeat request
                Thread.sleep(inspectionTime);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return answer;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);

            //if data have been loaded follow next Activity or repeat connection
            if(result){
                Log.d(LOG_TAG, "WaiterAsync: onPostExecute() Boolean result)" +result);
                progressBarCircle.setVisibility(View.GONE);

                if(CommonResources.endMainActitvity==false) {
                    checkNetCommunication();
                }
                else{
                    CommonResources.endMainActitvity=false;
                    onDestroy();
                }
            }else{
                Log.d(LOG_TAG, "Данные не получены ");
                if (textView != null &&  CommonResources.visibleOnScreen == true){
                    textView.setText(R.string.Failure_of_the_connection);
                    DialogFragment alertDialogFragmentRepeat = new AlertDialogFragment();
                    alertDialogFragmentRepeat.show(getFragmentManager(), "myAlertFRAGMENT");
                }
                inspectionTime=8000;
            }
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            Log.d(LOG_TAG, "Cancel");
        }
    }

    @Override
    protected void onDestroy() {

        CommonResources.visibleOnScreen = false;

        super.onDestroy();
        Log.d(LOG_TAG, "MainActivity: onDestroy()");


    }

}
