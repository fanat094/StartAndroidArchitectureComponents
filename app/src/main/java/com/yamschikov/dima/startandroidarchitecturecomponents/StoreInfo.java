package com.yamschikov.dima.startandroidarchitecturecomponents;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

class StoreInfo {

    @SerializedName("store")
    @Expose
    private String store;
    @SerializedName("maxCashback")
    @Expose
    private String maxCashback;
    @SerializedName("totalCoupons")
    @Expose
    private String totalCoupons;
    @SerializedName("topCoupons")
    @Expose
    private List<String> topCoupons = null;
    @SerializedName("cashback")
    @Expose
    private List<String> cashback = null;

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getMaxCashback() {
        return maxCashback;
    }

    public void setMaxCashback(String maxCashback) {
        this.maxCashback = maxCashback;
    }

    public String getTotalCoupons() {
        return totalCoupons;
    }

    public void setTotalCoupons(String totalCoupons) {
        this.totalCoupons = totalCoupons;
    }

    public List<String> getTopCoupons() {
        return topCoupons;
    }

    public void setTopCoupons(List<String> topCoupons) {
        this.topCoupons = topCoupons;
    }

    public List<String> getCashback() {
        return cashback;
    }

    public void setCashback(List<String> cashback) {
        this.cashback = cashback;
    }
}
