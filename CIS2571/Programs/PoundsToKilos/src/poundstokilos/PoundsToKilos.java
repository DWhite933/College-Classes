/*
Name: David White
Class: CIS2571
Instructor: Barry Speller
Assignment: Lab ch.2
File: PoundsToKilos.java
Description: Convert Pounds into kilograms
 */
package poundstokilos;

import java.util.Scanner;

public class PoundsToKilos {
    public static void main(String[] args) {
        // declare variables
        double weightInPounds, weightInKilos;
        
        // create scanner
        Scanner input = new Scanner(System.in);
        
        // ask user for input
        System.out.print("Enter a weight in Pounds: ");
        weightInPounds = input.nextDouble();
        
        // compute equation
        weightInKilos = weightInPounds * .454;
        
        // display results
        System.out.print(weightInPounds + " pounds is " + weightInKilos + " kilograms ");
    }
    
}
