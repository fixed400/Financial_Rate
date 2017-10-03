package com.netcommunicationapp.grd.financial_rate.common;

//import Rate;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by grd on 1/24/17.
 */

public class ConverterData {

    //------------Fields--------------------------

    public static double usd = (double) 1.0;  //1
    public static double eur ;  //2
    public static double gbp ;  //3
    public static double cadReverce ;  //4
    public static double jpyReverce ;  //5
    public static double chfReverce ;  //6
    public static double cnhReverce ;  //7
    public static double aud ;  //8
    public static double plnReverce ;  //9
    public static double rubReverce ;  //10
    public static double uahReverce ;  //11
    public static double btc;  //12
    public static double eth;  //13

    public static double bynReverce ;  //14
    public static double kztReverce ;  //15
    public static double tryReverce ;  //16
    public static double inrReverce ;  //17
    public static double sgdReverce ;  //18
    public static double thbReverce ;  //19
    public static double nzdReverce ;  //20
    public static double brlReverce ;  //21
    public static double mxnReverce ;  //22

    public static double pkrReverce ;  //23
    public static double egpReverce ;  //24

    public static double gelReverce ;  //25
    public static double ilsReverce ;  //26
    public static double krwReverce ;  //27
    public static double arsReverce ;  //28
    public static double clpReverce ;  //29


    public static   Map<String, Double> mapRateData = new HashMap<String, Double>();
    public static double valueFactor = (double) 0.0;
    public static double valueRatio = (double) 0.0;

    ///=============Constructor=================================
    public  ConverterData() {
        initConverterData();
    }


     public  void initConverterData() {

         mapRateData.put("USD",  usd);
         mapRateData.put("EUR", eur);  //2
         mapRateData.put("GBP", gbp);  //3
         mapRateData.put("CAD", cadReverce);  //4
         mapRateData.put("JPY", jpyReverce);  //5
         mapRateData.put("CHF", chfReverce);  //6
         mapRateData.put("CNH", cnhReverce);  //7
         mapRateData.put("AUD", aud);  //8
         mapRateData.put("PLN", plnReverce);  //9
         mapRateData.put("RUB", rubReverce);  //10
         mapRateData.put("UAH", uahReverce);  //11
         mapRateData.put("BTC", btc);  //12
         mapRateData.put("ETH", eth);  //13
         mapRateData.put("BYN", bynReverce);  //14
         mapRateData.put("KZT", kztReverce);  //15
         mapRateData.put("TRY", tryReverce);  //16
         mapRateData.put("INR", inrReverce);  //17
         mapRateData.put("SGD", sgdReverce);  //18
         mapRateData.put("THB", thbReverce);  //19
         mapRateData.put("NZD", nzdReverce);  //20
         mapRateData.put("BRL", brlReverce);  //21
         mapRateData.put("MXN", mxnReverce);  //22
         mapRateData.put("PKR", pkrReverce);  //23
         mapRateData.put("EGP", egpReverce);  //24
         mapRateData.put("GEL", gelReverce);  //25
         mapRateData.put("ILS", ilsReverce);  //26
         mapRateData.put("KRW", krwReverce);  //27
         mapRateData.put("ARS", arsReverce);  //28
         mapRateData.put("CLP", clpReverce);  //29

 }

    public static Double  fetchRateItem(String val){

        return mapRateData.get(val);
    }

 }


