package com.example.mazerunner1;

import com.example.mazerunner1.rendering.Player;
import com.example.mazerunner1.rendering.Ray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.ClosedFileSystemException;

public class MazeConverter {
    private final String extension = ".maize";
    private GameSettings settings;
    private Maze maze;
    private File file;
    private Player player;

    public MazeConverter(GameSettings settings) {
        this.settings = settings;
    }

    public void setFile(File file) throws Exception {
        this.file = file;
        if(!endsWith(file.getName(), extension))
            throw new Exception("wrong extension");
        else
            parseFile();
    }

    private void parseFile() throws Exception{
        String fileString =splitIntoString(file);
        StringConverter converter = new StringConverter();
        if(converter.isRectangle(fileString)) {
            char[][] fileArray = converter.StringToCharArray(fileString);
            setPlayerFromArray(fileArray);
            setMazeFromArray(fileArray);

        }
    }

    private void setPlayerFromArray(char[][] array) throws Exception {
        Coord playerLoc = findLocOf(array,'p');
        if(playerLoc!=null) {
            Ray facingRay = new Ray(playerLoc, settings.getStartingAngle());
            player = new Player(facingRay, settings.getMoveSpeed(), settings.getFov());
        } else
            throw new Exception("Player not found");
    }
    private void setMazeFromArray(char[][] array) throws Exception {
        Coord goalLoc = findLocOf(array,'g');
        if(goalLoc!=null) {
            maze = new Maze(array, player.getPosition());
        } else
            throw new Exception("Goal not found");

    }

    private Coord findLocOf(char[][] array, char toFind) {
        for(int x = 0; x<array.length;x++) {
            for(int y = 0; y<array.length; y++) {
                if(array[x][y]==toFind) {
                    return new Coord(x,y);
                }
            }
        }
        return null;
    }
    private String splitIntoString(File file) throws Exception {
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

    private boolean endsWith(String toCheck, String ending) {
        return toCheck.length()>ending.length()&&
               toCheck.substring(toCheck.length()-ending.length()).equals(ending);
    }
    public Maze getMaze() {
        return maze;}
    public Player getPlayer() {
        return player;
    }
}
