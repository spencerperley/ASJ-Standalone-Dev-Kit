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
    public void componentAlongPath(){
        Point[] points = new Point[] {new Point(0,1), new Point(0,10)};
        Point point = new Point(0,1);
        Path path = new Path(points);
        assertEquals(9.0,path.componentAlongPath(point,path.getWayPoints().get(1)),0.00001);
    }


    @Test
    public void totalLengthOfPath() {
        Point[] points = new Point[] {new Point(1,1), new Point(1,1), new Point(3,4),new Point(10,5)};
        Path path = new Path(points);
        assertEquals(10.6766190873, path.totalLengthOfPath(), 0.00001);
    }
}