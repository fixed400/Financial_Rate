package com.netcommunicationapp.grd.financial_rate.view.сurrency_сonverter;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.app.Fragment;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.netcommunicationapp.grd.financial_rate.R;
import com.netcommunicationapp.grd.financial_rate.common.ConverterData;

import java.math.BigDecimal;

public class ConverterFragment extends Fragment {

   private static final String LOG_TAG = "myLogs";


   private static EditText editTxt;

   private static TextView txtMultiplier;
   private static TextView txtFactor;

    FrameLayout frameLayout;
    static boolean emptyMultiplicator = false;

    ConverterData converterData = new ConverterData();

   private static Context context;

    public ConverterFragment() {

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(LOG_TAG, "Fragment2 onAttach");
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "Fragment2 onCreate");
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(LOG_TAG, "Fragment onActivityCreated");

        context= getActivity();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_converter,container,false);

        frameLayout = (FrameLayout) view.findViewById(R.id.llColors);

        editTxt   = (EditText)view.findViewById(R.id.editText);

        txtFactor = (TextView) view.findViewById(R.id.factor_txt);
        txtMultiplier = (TextView) view.findViewById(R.id.multiplier_txt);

        //--------------preView Sart Convertor-------------
        Button btnFactor = (Button) view.findViewById(R.id.btn_factor);
        Button  btnMultiplier = (Button) view.findViewById(R.id.btn_multiplier);
        btnFactor.setText("EUR");
        btnMultiplier.setText("USD");

        preViewConvertor();

        //------------------------------------------------------------------------------
        ImageButton swipeButton = (ImageButton) view.findViewById(R.id.imageButton);
        swipeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                swapValue();

                Vibrator vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(25);

            }
        });

        //==========================================================================================
        //----------------------------------------Button 1--------------------------------------
        Button button1 = (Button) view.findViewById(R.id.btn_factor);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentManager manager = getFragmentManager();
                PairListCurrencyDialogFactor dialog = new PairListCurrencyDialogFactor();
                dialog.show(manager, "currencyNameFactor" );

            }
        });
        //---------------------------------------Button 2---------------------------------------
        Button button2 = (Button) view.findViewById(R.id.btn_multiplier);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                DialogFragment listDialog = new PairListCurrencyDialogRatio();
                listDialog.show(getFragmentManager(), "currencyNameRatio");

            }
        });

        //----------------------------------------Button Account--------------------------------------
        Button buttonAccount = (Button) view.findViewById(R.id.buttonCount);
        buttonAccount.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Vibrator vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(35);

                accountValueOf();

            }
        });

        editTxt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                accountValueOf();
                return false;
            }
        });

        Toast.makeText(getActivity(),"Attention! The result of coverture is approximate! Large numbers are rounded!",Toast.LENGTH_SHORT).show();

        return view;
    } //------------ END onCreateView()

    //=========================================preViewConvertor=========================================
    private  void preViewConvertor() {

        txtFactor.setText(""+String.valueOf(ConverterData.valueFactor = roundToDoubleFinancialRate(ConverterData.fetchRateItem("USD"), 4)));
        txtMultiplier.setText(""+String.valueOf(ConverterData.valueRatio = roundToDoubleFinancialRate(ConverterData.fetchRateItem("EUR"), 4)));

        //set to normal sequence for convertor algorithm
        ConverterData.valueFactor = roundToDoubleFinancialRate(ConverterData.fetchRateItem("EUR"), 4);
        ConverterData.valueRatio = roundToDoubleFinancialRate(ConverterData.fetchRateItem("USD"), 4);

    }
    //===============================================================================================

    private void swapValue() {

        Button btnValue1 = (Button) getActivity().findViewById(R.id.btn_factor);
        Button  btnValue2 = (Button) getActivity().findViewById(R.id.btn_multiplier);
        String txtValue1 = (String) btnValue1.getText();
        String txtValue2 = (String) btnValue2.getText();
        btnValue1.setText(txtValue2);
        btnValue2.setText(txtValue1);

        double swap1 = ConverterData.valueFactor;
        double swap2 = ConverterData.valueRatio;

        ConverterData.valueFactor = swap2;
        ConverterData.valueRatio = swap1;

        txtFactor.setText(""+ConverterData.valueFactor);
        txtMultiplier.setText(""+ConverterData.valueRatio);

        accountValueOf();

    }

    ///---------------------------valueTicker--------------------------------
    //  получение данных с dialogFragmnet
    public static void valueTickerFactor(String selectedValueOne) {

        try {
            ConverterData.valueFactor = ConverterData.fetchRateItem(selectedValueOne);
            txtFactor.setText(getInputValue()+" "+selectedValueOne+"=");

            txtMultiplier.setText("0.00");
        }catch (NumberFormatException exception){
            Toast.makeText(context,"Пустое значение !",Toast.LENGTH_SHORT).show();

        }

    }
    // Multiplier
    public static  void valueTickerRatio(String selectedValueTwo) {

        ConverterData.valueRatio =ConverterData.fetchRateItem(selectedValueTwo);
        txtMultiplier.setText(""+ConverterData.valueRatio);

        accountValueOf();

    }

    //===============================mathematics======================
    private static void accountValueOf() {

            try {
                double outcome = 0.0;
                if (ConverterData.valueFactor == ConverterData.valueRatio) {
                    outcome = getInputValue() * (1 / 1);
                } else{
                    outcome = getInputValue() * (ConverterData.valueFactor /
                            roundToDoubleFinancialRate(ConverterData.valueRatio, 4));
                }

                String roundOutcome = String.format("%(.4f", outcome);
                // for small value
                if (outcome <= 0.00009) {
                    txtMultiplier.setText("" + roundOutcome);
                } else {
                    txtMultiplier.setText("" + roundOutcome);
                }

            } catch (ArithmeticException excep) {
                excep.printStackTrace();

            }catch (NumberFormatException excep){
                excep.printStackTrace();
                txtMultiplier.setText("0");
                emptyMultiplicator=true;
                Log.e(LOG_TAG, "-- Empty value of factor in order to use count ---");
            }  catch (Exception e) {
                e.printStackTrace();
            }

    }

    public static double roundToDoubleFinancialRate(double d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Double.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }

   private static int getInputValue() {
      return Integer.parseInt(editTxt.getText().toString());
    }


    public void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "Fragment2 onStart");
    }

    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "Fragment2 onResume");

    }

    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "Fragment2 onPause");
    }

    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "Fragment2 onStop");
    }

    public void onDestroyView() {
        super.onDestroyView();
        Log.d(LOG_TAG, "Fragment2 onDestroyView");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "Fragment2 onDestroy");

    }

    public void onDetach() {
        super.onDetach();
        Log.d(LOG_TAG, "Fragment2 onDetach");
    }

}
