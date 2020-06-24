package edu.ahs.robotics.java;

public class Main {
    public static void main(String[] args) {
        Point[] randomPoints = new Point[5];
        randomPoints[0]=new Point(-21,-5);
        randomPoints[1]=new Point(-1,5);
        randomPoints[2]=new Point(2,2);
        randomPoints[3]=new Point(-5,5);
        randomPoints[4]=new Point(1,-5);

        Point a = new Point(1,1);
        Point c = new Point(8,18);
        Point d = new Point(12,-45);
        LineSegment b= new LineSegment(c,d);
        b.subDivide(5);
        System.out.println(Point.numberOfPoints());
        System.out.println(a.distanceToPoint(c));
        System.out.println(a.findClosestPointFromArray(randomPoints));

    }

}