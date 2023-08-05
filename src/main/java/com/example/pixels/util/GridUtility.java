package com.example.pixels.util;

import com.example.pixels.constant.Direction;
import com.example.pixels.data.Point;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class GridUtility {

    public static Point applyDirection(Point start, Direction direction) {
        return new Point(start.getRow() + direction.getColumn(), start.getColumn() + direction.getRow());
    }

    public static void validateInput( int[][] pixels, int... inputs) {
        Arrays.stream(inputs).forEach(input -> {
            assert (input >= 0 && input <= pixels.length);
        });
    }
}
