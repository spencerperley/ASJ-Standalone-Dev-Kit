package edu.ahs.robotics.java;

public class Point {
    private double x;
    private double y;
    private static int countPoints = 0;
    public Point (double x, double y){
        this.x=x;
        this.y=y;
        countPoints++;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point=(" +
                x +
                "," + y +
                ')';
    }
    public double distanceFromOrigin(){
        double xSquare = Math.pow(x,2);
        double ySquare = Math.pow(y,2);
        return Math.sqrt(xSquare+ySquare);


    }

    public String getQuadrant() {
        if (x>0 && y>0){
            return "Quadrant 1";

        } else if (x<0 && y>0){
            return "Quadrant 2";

        }else if (x<0 && y<0) {
            return "Quadrant 3";

        }else if (x>0 && y<0) {
            return "Quadrant 4";

        }else if (x==0 ^ y==0) {
            return "Axis";

        }else if (x==0 && y==0){
            return "Origin";
        }
        else {
            return null;
        }
    }
    public static String numberOfPoints(){

        return "There are " + countPoints +" points";
    }

    public double distanceToPoint(Point secondPoint){
        double xSquare = Math.pow(x-secondPoint.getX(),2);
        double ySquare = Math.pow(y-secondPoint.getY(),2);
        return Math.sqrt(xSquare+ySquare);
    }

    public Point findClosestPointFromArray(Point[] points){
        Point closestPoint= points[0];
        int sizeOfList = points.length;
        for (int i = 1; i <sizeOfList; i++) {
            if (this.distanceToPoint(closestPoint)>this.distanceToPoint(points[i])){
                closestPoint=points[i];
            }


        }
        return closestPoint;
    }

    public static double distanceBeetweenTwoPoints(Point pointOne,Point pointTwo){
        return pointOne.distanceToPoint(pointTwo);
    }

    public static Point midpointBetweenTwoPoints(Point pointOne, Point pointTwo){
        Point midpoint;
        LineSegment twoPoints = new LineSegment(pointOne,pointTwo);
        Point[] midList = twoPoints.subDivide(2);
        midpoint=midList[0];
        return midpoint;
    }

    public class WayPoint {
    }
}
