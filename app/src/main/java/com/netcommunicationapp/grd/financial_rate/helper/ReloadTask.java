package com.netcommunicationapp.grd.financial_rate.helper;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.netcommunicationapp.grd.financial_rate.common.CommonResources;

import static com.netcommunicationapp.grd.financial_rate.common.CommonResources.hostDataCurrency;

/**
 * Created by grd on 9/25/17.
 */

public  class ReloadTask extends AsyncTask<Void, Void, String> {

    private static String LOG_TAG = "ReloadTask_log";
    private Context context;

    public ReloadTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Void... params) {

        Log.d(LOG_TAG, " doInBackground  -------ReloadTask---------------------- ");
       new URLHelper(context).getDataURLUpdate(hostDataCurrency);
       // new URLHelper(context).getDataURL1(CommonResources.hostDataCurrency);

        String  localJson = new FileHelper(context).readJSONOfFile(CommonResources.FILENAME);
        new ParserDataCurrency().doParceGSON(localJson);

        String resultJson = "";
        return resultJson ;
    }
    @Override
    protected void onPostExecute(String strJson) {
        super.onPostExecute(strJson);

    }

}//end task