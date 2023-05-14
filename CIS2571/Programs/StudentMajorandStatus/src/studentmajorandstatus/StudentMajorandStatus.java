/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmajorandstatus;

import java.util.Scanner;

/*
Name: David White
Class: CIS2571
Instructor: Barry Speller
Assignment: Lab ch.4
File: StudentMajorandStatus.java
Description: prompts the user to enter two characters and displays the major and status represented in the characters.
 */
public class StudentMajorandStatus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // declare variables
        String majorOutput = null;
        String statusOutput = null;
        
        // create scanner
        Scanner input = new Scanner(System.in);
        
        // ask user for input
        System.out.print("Enter two characters: ");
        String studentID = input.nextLine();
        
        // get char from input
        char major = studentID.charAt(0);
        char status = studentID.charAt(1);
        
        // find major
        Character.toUpperCase(major);
        switch (major) {
            case 'I': majorOutput = "Information Managment "; break;
            case 'C': majorOutput = "Computer Science "; break;
            case 'A': majorOutput = "Accounting "; break;
            default: 
                System.out.print("Invalid input");
                System.exit(1);
        }
        
        // find status
        switch (status) {
            case '1': statusOutput = "Freshman"; break;
            case '2': statusOutput = "Sophmore"; break;
            case '3': statusOutput = "Junior"; break;
            case '4': statusOutput = "Senior"; break;
            default:
                System.out.print("Invalid input");
                System.exit(1);
        }
        
        // display output
        System.out.print(majorOutput + statusOutput);
    }
    
}
