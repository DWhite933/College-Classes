/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vowelorconsonant;

import java.util.Scanner;

/*
Name: David White
Class: CIS2571
Instructor: Barry Speller
Assignment: Lab ch.4
File: JVowelOrConsonant.java
Description: Write a program that checka whether the letter is a vowel or consonant.
 */
public class VowelOrConsonant {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // declare variables
        char letter;
        String temporary;
        
        
        // create scanner
        Scanner input = new Scanner(System.in);
        
        //ask user for input
        System.out.print("Enter a Letter: ");
        temporary = input.nextLine();
        letter = temporary.charAt(0); // convert string to char
        
        // check to see if input is a letter
        if (Character.isLetter(letter) == false)
            System.out.print(letter + " is an invalid input");
        
        // check to see if letter is vowel or consonant
        else {
            Character.toLowerCase(letter);
            
            switch (letter) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u': System.out.print(letter + " is a vowel"); break; // display results
                default: System.out.print(letter + " is a consonant");
            }
                
                
            }
        }
        
        
       
                
        
    }
    

