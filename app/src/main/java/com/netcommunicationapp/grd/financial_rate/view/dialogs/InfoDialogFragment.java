package com.netcommunicationapp.grd.financial_rate.view.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.util.Linkify;
import android.util.Log;

import com.netcommunicationapp.grd.financial_rate.R;


/**
 * Created by grd on 1/23/17.
 */

public class InfoDialogFragment extends DialogFragment {
    final String LOG_TAG = "InfoDialogFrag";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final SpannableString link = new SpannableString("https://finance.yahoo.com/");
        Linkify.addLinks(link, Linkify.ALL);

        builder.setTitle(getResources().getString(R.string.data_info))
                 .setMessage(link)

                .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                }) .setPositiveButton(getResources().getString(R.string.follow_the_link), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://finance.yahoo.com/"));
                getActivity().startActivity(i);
                getDialog().dismiss();
            }
        });

        return builder.create();
    }

    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        Log.d("InfoDialog", "Dialog 1: onDismiss");
    }

    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Log.d("InfoDialog", "Dialog 1: onCancel");
    }
}
