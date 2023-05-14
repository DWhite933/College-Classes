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
File: HomeworkCh13.java
Description: Write a test program that creates an array of five GeometricObjects: Circles, Rectangles and Squares. 
             For each object in the array, display its area and invoke its howToColor() method if it is colorable
 */
public class HomeworkCh13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create array
        GeometricObject[] shapes = new GeometricObject[5];
        
        //add circles
        shapes[0] = new Circle(5);
        shapes[1] = new Circle(Math.random() * 10);
        
        //add rectangle
        shapes[2] = new Rectangle(8.5, 11);
        
        //add squares
        shapes[3] = new Square(5);
        shapes[4] = new Square(Math.random() * 10);
        
        //display area and how to color
        for (int i = 0; i < shapes.length; i++) {
            System.out.println("Area of shape " + (i + 1)  + " is: " + shapes[i].getArea());
            if (shapes[i] instanceof Colorable) {
                System.out.println("How to Color: " + ((Colorable)shapes[i]).howToColor());
            }
        }
    }
}
