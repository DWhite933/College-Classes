/*
 Name: David White
Class: CIS2571
Instructor: Barry Speller
Assignment: Homework ch.2
File: InvestmentCalculator.java
Description: Read in investment amount, annual interest rate, and number of years,
and display the future investment value
 */
package investmentcalculator;

import java.util.Scanner;

public class InvestmentCalculator {
    public static void main(String[] args) {
        // declare variables
        double investmentAmount; // amount to be invested
        double monthlyInterestRate; // annual interest rate as a percent
        double futureInvestmentTotal; // investment total 
        int numberOfYears; // number of years for investment
        
        // create scanner
        Scanner input = new Scanner(System.in);
        
        // ask user for investment amount
        System.out.print("Enter investment Amount: ");
        investmentAmount = input.nextDouble();
        
        // ask user for interest rate
        System.out.print("Enter interest rate percentage: ");
        monthlyInterestRate = input.nextDouble();
        
        // ask user for number of years
        System.out.print("Enter number of years: ");
        numberOfYears = input.nextInt();
        
        // calculate investment value
        futureInvestmentTotal = investmentAmount * Math.pow(1 + monthlyInterestRate / 1200, (numberOfYears * 12));
        
        // show user total
        System.out.print("Accumulated value: $" + futureInvestmentTotal);
        
        
    }
    
}
