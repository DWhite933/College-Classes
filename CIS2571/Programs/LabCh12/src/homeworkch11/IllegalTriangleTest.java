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
File: IllegalTriangleTest.java
Description: Write a program that will create at least one triangle object successfully and attempt to create a triangle that will cause the exception to be thrown. 
 */
public class IllegalTriangleTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //counts number of triangles
        int numberOfTriangles = 0;
        try {
            Triangle triangle1 = new Triangle(2, 2, 2);
            numberOfTriangles++;
            Triangle triangle2 = new Triangle(2.5, 2.5, 2.5);
            numberOfTriangles++;
            Triangle triangle3 = new Triangle(1, 2, 3);
            numberOfTriangles++;
            Triangle triangle4 = new Triangle(5, 5, 5);
        } catch (IllegalTriangleException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Number of triangles: " + numberOfTriangles);
        }
        
        
    }
    
}
