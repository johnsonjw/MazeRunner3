package com.example.mazerunner1.rendering;

import com.example.mazerunner1.Maze;

public class MovementHandler {
    Maze maze;

    public MovementHandler(Maze maze) {
        this.maze = maze;
    }

    public void turn(Player player, double amnt) {
//        System.out.println("Turning " +amnt);
        Ray startingRay = player.getFacingRay();
        Ray newRay = new Ray(startingRay.getOrigin(), startingRay.getAngle()+(player.getTurnSpeed()*amnt));
        player.setFacingRay(newRay);
    }

    public void move(Player player, double amnt) {
//        System.out.println("Moving " +amnt);
        boolean needSpace = true;
        for(double x=amnt*player.moveSpeed; x>0; x-=.1) {
            if(maze.getTileAt(player.getFacingRay().getCoordAt(x))!='#') {
                if(needSpace) {
                    player.setPosition(player.getFacingRay().getCoordAt(x));
                    needSpace = false;
                }
            } else {
                needSpace = true;
            }
        }
    }
}
