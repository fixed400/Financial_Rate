package com.netcommunicationapp.grd.financial_rate.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.netcommunicationapp.grd.financial_rate.R;
import com.netcommunicationapp.grd.financial_rate.view.SharesQuoteFragment.OnListFragmentInteractionListener;
import com.netcommunicationapp.grd.financial_rate.market_model.MarketCommoditiesContent.MarketItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link MarketItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<MarketItem> mValues;


    Integer[] resImg = {

            R.drawable.oil, //1
            R.drawable.shares, //2
            R.drawable.oil, //3
            R.drawable.gold, //4
            R.drawable.oil, //5
            R.drawable.gold, //6
            R.drawable.shares, //7
            R.drawable.gold, //8
            R.drawable.oil, //9

    };


    public MyItemRecyclerViewAdapter(List<MarketItem> items) {
        mValues = items;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item_commodities, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.imageView.setImageResource(resImg[position]); // USE
        /*
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).id);
        holder.mContentView1.setText(mValues.get(position).content);
        holder.mContentView2.setText(mValues.get(position).content2);
        holder.mContentView3.setText(mValues.get(position).content3);
        holder.mContentView4.setText(mValues.get(position).content4);
        */


        holder.mItem = mValues.get(position);


         /*
        // java.lang.IndexOutOfBoundsException: Invalid index 0, size is 0  - NEED LOAD DATA! >> GO TO PreLoaderActivity
        holder.mContentView1.setText(CommonResources.listRateTickersCommodities.get(position));
        holder.mContentView2.setText(CommonResources.listChangeTickersCommodities.get(position));
        holder.mContentView3.setText(CommonResources.listarrayDateTickersCommodities.get(position));
        holder.mContentView4.setText(CommonResources.listTimeTickersCommodities.get(position));
        */

        /*
        // java.lang.IndexOutOfBoundsException: Invalid index 1, size is 0 - NEED LOAD DATA! >> GO TO PreLoaderActivity
        holder.mContentView1.setText(CommonResources.listRateTickersCommodities.get(1));
        holder.mContentView2.setText(CommonResources.listChangeTickersCommodities.get(1));
        holder.mContentView3.setText(CommonResources.listarrayDateTickersCommodities.get(1));
        holder.mContentView4.setText(CommonResources.listTimeTickersCommodities.get(1));
        */



        holder.mContentView.setText(mValues.get(position).content);
        holder.mContentView1.setText(mValues.get(position).content1);
        holder.mContentView2.setText(mValues.get(position).content2);
        holder.mContentView3.setText(mValues.get(position).content3);
        holder.mContentView4.setText(mValues.get(position).content4);

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        ImageView imageView;

        public final TextView mContentView;
        public final TextView mContentView1;
        public final TextView mContentView2;
        public final TextView mContentView3;
        public final TextView mContentView4;

        public MarketItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;

            imageView = (ImageView) view.findViewById(R.id.imageView);

            mContentView = (TextView) view.findViewById(R.id.content);
            mContentView1 = (TextView) view.findViewById(R.id.content1);
            mContentView2 = (TextView) view.findViewById(R.id.content2);
            mContentView3 = (TextView) view.findViewById(R.id.content3);
            mContentView4 = (TextView) view.findViewById(R.id.content4);

        }

        @Override public String toString() {
            return super.toString() + " '" + mContentView1.getText() + "'";
        }

    }
}
