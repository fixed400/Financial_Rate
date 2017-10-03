package com.netcommunicationapp.grd.financial_rate.market_model;

import com.netcommunicationapp.grd.financial_rate.common.CommonResources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
// DEFAULT GENERATE CODE - AND my custom version
public class MarketCommoditiesContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<MarketItem> ITEMS = new ArrayList<MarketItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, MarketItem> ITEM_MAP = new HashMap<String, MarketItem>();


   // private static final int COUNT = 9;
    private static final int COUNT = CommonResources.listNameTickersCommodities.size();
   // private static final int COUNT = CommonResources.arrayNameTickersCommodities.length;

    //static блок выполняется при первом обращении к классу. А нужен он для инициализации статических полей
    //Зачем вызывать каждый раз инициализацию статических переменных в конструкторе?,
    // если можно сделать это единожды, таким образом не тратить ресурсы на повторные инициализации
    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    //fill,fill_in,fill_out,supplement - пополнять  ,replenish - дополнять
    private static void addItem(MarketItem item) {
        ITEMS.add(item); // fill list
        ITEM_MAP.put(item.id, item); // fill map
    }

    private static MarketItem createDummyItem(int i) {
        int position = i - 1;
        // "Hello World".substring(6) -> "World" --- cut sTRING
        return new MarketItem(CommonResources.listNameTickersCommodities.get(position).substring(0, 15),
                CommonResources.listRateTickersCommodities.get(position),
                CommonResources.listChangeTickersCommodities.get(position) + " %",
                CommonResources.listarrayDateTickersCommodities.get(position),
                CommonResources.listTimeTickersCommodities.get(position));
    }


    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class MarketItem {

        public final String content;
        public final String content1;
        public final String content2;
        public final String content3;
        public final String content4;
        public String id = "1";// dummy for Map (dummy - фиктивный)


        public MarketItem(String content, String content1 ,
                          String content2, String content3, String content4) {

            this.content = content;
            this.content1 = content1;
            this.content2 = content2;
            this.content3 = content3;
            this.content4 = content4;

        }


    }
}
