/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characteranalaysis;

import java.util.Scanner;

/*
Name: David White
Class: CIS2571
Instructor: Barry Speller
Assignment: Lab ch.4
File: StudentMajorandStatus.java
Description: Count and display the number of vowels, consonants, uppercase and lowercase letters in a string.
 */
public class CharacterAnalaysis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // declare variables
        int numberOfVowels = 0;
        int numberOfConsonants = 0;
        int uppercaseCount = 0;
        int lowercaseCount = 0;
        
        // create scanner
        Scanner input = new Scanner(System.in);
        
        //ask user for input
        System.out.print("Enter a string: ");
        String word = input.nextLine();
        
        for (int index = 0; index < word.length(); index++) {
            char letter = word.charAt(index);
            
            
            // check if letter is upper or lower case
            if (Character.isUpperCase(letter)) 
                uppercaseCount++;
            else lowercaseCount++;
            
            Character.toLowerCase(letter);
            //check if letter is vowel or consonant
            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u')
                numberOfVowels++;
            else numberOfConsonants++;
           
        }
        
        // dsiplay output
        System.out.println("The number of vowels is " + numberOfVowels);
        System.out.println("The number of consonants is " + numberOfConsonants);
        System.out.println("The number of uppercase is " + uppercaseCount);
        System.out.println("The number of lowercase is " + lowercaseCount);
    }
    
}
