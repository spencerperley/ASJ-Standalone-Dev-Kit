package edu.ahs.robotics.java;

public class Point {
    private double x;
    private double y;
    public Point (double x, double y){
        this.x=x;
        this.y=y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point=(" +
                x +
                "," + y +
                ')';
    }
    public double distanceFromOrigin(){
        double xSquare = Math.pow(x,2);
        double ySquare = Math.pow(y,2);
        return Math.sqrt(xSquare+ySquare);


    }

    public String getQuadrant() {
        return null;
    }

}
