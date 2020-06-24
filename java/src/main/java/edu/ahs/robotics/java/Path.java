package edu.ahs.robotics.java;

public class Path {

    public static class WayPoint{
        private Point wayPoint;

        public WayPoint(Point wayPoint) {
            this.wayPoint = wayPoint;
        }
    }

    public Path(Point[] rawPoints){
        for (int i = 0; i <(rawPoints.length)+1; i++) {
            if (rawPoints[i]!=rawPoints[i+1]){

            }

        }
    }


    public double totalLengthOfPath(){
        return 0.0;
    }

    public Path.WayPoint targetPoint(Point curent, double distance){
        return new WayPoint(new Point(0,0));
    }
}
