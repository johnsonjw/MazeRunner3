package com.example.mazerunner1.rendering;

import com.example.mazerunner1.Maze;

public class AsciiRenderer {

    Maze maze;
    RayCaster caster;

    //TODO
    public AsciiRenderer(Maze maze) {
        this.maze = maze;
    }

    public String getRenderColumn(int c) {
        return "rendering column " + c;
    }
}
