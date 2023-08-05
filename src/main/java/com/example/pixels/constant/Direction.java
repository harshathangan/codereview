package com.example.pixels.constant;

import com.example.pixels.data.Point;
import lombok.Getter;

@Getter
public enum Direction {
    UP(0, -1),
    DOWN(0,1),
    LEFT(-1,0),
    RIGHT(1,0);

    final int row;
    final int column;

    Direction(int row, int column) {
        this.row = row;
        this.column = column;
    }

}
