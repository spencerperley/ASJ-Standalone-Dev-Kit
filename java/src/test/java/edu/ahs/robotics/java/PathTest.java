package edu.ahs.robotics.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class PathTest {
    @Test
    public void duplicateRemoved(){
        Point[] points = new Point[] {new Point(1,1), new Point(1,1), new Point(3,4),new Point(10,5)};
        Path path = new Path(points);
        a

    }


    @Test
    public void totalLengthOfPath() {
        Point[] points = new Point[] {new Point(1,1), new Point(1,1), new Point(3,4),new Point(10,5)};
        Path path = new Path(points);
        assertEquals(10.6766190873, path.totalLengthOfPath(), 0.00001);
    }
}