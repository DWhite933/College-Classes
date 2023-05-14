/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findtheflippedcell;

import java.util.Scanner;

/*
 Name: David White
 Class: CIS2571
 Instructor: Barry Speller
 Assignment: HW ch.8
 File: FindtheFlippedCell.java
 Description: Prompt the user to enter a 6-by-6 array with 0s and 1s and find the first row and first column where the number of 1s is not even
 */
public class FindtheFlippedCell {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // declare variables
        int row;
        int column;
        
        // get matrix from user
        System.out.println("Enter a 6-by-6 matrix row by row:");
        int[][] matrix = getMatrix();
        
        // find the first row and column where the even 1s property is violated
        row = oddRows(matrix);
        column = oddColumns(matrix);
        
        // Display flipped cell
        if (row < 0 || column < 0) 
            System.out.println("No cell has been flipped");
        else
            System.out.println("The flipped cell is at (" + row + ", " + column + ")" );
    }
    
    public static int[][] getMatrix() {
        // create scanner
        Scanner input = new Scanner(System.in);

        // Create matrix
        int[][] matrix = new int[6][6];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                    matrix[j][i] = input.nextInt();
            }
        }
        
        return matrix;
	}
    
    public static int oddRows(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            int count = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) 
                    count++;
            }
            if (isOdd(count)) 
                return i;
            
        }
        return -1;
    }
    
    public static int oddColumns(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            int count = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) 
                    count++;
            }
            if (isOdd(count)) 
                return i;
            
        }
        return -1;
    }
    
    public static boolean isOdd(int number){
        boolean odd;
        if (number % 2 != 0) 
            odd = false;
        else 
            odd = true;
        
        return odd;
        
    }
}
