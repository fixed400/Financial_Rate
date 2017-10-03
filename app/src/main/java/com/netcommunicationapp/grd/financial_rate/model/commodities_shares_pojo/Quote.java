package com.netcommunicationapp.grd.financial_rate.model.commodities_shares_pojo;

/**
 * Created by grd on 1/24/17.
 */


import com.google.gson.annotations.SerializedName;
/*
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
*/

    public class Quote {

        //@SerializedName("symbol_one") // fake
        //@Expose
        //private String symbolOne;
        @SerializedName("AverageDailyVolume")
        private Object averageDailyVolume;
        @SerializedName("Change")
        private String change;
        @SerializedName("DaysLow")
        private String daysLow;
        @SerializedName("DaysHigh")
        private String daysHigh;
        @SerializedName("YearLow")
        private String yearLow;
        @SerializedName("YearHigh")
        private String yearHigh;
        @SerializedName("MarketCapitalization")
        private Object marketCapitalization;
        @SerializedName("LastTradePriceOnly")
        private String lastTradePriceOnly;
        @SerializedName("DaysRange")
        private String daysRange;
        @SerializedName("Name")
        private String name;
        @SerializedName("Symbol")
        private String symbol;
        @SerializedName("Volume")
        private String volume;
        @SerializedName("StockExchange")
        private String stockExchange;

        /*  //"symbol_one"
        public String getSymbolOne() {
            return symbolOne;
        }

        public void setSymbolOne(String symbolOne) {
            this.symbolOne = symbolOne;
        }
        */

        public Object getAverageDailyVolume() {
            return averageDailyVolume;
        }

        public void setAverageDailyVolume(Object averageDailyVolume) {
            this.averageDailyVolume = averageDailyVolume;
        }

        public String getChange() {
            return change;
        }

        public void setChange(String change) {
            this.change = change;
        }

        public String getDaysLow() {
            return daysLow;
        }

        public void setDaysLow(String daysLow) {
            this.daysLow = daysLow;
        }

        public String getDaysHigh() {
            return daysHigh;
        }

        public void setDaysHigh(String daysHigh) {
            this.daysHigh = daysHigh;
        }

        public String getYearLow() {
            return yearLow;
        }

        public void setYearLow(String yearLow) {
            this.yearLow = yearLow;
        }

        public String getYearHigh() {
            return yearHigh;
        }

        public void setYearHigh(String yearHigh) {
            this.yearHigh = yearHigh;
        }

        public Object getMarketCapitalization() {
            return marketCapitalization;
        }

        public void setMarketCapitalization(Object marketCapitalization) {
            this.marketCapitalization = marketCapitalization;
        }

        public String getLastTradePriceOnly() {
            return lastTradePriceOnly;
        }

        public void setLastTradePriceOnly(String lastTradePriceOnly) {
            this.lastTradePriceOnly = lastTradePriceOnly;
        }

        public String getDaysRange() {
            return daysRange;
        }

        public void setDaysRange(String daysRange) {
            this.daysRange = daysRange;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getVolume() {
            return volume;
        }

        public void setVolume(String volume) {
            this.volume = volume;
        }

        public String getStockExchange() {
            return stockExchange;
        }

        public void setStockExchange(String stockExchange) {
            this.stockExchange = stockExchange;
        }

        /*
        @Override
        public String toString() {
            return new ToStringBuilder(this).append("symbolOne", symbolOne).append("averageDailyVolume", averageDailyVolume).append("change", change).append("daysLow", daysLow).append("daysHigh", daysHigh).append("yearLow", yearLow).append("yearHigh", yearHigh).append("marketCapitalization", marketCapitalization).append("lastTradePriceOnly", lastTradePriceOnly).append("daysRange", daysRange).append("name", name).append("symbol", symbol).append("volume", volume).append("stockExchange", stockExchange).toString();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(marketCapitalization).append(daysHigh).append(symbol).append(change).append(symbolOne).append(yearLow).append(yearHigh).append(daysRange).append(averageDailyVolume).append(name).append(volume).append(daysLow).append(stockExchange).append(lastTradePriceOnly).toHashCode();
        }

        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            if ((other instanceof Quote) == false) {
                return false;
            }
            Quote rhs = ((Quote) other);
            return new EqualsBuilder().append(marketCapitalization, rhs.marketCapitalization).append(daysHigh, rhs.daysHigh).append(symbol, rhs.symbol).append(change, rhs.change).append(symbolOne, rhs.symbolOne).append(yearLow, rhs.yearLow).append(yearHigh, rhs.yearHigh).append(daysRange, rhs.daysRange).append(averageDailyVolume, rhs.averageDailyVolume).append(name, rhs.name).append(volume, rhs.volume).append(daysLow, rhs.daysLow).append(stockExchange, rhs.stockExchange).append(lastTradePriceOnly, rhs.lastTradePriceOnly).isEquals();
        }
          */

    }