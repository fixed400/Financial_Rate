package com.netcommunicationapp.grd.financial_rate.model.currency_pojo;

/**
 * Created by grd on 1/3/17.
 */

import com.google.gson.annotations.SerializedName;

public class Rate {

    @SerializedName("id")
    private String id;

    @SerializedName("Name")
    private String name;

    @SerializedName("Rate")
    private String rate;

    @SerializedName("Date")
    private String date;

    @SerializedName("Time")
    private String time;

    @SerializedName("Ask")
    private String ask;

    @SerializedName("Bid")
    private String bid;

    /**
     * No args constructor for use in serialization
     *
     */
    public Rate() {
    }

    /**
     *
     * @param id
     * @param time
     * @param rate
     * @param name
     * @param ask
     * @param date
     * @param bid
     */
    public Rate(String id, String name, String rate, String date, String time, String ask, String bid) {
        super();
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.date = date;
        this.time = time;
        this.ask = ask;
        this.bid = bid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

}
