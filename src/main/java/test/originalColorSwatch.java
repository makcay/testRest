package test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.awt.*;
import java.lang.reflect.Field;

public class originalColorSwatch {
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String color;
    private String basicColor;
    private String colorSwatchUrl;
    private String imageUrl;
    private String isAvailable;
    private String skuId;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBasicColor() {
        return basicColor;
    }

    public void setBasicColor(String basicColor) {
        this.basicColor = basicColor;
    }

    public String getColorSwatchUrl() {
        return colorSwatchUrl;
    }

    public void setColorSwatchUrl(String colorSwatchUrl) {
        this.colorSwatchUrl = colorSwatchUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getHexColor(){
        String hex="";
        if (basicColor!=null) {
            Color color;
            try {
                //color=Color.getColor(basicColor.toLowerCase());
                //by usşng reflection find the color in the Color classes fields and use it
                Field field = Class.forName("java.awt.Color").getField(basicColor.toLowerCase());
                color = (Color)field.get(null);
                hex = String.format("0x%06X",color.getRGB() & 0xffffff);
            } catch (Exception e) {
                color = null; // Not defined
            }
        }
        return hex;
    }
}
