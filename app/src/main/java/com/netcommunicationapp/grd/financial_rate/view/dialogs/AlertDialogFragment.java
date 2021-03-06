package com.netcommunicationapp.grd.financial_rate.view.dialogs;

/**
 * Created by grd on 1/19/17.
 */

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import com.netcommunicationapp.grd.financial_rate.PreLoaderActivity;
import com.netcommunicationapp.grd.financial_rate.R;


public class AlertDialogFragment extends DialogFragment {

    final String LOG_TAG = "AlertDialogFrag";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(getResources().getString(R.string.what_do))
                .setTitle(getResources().getString(R.string.Failure_of_the_connection))
                .setPositiveButton(getResources().getString(R.string.again), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                         ((PreLoaderActivity) getActivity()).tryAgainToGetConnection();
                    }
                })
                .setNeutralButton(getResources().getString(R.string.exit), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                       ((PreLoaderActivity) getActivity()).closeApp();
                    }
                });

        return builder.create();
    }

    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        Log.d(LOG_TAG, "Dialog 1: onDismiss");
    }

    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Log.d(LOG_TAG, "Dialog 1: onCancel");
    }
}