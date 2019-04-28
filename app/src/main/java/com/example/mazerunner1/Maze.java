package com.example.mazerunner1;

public class Maze {
    private char[][] tileChars;
    Coord startingCoord;
    public Maze(char[][] tilesIn, Coord startingCoord) {
        tileChars = tilesIn;
        this.startingCoord = startingCoord;
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
        for(int y=0; y<tileChars[0].length;y++) {
            for(int x=0; x<tileChars.length;x++) {
                out+=tileChars[x][y];
            }
            out +="\n";
        }
        return out;
    }
}
