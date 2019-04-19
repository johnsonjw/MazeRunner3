package com.example.mazerunner1.rendering;

import com.example.mazerunner1.Coord;
import com.example.mazerunner1.Maze;
import com.example.mazerunner1.StringConverter;

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
    public String getTextScreen(Player player, Maze maze) {
        return renderer.renderFrom(caster.getDistanceArray(player, maze));
    }
}
