package com.technologyconversations.learning.kata.solutions.marsrover;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
Source: http://dallashackclub.com/rover

Develop an api that moves a rover around on a grid.
* You are given the initial starting point (x,y) of a rover and the direction (N,S,E,W) it is facing.
* The rover receives a character array of commands.
* Implement commands that move the rover forward/backward (f,b).
* Implement commands that turn the rover left/right (l,r).
* Implement wrapping from one edge of the grid to another. (planets are spheres after all)
* Implement obstacle detection before each move to a new square.
If a given sequence of commands encounters an obstacle, the rover moves up to the last possible point and reports the obstacle.
*/
public class RoverTest {

    // TODO Move backward
    // TODO Obstacle detection

    private Rover rover;
    private Coordinates roverCoordinates;
    private final Direction direction = Direction.NORTH;
    private final int x = 1;
    private final int y = 2;
    private final int maxX = 9;

    @Before
    public void beforeRoverTest() {
        roverCoordinates = new Coordinates(x, y, maxX, 9);
        rover = new Rover(roverCoordinates, direction);
    }

    @Test
    public void setRoverCoordinatesShouldStoreCoordinates() {
        Coordinates roverCoordinates = new Coordinates(3,6, 9, 9);
        rover.setCoordinates(roverCoordinates);
        Assert.assertEquals(roverCoordinates, rover.getCoordinates());
    }

    @Test
    public void setDirectionShouldStoreDirection() {
        Direction direction = Direction.SOUTH;
        rover.setDirection(direction);
        Assert.assertEquals(direction, rover.getDirection());
    }

    @Test
    public void newInstanceShouldRequireRoverCoordinatesAndDirection() {
        Assert.assertEquals(roverCoordinates, rover.getCoordinates());
        Assert.assertEquals(direction, rover.getDirection());
    }

    @Test
    public void receiveSingleCommandShouldMoveForwardWhenCommandIsM() throws Exception {
        rover.receiveSingleCommand('M');
        Assert.assertEquals(y + 1, rover.getCoordinates().getY().getLocation());
    }

    @Test
    public void receiveSingleCommandShouldTurnLeftWhenCommandIsL() throws Exception {
        rover.receiveSingleCommand('L');
        Assert.assertEquals(Direction.WEST, rover.getDirection());
    }

    @Test
    public void receiveSingleCommandShouldTurnRightWhenCommandIsR() throws Exception {
        rover.receiveSingleCommand('R');
        Assert.assertEquals(Direction.EAST, rover.getDirection());
    }

    @Test(expected = Exception.class)
    public void receiveSingleCommandShouldThrowExceptionWhenCommandIsUnknown() throws Exception {
        rover.receiveSingleCommand('X');
    }

    @Test
    public void receiveCommandsShouldBeAbleToReceiveMultipleCommands() throws Exception {
        rover.receiveCommands("RMR");
        Assert.assertEquals(x + 1, rover.getCoordinates().getX().getLocation());
        Assert.assertEquals(Direction.SOUTH, rover.getDirection());
    }

    @Test
    public void receiveCommandShouldWhatFromOneEdgeOfTheGridToAnother() throws Exception {
        rover.receiveCommands("LMMM");
        Assert.assertEquals(maxX + x - 2, rover.getCoordinates().getX().getLocation());
    }

    @Test
    public void positionShouldReturnXYAndDirection() throws Exception {
        rover.receiveCommands("LMMMRMM");
        Assert.assertEquals("84N", rover.getPosition());
    }


}
