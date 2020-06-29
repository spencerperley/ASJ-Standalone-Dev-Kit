package edu.ahs.robotics.java;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Path {

    public static class WayPoint{
        public Point point;
        private double deltaXFroPrevious;
        private double deltaYFroPrevious;
        private double distanceFromPrevious;

        private WayPoint(Point point, double deltaXFroPrevious, double deltaYFroPrevious, double distanceFromPrevious) {
            this.point = point;
            this.deltaXFroPrevious = deltaXFroPrevious;
            this.deltaYFroPrevious = deltaYFroPrevious;
            this.distanceFromPrevious = distanceFromPrevious;
        }
    }
    private ArrayList<WayPoint> wayPoints;


    public Path(Point[] rawPoints){

        wayPoints=new ArrayList<>();
        wayPoints.add(new WayPoint.(rawPoints[0]));
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

    private double componentAlongPath(Point current, WayPoint wayPoint) {
        double deltaXToWayPoint = wayPoint.point.x - current.x;
        double deltaYToWayPoint = wayPoint.point.y - current.y;

        double dp = deltaXToWayPoint * wayPoint.deltaXFromPrevious + deltaYToWayPoint * wayPoint.deltaYFromPrevious;
        return dp / wayPoint.distanceFromPrevious;
    }

}
