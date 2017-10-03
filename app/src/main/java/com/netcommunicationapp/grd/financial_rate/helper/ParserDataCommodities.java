package com.netcommunicationapp.grd.financial_rate.helper;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.netcommunicationapp.grd.financial_rate.common.CommonResources;
import com.netcommunicationapp.grd.financial_rate.model.commodities_shares_pojo.Market;
import com.netcommunicationapp.grd.financial_rate.model.commodities_shares_pojo.Quote;


/**
 * Created by grd on 9/26/17.
 */

public class ParserDataCommodities {

    public static String LOG_TAG = "ParserCommodities";


    public ParserDataCommodities() {
    }


    public ParserDataCommodities doParceGSONCommodities (String gsonData){

        try {
            //Parse
            Gson gson = new Gson();
            // MarketCurrency -> Query -> Result -> Rate -> getName();
            Market market = gson.fromJson(gsonData, Market.class);

            System.out.println(" Output my JSON " + market.getQuery().getCreated());

            StringBuffer sb = new StringBuffer();

            for (Quote res : market.getQuery().getResults().getQuote()) {

                sb.append("\n" + res.getChange() + "\n" + res.getDaysLow() + "\n" + res.getDaysHigh() +
                        "\n" + res.getYearLow() + "\n" + res.getYearHigh() +
                        "\n" + res.getLastTradePriceOnly() + "\n" + res.getDaysRange() +"\n"
                        + res.getName() + "\n" + res.getSymbol()+
                        "\n"+res.getVolume() + "\n" + res.getStockExchange() );


                switch (res.getSymbol()) {
                    //CommonResources.arrayNameTickers[0] = res.getName();
                    // OR
                    // import static CommonResources.arrayDateTickers;
                    case "BZ=F":
                        // For Array
                        CommonResources.arrayNameTickersCommodities[0] = res.getName();
                        CommonResources.arrayRateTickersCommodities[0] = res.getLastTradePriceOnly();
                        CommonResources.arrayDateTickersCommodities[0] = res.getChange();
                        CommonResources.arrayDateTickersCommodities[0] = res.getSymbol();
                        CommonResources.arrrayTimeTickersCommodities[0] = res.getStockExchange();

                        // for List


                        CommonResources.listNameTickersCommodities.add(res.getName());
                        CommonResources.listRateTickersCommodities.add(res.getLastTradePriceOnly());
                        CommonResources.listChangeTickersCommodities.add(res.getChange());
                        CommonResources.listarrayDateTickersCommodities.add(res.getSymbol());
                        CommonResources.listTimeTickersCommodities.add(res.getStockExchange());

                       // CommonResources.commoditiesMap.put();

                        break;
                    case "CL=F":
                        CommonResources.arrayNameTickersCommodities[1] = res.getName();
                        CommonResources.arrayRateTickersCommodities[1] = res.getLastTradePriceOnly();
                        CommonResources.arrayChangeTickersCommodities[1] = res.getChange();
                        CommonResources.arrayDateTickersCommodities[1] = res.getSymbol();
                        CommonResources.arrrayTimeTickersCommodities[1] = res.getStockExchange();

                        CommonResources.listNameTickersCommodities.add(res.getName());
                        CommonResources.listRateTickersCommodities.add(res.getLastTradePriceOnly());
                        CommonResources.listChangeTickersCommodities.add(res.getChange());
                        CommonResources.listarrayDateTickersCommodities.add(res.getSymbol());
                        CommonResources.listTimeTickersCommodities.add(res.getStockExchange());

                        break;
                    case "NG=F":
                        CommonResources.arrayNameTickersCommodities[2] = res.getName();
                        CommonResources.arrayRateTickersCommodities[2] = res.getLastTradePriceOnly();
                        CommonResources.arrayChangeTickersCommodities[2] = res.getChange();
                        CommonResources.arrayDateTickersCommodities[2] = res.getSymbol();
                        CommonResources.arrrayTimeTickersCommodities[2] = res.getStockExchange();


                        CommonResources.listNameTickersCommodities.add(res.getName());
                        CommonResources.listRateTickersCommodities.add(res.getLastTradePriceOnly());
                        CommonResources.listChangeTickersCommodities.add(res.getChange());
                        CommonResources.listarrayDateTickersCommodities.add(res.getSymbol());
                        CommonResources.listTimeTickersCommodities.add(res.getStockExchange());

                        break;
                    case "GC=F":
                        CommonResources.arrayNameTickersCommodities[3] = res.getName();
                        CommonResources.arrayRateTickersCommodities[3] = res.getLastTradePriceOnly();
                        CommonResources.arrayChangeTickersCommodities[3] = res.getChange();
                        CommonResources.arrayDateTickersCommodities[3] = res.getSymbol();
                        CommonResources.arrrayTimeTickersCommodities[3] = res.getStockExchange();


                        CommonResources.listNameTickersCommodities.add(res.getName());
                        CommonResources.listRateTickersCommodities.add(res.getLastTradePriceOnly());
                        CommonResources.listChangeTickersCommodities.add(res.getChange());
                        CommonResources.listarrayDateTickersCommodities.add(res.getSymbol());
                        CommonResources.listTimeTickersCommodities.add(res.getStockExchange());

                        break;
                    case "SI=F":
                        CommonResources.arrayNameTickersCommodities[4] = res.getName();
                        CommonResources.arrayRateTickersCommodities[4] = res.getLastTradePriceOnly();
                        CommonResources.arrayChangeTickersCommodities[4] = res.getChange();
                        CommonResources.arrayDateTickersCommodities[4] = res.getSymbol();
                        CommonResources.arrrayTimeTickersCommodities[4] = res.getStockExchange();

                        CommonResources.listNameTickersCommodities.add(res.getName());
                        CommonResources.listRateTickersCommodities.add(res.getLastTradePriceOnly());
                        CommonResources.listChangeTickersCommodities.add(res.getChange());
                        CommonResources.listarrayDateTickersCommodities.add(res.getSymbol());
                        CommonResources.listTimeTickersCommodities.add(res.getStockExchange());

                        break;
                    case "PL=F":
                        CommonResources.arrayNameTickersCommodities[5] = res.getName();
                        CommonResources.arrayRateTickersCommodities[5] = res.getLastTradePriceOnly();
                        CommonResources.arrayChangeTickersCommodities[5] = res.getChange();
                        CommonResources.arrayDateTickersCommodities[5] = res.getSymbol();
                        CommonResources.arrrayTimeTickersCommodities[5] = res.getStockExchange();

                        CommonResources.listNameTickersCommodities.add(res.getName());
                        CommonResources.listRateTickersCommodities.add(res.getLastTradePriceOnly());
                        CommonResources.listChangeTickersCommodities.add(res.getChange());
                        CommonResources.listarrayDateTickersCommodities.add(res.getSymbol());
                        CommonResources.listTimeTickersCommodities.add(res.getStockExchange());

                        break;
                    case "ZW=F":
                        CommonResources.arrayNameTickersCommodities[6] = res.getName();
                        CommonResources.arrayRateTickersCommodities[6] = res.getLastTradePriceOnly();
                        CommonResources.arrayChangeTickersCommodities[6] = res.getChange();
                        CommonResources.arrayDateTickersCommodities[6] = res.getSymbol();
                        CommonResources.arrrayTimeTickersCommodities[6] = res.getStockExchange();


                        CommonResources.listNameTickersCommodities.add(res.getName());
                        CommonResources.listRateTickersCommodities.add(res.getLastTradePriceOnly());
                        CommonResources.listChangeTickersCommodities.add(res.getChange());
                        CommonResources.listarrayDateTickersCommodities.add(res.getSymbol());
                        CommonResources.listTimeTickersCommodities.add(res.getStockExchange());

                        break;
                    case "KC=F":
                        CommonResources.arrayNameTickersCommodities[7] = res.getName();
                        CommonResources.arrayRateTickersCommodities[7] = res.getLastTradePriceOnly();
                        CommonResources.arrayChangeTickersCommodities[7] = res.getChange();
                        CommonResources.arrayDateTickersCommodities[7] = res.getSymbol();
                        CommonResources.arrrayTimeTickersCommodities[7] = res.getStockExchange();


                        CommonResources.listNameTickersCommodities.add(res.getName());
                        CommonResources.listRateTickersCommodities.add(res.getLastTradePriceOnly());
                        CommonResources.listChangeTickersCommodities.add(res.getChange());
                        CommonResources.listarrayDateTickersCommodities.add(res.getSymbol());
                        CommonResources.listTimeTickersCommodities.add(res.getStockExchange());

                        break;
                    case "SB=F":
                        CommonResources.arrayNameTickersCommodities[8] = res.getName();
                        CommonResources.arrayRateTickersCommodities[8] = res.getLastTradePriceOnly();
                        CommonResources.arrayChangeTickersCommodities[8] = res.getChange();
                        CommonResources.arrayDateTickersCommodities[8] = res.getSymbol();
                        CommonResources.arrrayTimeTickersCommodities[8] = res.getStockExchange();


                        CommonResources.listNameTickersCommodities.add(res.getName());
                        CommonResources.listRateTickersCommodities.add(res.getLastTradePriceOnly());
                        CommonResources.listChangeTickersCommodities.add(res.getChange());
                        CommonResources.listarrayDateTickersCommodities.add(res.getSymbol());
                        CommonResources.listTimeTickersCommodities.add(res.getStockExchange());

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
