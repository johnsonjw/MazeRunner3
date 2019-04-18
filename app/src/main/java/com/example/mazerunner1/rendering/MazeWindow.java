package com.example.mazerunner1.rendering;

public class MazeWindow {

    int xSize;
    int ySize;
    AsciiRenderer renderer;
    RayCaster caster = new RayCaster();

    public MazeWindow(int width, int height) {
        this.xSize = width;
        this.ySize = height;
    }

    //TODO
    public void setRenderPoint(double x, double y) {

    }

    //TODO
    public void setRenderAngle(double t) {

    }

    //TODO
    public String getTextScreen() {
        return "MAZE NOT RENDERED";
    }
}
