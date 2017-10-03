package com.netcommunicationapp.grd.financial_rate.util;

/**
 * Created by fixoid on 8/24/17.
 */



import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import android.preference.PreferenceFragment;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.netcommunicationapp.grd.financial_rate.R;


/**
 * A simple {@link Fragment} subclass.
 */

/*
Сам фрагмент SettingsFragment наследуется от класса PreferenceFragment.
В его методе onCreate() вызывается метод addPreferencesFromResource(),
 в который передается id ресурса xml с настройками (в данном
 случае ранее определенный ресурс R.xml.settings).
 */
public class SettingsFragment extends PreferenceFragment {




    public SettingsFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.my_preference);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(view != null){
            //view.setBackgroundColor(ContextCompat.getColor(getActivity(), android.R.color.background_dark));
           // view.setBackgroundColor(ContextCompat.getColor(getActivity(), android.R.color.darker_gray));
          //  view.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.list_background));
          //  view.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
            view.setBackgroundColor(ContextCompat.getColor(getActivity(), android.R.color.background_light));
        }
    }

}