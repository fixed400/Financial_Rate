package com.netcommunicationapp.grd.financial_rate.model.commodities_pojo;

/**
 * Created by grd on 1/24/17.
 */

public class Results {

    private Quote[] quote;

    public Quote[] getQuote ()
    {
        return quote;
    }

    public void setQuote (Quote[] quote)
    {
        this.quote = quote;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [quote = "+quote+"]";
    }
}
