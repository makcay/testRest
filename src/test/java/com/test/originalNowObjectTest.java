package com.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class originalNowObjectTest {

    @Test
    void testFrom() {
        originalNowObject on=new originalNowObject();
        on.setFrom("20");
        Assertions.assertEquals("20",on.getFrom());
    }

    @Test
    void testTo() {
        originalNowObject on=new originalNowObject();
        on.setTo("20");
        Assertions.assertEquals("20",on.getTo());
    }

    @Test
    void getPriceNow() {
        originalNowObject on=new originalNowObject();
        on.setSimpleNow("40.86");
        Assertions.assertEquals("40", on.getNowPrice());
    }

    @Test
    void getPriceNowFromTo() {
        originalNowObject on=new originalNowObject();
        on.setSimpleNow("40.86");
        on.setTo("50.2");
        Assertions.assertEquals("40", on.getNowPrice());
    }

    @Test
    void getPriceNowFromTo2() {
        originalNowObject on=new originalNowObject();
        on.setTo("50.2");
        Assertions.assertEquals("50.2", on.getNowPrice());
    }


}