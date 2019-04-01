package test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class originalProduct {
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String productId;
    private String type;
    private String title;
    private String code;
    private String averageRating;
    private String reviews;
    private originalPrice price;
    private String defaultSkuId;
    private originalColorSwatch[] colorSwatches;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public originalPrice getPrice() {
        return price;
    }

    public void setPrice(originalPrice price) {
        this.price = price;
    }

    public String getDefaultSkuId() {
        return defaultSkuId;
    }

    public void setDefaultSkuId(String defaultSkuId) {
        this.defaultSkuId = defaultSkuId;
    }

    public originalColorSwatch[] getColorSwatches() {
        return colorSwatches;
    }

    public void setColorSwatches(originalColorSwatch[] colorSwatches) {
        this.colorSwatches = colorSwatches;
    }
}