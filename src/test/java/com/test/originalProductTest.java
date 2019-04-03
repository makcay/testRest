package com.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class originalProductTest {

    @Test
    void testProductId() {
        originalProduct op=new originalProduct();
        op.setProductId("123");
        Assertions.assertEquals("123",op.getProductId());
    }

    @Test
    void testType() {
        originalProduct op=new originalProduct();
        op.setType("type1");
        Assertions.assertEquals("type1",op.getType());
    }

    @Test
    void testTitle() {
        originalProduct op=new originalProduct();
        op.setTitle("title1");
        Assertions.assertEquals("title1",op.getTitle());
    }

    @Test
    void testCode() {
        originalProduct op=new originalProduct();
        op.setCode("code1");
        Assertions.assertEquals("code1",op.getCode());
    }

    @Test
    void testAverageRating() {
        originalProduct op=new originalProduct();
        op.setAverageRating("5");
        Assertions.assertEquals("5",op.getAverageRating());
    }

    @Test
    void testReviews() {
        originalProduct op=new originalProduct();
        op.setReviews("rev1");
        Assertions.assertEquals("rev1",op.getReviews());
    }

    @Test
    void testPrice() {
        originalPrice oprice=new originalPrice();
        originalProduct op=new originalProduct();
        op.setPrice(oprice);
        oprice.setWas("100");
        oprice.setThen1("44");
        oprice.setThen2("24");
        oprice.setCurrency("GBP");
        Assertions.assertEquals(oprice,op.getPrice());
    }

    @Test
    void testDefaultSkuId() {
        originalProduct op=new originalProduct();
        op.setDefaultSkuId("default1");
        Assertions.assertEquals("default1", op.getDefaultSkuId());
    }

    @Test
    void testColorSwatches() {
        ArrayList<originalColorSwatch> ocs=new ArrayList<originalColorSwatch>();
        ocs.add(new originalColorSwatch());
        ocs.add(new originalColorSwatch());
        originalProduct op=new originalProduct();
        originalColorSwatch[] listCs=(originalColorSwatch[])ocs.toArray(new originalColorSwatch[ocs.size()]);
        op.setColorSwatches(listCs);
        originalColorSwatch[] list2=op.getColorSwatches();
        Assertions.assertEquals(listCs,list2);
    }
}