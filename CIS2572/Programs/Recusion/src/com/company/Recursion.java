package com.company;

import java.util.Scanner;

/*
Name: David White
Class: CIS2572
Instructor:  Mohammad Morovati
Assignment: Programming exercise 18.21
File: Recursion.java
Description: Write a recursive method that converts a decimal number into a binary number as a string.
             Write a test program that prompts the user to enter a decimal number and displays its binary equivalent
 */
public class Recursion {

    public static void main(String[] args) {
        // create scanner
        Scanner input = new Scanner(System.in);

        // ask user to enter a decimal number
        System.out.print("Enter a decimal number: ");
        int decimal = input.nextInt();

        // display binary equivalent
        System.out.println("The binary equivalent of " + decimal + " is " + dec2Bin(decimal));
    }

    /**
     * @param decimal an int to find binary equivalent of
     * @return send to recursive helper
     */
    // converts a decimal into a binary as a string
    public static String dec2Bin(int decimal){
        String result = "";
        return dec2Bin(decimal, result);
    }

    /**
     * @param decimal int to find binary equivalent of
     * @param result binary equivalent of decimal
     * @return recursive
     */
    // recursive helper
    public static String dec2Bin(int decimal, String result){
        if (decimal / 2 == 0) // base case
            return (decimal % 2) + result;
        else
            return dec2Bin(decimal / 2, (decimal % 2) + result);
    }
}
