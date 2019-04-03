package com.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class productTest {

    private product p;
    @BeforeEach
    void setUp() {
        p=new product();
    }

    @AfterEach
    void tearDown() {
        p=null;
    }

    @Test
    void testProductid() {
        p.setProductid("pid1");
        Assertions.assertEquals("pid1",p.getProductid());
    }

    @Test
    void testTitle() {
        p.setTitle("title1");
        Assertions.assertEquals("title1",p.getTitle());
    }

    @Test
    void testColorSwatches() {
        ArrayList<ColorSwatch> ocs=new ArrayList<ColorSwatch>();
        ocs.add(new ColorSwatch());
        ocs.add(new ColorSwatch());
        ColorSwatch[] listCs=(ColorSwatch[])ocs.toArray(new ColorSwatch[ocs.size()]);

        p.setColorSwatches(listCs);
        ColorSwatch[] list2=p.getColorSwatches();
        Assertions.assertEquals(listCs,list2);
    }

    @Test
    void testNowPrice() {
        p.setNowPrice("12.56");
        Assertions.assertEquals("12.56",p.getNowPrice());
    }

    @Test
    void testPriceLabel() {
        p.setPriceLabel("Was £20, now £10");
        Assertions.assertEquals("Was £20, now £10",p.getPriceLabel());
    }
}