/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labch13;

/**
 *
 * Rectangle extends GeometricObject
 */
public class Rectangle extends GeometricObject {
        private double width;
        private double height;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /** Return width */
    public double getWidth() {
        return width;
    }

    /** Set a new width */
    public void setWidth(double width) {
        this.width = width;
    }

    /** Return height */
    public double getHeight() {
        return height;
    }

    /** Set a new height */
    public void setHeight(double height) {
        this.height = height;
    }

    /** */
    @Override
    public String toString() {
        return "[Rectangle] " + "width = " + width + ", height = " + height;
    }

    /** Return area */
    @Override
    public double getArea() {
        return width * height;
    }
    
    /** Return perimeter */
    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}
