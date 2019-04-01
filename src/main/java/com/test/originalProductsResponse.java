package com.test;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class originalProductsResponse {

    @JsonProperty("products")
    private List<originalProduct> products;

    public List<originalProduct> getProducts() {
        return products;
    }

    public void setProducts(List<originalProduct> products) {
        this.products = products;
    }
}
