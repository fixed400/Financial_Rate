package com.netcommunicationapp.grd.financial_rate.model.currency_pojo;

/**
 * Created by grd on 1/3/17.
 */

import com.google.gson.annotations.SerializedName;


/*

@Expose
//Expose - разоблачать
 Аннотация Expose. Она работает только в паре с методом GsonBuilder.excludeFieldsWithoutExposeAnnotation() ,
 который исключает из обработки все поля, не имеющие аннотации Expose.
  Но, выходит, чтобы исключить одно поле, нам нужно добавить аннотации ко всем остальным полям.
 */


public class Query {

    @SerializedName("count")
    private Integer count;

    @SerializedName("created")
    private String created;

    @SerializedName("lang")
    private String lang;

    @SerializedName("results")
    private Results results;

    /**
     * No args constructor for use in serialization
     *
     */
    public Query() {
    }

    /**
     *
     * @param results
     * @param count
     * @param created
     * @param lang
     */
    public Query(Integer count, String created, String lang, Results results) {
        super();
        this.count = count;
        this.created = created;
        this.lang = lang;
        this.results = results;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
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
