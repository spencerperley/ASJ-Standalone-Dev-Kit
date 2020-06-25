package edu.ahs.robotics.java;

import java.util.List;

public class Path {

    public static class WayPoint{
        private Point wayPoint;

        public WayPoint(Point wayPoint) {
            this.wayPoint = wayPoint;
        }
    }
    List wayPoints;

    public Path(Point[] rawPoints){
        for (int i = 0; i <(rawPoints.length)+1; i++) {
            if (rawPoints[i]!=rawPoints[i+1]){
                wayPoints.add(new WayPoint(rawPoints[i]));

            }

        }
    }


    public double totalLengthOfPath(){

        for (int i = 0; i < wayPoints.size(); i++) {
            double distance=distance+ (wayPoints[i].distanceToPoint(wayPoints[i+1]);

        }
        return ;
    }


    public Path.WayPoint targetPoint(Point current, double distance){
        return new WayPoint(new Point(0,0));
    }
}
