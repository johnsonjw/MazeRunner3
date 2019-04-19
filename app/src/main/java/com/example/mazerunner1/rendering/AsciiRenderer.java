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
        for(int x = 0; x<distanceArray.length;) {
            String columnText = renderColumn(distanceArray[x]);
            for(int y = 0; y < columnText.length(); y++) {

            }
        }
        return converter.charArrayToString(renderArray);
    }

    private String renderColumn(double distance) {
        return "";
    }
}
