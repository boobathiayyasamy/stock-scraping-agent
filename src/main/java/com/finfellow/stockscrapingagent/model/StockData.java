package com.finfellow.stockscrapingagent.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StockData {
    @JsonProperty("companyName")
    private String companyName;

    @JsonProperty("price")
    private String price;

    @JsonProperty("dayLow")
    private String dayLow;

    public StockData(String companyName, String price, String dayLow) {
        this.companyName = companyName;
        this.price = price;
        this.dayLow = dayLow;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPrice() {
        return price;
    }

    public String getDayLow() {
        return dayLow;
    }
}
