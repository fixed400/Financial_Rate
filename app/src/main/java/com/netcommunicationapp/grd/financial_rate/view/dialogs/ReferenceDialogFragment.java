package com.netcommunicationapp.grd.financial_rate.view.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.util.Linkify;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.netcommunicationapp.grd.financial_rate.R;

/**
 * Created by grd on 9/17/17.
 */

public class ReferenceDialogFragment extends DialogFragment {

    final String LOG_TAG = "ReferenceDialogFrag";

    private static int num;
    String reference ;

    public static ReferenceDialogFragment newInstance(int temp){
        ReferenceDialogFragment f = new ReferenceDialogFragment();
        num = temp;
        return f;
    };

    /**
     * Create a new instance of MyDialogFragment, providing "num"
     * as an argument.
     */
    static ReferenceDialogFragment newInstance1(int num) {
        ReferenceDialogFragment f = new ReferenceDialogFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        switch (num) {
           // case 0: reference = "https://finance.yahoo.com/quote/EURUSD=X?p=EURUSD=X"; break;
            case 0: reference = "https://ru.investing.com/currencies/eur-usd"; break;
            case 1: reference = "https://finance.yahoo.com/quote/GBPUSD=X?p=GBPUSD=X"; break;
            case 2: reference = "https://finance.yahoo.com/quote/BTCUSD=X?p=BTCUSD=X"; break;
           // case 2: reference = "https://ru.investing.com/currencies/btc-usd"; break;
            case 3: reference = "https://finance.yahoo.com/quote/ETHUSD=X?p=ETHUSD=X"; break;
            //case 3: reference = "https://ru.investing.com/currencies/eth-usd"; break;
            case 4: reference = "hhttps://finance.yahoo.com/quote/JPY=X?p=JPY=X"; break;
            case 5: reference = "https://finance.yahoo.com/quote/CHF=X?p=CHF=X"; break;
            case 6: reference = "https://finance.yahoo.com/quote/AUDUSD=X?p=AUDUSD=X"; break;
            case 7: reference = "hhttps://finance.yahoo.com/quote/CAD=X?p=CAD=X"; break;
            case 8: reference = "https://finance.yahoo.com/quote/CNH=X?p=CNH=X"; break;
            case 9: reference = "https://finance.yahoo.com/quote/PLN=X?p=PLN=X"; break;
            case 10: reference = "https://finance.yahoo.com/quote/RUB=X?p=RUB=X"; break;
            case 11: reference = "https://finance.yahoo.com/quote/UAH=X?p=UAH=X"; break;
            case 12: reference = "https://finance.yahoo.com/quote/EURGBP=X?p=EURGBP=X"; break;
            case 13: reference = "https://finance.yahoo.com/"; break;
            case 14: reference = "https://finance.yahoo.com/quote/EURPLN=X?p=EURPLN=X"; break;
            case 15: reference = "https://finance.yahoo.com/quote/EURRUB=X?p=EURRUB=X"; break;
            case 16: reference = "https://finance.yahoo.com/quote/EURUAH=X?p=EURUAH=X"; break;
            case 17: reference = "https://finance.yahoo.com"; break;
            case 18: reference = "https://finance.yahoo.com"; break;
            case 19: reference = "https://finance.yahoo.com"; break;
            case 20: reference = "https://finance.yahoo.com/quote/BYNRUB=X?p=BYNRUB=X"; break;
            case 21: reference = "https://finance.yahoo.com/quote/BYN=X?p=BYN=X"; break;
            case 22: reference = "https://finance.yahoo.com/quote/KZTRUB=X?p=KZTRUB=X"; break;
            case 23: reference = "https://finance.yahoo.com/quote/KZT=X?p=KZT=X"; break;
            case 24: reference = "https://finance.yahoo.com/quote/GEL=X?p=GEL=X"; break;
            case 25: reference = "https://finance.yahoo.com/quote/TRY=X?p=TRY=X"; break;
            case 26: reference = "https://finance.yahoo.com/quote/ILS=X?p=ILS=X"; break;
            case 27: reference = "https://finance.yahoo.com/quote/INR=X?p=INR=X"; break;
            case 28: reference = "https://finance.yahoo.com/quote/PKR=X?p=PKR=X"; break;
            case 29: reference = "https://finance.yahoo.com/quote/EGP=X?p=EGP=X"; break;
            case 30: reference = "https://finance.yahoo.com/quote/THB=X?p=THB=X"; break;
            case 31: reference = "https://finance.yahoo.com/quote/SGD=X?p=SGD=X"; break;
            case 32: reference = "https://finance.yahoo.com/quote/NZD=X?p=NZD=X"; break;
            case 33: reference = "https://finance.yahoo.com/quote/BRL=X?p=BRL=X"; break;
            case 34: reference = "https://finance.yahoo.com/quote/MXN=X?p=MXN=X"; break;
            case 35: reference = ""; break;
            case 36: reference = ""; break;
            case 37: reference = ""; break;
        }

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final SpannableString link = new SpannableString(reference);
        Linkify.addLinks(link, Linkify.ALL);

        builder.setTitle(getResources().getString(R.string.ref_info))
                .setMessage(link)
                .setNeutralButton("Сancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                }) .setPositiveButton(getResources().getString(R.string.follow_the_link), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(reference));
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


