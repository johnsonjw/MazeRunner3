package com.example.mazerunner1.rendering;

import com.example.mazerunner1.Maze;

public class RayCaster {
    private int screenWidth;

    private static double maxRenderDistance = 10;
    private static double renderResolution = .1;
    private static char wallChar = '#';


    public RayCaster (int width)
    {

    }

    public double[] getDistanceArray(Player player, Maze maze) {
        double[] outArray = new double[screenWidth];
        double degreesPerColumn = player.getFieldOfView()/screenWidth;
        for(int offset=0; offset<screenWidth; offset++) {
            double castingAngle = player.getFieldOfView() + degreesPerColumn*offset;
            Ray rayToCast = new Ray(player.getPosition(), castingAngle);
            outArray[offset] = getDistanceToWall(rayToCast, maze);
        }
        return outArray;
    }

    private double getDistanceToWall(Ray ray, Maze maze) {
        double distanceOut=0;
        boolean hitWall = false;
        while(!hitWall) {
            distanceOut+=renderResolution;
            Coord distanceCoord = ray.getCoordAt(distanceOut);

        }

        return distanceOut;
    }
}
