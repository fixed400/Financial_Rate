package com.netcommunicationapp.grd.financial_rate.view;

import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.netcommunicationapp.grd.financial_rate.common.CommonResources;
import com.netcommunicationapp.grd.financial_rate.MainNavigationDrawerActivity;
import com.netcommunicationapp.grd.financial_rate.R;
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
import java.util.Timer;
import java.util.TimerTask;

public final  class PreViewerActivity extends AppCompatActivity {

    public static String LOG_TAG = "PreViewerActivity_log";
    ProgressDialog PD;
    boolean readyLoadData = false;

    Timer timer;  // Class whitch the consider (count) time;
    TimerTask mMyTimerTask ;  //Class for exetute tasks

    int inspectionTime =2100;
    TextView textView;
    Button btn;

    Boolean accessUrlConnect = null;
    ProgressBar progressBarCircle;
    private final static String FILENAME = "my_sample.txt"; // имя файла

    WaiterAsync waierTask =new WaiterAsync();
    //----------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //чтоб не вылетало при повороте
        setContentView(R.layout.activity_pre_viewer);

        progressBarCircle = (ProgressBar) findViewById(R.id.pbc);
        progressBarCircle.setVisibility(View.VISIBLE);

        textView =(TextView) findViewById(R.id.textView);

       // btn =(Button) findViewById(R.id.buttonExit);


        //DialogFragment wDialog = new WarningDialogFragment();
        //wDialog.show(getFragmentManager(), "AtentionApp");

    }//--End onCreate

    public void exitApp(View v){
        //this.finish();

        onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "MainActivity: onStart()");

        new WaiterAsync().execute();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "MainActivity: onResume()");
        // реализовать  ожидание с progressBAR
    }

    public void checkNetCommunication(){
        Intent i = new Intent(PreViewerActivity.this, MainNavigationDrawerActivity.class);
        startActivity(i);

        finish();//закроет ту активность, в которой он вызван
    }

    //-----------------------------------------------------
    private Boolean getDataURL1(String hostData){

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
                    openFileOutput(FILENAME, MODE_PRIVATE)));

            bw.write(resultJson.toString());
            bw.flush();
            bw.close();
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

    //-----------------------------------------------------
    private Boolean getDataURL1Test(String hostData){

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
            /*
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
            */
            resultJson = CommonResources.testJsonData;

            res = true;
            //---------------save in file (private_app_Storage)----------------------

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    openFileOutput(FILENAME, MODE_PRIVATE)));

            bw.write(resultJson.toString());
            bw.flush();
            bw.close();
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

    public void tryAgainToGetConnection() {

        //Toast.makeText(this,"Not Connection !  \n TryAgain ",Toast.LENGTH_LONG).show();
        new WaiterAsync().execute();
    }

    public void closeAppRate() {

        Toast.makeText(this,"CLOSE ",Toast.LENGTH_LONG).show();
        progressBarCircle.setVisibility(View.VISIBLE);
        finish();

    }


// ----------------------------------------------------------------------------------------
    private class WaiterAsync extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected void onPreExecute() {
            //alertDialogFragment =null; // для тоого чтобы не добовлся второй раз
            //PD = null;
            // TODO Auto-generated method stub
            super.onPreExecute();
            try {
                int num =5;
                if (accessUrlConnect != null || true && num == 4) {
                    PD = new ProgressDialog(PreViewerActivity.this);
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

        //Don't try to touch UI from doInBackground(....) becouse app may crash.
        @Override
        protected Boolean doInBackground(Void... params) {


            Boolean answer =null;
            try {

                //answer=getDataURL1(CommonResources.hostData);
                answer=getDataURL1Test(CommonResources.testHost);
                //answer=LoadData.getDataURL2(CommonResources.hostData);
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

            //if data have been loaded follow next Actitvity or repeat connection
            if(result){
                Log.d(LOG_TAG, "WaiterAsync: onPostExecute() Boolean result)" +result);
                progressBarCircle.setVisibility(View.GONE);

                //close app
                if(CommonResources.endMainActitvity==false) {
                    checkNetCommunication();
                }
                else{
                    CommonResources.endMainActitvity=false;
                    onDestroy();
                }

            }else{
                Log.d(LOG_TAG,"Данные не получены ");
                textView.setText(R.string.Failure_of_the_connection);
                inspectionTime=8000;

                DialogFragment alertDialogFragmentRepeat = new AlertDialogFragment();
                alertDialogFragmentRepeat.show(getFragmentManager(), "myAlertFRAGMENT");
            }
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();

            Log.d(LOG_TAG, "Cancel");

        }
    }

//================================================================================================


    //OnDestroy () недеструктор . Это на самом деле не разрушить объект
    @Override
    protected void onDestroy() {

        super.onDestroy();
        Log.d(LOG_TAG, "MainActivity: onDestroy()");


    }

}
