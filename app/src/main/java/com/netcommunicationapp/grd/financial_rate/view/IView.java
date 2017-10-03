package com.netcommunicationapp.grd.financial_rate.view;

import android.view.View;

/**
 * Created by grd on 9/26/17.
 */


/*
When you define a new interface, you are defining a new reference data type.
 You can use interface names anywhere you can use any other data type name.
  If you define a reference variable whose type is an interface,
  any object you assign to it must be an instance of a class that implements the interface.
  //---------------------------------------------
Когда вы определяете новый интерфейс, вы определяете новый тип ссылочных данных.
 Вы можете использовать имена интерфейсов везде, где вы можете использовать любое другое имя типа данных.
 Если вы определяете ссылочную переменную, тип которой является интерфейсом, любой объект,
  который вы ему назначаете, должен быть экземпляром класса, который реализует интерфейс.

  A aa = new AImpl();
aa.a();
Here your reference variable is interface A type But actual Object is AImpl.


 IView iView;
       iView = new CurrencyListFragment();

        iView.loadList();


 */



//public abstract interface IView  {
public  abstract interface IView  {

   public abstract void showNotice();
   public abstract void loadList();


}
