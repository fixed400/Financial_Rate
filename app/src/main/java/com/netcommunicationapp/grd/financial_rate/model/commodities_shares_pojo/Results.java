package com.netcommunicationapp.grd.financial_rate.model.commodities_shares_pojo;

/**
 * Created by grd on 1/24/17.
 */

import java.util.List;

import com.google.gson.annotations.SerializedName;
/*
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
*/

public class Results {

    @SerializedName("quote")
    private List<Quote> quote = null;

    public List<Quote> getQuote() {
        return quote;
    }

    public void setQuote(List<Quote> quote) {
        this.quote = quote;
    }

    /*
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("quote", quote).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(quote).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Results) == false) {
            return false;
        }
        Results rhs = ((Results) other);
        return new EqualsBuilder().append(quote, rhs.quote).isEquals();
    }

    */
}