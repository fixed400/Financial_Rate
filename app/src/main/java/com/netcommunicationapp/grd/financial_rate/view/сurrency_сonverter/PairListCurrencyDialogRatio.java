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


//import static ConverterFragment.transfer2;

/**
 * Created by grd on 1/26/17.
 */

public class PairListCurrencyDialogRatio extends DialogFragment implements
        AdapterView.OnItemClickListener {


        // send data to activity
        public interface onEventListenerRatio {
            public void Value2Event(String s);
        }

        onEventListenerRatio ratioEventListener;


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
                ratioEventListener = (onEventListenerRatio) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " must implement onEventListenerRatio");
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

            ratioEventListener.Value2Event(listitems[position]);

            Button btnv2 = (Button) getActivity().findViewById(R.id.btn_multiplier);
            btnv2.setText(listitems[position]);

            CommonResources.currencyNameRatio = listitems[position];
            ConverterFragment.valueTickerRatio(CommonResources.currencyNameRatio);

            dismiss();

        }

    //--------------------------

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onResume() {
        super.onResume();

        super.onResume();
        Window window = getDialog().getWindow();
      //  window.setLayout(350, 1999);
        window.setGravity(Gravity.CENTER);
    }


}
