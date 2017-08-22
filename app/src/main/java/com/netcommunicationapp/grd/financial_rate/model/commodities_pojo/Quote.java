package com.netcommunicationapp.grd.financial_rate.model.commodities_pojo;

/**
 * Created by grd on 1/24/17.
 */

public class Quote {



    private String YearLow;

    private String symbol;

    private String Change;

    private String Volume;

    private String LastTradePriceOnly;

    private String DaysHigh;

    private String DaysRange;



    private String Name;

    private String YearHigh;

    private String StockExchange;

    private String Symbol;

    private String DaysLow;



    public String getYearLow ()
    {
        return YearLow;
    }

    public void setYearLow (String YearLow)
    {
        this.YearLow = YearLow;
    }

    public String getSymbol ()
    {
        return symbol;
    }

    public void setSymbol (String symbol)
    {
        this.symbol = symbol;
    }

    public String getChange ()
    {
        return Change;
    }

    public void setChange (String Change)
    {
        this.Change = Change;
    }

    public String getVolume ()
    {
        return Volume;
    }

    public void setVolume (String Volume)
    {
        this.Volume = Volume;
    }

    public String getLastTradePriceOnly ()
    {
        return LastTradePriceOnly;
    }

    public void setLastTradePriceOnly (String LastTradePriceOnly)
    {
        this.LastTradePriceOnly = LastTradePriceOnly;
    }

    public String getDaysHigh ()
    {
        return DaysHigh;
    }

    public void setDaysHigh (String DaysHigh)
    {
        this.DaysHigh = DaysHigh;
    }

    public String getDaysRange ()
    {
        return DaysRange;
    }

    public void setDaysRange (String DaysRange)
    {
        this.DaysRange = DaysRange;
    }



    public String getName ()
    {
        return Name;
    }

    public void setName (String Name)
    {
        this.Name = Name;
    }

    public String getYearHigh ()
    {
        return YearHigh;
    }

    public void setYearHigh (String YearHigh)
    {
        this.YearHigh = YearHigh;
    }

    public String getStockExchange ()
    {
        return StockExchange;
    }

    public void setStockExchange (String StockExchange)
    {
        this.StockExchange = StockExchange;
    }


    public String getDaysLow ()
    {
        return DaysLow;
    }

    public void setDaysLow (String DaysLow)
    {
        this.DaysLow = DaysLow;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [MarketCapitalization = "+", YearLow = "+YearLow+", symbol = "+symbol+", Change = "+Change+", Volume = "+Volume+", LastTradePriceOnly = "+LastTradePriceOnly+", DaysHigh = "+DaysHigh+", DaysRange = "+DaysRange+", AverageDailyVolume = "+", Name = "+Name+", YearHigh = "+YearHigh+", StockExchange = "+StockExchange+", Symbol = "+Symbol+", DaysLow = "+DaysLow+"]";
    }
}
