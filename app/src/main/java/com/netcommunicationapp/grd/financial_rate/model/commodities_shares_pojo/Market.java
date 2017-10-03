package com.netcommunicationapp.grd.financial_rate.model.commodities_shares_pojo;

import com.google.gson.annotations.SerializedName;

public class Market {


    @SerializedName("query")

    private Query query;

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }


}