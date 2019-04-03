package com.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class originalProductsResponseTest {

    private originalProductsResponse opr;

    @BeforeEach
    void setUp() {
        opr=new originalProductsResponse();
    }

    @AfterEach
    void tearDown() {
        opr=null;
    }

    @Test
    void testProducts() {
        List<originalProduct> ops=new ArrayList<originalProduct>();
        ops.add(new originalProduct());
        ops.add(new originalProduct());
        opr.setProducts(ops);
        List<originalProduct> list2=opr.getProducts();
        Assertions.assertEquals(ops, list2);
    }
}