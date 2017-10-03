package com.netcommunicationapp.grd.financial_rate.helper;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;

import com.netcommunicationapp.grd.financial_rate.common.CommonResources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by grd on 9/25/17.
 */

public class FileHelper extends ContextWrapper{

    private static String LOG_TAG = "FileHelper_log";

    private Context context = getApplicationContext();


    public FileHelper(Context base) {
        super(base);
        context = base;
    }

    public FileHelper(Context base, Context context) {
        super(base);
        this.context = context;
    }

    public String readJSONOfFile(String file_data) {

        String res ="Something...";

        File f = context.getFileStreamPath(file_data);
        if (f.length() != 0) {
            try {
                InputStream inputStream = context.openFileInput(CommonResources.FILENAME);
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
    //===========================2=========================
    public String readJSONOfFile2(String file_data) {

        String res ="Something...";

        File f = context.getFileStreamPath(file_data);
        if (f.length() != 0) {
            try {
                InputStream inputStream = context.openFileInput(CommonResources.FILENAME2);
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
    //===========================3=========================
    public String readJSONOfFile3(String file_data) {

        String res ="Something...";

        File f = context.getFileStreamPath(file_data);
        if (f.length() != 0) {
            try {
                InputStream inputStream = context.openFileInput(CommonResources.FILENAME3);
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
    //=====================================================

}
