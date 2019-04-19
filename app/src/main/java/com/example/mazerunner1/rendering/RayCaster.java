package com.example.mazerunner1.rendering;

import com.example.mazerunner1.Coord;
import com.example.mazerunner1.Maze;

public class RayCaster {
    private int screenWidth;

    private final double maxRenderDistance = 10;
    private final double renderResolution = .2;
    private final char wallChar = '#';


    public RayCaster (int width)
    {
        screenWidth = width;
    }

    public double[] getDistanceArray(Player player, Maze maze) {
        double[] outArray = new double[screenWidth];
        double degreesPerColumn = player.getFieldOfView()/(screenWidth-1);
        for(int offset=0; offset<screenWidth; offset++) {
            double castingAngle = player.getFacingRay().getAngle() + degreesPerColumn*offset;
            Ray rayToCast = new Ray(player.getPosition(), castingAngle);
            outArray[offset] = getDistanceToWall(rayToCast, maze);
        }
        return outArray;
    }

    private double getDistanceToWall(Ray ray, Maze maze) {
//        System.out.println("getDistanceToWall for ray:" + ray.toString());
        double distanceOut=0;
        boolean hitWall = false;
        while(!hitWall && distanceOut<maxRenderDistance) {
            Coord distanceCoord = ray.getCoordAt(distanceOut);
            if(maze.contains(distanceCoord)) {
                if(maze.getTileAt(distanceCoord) == wallChar) {
                    hitWall = true;
//                    System.out.print("WALL FOUND @ ");
//                    System.out.println(distanceCoord);
                }
            } else {
                hitWall=true;
            }
            distanceOut+=renderResolution;
        }

        return distanceOut-renderResolution;
    }
}
