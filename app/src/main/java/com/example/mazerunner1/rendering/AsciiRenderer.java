package com.example.mazerunner1.rendering;

import com.example.mazerunner1.Maze;
import com.example.mazerunner1.StringConverter;

public class AsciiRenderer {

    private int height;
    StringConverter converter = new StringConverter();

    //TODO
    public AsciiRenderer(int height) {
        this.height = height;
    }

    public String renderFrom(double[] distanceArray) {
        char[][] renderArray = new char[distanceArray.length][height];
        return converter.charArrayToString(renderArray);
    }
}
