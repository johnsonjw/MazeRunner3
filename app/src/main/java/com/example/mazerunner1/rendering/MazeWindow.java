package com.example.mazerunner1.rendering;

import com.example.mazerunner1.Coord;
import com.example.mazerunner1.Maze;
import com.example.mazerunner1.StringConverter;

public class MazeWindow {

    private int xSize;
    private int ySize;
    private double fov;
    AsciiRenderer renderer;
    RayCaster caster;
    StringConverter converter = new StringConverter();
    private String renderedScreen;
    private Ray renderRay;
    Maze maze;

    public MazeWindow(int width, int height, double fov, Maze maze) {
        this.xSize = width;
        this.ySize = height;
        this.fov = fov;
        this.maze = maze;
        renderer = new AsciiRenderer(height);
        caster =  new RayCaster(width);
    }

    //TODO
    public void setRenderRay(Ray ray) {
        renderRay = ray;
    }

    public void render() {
//        System.out.println("Rendering screen");
        double[] distanceArray = caster.getDistanceArray(renderRay, fov, maze);
        char[][] renderedCharArray = renderer.renderFrom(distanceArray);
        renderedScreen = converter.charArrayToString(renderedCharArray);
    }

    //TODO
    public String getTextScreen() {
        return renderedScreen;
    }
}
