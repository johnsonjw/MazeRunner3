package com.example.mazerunner1.rendering;

import android.util.Log;

import com.example.mazerunner1.Coord;
import com.example.mazerunner1.Maze;
import com.example.mazerunner1.StringConverter;

public class MazeWindow {
    private static final String TAG = "MazeWindow";
    private int xSize;
    private int ySize;
    private double fov;
    private AsciiRenderer renderer;
    private RayCaster caster;
    private StringConverter converter = new StringConverter();
    private String renderedScreen;
    private Ray renderRay;
    private Maze maze;

    public MazeWindow(int width, int height, double fov, Maze maze) {
        this.xSize = width;
        this.ySize = height;
        this.fov = fov;
        this.maze = maze;
        renderer = new AsciiRenderer(ySize);
        caster =  new RayCaster(xSize);
    }

    //TODO
    public void setRenderRay(Ray ray) {
        renderRay = ray;
    }

    public void render() {
        double[] distanceArray = caster.getDistanceArray(renderRay, fov, maze);
        Log.d(TAG,"render() on distanceArray of length " + distanceArray.length);
        char[][] renderedCharArray = renderer.renderFrom(distanceArray);
        addDistance(renderedCharArray);
        renderedScreen = converter.charArrayToString(renderedCharArray);
    }

    private void addDistance(char[][] array) {
        Coord goalLoc = maze.getGoal();
        String distance = renderRay.getDistanceTo(goalLoc) + "";
        for(int x=0; x<3;x++) {
            array[x][0] = distance.charAt(x);
        }
    }

    //TODO
    public String getTextScreen() {
        return renderedScreen;
    }
}
