package com.netcommunicationapp.grd.financial_rate.view;

/**
 * Created by adex on 12.04.16.
 */

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netcommunicationapp.grd.financial_rate.R;


public class AboutAppFragment extends Fragment {

    //конструктор
    public AboutAppFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.about_app_fragment, container,
                false);

        return rootView;
    }
}