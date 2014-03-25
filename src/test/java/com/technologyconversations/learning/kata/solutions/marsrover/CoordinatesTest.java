package com.technologyconversations.learning.kata.solutions.marsrover;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CoordinatesTest {

    private Coordinates coordinates;
    private final int maxLocation = 99;
    private final int x = 1;
    private final int y = 2;

    @Before
    public void beforeCoordinatesTest() {
        coordinates = new Coordinates(x, y, maxLocation, maxLocation);
    }

    @Test
    public void setXShouldStoreXPoint() {
        Point expected = new Point(3, maxLocation);
        coordinates.setX(expected);
        Assert.assertEquals(expected, coordinates.getX());
    }

    @Test
    public void setYShouldStoreYPoint() {
        Point expected = new Point(4, maxLocation);
        coordinates.setY(expected);
        Assert.assertEquals(expected, coordinates.getY());
    }

    @Test
    public void newInstanceShouldRequireXAndYParams() {
        Assert.assertEquals(new Point(x, maxLocation), coordinates.getX());
        Assert.assertEquals(new Point(y, maxLocation), coordinates.getY());
    }

    @Test
    public void equalsShouldReturnTrueIfXAndYreTheSame() {
        Coordinates equalCoordinates = new Coordinates(1, 2, maxLocation, maxLocation);
        Assert.assertEquals(coordinates, equalCoordinates);
    }

    @Test
    public void equalsShouldReturnFalseIfXLocationIsNotTheSame() {
        Coordinates xNotEqualCoordinate = new Coordinates(3, y, maxLocation, maxLocation);
        Assert.assertNotEquals(coordinates, xNotEqualCoordinate);
    }

    @Test
    public void equalsShouldReturnFalseIfYLocationIsNotTheSame() {
        Coordinates yNotEqualCoordinate = new Coordinates(x, 4, maxLocation, maxLocation);
        Assert.assertNotEquals(coordinates, yNotEqualCoordinate);
    }

    @Test
    public void moveShouldIncreaseYWhenDirectionIsNorth() {
        Point expected = new Point(coordinates.getY().getLocation() + 1, maxLocation);
        coordinates.move(Direction.NORTH);
        Assert.assertEquals(expected, coordinates.getY());
    }

    @Test
    public void moveShouldIncreaseXWhenDirectionIsEast() {
        Point expected = new Point(coordinates.getX().getLocation() + 1, maxLocation);
        coordinates.move(Direction.EAST);
        Assert.assertEquals(expected, coordinates.getX());
    }

    @Test
    public void moveShouldDecreaseYWhenDirectionIsSouth() {
        Point expected = new Point(coordinates.getY().getLocation() - 1, maxLocation);
        coordinates.move(Direction.SOUTH);
        Assert.assertEquals(expected, coordinates.getY());
    }

    @Test
    public void moveShouldDecreaseXWhenDirectionIsWest() {
        Point expected = new Point(coordinates.getX().getLocation() - 1, maxLocation);
        coordinates.move(Direction.WEST);
        Assert.assertEquals(expected, coordinates.getX());
    }

    @Test
    public void toStringShouldReturnXAndY() {
        Assert.assertEquals(x + "" + y, coordinates.toString());
    }

}
