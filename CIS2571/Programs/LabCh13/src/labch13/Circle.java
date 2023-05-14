/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labch13;

/**
 *
 * The circle class that extends GeometricObject
 */
public class Circle extends GeometricObject {
    private double radius;

    /**Default constructor*/
    public Circle() {
        this(1.0);
    }

    /**Construct circle with a specified radius*/
    public Circle(double radius) {
        this(radius, "white", false);
    }

    /**Construct a circle with specified radius, filled, and color*/
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    /**Return radius*/
    public double getRadius() {
        return radius;
    }

    /**Set a new radius*/
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**Implementation of the getArea method defined in GeometricObject*/
    public double getArea() {
        return radius*radius*Math.PI;
    }

    /**Implementation of the getPerimeter method defined in GeometricObject*/
    public double getPerimeter() {
        return 2*radius*Math.PI;
    }

    /**Override the equals() method defined in the Object class*/
    @Override 
    public boolean equals(Object o) {
        if (o instanceof Circle) {
            return this.radius == ((Circle)o).getRadius();
        } else
            return false;
    }

    /**Override the toString() method defined in the Object class */
    @Override 
    public String toString() {
        return "[Circle] radius = " + radius;
    }
}

