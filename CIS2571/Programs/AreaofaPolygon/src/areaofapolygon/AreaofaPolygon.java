/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areaofapolygon;

import java.util.Scanner;

/*
 Name: David White
 Class: CIS2571
 Instructor: Barry Speller
 Assignment: Lab ch.6
 File: AreaofaPolygon.java
 Description: Copmute area of a polygon
 */
public class AreaofaPolygon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // declare variables
        int sides;
        double length;
        
        // create scanner
        Scanner input = new Scanner(System.in);
        
        // ask user for input
        System.out.print("Enter the number of sides: ");
        sides = input.nextInt();
        System.out.print("Enter the side length: ");
        length = input.nextDouble();
        
        // call and print area calculation
        System.out.println("The area of the polygon is " + area(sides, length));
    }
    
    // calculate area
    public static double area(int numberOfSides, double sideLength) {
        double area;
        
        area = (numberOfSides * Math.pow(sideLength, 2)) / (4 * Math.tan(Math.PI / numberOfSides));
        
        return area;
    }
}
