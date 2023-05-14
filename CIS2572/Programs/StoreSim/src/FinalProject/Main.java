package FinalProject;

/*

Name: David White
Class: CIS2572
Instructor:  Mohammad Morovati
Assignment: Final Project
File: Main.java
Description:
Create an application that simulates a store with customers coming
in the store every 4 minutes and a service time of 3 minutes. Display
how many customer will be serviced in an 8-hour shift and the maximum
length of the line. Due to customer shopping time being random there
will be some variance between runs but the number of customers entering
the store will always be the same.

 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // all the customers in the store
        List<Customer> store = new ArrayList<>();

        // the customers in the checkout line
        Queue<Customer> checkoutLine = new LinkedList<>();

        // length of an 8-hour shift in minutes
        int shiftTime = 480;

        // the max length of the checkout line
        int maxLineLength = 0;

        // the number of customers serviced
        int numCustomers = 0;

        int serviceStart = 0;



        for (int index = 0; index < shiftTime; index++)  {
            // every 4 minutes a customer comes into the store
            if (index % 4 == 0){
                store.add(new Customer());
            }

            // Decrement the shopping time
            for (Customer c : store){
                c.shop();
            }
            
            // Customer moves to checkout line when done shopping
            for (int i = 0; i < store.size(); i++) {
                if (store.get(i).getShoppingTime() == 0){
                    checkoutLine.add(store.get(i));
                    store.remove(i);
                }
            }

            // calc max line length
            if (maxLineLength < checkoutLine.size()){
                maxLineLength = checkoutLine.size();
            }

            if (checkoutLine.peek() == null) {
                serviceStart += 3;
            }
            // checkout takes 3 min
            if (checkoutLine.peek() != null && serviceStart == index) {
                numCustomers += 1;
                checkoutLine.poll();
                serviceStart = index + 3;
            }
        }

        System.out.println("Customers serviced: " + numCustomers);
        System.out.println("Max line length: " + maxLineLength);

    }
}
