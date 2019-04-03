package com.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class originalPriceTest {

    @Test
    void testWas1() {
        originalPrice op=new originalPrice();
        op.setWas("10.5");
        Assertions.assertEquals("10",op.getWas());
    }

    @Test
    void testWas2() {
        originalPrice op=new originalPrice();
        op.setWas("5.6");
        Assertions.assertEquals("5.6",op.getWas());
    }

    @Test
    void testWas3() {
        originalPrice op=new originalPrice();
        op.setWas("43.896");
        Assertions.assertEquals("43",op.getWas());
    }

    @Test
    void testThen1_1() {
        originalPrice op=new originalPrice();
        op.setThen1("10");
        Assertions.assertEquals("10",op.getThen1());
    }

    @Test
    void testThen1_2() {
        originalPrice op=new originalPrice();
        op.setThen1("22.56");
        Assertions.assertEquals("22",op.getThen1());
    }

    @Test
    void testThen1_3() {
        originalPrice op=new originalPrice();
        op.setThen1("8.54");
        Assertions.assertEquals("8.54",op.getThen1());
    }

    @Test
    void testThen2_1() {
        originalPrice op=new originalPrice();
        op.setThen1("10.45");
        Assertions.assertEquals("10",op.getThen1());
    }

    @Test
    void testThen2_2() {
        originalPrice op=new originalPrice();
        op.setThen1("222.56");
        Assertions.assertEquals("222",op.getThen1());
    }

    @Test
    void testThen2_3() {
        originalPrice op=new originalPrice();
        op.setThen1("0.54");
        Assertions.assertEquals("0.54",op.getThen1());
    }

    @Test
    void testUom() {
        originalPrice op=new originalPrice();
        op.setUom("testUom");
        Assertions.assertEquals("testUom",op.getUom());
    }

    @Test
    void testCurrency() {
        originalPrice op=new originalPrice();
        op.setCurrency("GBP");
        Assertions.assertEquals("GBP",op.getCurrency());
    }

    @Test
    void testNowObject() {
        originalNowObject onow=new originalNowObject();
        originalPrice op=new originalPrice();
        op.setNowObject(onow);
        Assertions.assertEquals(onow,op.getNowObject());
    }

    @Test
    void getdiscount() {
        originalNowObject onow=new originalNowObject();
        onow.setSimpleNow("50");
        originalPrice op=new originalPrice();
        op.setNowObject(onow);
        op.setWas("72.5");
        Assertions.assertEquals(22,op.getdiscount());
    }

    @Test
    void roundPrice1() {
        Assertions.assertEquals(null,originalPrice.roundPrice(null));
    }

    @Test
    void roundPrice2() {
        Assertions.assertEquals("10",originalPrice.roundPrice("10.2"));
    }

    @Test
    void roundPrice3() {
        Assertions.assertEquals("0.55",originalPrice.roundPrice("0.55"));
    }

    @Test
    void getPriceNowWithCurrency1() {
        originalNowObject onow=new originalNowObject();
        onow.setSimpleNow("55.67");
        originalPrice op=new originalPrice();
        op.setNowObject(onow);
        op.setCurrency("GBP");
        Assertions.assertEquals("£55",op.getPriceNowWithCurrency());
    }

    @Test
    void getPriceNowWithCurrency2() {
        originalNowObject onow=new originalNowObject();
        onow.setSimpleNow("6.67");
        originalPrice op=new originalPrice();
        op.setNowObject(onow);
        op.setCurrency("GBP");
        Assertions.assertEquals("£6.67",op.getPriceNowWithCurrency());
    }

    @Test
    void getPriceText1() {
        originalNowObject onow=new originalNowObject();
        onow.setSimpleNow("6.67");
        originalPrice op=new originalPrice();
        op.setNowObject(onow);
        op.setWas("43");
        op.setCurrency("GBP");
        String text=op.getPriceText("ShowWasNow");
        Assertions.assertEquals("Was £43, now £6.67",text);
    }

    @Test
    void getPriceText2() {
        originalNowObject onow=new originalNowObject();
        onow.setSimpleNow("6.67");
        originalPrice op=new originalPrice();
        op.setNowObject(onow);
        op.setWas("43");
        op.setThen1("44");
        op.setCurrency("GBP");
        String text=op.getPriceText("ShowWasThenNow");
        Assertions.assertEquals("Was £43, then £44, now £6.67",text);
    }

    @Test
    void getPriceText3() {
        originalNowObject onow=new originalNowObject();
        onow.setSimpleNow("6.67");
        originalPrice op=new originalPrice();
        op.setNowObject(onow);
        op.setWas("43");
        op.setThen1("44");
        op.setThen2("24");
        op.setCurrency("GBP");
        String text=op.getPriceText("ShowWasThenNow");
        Assertions.assertEquals("Was £43, then £24, now £6.67",text);
    }

    @Test
    void getPriceText4() {
        originalNowObject onow=new originalNowObject();
        onow.setSimpleNow("10");
        originalPrice op=new originalPrice();
        op.setNowObject(onow);
        op.setWas("100");
        op.setThen1("44");
        op.setThen2("24");
        op.setCurrency("GBP");
        String text=op.getPriceText("ShowPercDscount");
        Assertions.assertEquals("90% off - now £10",text);
    }
}