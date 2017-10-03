package com.netcommunicationapp.grd.financial_rate;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.netcommunicationapp.grd.financial_rate.common.CommonResources;
import com.netcommunicationapp.grd.financial_rate.util.SettingsFragment;
import com.netcommunicationapp.grd.financial_rate.view.AboutAppFragment;
import com.netcommunicationapp.grd.financial_rate.view.CommoditiesFragment;
import com.netcommunicationapp.grd.financial_rate.view.CurrencyListFragment;
import com.netcommunicationapp.grd.financial_rate.view.SharesQuoteFragment;
import com.netcommunicationapp.grd.financial_rate.view.dialogs.InfoDialogFragment;
import com.netcommunicationapp.grd.financial_rate.view.сurrency_сonverter.ConverterFragment;
import com.netcommunicationapp.grd.financial_rate.view.сurrency_сonverter.PairListCurrencyDialogFactor;
import com.netcommunicationapp.grd.financial_rate.view.сurrency_сonverter.PairListCurrencyDialogRatio;


public class MainNavigationDrawerActivity extends AppCompatActivity implements PairListCurrencyDialogFactor.onEventListenerFactor,PairListCurrencyDialogRatio.onEventListenerRatio {

    private final String LOG_TAG = "LOG_Activity(Nav.Draw)";

    private DrawerLayout myDrawerLayout;
    private ListView myDrawerList;
    private android.support.v7.app.ActionBarDrawerToggle myDrawerToggle;

    private CharSequence myDrawerTitle;
    private CharSequence myTitle;

    private String[] viewsNames;
    private String selectedCurrency1 = "USD";
    private String selectedCurrency2 = "EUR";

    boolean restraint;

    Fragment fragment = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main_navigation_drawer);

        myTitle =  getTitle();
        myDrawerTitle = getResources().getString(R.string.menu);

        // load slide menu items
        viewsNames = getResources().getStringArray(R.array.nav_list_array); //list names in menu drawer
        myDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout); // display screen
        myDrawerList = (ListView) findViewById(R.id.left_drawer);  //curtain

        myDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, viewsNames));
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        myDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this, myDrawerLayout, R.string.open_menu, R.string.close_menu)
        {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(myTitle);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(myDrawerTitle);
                invalidateOptionsMenu();
            }
        };
        myDrawerLayout.setDrawerListener(myDrawerToggle);
        if (savedInstanceState == null) {
            displayView(0);
        }

        myDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        Toast.makeText(this, getResources().getString(R.string.danger_price), Toast.LENGTH_SHORT).show();
    }//----END onCrate()

    public void Value1Event(String inputPair) {
        selectedCurrency1 = inputPair;
        Log.d("Nav.Drawer",selectedCurrency1);
    }

    @Override
    public void Value2Event(String inputPair2) {
        selectedCurrency2 = inputPair2;
    }


    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(
                AdapterView<?> parent, View view, int position, long id
        ) {
            displayView(position);
        }
    }

    private void displayView(int position) {
        switch (position) {
            case 0:
                fragment = new CurrencyListFragment();
                restraint =true;
                break;
            case 1:
                fragment = sendToFragmentBundle(fragment);
                restraint =false;
                break;
            case 2:
                fragment = new AboutAppFragment();
                restraint =false;
                break;

            case 3:
                fragment = new CommoditiesFragment();
                restraint =false;
                break;
            case 4:
                fragment = new SharesQuoteFragment();
                restraint =false;

                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, fragment).commit();

            myDrawerList.setItemChecked(position, true);
            myDrawerList.setSelection(position);
            setTitle(viewsNames[position]);
            myDrawerLayout.closeDrawer(myDrawerList);

        } else {
            Log.e(LOG_TAG, "Error in creating fragment");
        }
    }

    public Fragment sendToFragmentBundle(Fragment frg)
    {
        frg = new ConverterFragment();
        Bundle bundle=new Bundle();
        bundle.putString("name", selectedCurrency1);
        frg.setArguments(bundle);

        return frg;
    }
    //------------------------menu-------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (myDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        //-------------------------------------
        switch (item.getItemId()) {
            case R.id.action_settings:

                Fragment fragment = new SettingsFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, fragment).commit();
                restraint =false;
                return true;
            case R.id.action_info:

                DialogFragment infoDialog = new InfoDialogFragment();
                infoDialog.show(getFragmentManager(), "InfoApp");
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean drawerOpen = myDrawerLayout.isDrawerOpen(myDrawerList);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void setTitle(CharSequence title) {
        myTitle = title;
        getSupportActionBar().setTitle(myTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        myDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        myDrawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public void onBackPressed() {
        if(!restraint) {
            fragment = new CurrencyListFragment();
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, fragment).commit();

            restraint =true;
        }else{
            finish();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume() --- --- MainNavigationDrawerActivity ");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(LOG_TAG, "onPause() --- MainNavigationDrawerActivity");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(LOG_TAG, "onStop()  --- MainNavigationDrawerActivity");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        CommonResources.repeatAnimation = true;
        Log.d(LOG_TAG, "onDestroy()  --- MainNavigationDrawerActivity");
    }

}

