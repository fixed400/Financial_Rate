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


import com.netcommunicationapp.grd.financial_rate.util.ConverterData;
import com.netcommunicationapp.grd.financial_rate.R;

import java.math.BigDecimal;


//A simple {@link Fragment} subclass.
//Activities that contain this fragment must implement the
//{@link ConverterFragment.OnFragmentInteractionListener} interface
//to handle interaction events.

//public class ConverterFragment extends Fragment implements PairListCurrencyDialogFragment1.onEventListenerPair1,PairListCurrencyDialogFragment2.onEventListenerPair2 {
public class ConverterFragment extends Fragment {

    final String LOG_TAG = "myLogs";

    Button buttonOne,buttonTwo ;
    static Button btn1,btn2 ;
    public static Button btnValue1,btnValue2;
    // Button btnValue1,btnValue2;

    // Button btnAccount;

    static EditText editTxt;

    static TextView txtFormPair2;
    static TextView txtFormPair1;

    static int multiplier = 1;

    static boolean valueX = false;
    static boolean valueY = false;

    FrameLayout frameLayout;
    int multiplicatioFor = 1;
    //static Boolean emptyMultiplicator = null;
    static boolean emptyMultiplicator = false;
    //  static String multiplierName = "name";

    //  static boolean preViewFinished = false;


    ConverterData converterData = new ConverterData();
    //------------------- GET DATA FROM ACTIVITY USE newInstance ---------------------------------------
/*
    //создание фрагментов будет происходить не через конструктор фрагмента,
    // а через метод newInstance
    private static String EXTRA_STRING = "my_fragment_extra_string";
    //public static String EXTRA_STRING = "my_fragment_extra_string";

    public static ConverterFragment newInstance(String message) {

        Bundle args = new Bundle();
        args.putString(EXTRA_STRING, message);

        ConverterFragment fragment = new ConverterFragment ();
        fragment.setArguments(args);
        return fragment;
    }
    */
    //-----------------------------------------------------------

    public ConverterFragment() {
        // Required empty public constructor
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
        Log.d(LOG_TAG, "Fragment2 onActivityCreated");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_converter,container,false);

        frameLayout = (FrameLayout) view.findViewById(R.id.llColors);

        editTxt   = (EditText)view.findViewById(R.id.editText);

        txtFormPair1 = (TextView) view.findViewById(R.id.textView5);
        txtFormPair2 = (TextView) view.findViewById(R.id.textView6);


        //--------------preView Sart Convertor-------------
        Button btnValue1 = (Button) view.findViewById(R.id.btn1);
        Button  btnValue2 = (Button) view.findViewById(R.id.btn2);
        btnValue1.setText("EUR");
        btnValue2.setText("USD");

        preViewConvertor();

        //------------------------------------------------------------------------------
        ImageButton imgButton = (ImageButton) view.findViewById(R.id.imageButton);
        imgButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // do something

                // !!! NOT correct work !!!!
                swapValue();

                Vibrator vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(25);

            }
        });

        //==========================================================================================
        //----------------------------------------Button 1--------------------------------------
        Button button1 = (Button) view.findViewById(R.id.btn1);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                FragmentManager manager = getFragmentManager();
                PairListCurrencyDialogFragment1 dialog = new PairListCurrencyDialogFragment1();
                dialog.show(manager, "ratePair1" );

            }
        });
        //---------------------------------------Button 2---------------------------------------
        Button button2 = (Button) view.findViewById(R.id.btn2);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                DialogFragment listDialog = new PairListCurrencyDialogFragment2();
                listDialog.show(getFragmentManager(), "InfoApp");

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

                counterValueOf();

            }
        });
        // Reflection at the moment
