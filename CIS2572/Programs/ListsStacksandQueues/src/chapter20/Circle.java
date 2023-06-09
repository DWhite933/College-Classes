package chapter20;

/*
Name: David White
Class: CIS2572
Instructor:  Mohammad Morovati
Assignment: Programming exercise 20.21
File: Circle.java
Description: Circle class. Copied directly from the book
 */

public class Circle  extends GeometricObject{
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius,
                  String color, boolean filled) {
        this.radius = radius;
        setColor(color);
        setFilled(filled);
    }

    /** Return radius */
    public double getRadius() {
        return radius;
    }

    /** Set a new radius */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override /* Return area */
    public double getArea() {
        return radius * radius * Math.PI;
    }

    /** Return diameter */
    public double getDiameter() {
        return 2 * radius;
    }

    @Override /* Return perimeter */
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override /* Override the toString method in the Object class */
    public String toString() {
        return super.toString() + ", Circle, Created: "
                + getDateCreated() + ", Radius: " + radius;
    }
}
