package com.example.mazerunner1;

public class Maze {
    private char[][] tileChars;
    public Maze(char[][] tilesIn) {
        tileChars = tilesIn;
    }

    public char getTileAt(int x, int y) {
        return tileChars[x][y];
    }

    public String toString() {
        String out="";
        for(int x=0; x<tileChars.length;x++) {
            for(int y=0; y<tileChars[x].length;y++) {
                out+=tileChars[x][y];
            }
            out +="\n";
        }
        return out;
    }
}