/*
        editTxt.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
               // if(editText1.getText().length() == 5)
                 //   editText2.requestFocus();
               // frameLayout.setBackgroundResource(R.drawable.bg_blur);
                return false;
            }
        });
*/

        // почистить  - лишнее
        editTxt.setOnEditorActionListener(new TextView.OnEditorActionListener() {


            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {


                //frameLayout.setBackgroundResource(R.drawable.bg_blur);
                //проверка для swap

                //   if(valueX =true && valueY==true)

                //   Log.v("------------ EditText", editTxt .getText().toString());

                //a nullable valuea,reset,  invalidate(аннулировать)
                //    txtFormPair2.setText("0.00");

                int quantity = 1;
                // если нету введеного значения   - !!! Переработать не срабатывает!!!
                if(editTxt .getText().toString()==""){
                    quantity = 1;
                    if(emptyMultiplicator==true) quantity = 0;

                    Toast.makeText(getActivity(),"Not correct value !",Toast.LENGTH_SHORT).show();
                }else{
                    try {
                        quantity = Integer.parseInt(editTxt.getText().toString());
                    }catch (Exception e){
                        Log.v("my LOG","------------ отработатно исключение и программа выполняется дальше");
                        emptyMultiplicator=true;
                        quantity = 0;
                    }
                }

                //-----------calculate----------------

                // if CURRENCY_1 == Currency_2)   CURRENCY_1 =1 , Currency_2 =2;
                try {
                    quantity = Integer.valueOf(String.valueOf(editTxt.getText()));
                    ;//quantity, amount
                    //java.lang.NumberFormatException: For input string: ""
                    emptyMultiplicator = false;
                    if (emptyMultiplicator==true) {
                        quantity = 0;
                    }
                } catch (NumberFormatException excep){
                    Log.d("my LOG_TAG", " >>>>>>>>>>>> Exception Not support TYPE!  "+excep.getMessage());
                } catch (Exception excep)
                {
                    Log.d("my LOG_TAG", " >>>>>>>>>>>> Exception  ");
                    quantity = 0;
                    Log.v("my LOG","------------ отработатно исключение и программа выполняется дальше");
                    emptyMultiplicator=true;

                }

                //Math - calculate
                try {
                    double outcome = (ConverterData.valueOne / ConverterData.valueTwo);
                    txtFormPair2.setText("" + outcome+" ");
                    emptyMultiplicator = false;

                }catch (ArithmeticException excep){
                    excep.printStackTrace();
                    Log.d("my LOG_TAG", " >>>>>>>>>>> Exception  "+excep.getMessage());
                }

                try {
                    multiplicatioFor = Integer.parseInt(editTxt.getText().toString());
                }catch (Exception e){
                    multiplicatioFor =0;
                }

                ////   Toast.makeText(getActivity(),"Введите число!",Toast.LENGTH_SHORT).show();

                counterValueOf();
                return false;
            }
        });
        //--------------------------Dynamic changes----------------------------

        Toast.makeText(getActivity(),"Attention! The result of coverture is approximate! Large numbers are rounded!",Toast.LENGTH_SHORT).show();

        //==========================================================================================
        return view;
    } //------------ END onCreateView()



    //=========================================preViewConvertor=========================================
    private  void preViewConvertor() {

        txtFormPair1.setText(""+String.valueOf(ConverterData.valueOne = roundToDoubleFinancialRate(ConverterData.fetchRateItem("USD"), 4)));
        txtFormPair2.setText(""+String.valueOf(ConverterData.valueTwo = roundToDoubleFinancialRate(ConverterData.fetchRateItem("EUR"), 4)));

        //set to normal sequence for convertor algorithm
        ConverterData.valueOne = roundToDoubleFinancialRate(ConverterData.fetchRateItem("EUR"), 4);
        ConverterData.valueTwo = roundToDoubleFinancialRate(ConverterData.fetchRateItem("USD"), 4);

        //  multiplierName="EUR";

        // preViewFinished = true;
    }
    //===============================================================================================

    private void swapValue() {

        Button btnValue1 = (Button) getActivity().findViewById(R.id.btn1);
        Button  btnValue2 = (Button) getActivity().findViewById(R.id.btn2);
        String txtValue1 = (String) btnValue1.getText();
        String txtValue2 = (String) btnValue2.getText();
        btnValue1.setText(txtValue2);
        btnValue2.setText(txtValue1);

        double swap1 = ConverterData.valueOne;
        double swap2 = ConverterData.valueTwo;

        ConverterData.valueOne = swap2;
        ConverterData.valueTwo = swap1;

        txtFormPair1.setText(""+ConverterData.valueOne);
        txtFormPair2.setText(""+ConverterData.valueTwo);

        counterValueOf();

    }

    ///---------------------------valueTicker--------------------------------
    //  получение данных с dialogFragmnet

    public static void valueTickerOne(String selectedValueOne) {

        ConverterData.valueOne = ConverterData.fetchRateItem(selectedValueOne);
        try {
            txtFormPair1.setText(editTxt .getText().toString()+" "+selectedValueOne+"=");
        }
        catch (Exception e){
            Log.v("my LOG","------------ отработатно исключение и программа выполняется дальше");

            emptyMultiplicator=true;
        }
        //---------------Purge(clean,wipe,flush) the previous result of choice ----
        ////если значение не выбрано для valueTickerTwo то обнолуть (invalidate)
        txtFormPair2.setText("0,00");
        //------------------------------------

        // multiplierName = valueTickerOne;
        valueX = true;

    }

    public static  void valueTickerTwo(String selectedValueTwo) {

        ConverterData.valueTwo =ConverterData.fetchRateItem(selectedValueTwo);
        txtFormPair2.setText(""+ConverterData.valueTwo);

        // counterValueOf(selectedValueTwo);
        counterValueOf();
        valueY = true;

        //  preViewFinished=false;
    }


    //===============================mathematics======================

    private static void counterValueOf() {

        int quantity = 1;

        //-----------Math - calculate
        //+//-----------check value cast to int----------------

        if(emptyMultiplicator==false) {
            try {
                double outcome = 0.0;
                // !!! Потеря точности из Double во Float
                // https://habrahabr.ru/post/201066/
                //  if(ConverterData.valueOne .equals(ConverterData.valueTwo)== ConverterData.valueTwo) {
                if (ConverterData.valueOne == ConverterData.valueTwo) {
                    // Если две пары одинаковы выбрать 1:1 для того чтобы небыло проблем с переводом и окрглением типов
                    outcome = Integer.parseInt(editTxt.getText().toString()) * (1 / 1);
                } else{
                    // Окугление (round) - для второй части пары
                    outcome = Integer.parseInt(editTxt.getText().toString()) * (ConverterData.valueOne / roundToDoubleFinancialRate(ConverterData.valueTwo, 4));
                }
                // Окугление -   round
                String roundOutcome = String.format("%(.4f", outcome);
                // myRound(200.3456, 2); // returns 200.35
                // myRound(200.3456, 3); // returns 200.345
                // String roundOutcome = Double.toString(myRound(outcome, 2)) ;

                // String STRtEST = String.valueOf(Double.parseDouble("8788"));

                // если значение очень мальнекое
                if (outcome <= 0.00009) {
                    String nothing = "too little";
                    // txtFormPair2.setText("" + nothing + " " + currencyName);
                    txtFormPair2.setText("" + roundOutcome);
                } else {
                    txtFormPair2.setText("" + roundOutcome);
                }

                //------------------------------------------
            } catch (ArithmeticException excep) {
                excep.printStackTrace();
                Log.d("my LOG_TAG", " >>>>>>>> ArithmeticException  " + excep.getMessage());
            }catch (NumberFormatException excep){
                // Sometimes throw
                Log.d("my LOG_TAG", ">>>>>> java.lang.NumberFormatException: For input string: \"\" "+excep.getMessage());
                txtFormPair2.setText("0");

                emptyMultiplicator=true;
                quantity = 0;

            }  catch (Exception e) {
                Log.v("my LOG", "------------ отработатно исключение и программа выполняется дальше");

                emptyMultiplicator = true;
            }
        }else {
            txtFormPair2.setText("0");
        }

        Log.d("my LOG_TAG", " ^^^^^^^^^^^^^ quantity is  "+quantity);

    }

    //end meth =======================================================




    public static double roundToDoubleFinancialRate(double d, int decimalPlace) {
        // BigDecimal bd = new BigDecimal(Float.toString(d));
        BigDecimal bd = new BigDecimal(Double.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }

    public static double myRound(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
//--------------------------------------------------------

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
