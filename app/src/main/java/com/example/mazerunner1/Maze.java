package com.example.mazerunner1;

public class Maze {
    private char[][] tileChars;
    public Maze(char[][] tilesIn) {
        tileChars = tilesIn;
    }

    public boolean contains(int x, int y) {
        try {
            getTileAt(x,y);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean contains(Coord coord) {
        try {
            getTileAt(coord);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public char getTileAt(int x, int y) {
        return tileChars[x][y];
    }
    public char getTileAt(Coord coord) {
        return tileChars[(int)coord.getX()][(int)coord.getY()];
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
