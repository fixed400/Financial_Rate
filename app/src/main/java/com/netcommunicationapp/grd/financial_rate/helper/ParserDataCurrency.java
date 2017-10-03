package com.netcommunicationapp.grd.financial_rate.helper;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.netcommunicationapp.grd.financial_rate.common.ConverterData;
import com.netcommunicationapp.grd.financial_rate.common.CommonResources;
import com.netcommunicationapp.grd.financial_rate.model.currency_pojo.MarketCurrency;
import com.netcommunicationapp.grd.financial_rate.model.currency_pojo.Rate;



/**
 * Created by grd on 1/22/17.
 */

public class ParserDataCurrency {

    public static String LOG_TAG = "my_log_ParceData";


    public ParserDataCurrency(){

    }

    public ParserDataCurrency(String jsonStr){

        doParceGSON(jsonStr);
    }

    //--------------------------------------------------------------

    public ParserDataCurrency doParceGSON (String gsonData){

        try {
            //Parse
            Gson gson = new Gson();
            // MarketCurrency -> Query -> Result -> Rate -> getName();
            MarketCurrency marketCurrency = gson.fromJson(gsonData, MarketCurrency.class);

            System.out.println(" Output my JSON " + marketCurrency.getQuery().getCreated());

            StringBuffer sb = new StringBuffer();

            for (Rate res : marketCurrency.getQuery().getResults().getRate()) {

                sb.append("\n" + res.getId() + "\n" + res.getName() + "\n" + res.getRate() +
                        "\n" + res.getDate() + "\n" + res.getTime() +
                        "\n" + res.getAsk() + "\n" + res.getBid());

                switch (res.getId()) {
                    //CommonResources.arrayNameTickers[0] = res.getName();
                    // OR
                    // import static CommonResources.arrayDateTickers;
                    case "EURUSD":
                        CommonResources.arrayNameTickers[0] = res.getName();
                        CommonResources.arrayRateTickers[0] = res.getRate();
                        CommonResources.arrayDateTickers[0] = res.getDate();
                        CommonResources.arrrayTimeTickers[0] = res.getTime();
                        break;
                    case "GBPUSD":
                        CommonResources.arrayNameTickers[1] = res.getName();
                        CommonResources.arrayRateTickers[1] = res.getRate();
                        CommonResources.arrayDateTickers[1] = res.getDate();
                        CommonResources.arrrayTimeTickers[1] = res.getTime();
                        break;
                    case "BTCUSD":
                        CommonResources.arrayNameTickers[2] = res.getName();
                        CommonResources.arrayRateTickers[2] = res.getRate();
                        CommonResources.arrayDateTickers[2] = res.getDate();
                        CommonResources.arrrayTimeTickers[2] = res.getTime();
                        break;
                    case "ETHUSD":
                        CommonResources.arrayNameTickers[3] = res.getName();
                        CommonResources.arrayRateTickers[3] = res.getRate();
                        CommonResources.arrayDateTickers[3] = res.getDate();
                        CommonResources.arrrayTimeTickers[3] = res.getTime();
                        break;
                    case "USDJPY":
                        CommonResources.arrayNameTickers[4] = res.getName();
                        CommonResources.arrayRateTickers[4] = res.getRate();
                        CommonResources.arrayDateTickers[4] = res.getDate();
                        CommonResources.arrrayTimeTickers[4] = res.getTime();
                        break;
                    case "USDCHF":
                        CommonResources.arrayNameTickers[5] = res.getName();
                        CommonResources.arrayRateTickers[5] = res.getRate();
                        CommonResources.arrayDateTickers[5] = res.getDate();
                        CommonResources.arrrayTimeTickers[5] = res.getTime();
                        break;
                    case "AUDUSD":
                        CommonResources.arrayNameTickers[6] = res.getName();
                        CommonResources.arrayRateTickers[6] = res.getRate();
                        CommonResources.arrayDateTickers[6] = res.getDate();
                        CommonResources.arrrayTimeTickers[6] = res.getTime();
                        break;
                    case "USDCAD":
                        CommonResources.arrayNameTickers[7] = res.getName();
                        CommonResources.arrayRateTickers[7] = res.getRate();
                        CommonResources.arrayDateTickers[7] = res.getDate();
                        CommonResources.arrrayTimeTickers[7] = res.getTime();
                        break;
                    case "USDCNH":
                        CommonResources.arrayNameTickers[8] = res.getName();
                        CommonResources.arrayRateTickers[8] = res.getRate();
                        CommonResources.arrayDateTickers[8] = res.getDate();
                        CommonResources.arrrayTimeTickers[8] = res.getTime();
                        break;
                    case "USDPLN":
                        CommonResources.arrayNameTickers[9] = res.getName();
                        CommonResources.arrayRateTickers[9] = res.getRate();
                        CommonResources.arrayDateTickers[9] = res.getDate();
                        CommonResources.arrrayTimeTickers[9] = res.getTime();
                        break;
                    case "USDRUB":
                        CommonResources.arrayNameTickers[10] = res.getName();
                        //arrayRateTickers[0]=res.getDate();
                        CommonResources.arrayRateTickers[10] = res.getRate();
                        CommonResources.arrayDateTickers[10] = res.getDate();
                        CommonResources.arrrayTimeTickers[10] = res.getTime();
                        break;
                    case "USDUAH":
                        CommonResources.arrayNameTickers[11] = res.getName();
                        CommonResources.arrayRateTickers[11] = res.getRate();
                        CommonResources.arrayDateTickers[11] = res.getDate();
                        CommonResources.arrrayTimeTickers[11] = res.getTime();
                        break;
                    case "EURGBP":
                        CommonResources.arrayNameTickers[12] = res.getName();
                        CommonResources.arrayRateTickers[12] = res.getRate();
                        CommonResources.arrayDateTickers[12] = res.getDate();
                        CommonResources.arrrayTimeTickers[12] = res.getTime();
                        break;
                    case "BTCEUR":
                        CommonResources.arrayNameTickers[13] = res.getName();
                        CommonResources.arrayRateTickers[13] = res.getRate();
                        CommonResources.arrayDateTickers[13] = res.getDate();
                        CommonResources.arrrayTimeTickers[13] = res.getTime();
                        break;
                    case "EURPLN":
                        CommonResources.arrayNameTickers[14] = res.getName();
                        CommonResources.arrayRateTickers[14] = res.getRate();
                        CommonResources.arrayDateTickers[14] = res.getDate();
                        CommonResources.arrrayTimeTickers[14] = res.getTime();
                        break;
                    case "EURRUB":
                        CommonResources.arrayNameTickers[15] = res.getName();
                        CommonResources.arrayRateTickers[15] = res.getRate();
                        CommonResources.arrayDateTickers[15] = res.getDate();
                        CommonResources.arrrayTimeTickers[15] = res.getTime();
                        break;
                    case "EURUAH":
                        CommonResources.arrayNameTickers[16] = res.getName();
                        CommonResources.arrayRateTickers[16] = res.getRate();
                        CommonResources.arrayDateTickers[16] = res.getDate();
                        CommonResources.arrrayTimeTickers[16] = res.getTime();
                        break;

                    case "BTCPLN":
                        CommonResources.arrayNameTickers[17] = res.getName();
                        CommonResources.arrayRateTickers[17] = res.getRate();
                        CommonResources.arrayDateTickers[17] = res.getDate();
                        CommonResources.arrrayTimeTickers[17] = res.getTime();
                        break;
                    case "BTCRUB":
                        CommonResources.arrayNameTickers[18] = res.getName();
                        CommonResources.arrayRateTickers[18] = res.getRate();
                        CommonResources.arrayDateTickers[18] = res.getDate();
                        CommonResources.arrrayTimeTickers[18] = res.getTime();
                        break;
                    case "BTCUAH":
                        CommonResources.arrayNameTickers[19] = res.getName();
                        CommonResources.arrayRateTickers[19] = res.getRate();
                        CommonResources.arrayDateTickers[19] = res.getDate();
                        CommonResources.arrrayTimeTickers[19] = res.getTime();
                        break;
                    case "BYNRUB":
                        CommonResources.arrayNameTickers[20] = res.getName();
                        CommonResources.arrayRateTickers[20] = res.getRate();
                        CommonResources.arrayDateTickers[20] = res.getDate();
                        CommonResources.arrrayTimeTickers[20] = res.getTime();
                        break;
                    case "USDBYN":
                        CommonResources.arrayNameTickers[21] = res.getName();
                        CommonResources.arrayRateTickers[21] = res.getRate();
                        CommonResources.arrayDateTickers[21] = res.getDate();
                        CommonResources.arrrayTimeTickers[21] = res.getTime();
                        break;
                    case "KZTRUB":
                        CommonResources.arrayNameTickers[22] = res.getName();
                        CommonResources.arrayRateTickers[22] = res.getRate();
                        CommonResources.arrayDateTickers[22] = res.getDate();
                        CommonResources.arrrayTimeTickers[22] = res.getTime();
                        break;
                    case "USDKZT":
                        CommonResources.arrayNameTickers[23] = res.getName();
                        CommonResources.arrayRateTickers[23] = res.getRate();
                        CommonResources.arrayDateTickers[23] = res.getDate();
                        CommonResources.arrrayTimeTickers[23] = res.getTime();
                        break;
                    case "USDGEL":
                        CommonResources.arrayNameTickers[24] = res.getName();
                        CommonResources.arrayRateTickers[24] = res.getRate();
                        CommonResources.arrayDateTickers[24] = res.getDate();
                        CommonResources.arrrayTimeTickers[24] = res.getTime();
                        break;

                    case "USDTRY":
                        CommonResources.arrayNameTickers[25] = res.getName();
                        CommonResources.arrayRateTickers[25] = res.getRate();
                        CommonResources.arrayDateTickers[25] = res.getDate();
                        CommonResources.arrrayTimeTickers[25] = res.getTime();
                        break;
                    case "USDILS":
                        CommonResources.arrayNameTickers[26] = res.getName();
                        CommonResources.arrayRateTickers[26] = res.getRate();
                        CommonResources.arrayDateTickers[26] = res.getDate();
                        CommonResources.arrrayTimeTickers[26] = res.getTime();
                        break;
                    case "USDINR":
                        CommonResources.arrayNameTickers[27] = res.getName();
                        CommonResources.arrayRateTickers[27] = res.getRate();
                        CommonResources.arrayDateTickers[27] = res.getDate();
                        CommonResources.arrrayTimeTickers[27] = res.getTime();
                        break;


                    case "USDPKR":
                        CommonResources.arrayNameTickers[28] = res.getName();
                        CommonResources.arrayRateTickers[28] = res.getRate();
                        CommonResources.arrayDateTickers[28] = res.getDate();
                        CommonResources.arrrayTimeTickers[28] = res.getTime();
                        break;
                    case "USDEGP":
                        CommonResources.arrayNameTickers[29] = res.getName();
                        CommonResources.arrayRateTickers[29] = res.getRate();
                        CommonResources.arrayDateTickers[29] = res.getDate();
                        CommonResources.arrrayTimeTickers[29] = res.getTime();
                        break;


                    case "USDTHB":
                        CommonResources.arrayNameTickers[30] = res.getName();
                        CommonResources.arrayRateTickers[30] = res.getRate();
                        CommonResources.arrayDateTickers[30] = res.getDate();
                        CommonResources.arrrayTimeTickers[30] = res.getTime();
                        break;

                    case "USDSGD":
                        CommonResources.arrayNameTickers[31] = res.getName();
                        CommonResources.arrayRateTickers[31] = res.getRate();
                        CommonResources.arrayDateTickers[31] = res.getDate();
                        CommonResources.arrrayTimeTickers[31] = res.getTime();
                        break;

                    case "USDNZD":
                        CommonResources.arrayNameTickers[32] = res.getName();
                        CommonResources.arrayRateTickers[32] = res.getRate();
                        CommonResources.arrayDateTickers[32] = res.getDate();
                        CommonResources.arrrayTimeTickers[32] = res.getTime();
                        break;
                    case "USDBRL":
                        CommonResources.arrayNameTickers[33] = res.getName();
                        CommonResources.arrayRateTickers[33] = res.getRate();
                        CommonResources.arrayDateTickers[33] = res.getDate();
                        CommonResources.arrrayTimeTickers[33] = res.getTime();
                        break;
                    case "USDMXN":
                        CommonResources.arrayNameTickers[34] = res.getName();
                        CommonResources.arrayRateTickers[34] = res.getRate();
                        CommonResources.arrayDateTickers[34] = res.getDate();
                        CommonResources.arrrayTimeTickers[34] = res.getTime();
                        break;




                    /*
                    case "USDILS":
                        CommonResources.arrayNameTickers[33] = res.getName();
                        CommonResources.arrayRateTickers[33] = res.getRate();
                        CommonResources.arrayDateTickers[33] = res.getDate();
                        CommonResources.arrrayTimeTickers[33] = res.getTime();
                        break;
                    case "USDKRW":
                        CommonResources.arrayNameTickers[34] = res.getName();
                        CommonResources.arrayRateTickers[34] = res.getRate();
                        CommonResources.arrayDateTickers[34] = res.getDate();
                        CommonResources.arrrayTimeTickers[34] = res.getTime();
                        break;
                    case "USDARS":
                        CommonResources.arrayNameTickers[35] = res.getName();
                        CommonResources.arrayRateTickers[35] = res.getRate();
                        CommonResources.arrayDateTickers[35] = res.getDate();
                        CommonResources.arrrayTimeTickers[35] = res.getTime();
                        break;
                    case "USDCLP":
                        CommonResources.arrayNameTickers[36] = res.getName();
                        CommonResources.arrayRateTickers[36] = res.getRate();
                        CommonResources.arrayDateTickers[36] = res.getDate();
                        CommonResources.arrrayTimeTickers[36] = res.getTime();
                        break;
                        */


                }//-- End switch
                    //------------------& switch 2 for convertor------------------

                switch (res.getId()) {
                    //CommonResources.arrayNameTickers[0] = res.getName();
                    // OR
                    // import static CommonResources.arrayDateTickers;
                    case "EURUSD":

                        ConverterData.eur= Float.parseFloat(res.getRate());
                        break;
                    case "GBPUSD":

                        ConverterData.gbp= Float.parseFloat(res.getRate());
                        break;
                    case "BTCUSD":

                        ConverterData.btc= Float.parseFloat(res.getRate());
                        break;
                    //ETHUSD
                    case "ETHUSD":

                        ConverterData.eth= Float.parseFloat(res.getRate());
                        break;
                    case "USDJPY":

                        ConverterData.jpyReverce = ConverterData.usd/Float.parseFloat(res.getRate());
                        break;
                    case "USDCHF":

                        ConverterData.chfReverce = ConverterData.usd/Float.parseFloat(res.getRate());
                        break;
                    case "AUDUSD":

                        ConverterData.aud= Float.parseFloat(res.getRate());
                        break;
                    case "USDCAD":

                        ConverterData.cadReverce = ConverterData.usd/Float.parseFloat(res.getRate());
                        break;
                    case "USDCNH":

                        ConverterData.cnhReverce = ConverterData.usd/Float.parseFloat(res.getRate());
                        break;
                    case "USDPLN":
                        ConverterData.plnReverce = ConverterData.usd/Float.parseFloat(res.getRate());
                        break;
                    case "USDRUB":

                        ConverterData.rubReverce = ConverterData.usd/Float.parseFloat(res.getRate());
                        break;
                    case "USDUAH":

                        ConverterData.uahReverce = ConverterData.usd/Float.parseFloat(res.getRate());
                        break;
                    //-----------------
                    case "USDBYN":

                        ConverterData.bynReverce = ConverterData.usd/Float.parseFloat(res.getRate());
                        break;
                    case "USDKZT":

                        ConverterData.kztReverce = ConverterData.usd/Float.parseFloat(res.getRate());
                        break;
                    case "USDGEL":

                        ConverterData.gelReverce = ConverterData.usd/Float.parseFloat(res.getRate());
                        break;
                    case "USDTRY":

                        ConverterData.tryReverce = ConverterData.usd/Float.parseFloat(res.getRate());
                        break;
                    case "USDILS":

                        ConverterData.ilsReverce = ConverterData.usd/Float.parseFloat(res.getRate());
                        break;

                    case "USDINR":

                        ConverterData.inrReverce = ConverterData.usd/Float.parseFloat(res.getRate());
                        break;

                    case "USDTHB":
                        ConverterData.thbReverce = ConverterData.usd/Float.parseFloat(res.getRate());
                        break;
                    case "USDSGD":

                        ConverterData.sgdReverce = ConverterData.usd/Float.parseFloat(res.getRate());
                        break;
                    case "USDNZD":

                        ConverterData.nzdReverce = ConverterData.usd/Float.parseFloat(res.getRate());
                        break;
                    case "USDBRL":

                        ConverterData.brlReverce = ConverterData.usd/Float.parseFloat(res.getRate());
                        break;
                    case "USDMXN":

                        ConverterData.mxnReverce = ConverterData.usd/Float.parseFloat(res.getRate());
                        break;

                    case "USDPKR":

                        ConverterData.pkrReverce = ConverterData.usd/Float.parseFloat(res.getRate());
                        break;
                    case "USDEGP":

                        ConverterData.egpReverce = ConverterData.usd/Float.parseFloat(res.getRate());
                        break;


                }//-- End switch

            }// end for

        } catch (JsonParseException e) {
            System.out.println("!!!------- CAUGHT Exception JSON   " );
            e.printStackTrace();
        } catch (Exception e){
            Log.d(LOG_TAG, " -----!!! Exception ParseGSON!!!--- "+e.getMessage());
            System.out.println("CAUGHT Exception " );
            e.printStackTrace();
        }

        return null;
    }


}
