package edu.ahs.robotics.java;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Path {

    public static class WayPoint{
        public Point point;

        public WayPoint(Point point) {
            this.point = point;
        }
    }
    private ArrayList<WayPoint> wayPoints;


    public Path(Point[] rawPoints){

        wayPoints=new ArrayList<>();
        wayPoints.add(new WayPoint((rawPoints[0])));
        int j = 0;
        for (int i = 1; i <(rawPoints.length); i++) {
            if (!rawPoints[i].equals(wayPoints.get(j).point)) {
                j++;
                wayPoints.add(new WayPoint(rawPoints[i]));
            }
        }
    }

    public ArrayList<WayPoint> getWayPoints() {
        return wayPoints;
    }

    public double totalLengthOfPath(){
        double distance=0.0;

        for (int i = 1; i < wayPoints.size(); i++) {
            distance= distance + (wayPoints.get(i-1).point.distanceToPoint(wayPoints.get(i).point));

        }
        return distance;
    }


    public Path.WayPoint targetPoint(Point current, double distance){
        return new WayPoint(new Point(0,0));
    }
}
