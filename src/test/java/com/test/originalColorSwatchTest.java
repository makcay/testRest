package com.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class originalColorSwatchTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getHexColor() {
        originalColorSwatch ocs=new originalColorSwatch();
        ocs.setBasicColor("red");
        Assertions.assertEquals("FF0000",ocs.getHexColor());
    }

    @Test
    void testBasicColor(){
        originalColorSwatch ocs=new originalColorSwatch();
        ocs.setBasicColor("red");
        Assertions.assertEquals("red",ocs.getBasicColor());
    }

    @Test
    void testColor(){
        originalColorSwatch ocs=new originalColorSwatch();
        ocs.setColor("red");
        Assertions.assertEquals("red",ocs.getColor());
    }

    @Test
    void testSkuId(){
        originalColorSwatch ocs=new originalColorSwatch();
        ocs.setSkuId("testSkuId");
        Assertions.assertEquals("testSkuId",ocs.getSkuId());
    }
}