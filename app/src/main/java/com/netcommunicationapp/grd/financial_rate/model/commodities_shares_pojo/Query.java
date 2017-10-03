package com.netcommunicationapp.grd.financial_rate.model.commodities_shares_pojo;

/**
 * Created by grd on 1/24/17.
 */

import com.google.gson.annotations.SerializedName;

public class Query {

    @SerializedName("count")
    private Long count;
    @SerializedName("created")
    private String created;
    @SerializedName("lang")
    private String lang;
    @SerializedName("results")
    private Results results;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }



}