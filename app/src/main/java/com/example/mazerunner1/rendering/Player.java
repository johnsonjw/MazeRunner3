package com.example.mazerunner1.rendering;

import com.example.mazerunner1.Coord;

public class Player {
    double moveSpeed;
    double turnSpeed;
    Ray facingRay;
    double fieldOfView;

    public Player (Ray facing, double moveSpeed, double turnSpeed, double fov) {
        this.facingRay = facing;
        this.moveSpeed = moveSpeed;
        this.turnSpeed = turnSpeed;
        this.fieldOfView = fov;
    }

    public void setPosition(Coord position) {
        this.facingRay = new Ray(position, this.facingRay.getAngle());
    }

    public void setFacingRay(Ray facingRay) {
        this.facingRay = facingRay;
    }


    //Getter Methods
    public Coord getPosition() {
        return facingRay.getOrigin();
    }
    public double getMoveSpeed() {
        return moveSpeed;
    }
    public double getTurnSpeed() {
        return turnSpeed;
    }
    public double getFieldOfView() {
        return fieldOfView;
    }
    public Ray getFacingRay() {
        return facingRay;
    }
}