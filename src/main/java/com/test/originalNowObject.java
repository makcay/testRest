package com.test;

public class originalNowObject{
    private String from;
    private String to;
    private String simpleNow=null;

    public originalNowObject(){
    }

    public originalNowObject(String now){
        this.simpleNow=originalPrice.roundPrice(now);
    }

    public originalNowObject(Object nowObject){
        if (nowObject instanceof String){
            this.simpleNow=originalPrice.roundPrice(nowObject.toString());
        }
        else {
            originalNowObject o=(originalNowObject) nowObject;
            this.from = originalPrice.roundPrice(o.from);
            this.to = originalPrice.roundPrice(o.to);
        }
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSimpleNow() {
        return simpleNow;
    }

    public void setSimpleNow(String simpleNow) {
        this.simpleNow = originalPrice.roundPrice(simpleNow);
    }

    public String getNowPrice(){
        if (simpleNow!=null){
            return simpleNow;
        } else{
            return to;
        }
    }
}
