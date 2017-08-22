package com.netcommunicationapp.grd.financial_rate.common;

/**
 * Created by grd on 1/20/17.
 */

public class CommonResources {



    // ---- часто обновления данных---
    //лимит 2000 запросов в 24  часа

    public final static int update_frequency = 900_100;////15 минут
    // public final static int update_frequency = 30_100;//30sec

    public final static String FILENAME = "my_sample.txt"; // имя файла
    //https://query.yahooapis.com/v1/public/yql?q=select+*+from+yahoo.finance.xchange+where+pair+=+%22USDRUB,EURRUB%22&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys
    //String hostData = "https://query.yahooapis.com/v1/public/yql?q=select+*+from+yahoo.finance.xchange+where+pair+=+%22USDRUB,EURRUB%22&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
   // public static final String hostData ="https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22EURUSD%22%2C%20%22GBPUSD%22%2C%20%22BTCUSD%22%2C%20%22%20%09USDJPY%22%2C%20%22USDCHF%22%2C%20%22AUDUSD%22%2C%20%22USDCAD%22%2C%20%22USDCNH%22%2C%20%22USDPLN%22%2C%20%22USDRUB%22%2C%20%22USDUAH%22%2C%20%22EURGBP%22%2C%22BTCEUR%22%2C%22EURPLN%22%2C%22EURRUB%22%2C%22EURUAH%22%2C%22BTCPLN%22%2C%22BTCRUB%22%2C%22BTCUAH%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=";

   // public static boolean endMainActitvity =false;




    //30
   // public static final String hostData1="https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22EURUSD%22%20%2C%0A%22GBPUSD%22%2C%0A%22BTCUSD%22%20%2C%0A%22USDJPY%22%20%2C%0A%22USDCHF%22%20%2C%0A%22AUDUSD%22%20%2C%0A%22USDCAD%22%20%2C%0A%22USDCNH%22%20%2C%0A%22USDPLN%22%20%2C%0A%22USDRUB%22%20%2C%0A%22USDUAH%22%20%2C%0A%22EURGBP%22%20%2C%0A%22BTCEUR%22%20%2C%0A%22EURPLN%22%20%2C%0A%22EURRUB%22%20%2C%0A%22EURUAH%22%2C%0A%22BTCPLN%22%2C%0A%22BTCRUB%22%2C%0A%22BTCUAH%22%2C%22RUBBYN%22%2C%22USDBYN%22%2C%22USDKZT%22%2C%22RUBKZT%22%2C%22USDTRY%22%2C%22USDINR%22%2C%22USDBRL%22%2C%22USDNZD%22%2C%22USDSGD%22%2C%22USDMXN%22%2C%22USDTHB%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=";
    //32
   // public static final String hostData2 ="https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22EURUSD%22%20%2C%0A%22GBPUSD%22%2C%0A%22BTCUSD%22%20%2C%0A%22USDJPY%22%20%2C%0A%22USDCHF%22%20%2C%0A%22AUDUSD%22%20%2C%0A%22USDCAD%22%20%2C%0A%22USDCNH%22%20%2C%0A%22USDPLN%22%20%2C%0A%22USDRUB%22%20%2C%0A%22USDUAH%22%20%2C%0A%22EURGBP%22%20%2C%0A%22BTCEUR%22%20%2C%0A%22EURPLN%22%20%2C%0A%22EURRUB%22%20%2C%0A%22EURUAH%22%2C%0A%22BTCPLN%22%2C%0A%22BTCRUB%22%2C%0A%22BTCUAH%22%2C%22BYNRUB%22%2C%22USDBYN%22%2C%22USDKZT%22%2C%22KZTRUB%22%2C%22USDTRY%22%2C%22USDINR%22%2C%22USDBRL%22%2C%22USDNZD%22%2C%22USDSGD%22%2C%22USDMXN%22%2C%22USDTHB%22%2C%22USDPKR%22%2C%22USDEGP%20%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=";
    //37
    // https://developer.yahoo.com/yql/console/?q=show%20tables&env=store://datatables.org/alltableswithkeys&debug=true#h=select+*+from+yahoo.finance.xchange+where+pair+in+(%22EURUSD%22%2C%0A%22GBPUSD%22%2C%0A%22BTCUSD%22%2C%0A%22USDJPY%22%2C%0A%22USDCHF%22%2C%0A%22AUDUSD%22%2C%0A%22USDCAD%22%2C%0A%22USDCNH%22%2C%0A%22USDPLN%22%2C%0A%22USDRUB%22%2C%0A%22USDUAH%22%2C%0A%22EURGBP%22%2C%0A%22BTCEUR%22%2C%0A%22EURPLN%22%2C%0A%22EURRUB%22%2C%0A%22EURUAH%22%2C%0A%22BTCPLN%22%2C%0A%22BTCRUB%22%2C%0A%22BTCUAH%22%2C%0A%22BYNRUB%22%2C%0A%22USDBYN%22%2C%0A%22USDKZT%22%2C%0A%22KZTRUB%22%2C%0A%22USDPKR%22%2C%0A%22USDEGP%22%2C%0A%22USDTRY%22%2C%0A%22USDINR%22%2C%0A%22USDBRL%22%2C%0A%22USDNZD%22%2C%0A%22USDSGD%22%2C%0A%22USDMXN%22%2C%0A%22USDTHB%22%2C%0A%22USDGEL%22%2C%0A%22USDILS%22%2C%0A%22USDKRW%22%2C%0A%22USDARS%22%2C%0A%22USDCLP%22)
    public static final String  hostData ="https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22EURUSD%22%2C%0A%22GBPUSD%22%2C%0A%22BTCUSD%22%2C%0A%22USDJPY%22%2C%0A%22USDCHF%22%2C%0A%22AUDUSD%22%2C%0A%22USDCAD%22%2C%0A%22USDCNH%22%2C%0A%22USDPLN%22%2C%0A%22USDRUB%22%2C%0A%22USDUAH%22%2C%0A%22EURGBP%22%2C%0A%22BTCEUR%22%2C%0A%22EURPLN%22%2C%0A%22EURRUB%22%2C%0A%22EURUAH%22%2C%0A%22BTCPLN%22%2C%0A%22BTCRUB%22%2C%0A%22BTCUAH%22%2C%0A%22BYNRUB%22%2C%0A%22USDBYN%22%2C%0A%22USDKZT%22%2C%0A%22KZTRUB%22%2C%0A%22USDPKR%22%2C%0A%22USDEGP%22%2C%0A%22USDTRY%22%2C%0A%22USDINR%22%2C%0A%22USDBRL%22%2C%0A%22USDNZD%22%2C%0A%22USDSGD%22%2C%0A%22USDMXN%22%2C%0A%22USDTHB%22%2C%0A%22USDGEL%22%2C%0A%22USDILS%22%2C%0A%22USDKRW%22%2C%0A%22USDARS%22%2C%0A%22USDCLP%22)&format=json&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=";

