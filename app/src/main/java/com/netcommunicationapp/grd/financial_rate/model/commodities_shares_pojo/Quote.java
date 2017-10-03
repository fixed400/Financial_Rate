package com.netcommunicationapp.grd.financial_rate.model.commodities_shares_pojo;

/**
 * Created by grd on 1/24/17.
 */


import com.google.gson.annotations.SerializedName;

    public class Quote {

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

    }