package com.example.mazerunner1.rendering;

public class AsciiRenderer {

    private int height;
    private int horizonLine;
    private double maxRender = 8f;

    //$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\|()1{}[]?-_+~<>i!lI;:,"^`'.

    //TODO
    public AsciiRenderer(int height) {
        this.height = height;
        this.horizonLine = (int)Math.round(height * .5);
        //System.out.println("horizonLine=" +horizonLine);
    }

    public char[][] renderFrom(double[] distanceArray) {
        char[][] renderArray = new char[distanceArray.length][height];
//        System.out.println("renderArray" + renderArray.length +"x"+renderArray[0].length);
        for(int x = 0; x<distanceArray.length; x++) {
            char[] column = renderColumn(distanceArray[x]);
            for(int y = 0; y < column.length; y++) {
                renderArray[x][y] = column[y];
            }
        }
        return renderArray;
    }

    public char[] renderColumn(double distance) {
//        System.out.println("rendering column for distance " + distance);
        char[] column = getEmptyColumn(height);
        int wallHeight = (int) Math.round(getRelativeWallHeight(distance) * height);
        column = addWallTo(column, wallHeight);
        return column;
    }

    private char[] addWallTo(char[] input, float wallHeight) {
//        System.out.println("adding wall of height " + wallHeight);
        char[] output = input;
        char wallChar;
        double relHeight = wallHeight/height;
        if(relHeight<.1) {
            wallChar = '*';
        } else if(relHeight<.4) {
            wallChar = '$';
        } else if(relHeight<.8) {
            wallChar = '@';
        } else {
            wallChar = '#';
        }
        for(int i=0;i<wallHeight/2;i++) {
//            System.out.println("i="+i);
            if(output.length>(horizonLine+i))
                output[horizonLine+i]=wallChar;
            if(horizonLine-1>=0)
                output[horizonLine-i]=wallChar;
        }
        return output;
    }


    private char[] getEmptyColumn(int height) {
        char[] out = new char[height];
        for(int i = 0; i<height; i++) {
            double floorSpace = (horizonLine -i)/(double)(horizonLine-height);
            if(i<horizonLine) {
                out[i] = ' ';
            } else if(floorSpace < .2) {
                out[i] = '.';
            } else if(floorSpace< .6) {
                out[i] = ':';
            } else {
                out[i] = ';';
            }
        }
        return out;
    }
    public double getRelativeWallHeight(double distance) {
        double clampedDistance = Math.min(distance,maxRender);
        double wallHeight = 1f - clampedDistance / maxRender;
//        System.out.println("WallHeight="+ wallHeight);
        return wallHeight;
    }
}
