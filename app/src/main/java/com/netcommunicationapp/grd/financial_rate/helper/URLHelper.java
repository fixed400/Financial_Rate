package com.netcommunicationapp.grd.financial_rate.helper;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
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
import static com.netcommunicationapp.grd.financial_rate.common.CommonResources.FILENAME2;
import static com.netcommunicationapp.grd.financial_rate.common.CommonResources.FILENAME3;

/**
 * Created by Cosmos on 24.02.2017.
 */


public class URLHelper extends ContextWrapper{

    public static String LOG_TAG = "URLHelper _log";
    boolean readyLoadData = false;

    Context context;

    public URLHelper(Context base) {
        super(base);
        this.context = base;
    }

    //-----------------------------------------------------

    //===================================1 Currency====================================
    public Boolean getDataURL1(String hostData){

        Boolean res=false;

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String resultJson = "";

        try {

            URL url = new URL(hostData);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            readyLoadData=true;

            StringBuffer buffer = new StringBuffer();
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            resultJson = buffer.toString();
            res = true;

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    openFileOutput(FILENAME, MODE_PRIVATE)));

            bw.write(resultJson.toString());
            bw.flush();
            bw.close();

        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "MalformedURLException: " + e.getMessage());
        } catch (ProtocolException e) {
            Log.e(LOG_TAG, "ProtocolException: " + e.getMessage());
            res = false;
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
    //===================================2 Commodities ====================================
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

            InputStream inputStream = urlConnection.getInputStream();
            readyLoadData=true;

            StringBuffer buffer = new StringBuffer();
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            resultJson = buffer.toString();
            res = true;

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    openFileOutput(FILENAME2, MODE_PRIVATE)));

            bw.write(resultJson.toString());
            bw.flush();
            bw.close();

        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "MalformedURLException: " + e.getMessage());
        } catch (ProtocolException e) {
            Log.e(LOG_TAG, "ProtocolException: " + e.getMessage());
            res = false;
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
    //===================================3 Shares ====================================
    public Boolean getDataURL3(String hostData){

        Boolean res=false;

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String resultJson = "";

        try {

            URL url = new URL(hostData);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            readyLoadData=true;

            StringBuffer buffer = new StringBuffer();
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            resultJson = buffer.toString();
            res = true;

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    openFileOutput(FILENAME3, MODE_PRIVATE)));

            bw.write(resultJson.toString());
            bw.flush();
            bw.close();

        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "MalformedURLException: " + e.getMessage());
        } catch (ProtocolException e) {
            Log.e(LOG_TAG, "ProtocolException: " + e.getMessage());
            res = false;
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
    //=======================================================================

    //-----------------------------------------------------
    public Boolean getDataURLUpdate(String hostData){
        Log.d(LOG_TAG,"------==============----getDataURLUpdate = ");
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

            }
            resultJson = buffer.toString();
            res = true;
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    context.openFileOutput(FILENAME, MODE_PRIVATE)));

            bw.write(resultJson.toString());
            bw.flush();
            bw.close();
            Log.d(LOG_TAG,"---------to be up to date ");
            //---------------------------------------------------


        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "MalformedURLException: " + e.getMessage());
        } catch (ProtocolException e) {
            Log.e(LOG_TAG, "ProtocolException: " + e.getMessage());

            res = false;

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
