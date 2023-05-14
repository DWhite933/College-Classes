/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonekeypad;

import java.util.Scanner;

/*
 Name: David White
 Class: CIS2571
 Instructor: Barry Speller
 Assignment: HW ch.6
 File: PhoneKeypad.java
 Description: Prompts the user to enter a phone number as a string,  translates a letter to a digit
 */
public class PhoneKeypad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // declare variables
        String phoneNumber;
        char currentNumber;
        
        //create scanner
        Scanner input = new Scanner(System.in);
        
        // ask user for input
        System.out.print("Enter phone number: ");
        phoneNumber = input.nextLine();
        
        for (int i = 0; i < phoneNumber.length(); i++) {
            currentNumber = phoneNumber.charAt(i);
            
            if (Character.isLetter(currentNumber)) {
                System.out.print(getNumber(Character.toUpperCase(currentNumber)));
            }
            else
                System.out.print(currentNumber);
        }
        
    }
    public static int getNumber(char uppercaseLetter){
        int newNumber = 0;
        
        switch (uppercaseLetter){
            case 'A':
            case 'B':
            case 'C': newNumber = 2; break;
            case 'D':
            case 'E':
            case 'F': newNumber = 3; break;
            case 'G':
            case 'H':
            case 'I': newNumber = 4; break;
            case 'J':
            case 'K':
            case 'L': newNumber = 5; break;
            case 'M':
            case 'N':
            case 'O': newNumber = 6; break;
            case 'P': 
            case 'Q':
            case 'R':
            case 'S': newNumber = 7; break;
            case 'T':
            case 'U':
            case 'V': newNumber = 8; break;
            case 'W':
            case 'X':
            case 'Y':
            case 'Z': newNumber = 9; break;
        }
        
        return newNumber;
    }
}
