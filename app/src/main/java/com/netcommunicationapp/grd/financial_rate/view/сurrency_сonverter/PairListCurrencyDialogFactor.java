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

import com.netcommunicationapp.grd.financial_rate.R;
import com.netcommunicationapp.grd.financial_rate.common.CommonResources;
import com.netcommunicationapp.grd.financial_rate.common.ConverterData;


/**
 * Created by grd on 1/24/17.
 */

public class PairListCurrencyDialogFactor extends DialogFragment implements
        AdapterView.OnItemClickListener {

    public interface onEventListenerFactor {
        public void Value1Event(String s);
    }

    onEventListenerFactor FactorEventListener;

    //сделать массив в sring
    String[] listitems = { "USD", "EUR", "GBP", "CAD","JPY", "CHF",
            "CNH", "AUD","PLN", "RUB", "UAH",
            "BTC",
            "ETH",
            "BYN","KZT","GEL","TRY","ILS","INR","PKR","EGP",

            "BRL",
            "NZD",
            "SGD",
            "MXN",
            "THB"

            };
ListView mylist;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            FactorEventListener = (onEventListenerFactor) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onEventListenerFactor");
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


        FactorEventListener.Value1Event(listitems[position]);


        Button btnv1 = (Button) getActivity().findViewById(R.id.btn_factor);
        btnv1.setText(listitems[position]);

        Button btnv2 = (Button) getActivity().findViewById(R.id.btn_multiplier);

        //-----------INVALIDATE -----------
        btnv2.setText("--");
        ConverterData.valueRatio = 0;
        //---------------------------------

        CommonResources.currencyNameFactor = listitems[position];
        ConverterFragment.valueTickerFactor(CommonResources.currencyNameFactor);
        dismiss();

    }


    //-------------weidth-------------
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onResume() {
        super.onResume();

        super.onResume();
        Window window = getDialog().getWindow();
        //window.setLayout(350, 1500);

        window.setGravity(Gravity.CENTER);
    }

}
