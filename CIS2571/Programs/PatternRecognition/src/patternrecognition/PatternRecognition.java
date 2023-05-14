/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patternrecognition;

import java.util.Scanner;

/*
 Name: David White
 Class: CIS2571
 Instructor: Barry Speller
 Assignment: HW ch.7
 File: PatternRecognition.java
 Description: Check if a series of integers has four consecutive numbers with the same value
 */
public class PatternRecognition {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // declare variables
        int numberOfValues;
        
        //create scanner
        Scanner input = new Scanner(System.in);
        
        // ask user for number of values
        System.out.print("Enter the number of values: ");
        numberOfValues = input.nextInt();
        
        // create array
        int[] values = new int[numberOfValues];
        
        // ask user for array values
        System.out.print("Enter the values: ");
        for (int i = 0; i < numberOfValues; i++) {
            values[i] = input.nextInt();
        }
        
        // show user result
        if (isConsecutiveFour(values) == true) 
            System.out.println("The list has consecutive fours.");
        else
            System.out.println("The list has no consecutive fours");
    }
    
    public static boolean isConsecutiveFour(int[] values){
        int count = 1; // number of consecutive int
        
        for (int i = 0; i < (values.length - 1); i++) {
            if (values[i] == values[i+1])
                count++;
            else
                count = 1;
            

            if (count >= 4)
                return true; 
            }
        return false;
        }
}
