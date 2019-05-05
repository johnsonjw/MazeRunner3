package com.example.mazerunner1.rendering;

import com.example.mazerunner1.Maze;

import org.junit.Test;

import static org.junit.Assert.*;

public class MazeWindowTest {

    @Test
    public void getTextScreen() {
//        MazeWindow window = new MazeWindow(80,20, 60, makeSquareMaze());
//        for(int i=0;i<5;i++) {
//            int renderAngle=0;
//            Ray renderRay = new Ray(1,1.1,renderAngle+(10*i));
//            window.setRenderRay(renderRay);
//            window.render();
//            System.out.println(window.getTextScreen());
//        }

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

        for(int i = 2; i<3; i++) {
            squareTiles[i+1][4] = '#';
        }
        squareTiles[2][7] = '#';
        squareTiles[5][5] = 'g';

        Maze mazeOut = new Maze(squareTiles, null);
        System.out.println(mazeOut.toString());
        return mazeOut;
    }
}