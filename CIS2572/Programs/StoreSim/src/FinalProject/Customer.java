package FinalProject;

/*

Name: David White
Class: CIS2572
Instructor:  Mohammad Morovati
Assignment: Final Project
File: Customer.java
Description:
This class simulates a customer. The customer will shop for a random amount
of time between 1 and 45 minutes.

 */

import java.util.Random;

public class Customer {

    // how long the customer will be shopping for
    private int shoppingTime;

    // Default Constructor
    public Customer(){
        // random number generator
        Random RNG = new Random();

        this.shoppingTime = RNG.nextInt(45);
    }

    // decrement shopping time
    public void shop(){
        this.shoppingTime -= 1;
    }

    // get shopping time
    public int getShoppingTime(){
        return this.shoppingTime;
    }
}
