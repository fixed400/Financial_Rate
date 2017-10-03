package com.netcommunicationapp.grd.financial_rate.helper;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.netcommunicationapp.grd.financial_rate.common.CommonResources;
import com.netcommunicationapp.grd.financial_rate.model.commodities_shares_pojo.Market;
import com.netcommunicationapp.grd.financial_rate.model.commodities_shares_pojo.Quote;

/**
 * Created by grd on 9/27/17.
 */

public class ParserDataShare {


    public static String LOG_TAG = "ParserCommodities";


    public ParserDataShare() {
    }


    public ParserDataCommodities doParceGSONShare (String gsonData){

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

                    case "AAPL":
                        CommonResources.arrayNameTickersShares[0] = res.getName();
                        CommonResources.arrayRateTickersShares[0] = res.getLastTradePriceOnly();
                        // CommonResources.arrayDateTickers[0] = res.getChange();
                        CommonResources.arraySymbolTickersShares[0] = res.getSymbol();
                        CommonResources.arrrayMarketStockTickersShares[0] = res.getStockExchange();
                        break;
                    case "MSFT":
                        CommonResources.arrayNameTickersShares[1] = res.getName();
                        CommonResources.arrayRateTickersShares[1] = res.getLastTradePriceOnly();
                        // CommonResources.arrayDateTickers[1] = res.getChange();
                        CommonResources.arraySymbolTickersShares[1] = res.getSymbol();
                        CommonResources.arrrayMarketStockTickersShares[1] = res.getStockExchange();
                        break;
                    case "NVDA":
                        CommonResources.arrayNameTickersShares[2] = res.getName();
                        CommonResources.arrayRateTickersShares[2] = res.getLastTradePriceOnly();
                        // CommonResources.arrayDateTickers[2] = res.getChange();
                        CommonResources.arraySymbolTickersShares[2] = res.getSymbol();
                        CommonResources.arrrayMarketStockTickersShares[2] = res.getStockExchange();
                        break;
                    case "FB":
                        CommonResources.arrayNameTickersShares[3] = res.getName();
                        CommonResources.arrayRateTickersShares[3] = res.getLastTradePriceOnly();
                        // CommonResources.arrayDateTickers[3] = res.getChange();
                        CommonResources.arraySymbolTickersShares[3] = res.getSymbol();
                        CommonResources.arrrayMarketStockTickersShares[3] = res.getStockExchange();
                        break;
                    case "GE":
                        CommonResources.arrayNameTickersShares[4] = res.getName();
                        CommonResources.arrayRateTickersShares[4] = res.getLastTradePriceOnly();
                        // CommonResources.arrayDateTickers[4] = res.getChange();
                        CommonResources.arraySymbolTickersShares[4] = res.getSymbol();
                        CommonResources.arrrayMarketStockTickersShares[4] = res.getStockExchange();
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
