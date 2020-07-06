package edu.ahs.robotics.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.MissingFormatArgumentException;

import static org.junit.Assert.*;

public class PathTest {
    @Test
    public void duplicateRemoved(){
        Point[] points = new Point[] {new Point(1,1), new Point(1,1), new Point(3,4),new Point(10,5)};
        Point[] expected = new Point[] {new Point(1,1), new Point(3,4),new Point(10,5)};
        Path path = new Path(points);
        ArrayList<Path.WayPoint> foundWayPoint = path.getWayPoints();
        assertEquals(expected.length,foundWayPoint.size());
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], foundWayPoint.get(i).getPoint());
        }



    }
    @Test
    public void targetPoint1(){
        Point[] points = new Point[] {new Point(0,0), new Point(2,1), new Point(3,2), new Point(4,4), new Point(4,20)};
        Point point = new Point(3,3);
        Path path = new Path(points);
        assertEquals(8.658,path.targetPoint(point,6).getPoint().getY(),0.01);
    }

    @Test
    public void targetPoint2(){
        Point[] points = new Point[] {new Point(0,0), new Point(1,3), new Point(5,4), new Point(4,8), new Point(0,9)};
        Point point = new Point(2,2);
        Path path = new Path(points);
        assertEquals(6.53,path.targetPoint(point,6).getPoint().getY(),0.01);



    }


    @Test
    public void totalLengthOfPath() {
        Point[] points = new Point[] {new Point(1,1), new Point(1,1), new Point(3,4),new Point(10,5)};
        Path path = new Path(points);
        assertEquals(10.6766190873, path.totalLengthOfPath(), 0.00001);
    }
}