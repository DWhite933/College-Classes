/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pickacard;

/*
Name: David White
Class: CIS2571
Instructor: Barry Speller
Assignment: Homework ch.3
File: PickACard.java
Description: Write a program that simulates picking a card from a deck of 52 cards
 */
public class PickACard {

    public static void main(String[] args) {
        // declare variables
        int rank = (int)(Math.random() * 13);
        int suit = (int)(Math.random() * 4);
        
        // show user info
        System.out.print("The card the computer picked is ");
        
        // generate card rank
        switch (rank) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9: System.out.print(rank + 1); break;
            case 0: System.out.print("Ace"); break;
            case 10: System.out.print("Jack"); break;
            case 11: System.out.print("Queen"); break;
            case 12: System.out.print("King"); break;
              
        }
        
        System.out.print(" of ");
        
        // genrate card suit
        switch (suit) {
            case 0: System.out.println("Clubs"); break;
            case 1: System.out.println("Hearts"); break;
            case 2: System.out.println("Spades"); break;
            case 3: System.out.println("Diamonds"); break;
        }
         
    }
    
}
