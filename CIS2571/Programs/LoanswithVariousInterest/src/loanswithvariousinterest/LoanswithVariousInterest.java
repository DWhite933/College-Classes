/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loanswithvariousinterest;

import java.util.Scanner;

/*
 Name: David White
 Class: CIS2571
 Instructor: Barry Speller
 Assignment: Homework ch.4
 File: LoanswithVariousInterest.java
 Description: Compare loans with various interest rates
 */
public class LoanswithVariousInterest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Decalre variables
        double loanAmount, monthlyPayment, totalPayment; 
        int numberOfYears;
        double interestRate = 5;
        
        // create scanner
        Scanner input = new Scanner(System.in);
        
        // ask user for input
        System.out.print("Loan Amount: ");
        loanAmount = input.nextDouble();
        System.out.print("Number of Years: ");
        numberOfYears = input.nextInt();
        
        // Display Header
        System.out.printf("%10s%25s%25s\n", "Intrest Rate", "Monthly Payment", "Total Payment");
        
        // calculate interest
        while (interestRate <= 10) {            
            // calculate monthly payment
            monthlyPayment = (loanAmount * interestRate / 1200) / (1 - (1 / Math.pow((1 + interestRate / 1200), (numberOfYears * 12))));
            
            //calculate total payment
            totalPayment = monthlyPayment * numberOfYears * 12;
            
            //display info
            System.out.printf("%.3f%% %25.2f %25.2f\n", interestRate, monthlyPayment, totalPayment);
            
            //increment counter
            interestRate += .25;
            
        }
        
    }
    
}
