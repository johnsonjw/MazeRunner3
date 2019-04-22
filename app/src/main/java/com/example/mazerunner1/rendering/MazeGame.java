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
        window.render();
    }
}
