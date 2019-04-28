package com.example.mazerunner1;

public class GameSettings {
    private double moveSpeed;
    private double turnSpeed;
    private double startingAngle;
    private double fov;

    public GameSettings(double moveSpeed, double turnSpeed, double startingAngle, double fov) {
        this.moveSpeed = moveSpeed;
        this.turnSpeed = turnSpeed;
        this.startingAngle = startingAngle;
        this.fov = fov;
    }

    public double getMoveSpeed() {
        return moveSpeed;
    }
    public double getStartingAngle() {
        return startingAngle;
    }
    public double getTurnSpeed() {
        return turnSpeed;
    }
    public double getFov() {
        return fov;
    }
}
