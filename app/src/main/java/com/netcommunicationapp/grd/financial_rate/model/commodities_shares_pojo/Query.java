package com.netcommunicationapp.grd.financial_rate.model.commodities_shares_pojo;

/**
 * Created by grd on 1/24/17.
 */

import com.google.gson.annotations.SerializedName;
/*
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
*/

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

    /*
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("count", count).append("created", created).append("lang", lang).append("results", results).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(results).append(count).append(created).append(lang).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Query) == false) {
            return false;
        }
        Query rhs = ((Query) other);
        return new EqualsBuilder().append(results, rhs.results).append(count, rhs.count).append(created, rhs.created).append(lang, rhs.lang).isEquals();
    }
    */

}