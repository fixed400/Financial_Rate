package com.netcommunicationapp.grd.financial_rate.model.commodities_shares_pojo;

import com.google.gson.annotations.SerializedName;
/*
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
*/

/**
 * Created by grd on 1/24/17.
 */

// moke to JSON
public class Market {


    @SerializedName("query") //изменить выходное имя свойств
    //Expose - разоблачать
    /*аннотации Expose. Она работает только в паре с методом GsonBuilder.excludeFieldsWithoutExposeAnnotation() ,
     который исключает из обработки все поля, не имеющие аннотации Expose.
     Но, выходит, чтобы исключить одно поле, нам нужно добавить аннотации ко всем остальным полям.
      */
   // @Expose
    private Query query;

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    /*
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("query", query).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(query).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Example) == false) {
            return false;
        }
        Example rhs = ((Example) other);
        return new EqualsBuilder().append(query, rhs.query).isEquals();
    }
    */

}