package com.netcommunicationapp.grd.financial_rate.view.adapter;

/**
 * Created by grd on 1/5/17.
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

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemName;
    private final String[] rateValue;
    private final String[] dateData;
    private final String[] timeData;
    //private final Integer[] imgid;

    private Integer[] imgid = new Integer[19];

    private int lastPosition = -1;

    public static Integer[] arrayImg={

            R.drawable.eur_usd_flags, //1
            R.drawable.gbp_usd_flags, //2
            R.drawable.btc_usd_flags, //3
            R.drawable.usd_jpy_flags, //4
            R.drawable.usd_chf_flags, //5
            R.drawable.aud_usd_flags, //6
            R.drawable.usd_cad_flags,  //7
            R.drawable.usd_cnh_flags,  //8
            R.drawable.usd_pln_flags,  //9
            R.drawable.usd_rus_flags,  //10
            R.drawable.usd_uah_flags,  //11
            R.drawable.gbp_usd_flags,  //12
            R.drawable.btc_eur_flags,  //13
            R.drawable.eur_pln_flags,  //14
            R.drawable.eur_rub_flags,  //15
            R.drawable.eur_uah_flags,  //16
            R.drawable.btc_pln_flags,  //17
            R.drawable.btc_rus_flags,  //18
            R.drawable.btc_uah_flags,  //19
            R.drawable.btc_uah_flags,  //20
            R.drawable.btc_uah_flags  //21

    };

      //Add place holder
    public CustomListAdapter(Activity context, String[] itemname, String[] itemname2, String[] itemname3, String[] itemname4, Integer[] imgid) {
        super(context, R.layout.item_list, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemName =itemname;
        this.rateValue =itemname2;
        this.dateData =itemname3;
        this.timeData =itemname4;
        this.imgid=imgid;
    }

    //add place holder

    static class ViewHolder {
        ImageView imageView;
        TextView txtTitle;
        TextView txtTitle2;
        TextView txtTitle3;
        TextView txtTitle4;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View viewPreviouslyCreated = convertView; // keep previosly created items
        ViewHolder holderFindViewByIds; //keep findViewByIDs

        if (viewPreviouslyCreated == null) {

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            viewPreviouslyCreated = inflater.inflate(R.layout.item_list, null, true);
            //-----------------------------------------------
            holderFindViewByIds = new ViewHolder();
            holderFindViewByIds.imageView = (ImageView) viewPreviouslyCreated.findViewById(R.id.icon);
            holderFindViewByIds.txtTitle = (TextView) viewPreviouslyCreated.findViewById(R.id.itemName);
            //  holderFindViewByIds.txtTitle2= (TextView) viewPreviouslyCreated.findViewById(R.id.itemDate);
            holderFindViewByIds.txtTitle3 = (TextView) viewPreviouslyCreated.findViewById(R.id.itemTime);
            holderFindViewByIds.txtTitle4 = (TextView) viewPreviouslyCreated.findViewById(R.id.itemRate);


            viewPreviouslyCreated.setTag(holderFindViewByIds); // keep holders
        } else {
            //retrive (getting)holders
            holderFindViewByIds = (ViewHolder) viewPreviouslyCreated.getTag();
        }

        //holderFindViewByIds.imageView.setImageResource(R.drawable.usd_eur_flags);
       // holderFindViewByIds.imageView.setImageResource(R.drawable.currencyes);
        holderFindViewByIds.imageView.setImageResource(arrayImg[position]);
        holderFindViewByIds.txtTitle.setText(itemName[position]);
        //holderFindViewByIds.txtTitle2.setText(timeData[position]);
       // holderFindViewByIds.txtTitle3.setText(dateData[position]);
        holderFindViewByIds.txtTitle3.setText("Date "+ dateData[position]+"\nTime "+timeData[position]);
        holderFindViewByIds.txtTitle4.setText(rateValue[position]);

        return viewPreviouslyCreated;


    }
    //---------------------------------------------------------------------

/*
    public View getView(int position,View view,ViewGroup parent) {



        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.item_list, null,true);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);
        TextView extratxt2 = (TextView) rowView.findViewById(R.id.tvCondition);
       // TextView extratxt2 = (TextView) rowView.findViewById(R.id.tvCondition);

        imageView.setImageResource(imgid[position]);
        txtTitle.setText(itemName[position]);
       // extratxt.setText("Rate "+rateValue[position]);
        extratxt.setText(rateValue[position]);
        extratxt2.setText("Date "+dateData[position]+"\nTime "+timeData[position]);
        //extratxt2.setText(" Time "+timeData[position]);

        //---------------------------------------------
        //not work
       // Animation animation = AnimationUtils.loadAnimation(getContext(), (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
       // view.startAnimation(animation);
       // lastPosition = position;
        //----------------------------------------------
        return rowView;



    }
    */
    //---------------------------------------

    //----------------------------------with holder------
    /*

    View viewPreviouslyCreated = convertView; // keep previosly created items
    ViewHolder holderFindViewByIds; //keep findViewByIDs

    if (viewPreviouslyCreated == null) {
        // LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LayoutInflater inflater = context.getLayoutInflater();
        viewPreviouslyCreated = inflater.inflate(R.layout.list_single, null, true);

        holderFindViewByIds = new ViewHolder();
        holderFindViewByIds.imageView = (ImageView) viewPreviouslyCreated.findViewById(R.id.img);
        holderFindViewByIds.txtTitle = (TextView) viewPreviouslyCreated.findViewById(R.id.txt);
        // holderFindViewByIds.btnSound = (Button) viewPreviouslyCreated.findViewById(R.id.btn);

        viewPreviouslyCreated.setTag(holderFindViewByIds); // keep holders
    } else {
        //retrive (getting)holders
        holderFindViewByIds = (ViewHolder) viewPreviouslyCreated.getTag();
    }

    // int position - параметр getView() -Положение элемента в пределах адаптера, id = position.

    holderFindViewByIds.imageView.setImageResource(imageId[position]);
    holderFindViewByIds.txtTitle.setText(_sites[position]);

    return viewPreviouslyCreated;
  */
    //====================================================================
    //add place holder

/*
    static class ViewHolder {
        TextView txtItem;
        TextView txtTitle;
        ImageView imageView;
        TextView extratxt;
        TextView extratxt2;
    }

    public View getView(int position,View convertView,ViewGroup parent) {

        ViewHolder viewHolder;



        // viewHolder = new ViewHolder();
        //TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        //ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        //TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);
        //TextView extratxt2 = (TextView) rowView.findViewById(R.id.tvCondition);


        // TextView extratxt2 = (TextView) rowView.findViewById(R.id.tvCondition);

//-----------------------------------------

        if (convertView == null){
            LayoutInflater inflater=context.getLayoutInflater();
            convertView =inflater.inflate(R.layout.item_list, null,true);

            viewHolder = new ViewHolder();
            viewHolder.txtTitle = (TextView) convertView.findViewById(R.id.item);
            viewHolder .imageView = (ImageView) convertView.findViewById(R.id.icon);
            viewHolder.extratxt = (TextView) convertView.findViewById(R.id.textView1);
            viewHolder.extratxt2 = (TextView) convertView.findViewById(R.id.tvCondition);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        // viewHolder.txtItem.setText(getItem(position));

        return convertView;
        //------------------------------------


    }
    */
}