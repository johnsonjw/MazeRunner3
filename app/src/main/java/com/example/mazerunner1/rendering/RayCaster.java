package com.example.mazerunner1.rendering;

import android.util.Log;

import com.example.mazerunner1.Coord;
import com.example.mazerunner1.Maze;

import java.lang.annotation.Target;

public class RayCaster {
    private static final String TAG = "RayCaster";
    private int screenWidth;
    private final double maxRenderDistance = 8;
    private final double renderResolution = .2;
    private final char wallChar = '#';


    public RayCaster (int width)
    {
        screenWidth = width;
    }

    public double[] getDistanceArray(Ray ray, double fov, Maze maze) {
        Log.d(TAG,"fov = " + fov);
        double[] outArray = new double[screenWidth];
        double degreesPerColumn = fov/(screenWidth-1);
        Log.d(TAG,"outArray of length " + outArray.length + ", degreesPerColumn=" +degreesPerColumn);
        for(int offset=0; offset<screenWidth; offset++) {
            double castingAngle = ray.getAngle() - (fov/2) + degreesPerColumn*offset;
            Ray rayToCast = new Ray(ray.getOrigin(), castingAngle);
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
//            System.out.println("distanceCoord:" + distanceCoord);
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
//        System.out.println("distance for ray " + ray.toString() + "="+(distanceOut-renderResolution));
        return distanceOut-renderResolution;
    }
}
