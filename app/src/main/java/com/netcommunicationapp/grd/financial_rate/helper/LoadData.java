package com.netcommunicationapp.grd.financial_rate.helper;

import android.app.Activity;
import android.util.Log;

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

import static com.netcommunicationapp.grd.financial_rate.common.CommonResources.FILENAME;

/**
 * Created by Cosmos on 24.02.2017.
 */

//NOT USING PROBLEM WITH STATIC VAR
public class LoadData extends Activity{

    public static String LOG_TAG = "LoadData _log";
    boolean readyLoadData = false;
    LoadData(){}

    //-----------------------------------------------------
    public Boolean getDataURL2(String hostData){

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
                Log.d(LOG_TAG,"----------=line is  = "+line);

            }

            resultJson = buffer.toString();

            res = true;
            //---------------save in file (private_app_Storage)----------------------

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    openFileOutput(FILENAME, MODE_PRIVATE)));

            bw.write("");
            Log.d(LOG_TAG,"----------bw.write clear = ");
            bw.write(resultJson.toString());
            Log.d(LOG_TAG,"----------bw.write  = "+resultJson.toString());
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
}
