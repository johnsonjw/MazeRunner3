package com.example.mazerunner1.rendering;

import com.example.mazerunner1.Maze;

public class MazeGame {
    MazeWindow window;
    Maze maze;
    Player player;
    MovementHandler handler;

    public MazeGame(int width, int height, Maze maze, Player player) {
        this.player = player;
        this.maze = maze;
        window = new MazeWindow(width, height, this.player.getFieldOfView(), this.maze);
        handler = new MovementHandler(this.maze);
        updateMazeWindow();
    }

    public void turnLeft(double turnSpeed) {
        handler.turn(player, -turnSpeed);
        updateMazeWindow();
    }

    public void turnRight(double turnSpeed) {
        handler.turn(player, turnSpeed);
        updateMazeWindow();
    }

    public void moveForward(double moveSpeed) {
        handler.move(player, moveSpeed);
        updateMazeWindow();
    }

    public void moveBackward(double moveSpeed) {
        handler.move(player, -moveSpeed);
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
