package com.example.mazerunner1;

import android.util.Log;

import com.example.mazerunner1.rendering.Player;
import com.example.mazerunner1.rendering.Ray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MazeConverter {
    private static final String TAG = "MazeConverter";
    private final String extension = ".maize";
    private GameSettings settings;
    private Maze maze;
    private Player player;

    public MazeConverter(GameSettings settings) {
        this.settings = settings;
    }


    public void parseMaze(String maze) throws Exception{
        //String fileString = splitIntoString(file);
        StringConverter converter = new StringConverter();
        if(converter.isRectangle(maze)) {
            System.out.println("parseFile: Setting player and maze.");
            char[][] fileArray = converter.StringToCharArray(maze);
            setPlayerFromArray(fileArray);
            setMazeFromArray(fileArray);
        }
    }

    private void setPlayerFromArray(char[][] array) throws Exception {
        Coord playerLoc = findLocOf(array,'p');
        if(playerLoc!=null) {
            Log.i("MazeConverter", "setPlayerFromArray: Setting player from array.");
            Ray facingRay = new Ray(playerLoc, settings.getStartingAngle());
            player = new Player(facingRay, settings.getMoveSpeed(), settings.getTurnSpeed(), settings.getFov());
        } else {
            Log.i("MazeConverter", "Player not found");
            throw new Exception("Player not found");
        }
    }

    private void setMazeFromArray(char[][] array) throws Exception {
        Coord goalLoc = findLocOf(array,'g');
        if(goalLoc!=null) {
            maze = new Maze(array, player.getPosition());
        } else {
            Log.i("MazeConverter", "Goal not found");
            throw new Exception("Goal not found");
        }
    }

    private Coord findLocOf(char[][] array, char toFind) {
        for(int x = 0; x < array.length; x++) {
            for(int y = 0; y < array[x].length; y++) {
                if(array[x][y] == toFind) {
                    return new Coord(x,y);
                }
            }
        }
        return null;
    }

    public String splitIntoString(File file) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String fileString = "";
        boolean atStart = true;
        String toAdd;
        while((toAdd = reader.readLine())!=null) {
            if(atStart) {
                fileString += "\n";
                atStart = false;
            }
            fileString += toAdd;
        }
        return fileString;
    }
    
    public Maze getMaze() {
        return maze;
    }

    public Player getPlayer() {
        return player;
    }
}
