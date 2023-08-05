package com.example.pixels.util;

import com.example.pixels.constant.Direction;
import com.example.pixels.data.Grid;
import com.example.pixels.data.Point;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GridUtilityTest  {

    private static Point point;
    private static Grid grid;

    @BeforeClass
    public static void init(){
        point = new Point(2, 2);
        grid = new Grid();
        grid.pixels = new int[9][9];
    }

    @Test
    public void testApplyDirectionUP() {
        Point actualPoint = GridUtility.applyDirection(point, Direction.UP);
        assertEquals(actualPoint.getRow(), 1);
        assertEquals(actualPoint.getColumn(), 2);
    }

    @Test
    public void testApplyDirectionDown() {
        Point actualPoint = GridUtility.applyDirection(point, Direction.DOWN);
        assertEquals(actualPoint.getRow(), 3);
        assertEquals(actualPoint.getColumn(), 2);
    }

    @Test
    public void testApplyDirectionRight() {
        Point actualPoint = GridUtility.applyDirection(point, Direction.RIGHT);
        assertEquals(actualPoint.getRow(), 2);
        assertEquals(actualPoint.getColumn(), 3);
    }

    @Test
    public void testApplyDirectionLeft() {
        Point actualPoint = GridUtility.applyDirection(point, Direction.LEFT);
        assertEquals(actualPoint.getRow(), 2);
        assertEquals(actualPoint.getColumn(), 1);
    }

    @Test
    public void testValidateInput() {
        GridUtility.validateInput(grid.pixels, 3,3);
    }

    @Test(expected = AssertionError.class)
    public void validateInput_shouldThrowValidationError() {
        GridUtility.validateInput(grid.pixels, 10,10);
    }
}