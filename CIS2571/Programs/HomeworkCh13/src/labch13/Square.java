/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labch13;

/*
Name: David White
Class: CIS2571
Instructor: Barry Speller
Assignment: HW ch.13
File: Square.java
Description:  Design a class named Square that extends GeometricObject and implements Colorable
 */
public class Square extends GeometricObject implements Colorable{
    
    //length of one side
    private double sideLength = 1;
    
    //default constructor
    public Square() {
    }
    
    //create a square with specified side length
    public Square(double length){
        this.sideLength = length;
    }
    
    //sets side length to specified side length
    public void setSideLength(double length){
        this.sideLength = length;
    }
    
    //returns length of one side
    public double getSideLength(){
        return this.sideLength;
    }
    
    //returns area of square
    @Override
    public double getArea(){
       return Math.pow(sideLength, 2);
    }
    
    //returns perimeter of square
    @Override
    public double getPerimeter(){
        return 4 * sideLength;
    }
    
    //returns description of square
    @Override
    public String toString(){
        return "[Square] side length = " + sideLength;
    }
    
    //describes how to color the square
    @Override
    public String howToColor(){
        return "Color all four sides";
    }
}
