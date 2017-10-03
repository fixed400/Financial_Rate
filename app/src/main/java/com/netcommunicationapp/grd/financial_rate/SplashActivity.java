package com.netcommunicationapp.grd.financial_rate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;


public class SplashActivity extends Activity {

    public static String LOG_TAG = "SplashActivity_log";


    private static int SPLASH_TIME_OUT = 900;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

         /*
          * Showing splash screen with a timer. This will be useful when you
          * want to show case your app logo / company
          */

            @Override
            public void run() {

                Intent i = new Intent(SplashActivity.this, PreLoaderActivity.class);
                startActivity(i);


                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "MainActivity: onPause()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "MainActivity: onStop()");


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "MainActivity: onDestroy()");


    }
}