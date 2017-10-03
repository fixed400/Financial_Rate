package com.netcommunicationapp.grd.financial_rate.model.commodities_shares_pojo;

/**
 * Created by grd on 1/24/17.
 */

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("quote")
    private List<Quote> quote = null;

    public List<Quote> getQuote() {
        return quote;
    }

    public void setQuote(List<Quote> quote) {
        this.quote = quote;
    }

}