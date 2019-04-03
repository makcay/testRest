package com.test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class originalPrice{
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String was;
    private String then1;
    private String then2;

    @JsonProperty("now")
    private originalNowObject nowObject;

    private String uom;
    private String currency;

    private String currencySign;
    private Double discount;
    private String discountPercentage;

    public String getWas() {
        return was;
    }

    public void setWas(String was) {
        this.was = roundPrice(was);
        calculateDiscount();
    }

    public String getThen1() {
        return then1;
    }

    public void setThen1(String then1) {
        this.then1 = roundPrice(then1);
    }

    public String getThen2() {
        return then2;
    }

    public void setThen2(String then2) {
        this.then2 = roundPrice(then2);
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
        if ("GBP".equalsIgnoreCase(currency)){
            this.currencySign="£";
        }else if ("EUR".equalsIgnoreCase(currency)){
            this.currencySign="€";
        }
    }

    public originalNowObject getNowObject() {
        return nowObject;
    }

    public void setNowObject(originalNowObject nowObject) {
        this.nowObject = nowObject;
        calculateDiscount();
    }

    private void calculateDiscount(){
        this.discount=0.0;
        if (this.was!=null && this.was.length()>0
                && this.nowObject!=null && this.nowObject.getNowPrice()!=null && this.nowObject.getNowPrice().length()>0) {
            Double wasDouble=Double.valueOf(this.was);
            Double nowDouble=Double.valueOf(this.nowObject.getNowPrice());
            this.discount = wasDouble-nowDouble;
            Double percentage=this.discount/wasDouble*100;
            this.discountPercentage=String.format("%.2g",percentage);
        }
    }

    public Double getdiscount(){
        return discount;
    }

    public static String roundPrice(String price){
        String ret=price;
        if (price!=null && price.length()>0) {
            Double priceDouble = Double.valueOf(price);
            ret=priceDouble.toString();
            if (priceDouble >= 10) {
                priceDouble = Math.floor(priceDouble);
                ret=String.format("%.0f", priceDouble);
            }
        }
        return ret;
    }

    public String getPriceNowWithCurrency(){
        String ret="";
        if (getNowObject()!=null){
            ret=currencySign+getNowObject().getNowPrice();
        }
        return ret;
    }

    public String getPriceText(String labelType){
        String ret="";
        if ("ShowWasNow".equalsIgnoreCase(labelType)){
            ret="Was "+currencySign+was+", now "+currencySign+nowObject.getNowPrice();
        }
        else if ("ShowWasThenNow".equalsIgnoreCase(labelType)){
            String thenPrice=then1;
            if (then2!=null && then2.length()>0){
                thenPrice=then2;
            }
            ret="Was "+currencySign+was;
            if (thenPrice!=null && thenPrice.length()>0) {
                ret=ret+", then " + currencySign + thenPrice;
            }
            ret=ret+", now "+currencySign+nowObject.getNowPrice();
        }
        else if("ShowPercDscount".equalsIgnoreCase(labelType)){
            ret=discountPercentage+"% off - now "+currencySign+nowObject.getNowPrice();
        }
        return ret;
    }

}
