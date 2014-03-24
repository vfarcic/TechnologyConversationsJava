package com.technologyconversations.learning.kata.solutions.marsrover;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
Point is a two-dimensional point on the grid.
New instance is created with initial location and maximum location that can be reached on that axis.
Methods forward/backward increase/decrease location.
If maximum location is reached, forward/backward methods wrap location.
 */
public class PointTest {

    Point point;

    @Before
    public void beforePointTest() {
        point = new Point(5, 9);
    }

    @Test
    public void setLocationShouldStoreLocation() {
        Assert.assertEquals(5, point.getLocation());
        point.setLocation(7);
        Assert.assertEquals(7, point.getLocation());
    }

    @Test
    public void newInstanceShouldRequireLocationAndMaxLocationParams() {
        Assert.assertEquals(5, point.getLocation());
        Assert.assertEquals(9, point.getMaxLocation());
    }

    @Test
    public void equalsShouldReturnTrueIfLocationAndMaxLocationAreTheSame() {
        Point equalPoint = new Point(5, 9);
        Assert.assertEquals(point, equalPoint);
    }

    @Test
    public void equalsShouldReturnFalseIfLocationIsNotTheSame() {
        Point notEqualPoint = new Point(6, 9);
        Assert.assertNotEquals(point, notEqualPoint);
    }

    @Test
    public void equalsShouldReturnFalseIfMaxLocationIsNotTheSame() {
        Point notEqualPoint = new Point(5, 99);
        Assert.assertNotEquals(point, notEqualPoint);
    }

    @Test
    public void forwardShouldIncreasePointValueByOne() {
        int expected = point.getLocation() + 1;
        point.forward();
        Assert.assertEquals(expected, point.getLocation());
    }

    @Test
    public void backwardShouldDecreasePointValueByOne() {
        int expected = point.getLocation() - 1;
        point.backward();
        Assert.assertEquals(expected, point.getLocation());
    }

    @Test
    public void setMaxLocationShouldStoreMaxLocation() {
        int expected = 999;
        point.setMaxLocation(expected);
        Assert.assertEquals(expected, point.getMaxLocation());
    }

    @Test
    public void forwardShouldSetValueToZeroIfMaxLocationIsPassed() {
        point.setLocation(point.getMaxLocation());
        point.forward();
        Assert.assertEquals(0, point.getLocation());
    }

    @Test
    public void backwardShouldSetValueToMaxLocationIfZeroLocationIsPassed() {
        point.setLocation(0);
        point.backward();
        Assert.assertEquals(point.getMaxLocation(), point.getLocation());
    }

}
