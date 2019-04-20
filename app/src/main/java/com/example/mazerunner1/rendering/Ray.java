package com.example.mazerunner1.rendering;

import com.example.mazerunner1.Coord;

public class Ray {
    double angle;
    Coord origin;

    public Ray(double x, double y, double angle) {
        origin  = new Coord(x,y);
        this.angle = angle;
    }
    public Ray(Coord loc, double angle) {
        origin  = new Coord(loc.getX(), loc.getY());
        this.angle = angle;
    }

    public Coord getCoordAt(double distance) {
        //System.out.println(Math.cos(Math.toRadians(angle)) + "," + Math.sin(Math.toRadians(angle)));
        double xOut = (distance * Math.cos(Math.toRadians(angle))) + origin.getX();
        double yOut = (distance * Math.sin(Math.toRadians(angle))) + origin.getY();
        Coord coordOut = new Coord(xOut, yOut);
        return coordOut;
    }


    public Coord getOrigin() {
        return origin;
    }
    public double getAngle() {
        return angle;
    }

    public String toString() {
        return origin.toString() + ", " + String.format("%5.2f", angle);
    }
}
