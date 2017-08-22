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
import com.netcommunicationapp.grd.financial_rate.view.AboutAppFragment;
import com.netcommunicationapp.grd.financial_rate.view.CurrencyListFragment;
import com.netcommunicationapp.grd.financial_rate.view.dialogs.InfoDialogFragment;
import com.netcommunicationapp.grd.financial_rate.view.сurrency_сonverter.ConverterFragment;
import com.netcommunicationapp.grd.financial_rate.view.сurrency_сonverter.PairListCurrencyDialogFragment1;
import com.netcommunicationapp.grd.financial_rate.view.сurrency_сonverter.PairListCurrencyDialogFragment2;

//import com.my_research_app.grd.finnacetiks_4_4.view.dialogs.InfoDialogFragment;
//import com.my_research_app.grd.finnacetiks_4_4.view.сurrency_сonverter.ConverterFragment;
//import com.my_research_app.grd.finnacetiks_4_4.view.CurrencyListFragment;
//import com.my_research_app.grd.finnacetiks_4_4.view.AboutAppFragment;
//import com.my_research_app.grd.finnacetiks_4_4.view.сurrency_сonverter.PairListCurrencyDialogFragment1;
//import com.my_research_app.grd.finnacetiks_4_4.view.сurrency_сonverter.PairListCurrencyDialogFragment2;

// Ticker symbol
public class MainNavigationDrawerActivity extends AppCompatActivity implements PairListCurrencyDialogFragment1.onEventListenerPair1,PairListCurrencyDialogFragment2.onEventListenerPair2 {

   private final String LOG_TAG = "LOG_Activity(Nav.Draw)";
    Bundle bundle;
    private DrawerLayout myDrawerLayout;
    private ListView myDrawerList;
    private android.support.v7.app.ActionBarDrawerToggle myDrawerToggle;

    // navigation drawer title
    private CharSequence myDrawerTitle;
    // used to store app title
    private CharSequence myTitle;

    private String[] viewsNames;

    private String selectedCurrency1 = "USD";
    private String selectedCurrency2 = "EUR";

    static boolean showAnimation = false;

    private static FragmentManager fragmentManagerPass;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);// Но указанный способ не совсем желателен.
        // BUT BETTER
        // android:screenOrientation="portrait"
        /*

         Лучше установить нужную ориентацию через манифест,
         прописав в элементе <activity> параметр android:screenOrientation:
         */
        setContentView(R.layout.activity_main_navigation_drawer);

        myTitle =  getTitle();
        myDrawerTitle = getResources().getString(R.string.menu);

        // load slide menu items
        viewsNames = getResources().getStringArray(R.array.views_array); //list names in menu drawer
        myDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout); // display screen
        myDrawerList = (ListView) findViewById(R.id.left_drawer);  //шторка(curtain)

        /*
        задаем список пунктов меню для Navigation Drawer с помощью Array-адаптера.
         В качестве обработчика клика по пунктам меню используется класс DrawerItemClickListener.
         */
        myDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, viewsNames));

        // enabling action bar app icon and behaving it as toggle button
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        myDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this, myDrawerLayout, R.string.open_menu, R.string.close_menu)
        {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(myTitle);
                // calling onPrepareOptionsMenu() to show action bar icons
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(myDrawerTitle);
                // calling onPrepareOptionsMenu() to hide action bar icons
                invalidateOptionsMenu();
            }
        };
        myDrawerLayout.setDrawerListener(myDrawerToggle);//Use addDrawerListener() instead.
/*
При первой загрузке приложения  задается номер отображаемого фрагмента (нумерация с 0),
т.к. пользователь еще ничего не успел выбрать:
 */
        if (savedInstanceState == null) {
            // on first time display view for first nav item
            // Метод displayView(int position) получает в параметрах id нужного view,
            // а далее блок switch определяет, каким именно фрагментом нужно заполнить FrameLayout.
            displayView(0);
        }

        myDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        Toast.makeText(this, getResources().getString(R.string.danger_price), Toast.LENGTH_SHORT).show();
    }//----END onCrate()


    //=====================================================================
    public void Value1Event(String inputPair) {

         selectedCurrency1 = inputPair;
        Log.d("Nav.Drawer",selectedCurrency1);

    }

    @Override
    public void Value2Event(String inputPair2) {


        selectedCurrency2 = inputPair2;

    }



    //=====================================================================
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(
                AdapterView<?> parent, View view, int position, long id
        ) {
            // display view for selected nav drawer item
            displayView(position);
        }
    }

    private void displayView(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;

        switch (position) {
            case 0:

                fragment = new CurrencyListFragment();

                break;
            case 1:


                fragment = sendToFragmentBundle(fragment);
               // fragment = new AboutAppFragment();

                break;

            case 2:

                fragment = new AboutAppFragment();
                break;
            default:
                break;

        }

        if (fragment != null) {
            // install fragment in view for activity
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, fragment).commit();

            // update selected item and title, then close the drawer// Выделяем выбранный пункт, обновляем заглавие, закрываем drawer панель:
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
        //----------------------------------------
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
        // toggle nav drawer on selecting action bar app icon/title
        if (myDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

            DialogFragment infoDialog = new InfoDialogFragment();
            infoDialog.show(getFragmentManager(), "InfoApp");
            return true;



    }

    /**
     * Called when invalidateOptionsMenu() is triggered
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // if navigation drawer is opened, hide the action items
        boolean drawerOpen = myDrawerLayout.isDrawerOpen(myDrawerList);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void setTitle(CharSequence title) {
        myTitle = title;
        getSupportActionBar().setTitle(myTitle);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     * //// При спользовании ActionBarDrawerToggle, нужно вызывать методы onPostCreate() и onConfigurationChanged():
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.//  // Синхронизиет состояние переключателя после действия onRestoreInstanceState
        myDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        myDrawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume() --- --- MainNavigationDrawerActivity ");

       // new ParserDateCurrency().doParceGSON(CurrencyListFragment.readJSONOfFile(CommonResources.FILENAME));
       // CurrencyListFragment.reLoadList();


    }


    @Override
    public void onPause()
    {
        super.onPause();
       // CommonResources.showAnimation = false;
       // CommonResources.showAnimation = true;
        Log.d(LOG_TAG, "onPause() --- MainNavigationDrawerActivity");
    }

    @Override
    public void onStop(){
        super.onStop();
        //  CommonResources.showAnimation = false;
        // CommonResources.showAnimation = true;
        Log.d(LOG_TAG, "onDestroy()  --- MainNavigationDrawerActivity");

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
         CommonResources.showAnimation = true;
        Log.d(LOG_TAG, "onDestroy()  --- MainNavigationDrawerActivity");
    }

}

