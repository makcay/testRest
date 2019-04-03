package com.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ColorSwatchTest {

    @Test
    void testColor() {
        ColorSwatch cs=new ColorSwatch();
        cs.setColor("blue");
        Assertions.assertEquals("blue",cs.getColor());
    }

    @Test
    void testRgbColor() {
        ColorSwatch cs=new ColorSwatch();
        cs.setRgbColor("blue");
        Assertions.assertEquals("blue",cs.getRgbColor());
    }


    @Test
    void testSkuid() {
        ColorSwatch cs=new ColorSwatch();
        cs.setSkuid("skuid1");
        Assertions.assertEquals("skuid1",cs.getSkuid());
    }
}