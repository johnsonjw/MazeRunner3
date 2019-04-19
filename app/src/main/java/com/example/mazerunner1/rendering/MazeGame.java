package com.example.mazerunner1.rendering;

import com.example.mazerunner1.Maze;

public class MazeGame {
    MazeWindow window;
    Maze maze;
    Player player;

    public MazeGame() {

    }

    public void turnLeft() {

        updateMazeWindow();
    }

    public void turnRight() {

        updateMazeWindow();
    }

    public void moveForward() {

        updateMazeWindow();
    }

    public void moveBackward() {

        updateMazeWindow();
    }

    public String getMazeRender() {
        return window.getTextScreen();
    }

    private void updateMazeWindow() {
        window.setRenderRay(player.getFacingRay());
        window.setRenderPoint(player.getPosition());
    }
}
