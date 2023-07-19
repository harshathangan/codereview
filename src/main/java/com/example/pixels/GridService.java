package com.example.pixels;

public class GridService
{
        public void fillPixel(Grid grid, int row, int column, int colour) {
                assert(row>= 0 && row <=grid.pixels.length);
                assert(column>=0 && column<=grid.pixels.length);
                grid.pixels[column][row] = colour;
        }

        public void fillRowOfPixels(Grid grid, int row, int startColumn, int endColumn, int colour) {
                for(int i=startColumn; i<=endColumn; i++) {
                        grid.pixels[row][i] = colour;
                }
        }

    public void fillColumnOfPixels(Grid grid, int startRow, int endRow, int column, int colour) {
        for(int i=startRow; i<=endRow; i++) { grid.pixels[i][column] = colour; }
    }
}
