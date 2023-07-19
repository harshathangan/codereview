package com.example.pixels;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class GridFloodService {

    Deque<Direction> FLOOD_DIRECTIONS;

    public GridFloodService() {
        FLOOD_DIRECTIONS = new ArrayDeque<>();
        FLOOD_DIRECTIONS.addAll(List.of(Direction.UP, Direction.DOWN, Direction.LEFT, Direction.RIGHT));
    }

    public void flood(int[][] arr, Integer i1, Integer i2, Integer i3) {
        int i4 = arr[i2][i1];
        floodImplemetation(arr,i1,i2,i3, i4, FLOOD_DIRECTIONS);
    }

    /**
     * Flood algorithm described at https://en.wikipedia.org/wiki/Flood_fill
     */
    public void floodImplemetation(int[][] grid, Integer x, Integer y, Integer colour, Integer o, Deque<Direction> moves) {
        grid[y][x] = colour;

        while(!moves.isEmpty()) {
            Direction d = moves.pop();
            Point start = new Point();
            start.row = y;
            start.column = x;
            start = d.apply(start);
            while(grid[start.row][start.column] == o) {
                grid[start.row][start.column] = colour;
                start = d.apply(start);
            }
        };
    }
}
