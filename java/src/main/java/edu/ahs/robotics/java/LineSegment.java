package edu.ahs.robotics.java;

public class LineSegment {
    private Point point1;
    private Point point2;

    public LineSegment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;

    }
    public Point[] subDivide( int subSegments){
        Point[] points=new Point[subSegments-1];
        double xDif = (point2.getX())-(point1.getX());
        double yDif = (point2.getY())-(point1.getY());
        double relitiveXStart = (xDif)/subSegments;
        double relitiveYStart = (yDif)/subSegments;
        for (int i = 1; i <subSegments; i++) {
            double finX =(relitiveXStart*i)+point1.getX();
            double finY =(relitiveYStart*i)+point1.getY();
            Point newPoint=new Point(finX,finY);
            points[i-1]=newPoint;

        }
        return points;

    }
    
}
