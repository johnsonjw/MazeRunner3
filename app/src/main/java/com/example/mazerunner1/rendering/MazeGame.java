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

    //TODO
    public void loadMazeText(String mazeText) {

    }

    public String getMazeRender() {
        return window.getTextScreen(player, maze);
    }

    private void updateMazeWindow() {
        window.setRenderRay(player.getFacingRay());
    }
}