    //37
    /*
    "EURUSD",
    "GBPUSD",
    "BTCUSD",
    "USDJPY",
    "USDCHF",
    "AUDUSD",
    "USDCAD",
    "USDCNH",
    "USDPLN",
    "USDRUB",
    "USDUAH",
    "EURGBP",
    "BTCEUR",
    "EURPLN",
    "EURRUB",
    "EURUAH",
    "BTCPLN",
    "BTCRUB",
    "BTCUAH",
    "BYNRUB",
    "USDBYN",
    "USDKZT",
    "KZTRUB",
    "USDPKR",
    "USDEGP",
    "USDTRY",
    "USDINR",
    "USDBRL",
    "USDNZD",
    "USDSGD",
    "USDMXN",
    "USDTHB",
    "USDGEL",
    "USDILS",
    "USDKRW",
    "USDARS",
    "USDCLP"
     */

    public static boolean endMainActitvity =false;

    public static int contoleer = 0;

    public static boolean dataHasBeenDownloaded= false;

   public static String[] arrayNameTickers = new String[34];
    public static String[] arrayRateTickers = new String[34];
    public static String[] arrayDateTickers = new String[34];
    public static String[] arrrayTimeTickers = new String[34];



    /*
    public static String[] arrayNameTickers = new String[27];


    public static String[] arrayRateTickers = new String[27];
    public static String[] arrayDateTickers = new String[27];
    public static String[] arrrayTimeTickers = new String[27];

      /*
   public static String[] arrayNameTickers = new String[37];


    public static String[] arrayRateTickers = new String[37];
    public static String[] arrayDateTickers = new String[37];
    public static String[] arrrayTimeTickers = new String[37];

    */


    /*
     public static String[] arrayNameTickers = new String[19];


    public static String[] arrayRateTickers = new String[19];
    public static String[] arrayDateTickers = new String[19];
    public static String[] arrrayTimeTickers = new String[19];
     */

    public static String ratePair1;
    public static String ratePair2;


    public static boolean showAnimation = true;



    //---------------- constructor------------
    CommonResources(){}



}
