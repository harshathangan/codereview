package com.example.pixels;

public enum Direction {
    UP(0, -1),
    DOWN(0,1),
    LEFT(-1,0),
    RIGHT(1,0);

    final int x;
    final int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Point apply(Point start) {
        Point p = new Point();
        p.row = start.row + y;
        p.column = start.column + x;
        return p;
    }
}
