package com.netcommunicationapp.grd.financial_rate.view.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.netcommunicationapp.grd.financial_rate.R;
import com.netcommunicationapp.grd.financial_rate.common.CommonResources;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by grd on 9/28/17.
 */

/**
 * Created by grd on 9/27/17.
 */

public class MyRecyclerViewAdapterCommodities extends
        RecyclerView.Adapter<MyRecyclerViewAdapterCommodities.ItemHolder>{

    private List <Integer>  itemList = new ArrayList<Integer>();
    Integer[] resImg = {

            R.drawable.oil, //1
            R.drawable.shares, //2

            R.drawable.gold, //3
            R.drawable.oil, //4 - temper

            R.drawable.oil, //5
            R.drawable.gold, //6
            R.drawable.shares, //7
            R.drawable.gold, //8
            R.drawable.oil, //9
            //  R.drawable.oil, //10
    };

    String[] itemName = new String[9];
    String[] itemRate = new String[9];
    String[] itemDate = new String[9];
    String[] itemTime = new String[9];

    private List<String> itemsName;
    private List<Integer> itemsValue;
    private List<String> itemsRateValue;
    private List<String> itemsMarket;
    private LayoutInflater layoutInflater;
    private Context context;

    public MyRecyclerViewAdapterCommodities(Context context){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        itemsName = new ArrayList<String>();
        itemsValue = new ArrayList<Integer>();

        itemsRateValue = new ArrayList<String>();
        itemsMarket = new ArrayList<String>();


        this.itemName = CommonResources.arrayNameTickersCommodities;
        this.itemRate =CommonResources.arrayRateTickersCommodities;
        this.itemDate =CommonResources.arrayDateTickersCommodities;
        this.itemTime =CommonResources.arrrayTimeTickersCommodities;

    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        CardView itemCardView = (CardView)layoutInflater.inflate(R.layout.layout_cardview_grid_shares, viewGroup, false);
        // CardView itemCardView = (CardView)layoutInflater.inflate(R.layout.test_cadview, viewGroup, false);

        return new ItemHolder(itemCardView, this);
    }

    //// Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ItemHolder itemHolder, int i) {

        itemHolder.setItemName(itemName[i]);
        itemHolder.setItemValue(itemRate[i]);
        itemHolder.setTextItemPercent(itemDate[i]);
        itemHolder.setTextItemStock(itemTime[i]);

        itemHolder.imageView.setImageResource(resImg[i]);

    }

    @Override
    public int getItemCount() {
        return itemsName.size();
    }

    public void add(int location, String iName, int iValue){
        itemsName.add(location, iName);
        itemsValue.add(location, iValue);

        itemsRateValue.add(location, iName);
        itemsMarket.add(location, iName);

        notifyItemInserted(location);
    }

    public void remove(int location){
        if(location >= itemsName.size())
            return;

        itemsName.remove(location);
        itemsValue.remove(location);

        itemsMarket.remove(location);
        itemsRateValue.remove(location);

        notifyItemRemoved(location);
    }

    public static class ItemHolder extends RecyclerView.ViewHolder{

        private MyRecyclerViewAdapterCommodities parent;
        private CardView cardView;
        TextView textItemName;
        TextView textItemValue;

        TextView textItemPercent;
        TextView textItemStock;
        ImageView imageView;

        public ItemHolder(CardView cView, MyRecyclerViewAdapterCommodities parent) {
            super(cView);
            cardView = cView;
            this.parent = parent;

            textItemName = (TextView) cardView.findViewById(R.id.text_name);
            textItemValue = (TextView) cardView.findViewById(R.id.text_rate);

            textItemPercent = (TextView) cardView.findViewById(R.id.text_percent_change);
            textItemStock = (TextView) cardView.findViewById(R.id.text_stock);

            imageView = (ImageView) cardView.findViewById(R.id.item_image);
        }

        public void setItemName(CharSequence name){
            textItemName.setText(name);
        }

        public CharSequence getItemName(){
            return textItemName.getText();
        }

        public void setItemValue(CharSequence val){
            textItemValue.setText(val);
        }

        public CharSequence getItemValue(){
            return textItemValue.getText();
        }

        public void setImageView(Drawable drawable){
            imageView.setImageDrawable(drawable);
        }

        public CharSequence getTextItemPercent() {
            return textItemPercent.getText();
        }

        public void setTextItemPercent(CharSequence val) {
            this.textItemPercent.setText(val);
        }

        public CharSequence getTextItemStock() {
            return textItemStock.getText();
        }

        public void setTextItemStock(CharSequence val) {
            this.textItemStock.setText(val);
        }

    }
}