package edu.ahs.robotics.java;

public class Main {
    public static void main(String[] args) {
        Point[] randomPoints = new Point[6];
        randomPoints[0]=new Point(1,1);
        randomPoints[1]=new Point(1,1);
        randomPoints[2]=new Point(2,2);
        randomPoints[3]=new Point(4,4);
        randomPoints[4]=new Point(5,5);
        randomPoints[5]=new Point(5,5);

        Point a = new Point(1,1);
        Point x = new Point(1,1);
        Point c = new Point(3,4);
        Point d = new Point(10,5);
        Path testPath = new Path(randomPoints);


        System.out.println(testPath.totalLengthOfPath());





    }

}