package edu.ahs.robotics.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class PathTest {

    @Test
    public void totalLengthOfPath() {
        Point[] points = new Point[] {new Point(0,0), new Point(3,4)};
        Path path = new Path(points);
        assertEquals(5, path.totalLengthOfPath(), 0.00001);
    }
}