package com.example.pixels.service;

import com.example.pixels.constant.Colour;
import com.example.pixels.data.Grid;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GridServiceTest {
    private Grid grid;
    private GridService gridService;

    @Before
    public  void init(){
        grid = new Grid();
        grid.pixels = new int[9][9];
        gridService = new GridService();
    }

    @Test
    public void fillPixelTest() {
        gridService.fillPixel(grid, 4, 8, Colour.BLUE);
        assertEquals(grid.pixels[4][8], Colour.BLUE.getCode());
    }

    @Test(expected = AssertionError.class)
    public void fillPixel_shouldReturnValidationErrorWhenIncorrectRow(){
        gridService.fillPixel(grid, -1, 8, Colour.BLUE);
    }

    @Test(expected = AssertionError.class)
    public void fillPixel_shouldReturnValidationErrorWhenIncorrectColumn(){
        gridService.fillPixel(grid, 5, 10, Colour.BLUE);
    }

    @Test
    public void fillColumnOfPixelsTest() {
        gridService.fillColumnOfPixels(grid, 2, 6, 3, Colour.GREEN);
        assertEquals(grid.pixels[2][3], Colour.GREEN.getCode());
        assertEquals(grid.pixels[3][3], Colour.GREEN.getCode());
        assertEquals(grid.pixels[4][3], Colour.GREEN.getCode());
        assertEquals(grid.pixels[5][3], Colour.GREEN.getCode());
        assertEquals(grid.pixels[6][3], Colour.GREEN.getCode());
    }

    @Test(expected = AssertionError.class)
    public void fillColumnOfPixels_shouldReturnValidationErrorWhenIncorrectColumn() {
        gridService.fillColumnOfPixels(grid, 2, 6, 10, Colour.GREEN);
    }

    @Test(expected = AssertionError.class)
    public void fillColumnOfPixels_shouldReturnValidationErrorWhenIncorrectRow() {
        gridService.fillColumnOfPixels(grid, 2, 10, 7, Colour.GREEN);
    }

    @Test
    public void fillRowOfPixelsTest() {
        gridService.fillRowOfPixels(grid, 3, 2, 7, Colour.BLUE);
        assertEquals(grid.pixels[3][2], Colour.BLUE.getCode());
        assertEquals(grid.pixels[3][3], Colour.BLUE.getCode());
        assertEquals(grid.pixels[3][4], Colour.BLUE.getCode());
        assertEquals(grid.pixels[3][5], Colour.BLUE.getCode());
        assertEquals(grid.pixels[3][6], Colour.BLUE.getCode());
        assertEquals(grid.pixels[3][7], Colour.BLUE.getCode());
    }

    @Test(expected = AssertionError.class)
    public void fillRowOfPixels_shouldReturnValidationErrorWhenIncorrectColumn() {
        gridService.fillRowOfPixels(grid, 3, 2, 10, Colour.BLUE);
    }

    @Test(expected = AssertionError.class)
    public void fillRowOfPixels_shouldReturnValidationErrorWhenIncorrectRow() {
        gridService.fillRowOfPixels(grid, 10, 2, 7, Colour.BLUE);
    }

    @Test
    public void floodAdjacentPixelsOnlyTest() {
        grid.pixels[3][4] = Colour.BLACK.getCode();
        grid.pixels[3][5] = Colour.BLACK.getCode();
        grid.pixels[3][6] = Colour.BLACK.getCode();
        grid.pixels[3][7] = Colour.BLACK.getCode();
        grid.pixels[4][6] = Colour.BLACK.getCode();

        gridService.flood(grid.pixels, 3,6,Colour.RED.getCode());

        assertEquals(grid.pixels[3][4], Colour.RED.getCode());
        assertEquals(grid.pixels[3][5], Colour.RED.getCode());
        assertEquals(grid.pixels[3][6], Colour.RED.getCode());
        assertEquals(grid.pixels[3][7], Colour.RED.getCode());
        assertEquals(grid.pixels[4][6], Colour.RED.getCode());
        assertNotEquals(grid.pixels[4][4], Colour.RED.getCode());
        assertNotEquals(grid.pixels[4][7], Colour.RED.getCode());
        assertNotEquals(grid.pixels[2][4], Colour.RED.getCode());
        assertNotEquals(grid.pixels[2][5], Colour.RED.getCode());
        assertNotEquals(grid.pixels[2][6], Colour.RED.getCode());
        assertNotEquals(grid.pixels[2][7], Colour.RED.getCode());
    }

    @Test
    public void shouldNotFloodNonAdjacentPixelsTest() {
        grid.pixels[2][3] = Colour.GREEN.getCode();
        grid.pixels[3][3] = Colour.GREEN.getCode();
        grid.pixels[3][4] = Colour.BLACK.getCode();
        grid.pixels[3][5] = Colour.BLACK.getCode();
        grid.pixels[3][6] = Colour.BLACK.getCode();
        grid.pixels[3][7] = Colour.BLACK.getCode();
        grid.pixels[4][6] = Colour.BLACK.getCode();
        grid.pixels[2][8] = Colour.YELLOW.getCode();
        grid.pixels[4][8] = Colour.BLACK.getCode();

        gridService.flood(grid.pixels, 3,6,Colour.RED.getCode());
        assertEquals(grid.pixels[2][3], Colour.GREEN.getCode());
        assertEquals(grid.pixels[3][3], Colour.GREEN.getCode());
        assertEquals(grid.pixels[3][4], Colour.RED.getCode());
        assertEquals(grid.pixels[3][5], Colour.RED.getCode());
        assertEquals(grid.pixels[3][6], Colour.RED.getCode());
        assertEquals(grid.pixels[3][7], Colour.RED.getCode());
        assertEquals(grid.pixels[4][6], Colour.RED.getCode());
        assertEquals(grid.pixels[2][8], Colour.YELLOW.getCode());
        assertEquals(grid.pixels[4][8], Colour.BLACK.getCode());
    }
}
