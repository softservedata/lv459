package com.softserve.edu.opencart.data;

import java.util.HashMap;
import java.util.Map;

public class ProductInfo {

    private String Name;
    private String ShortDescription;
    private String PriceDollarExTax;
    // TODO
    // private Map<Currencies, Decimal> prices;
    private Map<Currencies, String> Prices;



    //setters
    public void setName(String Name) {
        this.Name = Name;
    }

    public void setShortDescription(String ShortDescription) {
        this.ShortDescription = ShortDescription;
    }

    public void setPriceDollarExTax(String PriceDollarExTax) {
        this.PriceDollarExTax = PriceDollarExTax;
    }



    //getters

    public String getName() {
        return Name;
    }

    public String getShortDescription() {
        return ShortDescription;
    }

    public String getPriceDollarExTax() {
        return PriceDollarExTax;
    }

    public String getPrice(Currencies currency) {
        return Prices.get(currency);
    }



    public ProductInfo(ProductNames Name, String ShortDescription, String PriceDollarExTax) {
       // this.Name = Name;
        this.ShortDescription = ShortDescription;
        this.PriceDollarExTax = PriceDollarExTax;
        Prices = new HashMap<Currencies, String>();

    }

    //add Price
    public ProductInfo addPrice(Currencies currency, String price) {
        Prices.put(currency, price);
        return this;
    }
}
