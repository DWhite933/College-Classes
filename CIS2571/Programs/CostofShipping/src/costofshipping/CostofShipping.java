/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package costofshipping;

import java.util.Scanner;

/*
Name: David White
Class: CIS2571
Instructor: Barry Speller
Assignment: Lab ch.3
File: CostofShipping.java
Description: Calculate the cost of shipping (in dollars) based on the weight of the package (in pounds)
 
 */
public class CostofShipping {

    public static void main(String[] args) {
        // declare variables
        double packageWeight; // weight of package
        double shippingCost = 0; // cost to ship package
       
        // create scanner
        Scanner input = new Scanner(System.in);
        
        // ask user for input
        System.out.print("Enter weight of package in pounds: ");
        packageWeight = input.nextDouble();
        
        // calculate shipping cost
        if (packageWeight <= 1)
            shippingCost = 3.5;
        else if (packageWeight <= 3)
            shippingCost = 5.50;
        else if (packageWeight <= 10)
            shippingCost = 8.50;
        else if (packageWeight <= 20)
            shippingCost = 10.50;
        else if (packageWeight > 20)
            System.out.print("Package is too heavy to be shipped.");
         
        // show user cost
        if (shippingCost > 1)
            System.out.print("It will cost $" + shippingCost + " to ship your package");
     
    
        
        }
    }
