package com.netcommunicationapp.grd.financial_rate.view;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netcommunicationapp.grd.financial_rate.R;
import com.netcommunicationapp.grd.financial_rate.common.CommonResources;
import com.netcommunicationapp.grd.financial_rate.market_model.MarketCommoditiesContent.MarketItem;
import com.netcommunicationapp.grd.financial_rate.view.adapter.MyRecyclerViewAdapterShares;

import java.lang.reflect.Field;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
//Trial
public class SharesQuoteFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;
    private OnListFragmentInteractionListener mListener;


    private RecyclerView myRecyclerView;
    private StaggeredGridLayoutManager staggeredGridLayoutManagerVertical;
    private MyRecyclerViewAdapterShares myRecyclerViewAdapter;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SharesQuoteFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static SharesQuoteFragment newInstance(int columnCount) {
        SharesQuoteFragment fragment = new SharesQuoteFragment();
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
        View view = inflater.inflate(R.layout.fragment_shares_item_list, container, false);

        myRecyclerView = (RecyclerView)view.findViewById(R.id.myrecyclerview);

        Context context = view.getContext();
        // в шахматном порядке
        staggeredGridLayoutManagerVertical =
                new StaggeredGridLayoutManager(
                        2,
                        LinearLayoutManager.VERTICAL);

        myRecyclerViewAdapter = new MyRecyclerViewAdapterShares(context);
        myRecyclerView.setAdapter(myRecyclerViewAdapter);
        myRecyclerView.setLayoutManager(staggeredGridLayoutManagerVertical);
       // myRecyclerView.setLayoutManager(new LinearLayoutManager(context));

        prepareItems();
        return view;
    }


    //trial
    private void prepareItems(){
        Field[] fieldDrawables = android.R.drawable.class.getFields();
        for(int i = 0; i< CommonResources.arrayNameTickersShares.length; i++){
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


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(MarketItem item);
    }
}
