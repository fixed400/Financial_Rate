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

import com.netcommunicationapp.grd.financial_rate.R;
import com.netcommunicationapp.grd.financial_rate.common.CommonResources;

public class CustomListArrayAdapter extends ArrayAdapter<String> {

    private Context mContext;

    Integer[] resImg={

            R.drawable.eur_usd_flags, //1
            R.drawable.gbp_usd_flags, //2

            R.drawable.btc_usd_flags, //3
            R.drawable.ethereum_mining_680x320, //4 - temper

            R.drawable.usd_jpy_flags, //5
            R.drawable.usd_chf_flags, //6
            R.drawable.aud_usd_flags, //7
            R.drawable.usd_cad_flags, //8
            R.drawable.usd_cnh_flags, //9
            R.drawable.usd_pln_flags, //10
            R.drawable.usd_rus_flags, //11
            R.drawable.usd_uah_flags, //12
            R.drawable.eur_gbp_flags, //13
            R.drawable.btc_eur_flags, //14
            R.drawable.eur_pln_flags, //15
            R.drawable.eur_rub_flags, //16
            R.drawable.eur_uah_flags, //17
            R.drawable.btc_pln_flags, //18
            R.drawable.btc_rus_flags, //19
            R.drawable.btc_uah_flags,  //20

            R.drawable.rub_byn_pair, //21
            R.drawable.usd_byn_pair, //22
            R.drawable.rub_kzt_pair, //23
            R.drawable.usd_kzt_pair,  //24
            R.drawable.usd_georgia, //25
            R.drawable.usd_try_pair, //26
            R.drawable.usd_ils_pair, //27
            R.drawable.usd_inr_pair, //28

            R.drawable.usd_pkr_pair, //29
            R.drawable.usd_egp_pair, //30
            R.drawable.usd_thb_pair, //31
            R.drawable.usd_sgd_pair, //32

            R.drawable.usd_nzd_pair, //33

            R.drawable.usd_brl_pair, //34
            R.drawable.usd_mxn_pair, //35


    };

    String[] itemName = new String[35];
    String[] itemRate = new String[35];
    String[] itemDate = new String[35];
    String[] itemTime = new String[35];


    public  int imgId;

    ImageView imageView;
    TextView txtTitle,txtTitle2,txtTitle3;

    public CustomListArrayAdapter(Activity context, int imgid1) {
        super(context, R.layout.item_layout);
        // TODO Auto-generated constructor stub

        this.mContext=context;

        this.itemName =CommonResources.arrayNameTickers;
        this.itemRate =CommonResources.arrayRateTickers;
        this.itemDate =CommonResources.arrayDateTickers;
        this.itemTime =CommonResources.arrrayTimeTickers;
        this.imgId=imgid1;
    }

    //FragmentList adapter
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


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

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
