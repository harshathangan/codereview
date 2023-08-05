package com.example.pixels.service;

import com.example.pixels.constant.Colour;
import com.example.pixels.constant.Direction;
import com.example.pixels.data.Grid;
import com.example.pixels.data.Point;
import com.example.pixels.util.GridUtility;

public class GridService {
    public void fillPixel(Grid grid, int row, int column, Colour colour) {
        GridUtility.validateInput(grid.pixels, row, column);
        grid.pixels[row][column] = colour.getCode();
    }

    public void fillRowOfPixels(Grid grid, int row, int startColumn, int endColumn, Colour colour) {
        GridUtility.validateInput(grid.pixels, startColumn, endColumn, row);
        for (int column = startColumn; column <= endColumn; column++) {
            grid.pixels[row][column] = colour.getCode();
        }
    }

    public void fillColumnOfPixels(Grid grid, int startRow, int endRow, int column, Colour colour) {
        GridUtility.validateInput(grid.pixels, startRow, endRow, column);
        for (int row = startRow; row <= endRow; row++) {
            grid.pixels[row][column] = colour.getCode();
        }
    }

    /**
     * Flood algorithm described at https://en.wikipedia.org/wiki/Flood_fill
     */
    public void flood(int[][] grid, int row, int column, int colour) {
        GridUtility.validateInput(grid, row, column);
        int previousColor = grid[row][column];
        floodFill(grid, new Point(row, column),colour, previousColor);
    }

    /**
     * DFS flood algorithm.
     */
    private static void floodFill(int[][] grid, Point start, int colour, int previousColor) {
        if(start.getRow()<0 || start.getRow() >= grid.length
                || start.getColumn() <0 || start.getColumn() >= grid.length
                || grid[start.getRow()][start.getColumn()] != previousColor) {
            return;
        }
        grid[start.getRow()][start.getColumn()] = colour;
        floodFill(grid, GridUtility.applyDirection(start, Direction.UP),colour, previousColor);
        floodFill(grid, GridUtility.applyDirection(start, Direction.DOWN),colour, previousColor);
        floodFill(grid, GridUtility.applyDirection(start, Direction.LEFT),colour, previousColor);
        floodFill(grid, GridUtility.applyDirection(start, Direction.RIGHT),colour, previousColor);
    }
}
