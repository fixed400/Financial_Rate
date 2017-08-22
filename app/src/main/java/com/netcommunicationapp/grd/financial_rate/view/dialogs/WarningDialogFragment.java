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

import com.netcommunicationapp.grd.financial_rate.R;


// предуприеждающий вход
public class WarningDialogFragment extends DialogFragment {

    final String LOG_TAG = "myLogs";

   // @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder


                .setTitle(getResources().getString(R.string.warming))
                .setMessage(getResources().getString(R.string.danger_info))
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {


                        // ((PreViewerActivity) getActivity()).tryAgainToGetConnection();
                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

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