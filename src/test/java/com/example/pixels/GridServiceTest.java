package com.example.pixels;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GridServiceTest {

    @Test
    public void fillPixelTest() {
        Grid g = new Grid();
        g.pixels = new int[5][5];

        GridService s = new GridService();
        s.fillPixel(g, 2,2,3);

        assertEquals(g.pixels[2][2], 3);
    }

    @Test
    public void fillColumnOfPixelsTest() {
        Grid g = new Grid();
        g.pixels = new int[5][5];
        GridService s = new GridService();
        s.fillRowOfPixels(g, 2, 2, 3, 3);

        assertEquals(g.pixels[2][2], 3);
        assertEquals(g.pixels[2][3], 3);
    }


    @Test
    public void fillRowOfPixelsTest() {
        // TODO
    }
}
