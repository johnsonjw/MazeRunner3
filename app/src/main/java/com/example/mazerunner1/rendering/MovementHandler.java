package com.example.mazerunner1.rendering;

import com.example.mazerunner1.Maze;

public class MovementHandler {
    Maze maze;

    public MovementHandler(Maze maze) {
        this.maze = maze;
    }

    public void turn(Player player, double amnt) {
        Ray startingRay = player.getFacingRay();
        Ray newRay = new Ray(startingRay.getOrigin(), startingRay.getAngle()+amnt);
        player.setFacingRay(newRay);
    }

    public void move(Player player, double amnt) {
        for(double x=amnt; x>0; x-=.1) {
            if(maze.getTileAt(player.getFacingRay().getCoordAt(amnt))!='#') {
                player.setPosition(player.getFacingRay().getCoordAt(x));
            }
        }
    }
}
