package com.netcommunicationapp.grd.financial_rate.model.currency_pojo;

/**
 * Created by grd on 1/3/17.
 */

import com.google.gson.annotations.SerializedName;

/*

@Expose
 Аннотация Expose. Она работает только в паре с методом GsonBuilder.excludeFieldsWithoutExposeAnnotation() ,
 который исключает из обработки все поля, не имеющие аннотации Expose.
  Но, выходит, чтобы исключить одно поле, нам нужно добавить аннотации ко всем остальным полям.
 */

public class Market {

    @SerializedName("query")
    private Query query;

    /**
     * No args constructor for use in serialization
     *
     */
    public Market() {
    }

    /**
     *
     * @param query
     */
    public Market(Query query) {
        super();
        this.query = query;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

}