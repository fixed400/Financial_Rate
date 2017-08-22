package com.netcommunicationapp.grd.financial_rate.view.сurrency_сonverter;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.netcommunicationapp.grd.financial_rate.common.CommonResources;
import com.netcommunicationapp.grd.financial_rate.R;


/**
 * Created by grd on 1/24/17.
 */

public class PairListCurrencyDialogFragment1 extends DialogFragment implements
        AdapterView.OnItemClickListener {

    public interface onEventListenerPair1 {
        public void Value1Event(String s);
    }

    onEventListenerPair1 pair1EventListener;

   // String[] listitems = { "USD", "EUR", "GBP", "CAD","JPY", "CHF",
   //         "CNH", "AUD","PLN", "RUB", "UAH", "BTC","BYN","KZT","TRY","INR","PKR","EGP"};

    //сделать массив в sring
    String[] listitems = { "USD", "EUR", "GBP", "CAD","JPY", "CHF",
            "CNH", "AUD","PLN", "RUB", "UAH", "BTC","BYN","KZT","GEL","TRY","ILS","INR","PKR","EGP",

            "BRL",
            "NZD",
            "SGD",
            "MXN",
            "THB"

            /*


            "KRW",
            "ARS",
            "CLP"
            */
            };
ListView mylist;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            pair1EventListener = (onEventListenerPair1) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onEventListenerPair1");
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.list_dialog_fragment, null, false);
        mylist = (ListView) view.findViewById(R.id.list);


        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(true);

        return view;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, listitems);

        mylist.setAdapter(adapter);

        mylist.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {


        pair1EventListener.Value1Event(listitems[position]);


        Button btnv1 = (Button) getActivity().findViewById(R.id.btn1);
        btnv1.setText(listitems[position]);

        Button btnv2 = (Button) getActivity().findViewById(R.id.btn2);

        btnv2.setText("--");

        CommonResources.ratePair1 = listitems[position];
        ConverterFragment.valueTickerOne(CommonResources.ratePair1);
        dismiss();

    }



    //-------------weidth-------------


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setStyle(DialogFragment.STYLE_NORMAL, R.style.colorPickerStyle);
        // this setStyle is VERY important.
        // STYLE_NO_FRAME means that I will provide my own layout and style for the whole dialog
        // so for example the size of the default dialog will not get in my way
        // the style extends the default one. see bellow.


    }

    public void onResume() {
        super.onResume();

        super.onResume();
        Window window = getDialog().getWindow();
        //window.setLayout(350, 1500);

        window.setGravity(Gravity.CENTER);
    }

}
