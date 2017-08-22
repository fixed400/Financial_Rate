package com.netcommunicationapp.grd.financial_rate.model.commodities_pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by grd on 1/24/17.
 */

// moke to JSON
public class MarketCommodities {

    @SerializedName("query")
    private Query query;

    public Query getQuery ()
    {
        return query;
    }

    public void setQuery (Query query)
    {
        this.query = query;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [query = "+query+"]";
    }
}
