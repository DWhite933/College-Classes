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
Assignment: Lab ch.13
File: Labch13.java
Description: Write a method that sums the areas of all the geometric objects in an array.
 */
public class Labch13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create array
        GeometricObject[] shapes = new GeometricObject[4];
        
        //add  circles
        shapes[0] = new Circle(3.5);
        shapes[1] = new Circle(Math.random() * 10);
        
        //add rectangles
        shapes[2] = new Rectangle(8.5, 11);
        shapes[3] = new Rectangle(Math.random() * 10, Math.random() * 10);
        
        //print total area
        System.out.println("The total area is " + sumArea(shapes));
    }
    //get total area
    public static double sumArea(GeometricObject[] objects){
        double totalArea = 0;
        for (GeometricObject object : objects) {
            totalArea = totalArea + object.getArea();
        }
        return totalArea;
    }
}
