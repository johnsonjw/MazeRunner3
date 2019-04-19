package com.example.mazerunner1.rendering;

import com.example.mazerunner1.Coord;

public class MazeWindow {

    private int xSize;
    private int ySize;
    AsciiRenderer renderer;
    RayCaster caster;

    public MazeWindow(int width, int height) {
        this.xSize = width;
        this.ySize = height;
        caster =  new RayCaster(width);
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
