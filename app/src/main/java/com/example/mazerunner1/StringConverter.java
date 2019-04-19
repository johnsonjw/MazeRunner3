package com.example.mazerunner1;

public class StringConverter {
    public char[][] StringToCharArray(String string) {
        char[][] outArray = new char[0][0];
        if(isRectangle(string)) {
            String[] split;
            split = string.split("\\n");
            outArray = new char[split[0].length()][split.length];
            for(int y=0; y<outArray[0].length;y++) {
                for(int x=0; x<outArray.length;x++) {
                    outArray[x][y] = split[y].charAt(x);
                }
            }
        }
        return outArray;
    }
    public String charArrayToString(char[][] charArray) {
        String out = "";
        for(int y=0; y<charArray[0].length-1;y++) {
            for(int x=0; x<charArray.length;x++) {
                out += charArray[x][y]+"";
            }
            out+="\n";
        }
        for(int x=0; x<charArray.length;x++) {
            out += charArray[x][charArray.length-1]+"";
        }
        return out;
    }
    private boolean isRectangle(String toCheck) {
        String[] split;
        boolean lengthMatch = true;
        split = toCheck.split("\\n");
        String lastLine = split[0];
        for(String line : split) {
            if(line.length() != lastLine.length()) {
                lengthMatch = false;
            }
        }
        return lengthMatch;
    }
}
