package com.netcommunicationapp.grd.financial_rate.helper;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.netcommunicationapp.grd.financial_rate.view.IView;
import com.netcommunicationapp.grd.financial_rate.common.CommonResources;
import com.netcommunicationapp.grd.financial_rate.view.CurrencyListFragment;

import java.io.File;

/**
 * Created by grd on 9/25/17.
 */

public class ParseTask extends AsyncTask<Void, Void, String> {


    private static String LOG_TAG = "ParseTask_log";

    private Context context;

    private CurrencyListFragment fragment;

    public ParseTask(Context context) {
        this.context = context;

    }

    public ParseTask(Context context,CurrencyListFragment fragment) {
        this.context = context;
        this.fragment = fragment;
    }

    @Override
    protected String doInBackground(Void... params) {


        String  localJson = new FileHelper(context).readJSONOfFile(CommonResources.FILENAME);
        String  localJson2 = new FileHelper(context).readJSONOfFile2(CommonResources.FILENAME2);
        String  localJson3 = new FileHelper(context).readJSONOfFile3(CommonResources.FILENAME3);

        //if(localJson == null)
        if(localJson == null&&localJson2 == null&&localJson3 == null)
        {
            Log.d(LOG_TAG, " doInBackground  localJson == null ");
            Log.d(LOG_TAG, " NO DATA ");
        }else{
            new ParserDataCurrency().doParceGSON(localJson);
            new ParserDataCommodities().doParceGSONCommodities(localJson2);
            new ParserDataShare().doParceGSONShare(localJson3);
        }

        String resultJson = "";
        return resultJson ;
    }
    @Override
    protected void onPostExecute(String strJson) {
        super.onPostExecute(strJson);

        IView iView;
        iView = fragment;

        iView.loadList();

        File f = context.getFileStreamPath(CommonResources.FILENAME);
        if(f.length() != 0) {
            Log.d(LOG_TAG, " DATA received ");
        }else{

            iView.showNotice();

        }
    }

}//end task