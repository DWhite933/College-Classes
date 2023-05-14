package com.example.closestpair;

/*
Name: David White
Class: CIS2572
Instructor:  Mohammad Morovati
Assignment: Programming exercise 22.17
File: PointPair.java
Description:
A pair of points

 */

import java.awt.geom.Point2D;




public class PointPair {

    // the points
    private final Point2D.Double pointA;
    private final Point2D.Double pointB;

    /**
    no arg constructor
    @param p1 first point
    @param p2 second point
     */
    public PointPair(Point2D.Double p1, Point2D.Double p2) {
        this.pointA = p1;
        this.pointB = p2;
    }

    /**
     * Returns the first point in the pair
     * @return the first point in the pair
     */

    public Point2D.Double getPointA() {
        return pointA;
    }

    /**
     * Returns the second point in the pair
     * @return the second point in the pair
     */

    public Point2D.Double getPointB() {
        return pointB;
    }

    /**
     * returns the distance between the points in the pair
     * @return the distance between the points in the pair
     */

    public double getDistance() {
        return Math.sqrt(Math.pow(pointA.x, pointA.y) + Math.pow(pointB.x, pointB.y));
    }
}
