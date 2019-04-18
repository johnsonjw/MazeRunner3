package com.example.mazerunner1.rendering;

public class Player {
    Coord position;
    double speed;
    Ray facingRay;
    double fieldOfView;

    public Player (Coord start, double speed, double fov) {
        this.position =  start;
        this.speed = speed;
        this.fieldOfView = fov;
    }

}
