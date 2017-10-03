package com.netcommunicationapp.grd.financial_rate.view;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netcommunicationapp.grd.financial_rate.market_model.MarketCommoditiesContent;
import com.netcommunicationapp.grd.financial_rate.view.adapter.MyItemRecyclerViewAdapter;
import com.netcommunicationapp.grd.financial_rate.R;
import com.netcommunicationapp.grd.financial_rate.view.adapter.MyRecyclerViewAdapterCommodities;

import java.lang.reflect.Field;


public class CommoditiesFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    private RecyclerView myRecyclerView;
    private StaggeredGridLayoutManager staggeredGridLayoutManagerVertical;
    private MyRecyclerViewAdapterCommodities myRecyclerViewAdapter;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CommoditiesFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static CommoditiesFragment newInstance(int columnCount) {
        CommoditiesFragment fragment = new CommoditiesFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_commodities_item_list, container, false);
        myRecyclerView = (RecyclerView)view.findViewById(R.id.myrecyclerview);

        //------------- Adapter 1------
        /*
        Context context = view.getContext();
        // в шахматном порядке
        staggeredGridLayoutManagerVertical =
                new StaggeredGridLayoutManager(
                        2, //The number of Columns in the grid
                        LinearLayoutManager.VERTICAL);

        // MyRecyclerViewAdapterCommodities
        myRecyclerViewAdapter = new MyRecyclerViewAdapterCommodities(context);
        myRecyclerView.setAdapter(myRecyclerViewAdapter);
       // myRecyclerView.setLayoutManager(staggeredGridLayoutManagerVertical); // !!! staggeredGridLayout
        myRecyclerView.setLayoutManager(new LinearLayoutManager(context)); // !!! simpleLayout

        prepareItems();
        */

        //----------------------------------------------------
        // /*
       //====================Adapter 2=================MyItemRecyclerViewAdapter=============
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;

            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(MarketCommoditiesContent.ITEMS));

        }
        //============================================
       // */
        return view;
    }

   // /*
    //trial
    private void prepareItems(){
        Field[] fieldDrawables = android.R.drawable.class.getFields();
         for(int i=0; i<9; i++){
            Field field = fieldDrawables[i];
            try {
                int value = (int) field.get(fieldDrawables);
                myRecyclerViewAdapter.add(
                        myRecyclerViewAdapter.getItemCount(),
                        "R.drawable." + field.getName(),
                        value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
   // */


    @Override public void onViewCreated(View view,
                                        @Nullable Bundle savedInstanceState) {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }



}
