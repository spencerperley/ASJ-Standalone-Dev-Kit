package edu.ahs.robotics.java;

public class Main {
    public static void main(String[] args) {
        Point[] randomPoints = new Point[2];
        randomPoints[0]=new Point(0,0);
        randomPoints[1]=new Point(0,10);


        Point a = new Point(1,1);
        Point x = new Point(1,1);
        Point c = new Point(0,1);
        Point d = new Point(10,5);
        Path testPath = new Path(randomPoints);

        //Point z = (testPath.targetPoint(c,6).getPoint());

       int z = (randomPoints.length);


        System.out.println(z);






    }

}