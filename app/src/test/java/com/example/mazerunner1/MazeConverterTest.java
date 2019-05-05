package com.example.mazerunner1;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class MazeConverterTest {
    GameSettings gameSettings = new GameSettings(0.5, 0.4, 0, 70);
    MazeConverter converter = new MazeConverter(gameSettings);
    @Test
    public void setFile() {
        File file = new File("C:\\Users\\Griff\\Documents\\GitHub\\MazeRunner3\\app\\src\\main\\assets\\mazes\\test.maize");
        try {
            String fileString = getFileString(file);
            System.out.println(fileString);
            converter.parseMaze(fileString);
            Maze maze = converter.getMaze();
            System.out.println(maze.toString());
            System.out.println(converter.getPlayer().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String getFileString(File file) {
        BufferedReader br = null;
        String out = "";
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                out+=line+'\n';
            }
            out = out.substring(0,out.length()-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out;
    }
}