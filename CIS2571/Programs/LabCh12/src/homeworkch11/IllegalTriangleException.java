/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeworkch11;

/*
Name: David White
Class: CIS2571
Instructor: Barry Speller
Assignment: Lab ch.12
File: IllegalTriangleException.java
Description: Create the IllegalTriangleException class
 */
public class IllegalTriangleException extends Exception {
    private double side1;
    private double side2;
    private double side3;
    
    //Construct IllegalTriangleException
    
    public IllegalTriangleException(double side1, double side2, double side3) {
        super("Illegal sides " + side1 + " " + side2 + " " + side3);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        
    }
    
    //return side1
    public double getSide1(){
        return side1;
    }
    
    //return side2
    public double getSide2(){
        return side2;
    }
    
    //return side3
    public double getSide3(){
        return side3;
    }
    
}
