package com.netcommunicationapp.grd.financial_rate.model.currency_pojo;

/**
 * Created by grd on 1/3/17.
 */

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results {

    @SerializedName("rate")

    private List<Rate> rate = null;
   // public List<Rate> rate;

    /**
     * No args constructor for use in serialization
     *
     */
    public Results() {
    }

    /**
     *
     * @param rate
     */
    public Results(List<Rate> rate) {
        super();
        this.rate = rate;
    }

    public List<Rate> getRate() {
        return rate;
    }

    public void setRate(List<Rate> rate) {
        this.rate = rate;
    }

}