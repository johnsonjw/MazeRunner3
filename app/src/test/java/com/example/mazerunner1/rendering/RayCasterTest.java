package com.example.mazerunner1.rendering;

import com.example.mazerunner1.Coord;
import com.example.mazerunner1.Maze;
import com.example.mazerunner1.StringConverter;

import org.junit.Test;

import static org.junit.Assert.*;

public class RayCasterTest {
    StringConverter converter = new StringConverter();

    @Test
    public void getDistanceArray() {
        Maze squareMaze = makeSquareMaze();
        Coord playerStart =  new Coord(1f,1f);
        Ray facingRay = new Ray(playerStart, 0);
        Player player = new Player(playerStart, facingRay, 0,90);
        RayCaster caster = new RayCaster(10);
        double[] distanceArray = caster.getDistanceArray(player, squareMaze);
        String toPrint = "";
        for(double printDouble : distanceArray) {
            toPrint += " " + String.format("%5.2f",printDouble);
        }
        System.out.println(toPrint);
    }

    private Maze makeSquareMaze() {
        char[][] squareTiles = new char[10][10];
        for(int x = 0; x<10; x++) {
            for(int y = 0; y<10; y++) {
                if(x==0||x==9||y==0||y==9) {
                    squareTiles[x][y] = '#';
                }
                else {
                    squareTiles[x][y] = '-';
                }
            }
        }
        squareTiles[1][5] = 3;
        String tileString = converter.charArrayToString(squareTiles);
        char[][] reConvertedArray = converter.StringToCharArray(tileString);
        String reConvertedString = converter.charArrayToString(reConvertedArray);
        Maze mazeOut = new Maze(squareTiles);
        return mazeOut;
    }
}