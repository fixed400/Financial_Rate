package com.netcommunicationapp.grd.financial_rate.util;

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

    public static double bynReverce ;  //13
    public static double kztReverce ;  //14
    public static double tryReverce ;  //15
    public static double inrReverce ;  //16
    public static double sgdReverce ;  //17
    public static double thbReverce ;  //18
    public static double nzdReverce ;  //19
    public static double brlReverce ;  //20
    public static double mxnReverce ;  //21

    public static double pkrReverce ;  //22
    public static double egpReverce ;  //23

    public static double gelReverce ;  //13
    public static double ilsReverce ;  //14
    public static double krwReverce ;  //15
    public static double arsReverce ;  //16
    public static double clpReverce ;  //17


    public static   Map<String, Double> mapRateData = new HashMap<String, Double>();

    public static double  valueOne = (double) 0.0;
    public static double  valueTwo = (double) 0.0;

    ///=============Constructor=================================
    public  ConverterData() {
        intitConverterData();
    }


     public  void intitConverterData() {

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

         //!!add new
         mapRateData.put("BYN", bynReverce);  //13
         mapRateData.put("KZT", kztReverce);  //14
         mapRateData.put("TRY", tryReverce);  //15
         mapRateData.put("INR", inrReverce);  //16
         mapRateData.put("SGD", sgdReverce);  //17
         mapRateData.put("THB", thbReverce);  //18
         mapRateData.put("NZD", nzdReverce);  //19
         mapRateData.put("BRL", brlReverce);  //20
         mapRateData.put("MXN", mxnReverce);  //21

        // "BYN","KZT","TRY","INR","SGD","THB","NZD","BRL","MXN"

         mapRateData.put("PKR", pkrReverce);  //22
         mapRateData.put("EGP", egpReverce);  //23

         //!!add new
         mapRateData.put("GEL", gelReverce);  //24
         mapRateData.put("ILS", ilsReverce);  //25
         mapRateData.put("KRW", krwReverce);  //26
         mapRateData.put("ARS", arsReverce);  //27
         mapRateData.put("CLP", clpReverce);  //28



 }

    public static Double  fetchRateItem(String val){

        Double res = null;
        res = mapRateData.get(val);

        return res;
    }

 }


