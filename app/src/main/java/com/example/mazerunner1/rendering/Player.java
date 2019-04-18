package com.example.mazerunner1.rendering;

public class Player {
    Coord position;
    double speed;
    Ray facingRay;
    double fieldOfView;

    public Player (Coord start, Ray facing, double speed, double fov) {
        this.position =  start;
        this.facingRay = facing;
        this.speed = speed;
        this.fieldOfView = fov;
    }

    public void setPosition(Coord position) {
        this.position = position;
    }

    public void setFacingRay(Ray facingRay) {
        this.facingRay = facingRay;
    }

    //TODO
    public void setRenderAngle(double t) {

    }

}
