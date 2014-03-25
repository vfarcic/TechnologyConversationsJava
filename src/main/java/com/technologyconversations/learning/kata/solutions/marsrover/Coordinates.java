package com.technologyconversations.learning.kata.solutions.marsrover;

/*
Method move should be used to change X or Y axis position.
 */
public class Coordinates {

    private Point x;
    public void setX(Point value) { x = value; }
    public Point getX() { return x; }

    private Point y;
    public void setY(Point value) { y = value; }
    public Point getY() { return y; }

    public Coordinates(int xValue, int yValue, int maxXValue, int maxYValue) {
        setX(new Point(xValue, maxXValue));
        setY(new Point(yValue, maxYValue));
    }

    public void move(final Direction direction) {
        switch (direction) {
            case NORTH:
                y.forward();
                break;
            case EAST:
                x.forward();
                break;
            case SOUTH:
                y.backward();
                break;
            case WEST:
                x.backward();
                break;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        if (x != null ? !x.equals(that.x) : that.x != null) return false;
        if (y != null ? !y.equals(that.y) : that.y != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = x != null ? x.hashCode() : 0;
        result = 31 * result + (y != null ? y.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getX().getLocation() + "" + getY().getLocation();
    }

}
