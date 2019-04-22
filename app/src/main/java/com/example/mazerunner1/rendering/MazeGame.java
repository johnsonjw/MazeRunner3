package com.example.mazerunner1.rendering;

import com.example.mazerunner1.Maze;

public class MazeGame {
    MazeWindow window;
    Maze maze;
    Player player;

    public MazeGame(int width, int height, Maze maze, Player player) {
        this.player = player;
        this.maze = maze;
        window = new MazeWindow(width, height, this.player.fieldOfView, this.maze);
    }

    //TODO
    public void turnLeft(double turnSpeed) {

        updateMazeWindow();
    }

    //TODO
    public void turnRight(double turnSpeed) {

        updateMazeWindow();
    }

    //TODO
    public void moveForward(double moveSpeed) {
        player.moveForward(moveSpeed);
        updateMazeWindow();
    }

    //TODO
    public void moveBackward(double moveSpeed) {
        player.moveBackward(moveSpeed);
        updateMazeWindow();
    }

    public String getMazeRender() {
        return window.getTextScreen();
    }

    private void updateMazeWindow() {
        window.setRenderRay(player.getFacingRay());
        window.render();
    }
}
