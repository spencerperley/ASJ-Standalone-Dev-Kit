package edu.ahs.robotics.java;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Path {

    public static class WayPoint{
        private Point point;
        private double deltaXFroPrevious;
        private double deltaYFroPrevious;
        private double distanceFromPrevious;
        //private int positionInPathIndex;

        private WayPoint(Point point, double deltaXFroPrevious, double deltaYFroPrevious, double distanceFromPrevious/*, int positionInPath*/) {
            this.point = point;
            //this.positionInPathIndex = positionInPathIndex;
            this.deltaXFroPrevious = deltaXFroPrevious;
            this.deltaYFroPrevious = deltaYFroPrevious;
            this.distanceFromPrevious = distanceFromPrevious;

        }

        public Point getPoint() {
            return point;
        }
    }
    private ArrayList<WayPoint> wayPoints;
    private int searchFrom = 0;


    public Path(Point[] rawPoints){

        wayPoints=new ArrayList<>();
        wayPoints.add(new WayPoint((rawPoints[0]),0.0,0.0,0.0));
        int j = 0;
        for (int i = 1; i <(rawPoints.length); i++) {
            if (!rawPoints[i].equals(wayPoints.get(j).point)) {
                j++;
                int lengthOfArrayList = wayPoints.size();
                double xFromPrevious =(rawPoints[i].getX()) - wayPoints.get(lengthOfArrayList-1).getPoint().getX();
                double yFromPrevious =(rawPoints[i].getY()) - wayPoints.get(lengthOfArrayList-1).getPoint().getY();
                double distanceFromPrevious = wayPoints.get(lengthOfArrayList-1).getPoint().distanceToPoint(rawPoints[i]);
                wayPoints.add(new WayPoint(rawPoints[i],xFromPrevious,yFromPrevious,distanceFromPrevious));
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
        int indexOfNextPoint = 0;
        int indexOfInterpolatedPoint = 0;

        for (int i = searchFrom; i <wayPoints.size(); i++) {
            if (componentAlongPath(current,wayPoints.get(i))>0){
                indexOfNextPoint=i;
                if (indexOfNextPoint>0){
                    searchFrom=indexOfNextPoint-1;
                }
                break;
            }
        }

        Point[] points;
        points = new Point[wayPoints.size()-indexOfNextPoint];

        LineSegment toBeInterpolatedToFindPointZero = new LineSegment(wayPoints.get(indexOfNextPoint).getPoint(),wayPoints.get(indexOfNextPoint-1).getPoint());
        points[0]=toBeInterpolatedToFindPointZero.interpolateLineSegment(componentAlongPath(current,wayPoints.get(indexOfNextPoint)));
        double acumulatedDistance = 0.0;
        for (int i = 1; i < points.length ; i++) {
            points[i]= wayPoints.get(indexOfNextPoint+i).getPoint();
            acumulatedDistance += points[i].distanceToPoint(points[i-1]);
            if (acumulatedDistance>distance){
                double acumulatedDistanceOfNonEndPoints =acumulatedDistance-points[i].distanceToPoint(points[i-1]);
                break;
            }
        }















        for (int i = indexOfNextPoint-1; i <wayPoints.size()-(indexOfNextPoint)-1; i++) {
            if (acumulatedDistance>distance && i== indexOfNextPoint-1){
                return new WayPoint();
            }else{
                if (acumulatedDistance>distance){
                    indexOfInterpolatedPoint=i;
                    break;
                }else{
                    acumulatedDistance=acumulatedDistance+(wayPoints.get(i).getPoint().distanceToPoint(wayPoints.get(i+1).getPoint()));
                }
            }


        }
        LineSegment toInterpolate = new LineSegment(wayPoints.get(indexOfInterpolatedPoint).getPoint(),wayPoints.get(indexOfInterpolatedPoint+1).getPoint());
        Point targetPoint = toInterpolate.interpolateLineSegment(acumulatedDistance-distance);
        double xFromPrevious = wayPoints.get(indexOfInterpolatedPoint).getPoint().getX()-targetPoint.getX();
        double yFromPrevious = wayPoints.get(indexOfInterpolatedPoint).getPoint().getY()-targetPoint.getY();
        double distanceFromPrevious = targetPoint.distanceToPoint(wayPoints.get(indexOfInterpolatedPoint).getPoint());
        return new WayPoint(targetPoint,xFromPrevious,yFromPrevious,distanceFromPrevious);
    }

    public double componentAlongPath(Point current, WayPoint wayPoint) {
        double deltaXToWayPoint = wayPoint.point.getX() - current.getX();
        double deltaYToWayPoint = wayPoint.point.getY() - current.getY();

        double dp = deltaXToWayPoint * wayPoint.deltaXFroPrevious + deltaYToWayPoint * wayPoint.deltaYFroPrevious;
        return dp / wayPoint.distanceFromPrevious;
    }



}
