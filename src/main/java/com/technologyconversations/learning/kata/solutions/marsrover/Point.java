package com.technologyconversations.learning.kata.solutions.marsrover;

public class Point {

    private int location;
    public void setLocation(int value) { location = value; }
    public int getLocation() { return location; }

    private int maxLocation;
    public void setMaxLocation(int value) { maxLocation = value; }
    public int getMaxLocation() { return maxLocation; }

    public Point(int locationValue, int maxLocationValue) {
        setLocation(locationValue);
        setMaxLocation(maxLocationValue);
    }

    public void forward() {
        setLocation((getLocation() + 1) % (getMaxLocation() + 1));
    }

    public void backward() {
        if (getLocation() > 0) setLocation(getLocation() - 1);
        else setLocation(getMaxLocation());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return !(location != point.location || maxLocation != point.maxLocation);
    }

    @Override
    public int hashCode() { return location + maxLocation; }

}
