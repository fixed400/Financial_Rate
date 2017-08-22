package com.netcommunicationapp.grd.financial_rate.view.adapter;

/**
 * Created by grd on 1/6/17.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.netcommunicationapp.grd.financial_rate.common.CommonResources;
import com.netcommunicationapp.grd.financial_rate.R;

// add VIEW HOLDER
public class CustomListArrayAdapter extends ArrayAdapter<String> {

    private Context mContext;

    //Display order flags - порядок отображения флагов
    //Sequence - последовательность
    Integer[] resImg={

            R.drawable.eur_usd_flags, //1
            R.drawable.gbp_usd_flags, //2
            R.drawable.btc_usd_flags, //3
            R.drawable.usd_jpy_flags, //4
            R.drawable.usd_chf_flags, //5
            R.drawable.aud_usd_flags, //6
            R.drawable.usd_cad_flags, //7
            R.drawable.usd_cnh_flags, //8
            R.drawable.usd_pln_flags, //9
            R.drawable.usd_rus_flags, //10
            R.drawable.usd_uah_flags, //11
            R.drawable.eur_gbp_flags, //12
            R.drawable.btc_eur_flags, //13
            R.drawable.eur_pln_flags, //14
            R.drawable.eur_rub_flags, //15
            R.drawable.eur_uah_flags, //16
            R.drawable.btc_pln_flags, //17
            R.drawable.btc_rus_flags, //18
            R.drawable.btc_uah_flags,  //19

            R.drawable.rub_byn_pair, //20
            R.drawable.usd_byn_pair, //21
            R.drawable.rub_kzt_pair, //22
            R.drawable.usd_kzt_pair,  //23
            R.drawable.usd_georgia, //24
            R.drawable.usd_try_pair, //25
            R.drawable.usd_ils_pair, //26
            R.drawable.usd_inr_pair, //27

            R.drawable.usd_pkr_pair, //28
            R.drawable.usd_egp_pair, //29
            R.drawable.usd_thb_pair, //30
            R.drawable.usd_sgd_pair, //31

            R.drawable.usd_nzd_pair, //32

            R.drawable.usd_brl_pair, //33
            R.drawable.usd_mxn_pair, //34


            /*


             R.drawable.none, //35

             R.drawable.none, //36
             R.drawable.none //37
             */

    };

   // String[] itemName = new String[27];
   // String[] itemRate = new String[27];
   // String[] itemDate = new String[27];
   // String[] itemTime = new String[27];

    String[] itemName = new String[34];
    String[] itemRate = new String[34];
    String[] itemDate = new String[34];
    String[] itemTime = new String[34];


   // String[] itemName = new String[35];
   // String[] itemRate = new String[35];
   // String[] itemDate = new String[35];
   // String[] itemTime = new String[35];


    public  int imgId;

    ImageView imageView;
    TextView txtTitle,txtTitle2,txtTitle3;


    // make cheking for empty array
    //-------------------------------------------------------------

    public CustomListArrayAdapter(Activity context, int imgid1, String[] itemname1, String[] itemname2, String[] itemname3, String[] itemname4) {
        super(context, R.layout.item_layout, itemname1);
        // TODO Auto-generated constructor stub

        this.mContext=context;

        this.itemName =itemname1;
        this.itemRate =itemname2;
        this.itemDate =itemname3;
        this.itemTime =itemname4;
        this.imgId=imgid1;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView txtTitle;
        TextView txtTitle2;
        TextView txtTitle3;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // НЕ применять ViewHolder  тормозной патерн  !!!

/*
        View viewPreviouslyCreated = convertView; // keep previosly created items
        ViewHolder holderFindViewByIds; //keep findViewByIDs


        if (viewPreviouslyCreated == null) {

            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            viewPreviouslyCreated = inflater.inflate(R.layout.list_fragment_row, null, true);
             //-----------------------------------------------
            holderFindViewByIds = new ViewHolder();
            holderFindViewByIds.imageView = (ImageView) viewPreviouslyCreated.findViewById(R.id.imageViewIcon);
            holderFindViewByIds.txtTitle = (TextView) viewPreviouslyCreated.findViewById(R.id.tickerSymbol);
            holderFindViewByIds.txtTitle2 = (TextView) viewPreviouslyCreated.findViewById(R.id.timeData);
            holderFindViewByIds.txtTitle3 = (TextView) viewPreviouslyCreated.findViewById(R.id.tickerRate);

            viewPreviouslyCreated.setTag(holderFindViewByIds); // keep holders

        } else {
            //retrive (getting)holders
            holderFindViewByIds = (ViewHolder) viewPreviouslyCreated.getTag();
        }


      //  LayoutInflater inflater1= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      //  View rowView=inflater1.inflate(R.layout.list_fragment_row, null, true);
        //View rowView=inflater1.inflate(R.layout.item_layout, null, true);
        holderFindViewByIds.imageView.setImageResource(resImg[position]);
        //ImageView imageView = (ImageView) rowView.findViewById(R.id.imageViewIcon);
        //imageView.setImageResource(resImg[position]);

        holderFindViewByIds.txtTitle.setText(CommonResources.arrayNameTickers[position]);
        holderFindViewByIds.txtTitle2.setText("Date "+ itemDate[position]+"\nTime "+ itemTime[position]);
        holderFindViewByIds.txtTitle3.setText(itemRate[position]);

        return viewPreviouslyCreated;
        */


        LayoutInflater inflater=(LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView=inflater.inflate(R.layout.list_fragment_row, null, true);


         imageView = (ImageView) rowView.findViewById(R.id.imageViewIcon);
         txtTitle = (TextView) rowView.findViewById(R.id.tickerSymbol);
         txtTitle2 = (TextView) rowView.findViewById(R.id.timeData);
         txtTitle3 = (TextView) rowView.findViewById(R.id.tickerRate);

        imageView.setImageResource(resImg[position]);
        txtTitle.setText(CommonResources.arrayNameTickers[position]);
        txtTitle2.setText("Date "+ itemDate[position]+"\nTime "+ itemTime[position]);
        txtTitle3.setText(itemRate[position]);



        return rowView;




    }
}
