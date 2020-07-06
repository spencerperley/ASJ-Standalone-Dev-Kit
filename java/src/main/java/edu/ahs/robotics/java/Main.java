package edu.ahs.robotics.java;

public class Main {
    public static void main(String[] args) {

        Point[] points = new Point[] {new Point(0,0), new Point(1,3), new Point(5,4), new Point(4,8), new Point(0,9)};
        Point point = new Point(2,2);
        Path path = new Path(points);


        System.out.println(path.targetPoint(point,6).getPoint());






    }

}