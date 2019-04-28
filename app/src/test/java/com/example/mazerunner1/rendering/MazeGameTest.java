package com.example.mazerunner1.rendering;

import com.example.mazerunner1.Maze;

import org.junit.Test;

import static org.junit.Assert.*;

public class MazeGameTest {

    @Test
    public void squareDance() {
        Ray renderRay = new Ray(1,1,0);
        Player player = new Player(renderRay,1,10,70);
        MazeGame mazeGame = new MazeGame(80,20,makeSquareMaze(),player);
        System.out.println(mazeGame.getMazeRender());
        for(int x=0;x<5;x++) {
            for(int y=0;y<5;y++) {
                mazeGame.moveForward(.5);
                System.out.println(mazeGame.getMazeRender());
            }
            for(int z=0;z<4;z++) {
                mazeGame.turnRight(1);
                System.out.println(mazeGame.getMazeRender());
            }
        }
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
        squareTiles[1][3] = '#';
        squareTiles[5][5] = 'g';

        Maze mazeOut = new Maze(squareTiles, null);
        System.out.println(mazeOut.toString());
        return mazeOut;
    }

}