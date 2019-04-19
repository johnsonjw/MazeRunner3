package com.example.mazerunner1;

public class Coord {
    private double x,y;

    public Coord(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return String.format("%5.2f", x) + "," + String.format("%5.2f", y);
    }

    public double getY() {
        return y;
    }
    public double getX() {
        return x;
    }
}
