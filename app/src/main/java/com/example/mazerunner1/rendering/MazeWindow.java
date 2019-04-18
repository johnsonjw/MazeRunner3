package com.example.mazerunner1.rendering;

public class MazeWindow {

    private int xSize;
    private int ySize;
    AsciiRenderer renderer;
    RayCaster caster = new RayCaster();

    public MazeWindow(int width, int height) {
        this.xSize = width;
        this.ySize = height;
    }

    //TODO
    public void setRenderPoint(Coord coord) {

    }

    //TODO
    public void setRenderRay(Ray ray) {

    }

    //TODO
    public String getTextScreen() {
        return "MAZE NOT RENDERED";
    }
}
