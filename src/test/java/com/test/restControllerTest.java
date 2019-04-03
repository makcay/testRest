package com.test;

import org.junit.jupiter.api.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
class restControllerTest {
    private static restController controller;

    @BeforeAll
    static void setUp() {
        controller=new restController("http://localhost:8080/fileMock");
        SpringApplication.run(com.test.restControllerTest.class, new String[0]);
    }

    @Test
    void index1() {
        List<product> result=controller.index("ShowWasNow");
        Assertions.assertEquals(6,result.size());
        if (result.size()>1){
            product firstProduct=result.get(0);
            product secondProduct=result.get(1);
            Assertions.assertEquals("Was £149, now £74", firstProduct.getPriceLabel());
            Assertions.assertEquals("Was £140, now £99", secondProduct.getPriceLabel());
        }

    }

    @Test
    void index2() {
        List<product> result=controller.index("ShowWasThenNow");
        Assertions.assertEquals(6,result.size());
        if (result.size()>1){
            product firstProduct=result.get(0);
            product secondProduct=result.get(1);
            Assertions.assertEquals("Was £149, then £89, now £74", firstProduct.getPriceLabel());
            Assertions.assertEquals("Was £140, now £99", secondProduct.getPriceLabel());
        }
    }

    @Test
    void index3() {
        List<product> result=controller.index("ShowPercDscount");
        Assertions.assertEquals(6,result.size());
        if (result.size()>1){
            product firstProduct=result.get(0);
            product secondProduct=result.get(1);
            Assertions.assertEquals("50% off - now £74", firstProduct.getPriceLabel());
            Assertions.assertEquals("29% off - now £99", secondProduct.getPriceLabel());
        }
    }
}