/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeworkch11;

/**
Name: David White
Class: CIS2571
Instructor: Barry Speller
Assignment: Lab ch.12
File: Triangle.java
Description: Modify the constructor of the Triangle class to throw an IllegalTriangleException object if a triangle is created with sides that violate the triangle rule
 */
public class Triangle extends GeometricObject {
    //length of side 1
    private double side1 = 1.0;
    
    //length of side 2
    private double side2 = 1.0;
    
    //length of side 3
    private double side3 = 1.0;
    
    //default constructor
    public Triangle(){
        
    }
    
    //creates a triangle with the specified arguemtns
    public Triangle(double side1, double side2, double side3, String color, boolean filled) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        super.setColor(color);
        super.setFilled(filled);
    }
    
    //create a triangle with specified sides
     public Triangle(double side1, double side2, double side3) throws IllegalTriangleException{
        //if 2 sides are less than another side then throw exception
        if (side1 + side2 <= side3 || side2 + side3 <= side1 || side1 + side3 <= side2) {
            throw new IllegalTriangleException(side1, side2, side3);
        }
        
        
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    //returns the length of side 1
    public double getSide1(){
        return this.side1;
    }
    
    //returns the length of side 2
    public double getSide2(){
        return this.side2;
    }
    
    //returns the length of side e
    public double getSide3(){
        return this.side3;
    }
    
    //returns the area of the triangle
    public double getArea(){
        double s = (this.side1 + this.side2 + this.side3) / 2;
        double area = Math.sqrt(s * (s - this.side1) * (s - this.side2) * (s - this.side3));
        return area;
    }
    
    //returns the perimeter of the triangle
    public double getPerimeter(){
        return this.side1 + this.side2 + this.side3;
    }
    
    @Override
    public String toString(){
        return "Trrangle:\n" + super.toString() + "\nTriangle: side1 = " + side1 + " side 2 = " + side2 + " side3 = " + side3;
    }
}
