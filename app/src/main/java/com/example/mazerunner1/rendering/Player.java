package com.example.mazerunner1.rendering;

import com.example.mazerunner1.Coord;

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

    public Player (Ray facing, double speed, double fov) {
        this.position =  facing.getOrigin();
        this.facingRay = facing;
        this.speed = speed;
        this.fieldOfView = fov;
    }

    public void moveForward(double moveSpeed) {
        setPosition(facingRay.getCoordAt(moveSpeed));
    }
    public void moveBackward(double moveSpeed) {
        setPosition(facingRay.getCoordAt(-moveSpeed));
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


    //Getter Methods
    public Coord getPosition() {
        return position;
    }
    public double getSpeed() {
        return speed;
    }
    public double getFieldOfView() {
        return fieldOfView;
    }
    public Ray getFacingRay() {
        return facingRay;
    }
}