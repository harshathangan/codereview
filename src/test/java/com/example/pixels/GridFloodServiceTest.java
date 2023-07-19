package com.example.pixels;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GridFloodServiceTest {

    @Test
    public void floodTest() {
        int[][] pixels = new int[5][5];

        pixels[2][1] = 1;
        pixels[2][2] = 1;
        pixels[2][3] = 1;
        pixels[3][2] = 1;

        GridFloodService s = new GridFloodService();
        s.flood(pixels, 2,2,2);

        assertEquals(pixels[2][1],2);
        assertEquals(pixels[2][2], 2);
        assertEquals(pixels[2][3], 2);
        assertEquals(pixels[3][2], 2);
    }

    @Test
    public void floodImplTest() {
        Deque<Direction> moves = new ArrayDeque<>();
        moves.addAll(List.of(Direction.UP, Direction.LEFT, Direction.RIGHT, Direction.DOWN));

        int[][] pixels = new int[5][5];

        pixels[2][1] = 1;
        pixels[2][2] = 1;
        pixels[2][3] = 1;
        pixels[3][2] = 1;

        GridFloodService s = new GridFloodService();
        s.floodImplemetation(pixels, 2,2,2, 1, moves);

        assertEquals(pixels[2][2], 2);
        assertEquals(pixels[2][1],2);
        assertEquals(pixels[2][3], 2);
        assertEquals(pixels[3][2], 2);
    }
}