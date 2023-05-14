/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessthecapitals;

import java.util.Scanner;

/*
 Name: David White
 Class: CIS2571
 Instructor: Barry Speller
 Assignment: Lab ch.8
 File: GuesstheCapitals.java
 Description: Prompt the user to enter a capital for a state, reports whether the answer is correct, and then tell the user the distance of the state’s capital from Chicago
 */
public class GuesstheCapitals {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // decalre variables
        char playAgain = 'Y'; // loop control variable
        String guess; // user's guess
        int correctGuesses = 0; // number of correct guesses
        int numberOfGuesses = 0; // number of guesses total
        String capital;
        String state;
        double chicagoToCapital;
        
        //initialize arrays
        String [][] statesAndCapitals = {
            {"Alabama", "Montgomery"},
            {"Alaska", "Juneau"},
            {"Arizona", "Phoenix"},
            {"Arkansas", "Little Rock"},
            {"California", "Sacramento"},
            {"Colorado", "Denver"},
            {"Connecticut", "Hartford"},
            {"Delaware", "Dover"},
            {"Florida", "Tallahassee"},
            {"Georgia", "Atlanta"},
            {"Hawaii", "Honolulu"},
            {"Idaho", "Boise"},
            {"Illinois", "Springfield"},
            {"Indiana", "Indianapolis"},
            {"Iowa", "Des Moines"},
            {"Kansas", "Topeka"},
            {"Kentucky", "Frankfort"},
            {"Louisiana", "Baton Rouge"},
            {"Maine", "Augusta"},
            {"Maryland", "Annapolis"},
            {"Massachusetts", "Boston"},
            {"Michigan", "Lansing"},
            {"Minnesota", "St. Paul"},
            {"Mississippi", "Jackson"},
            {"Missouri", "Jefferson City"},
            {"Montana", "Helena"},
            {"Nebraska", "Lincoln"},
            {"Nevada", "Carson City"},
            {"New Hampshire", "Concord"},
            {"New Jersey", "Trenton"},
            {"New Mexico", "Santa Fe"},
            {"New York", "Albany"},
            {"North Carolina", "Raleigh"},
            {"North Dakota", "Bismarck"},
            {"Ohio", "Columbus"},
            {"Oklahoma", "Oklahoma City"},
            {"Oregon", "Salem"},
            {"Pennsylvania", "Harrisburg"},
            {"Rhode Island", "Providence"},
            {"South Carolina", "Columbia"},
            {"South Dakota", "Pierre"},
            {"Tennessee", "Nashville"},
            {"Texas", "Austin"},
            {"Utah", "Salt Lake City"},
            {"Vermont", "Montpelier"},
            {"Virginia", "Richmond"},
            {"Washington", "Olympia"},
            {"West Virginia", "Charleston"},
            {"Wisconsin", "Madison"},
            {"Wyoming", "Cheyenne"}            
        };
        
        double[] distancesFromChicago = { 752.2, 3015.8, 1753.2, 653.1, 
            2044.0, 1003.6, 891.5, 783.4, 961.4, 716.5, 4246.0, 1698.3, 201.9, 
            183.2, 332.0, 573.2, 349.3, 914.5, 1136.6, 722.5, 983.8, 218.5, 
            401.1, 740.6, 393.5, 1445.1, 517.6, 1941.3, 963.1, 779.9, 1263.2, 
            818.7, 810.5, 833.9, 356.5, 794.2, 2164.4, 658.5, 968.9, 801.4, 
            789.2, 472.0, 1121.0, 1396.8, 949.5, 799.5, 2104.4, 492.0, 147.3, 960.0 };
        

        // create scanner
        Scanner input = new Scanner(System.in);
        
        while (playAgain == 'Y') {
            state = statesAndCapitals[numberOfGuesses][0];
            capital = statesAndCapitals[numberOfGuesses][1];
            chicagoToCapital = distancesFromChicago[numberOfGuesses];
            
            // ask user question
            System.out.print("What is the capitol of " + state + "? ");
            guess = input.nextLine();
            
            if (guess.equalsIgnoreCase(capital)) {
                // if guess is correct
                System.out.println("That is correct! " + capital + " is " + chicagoToCapital + " miles from Chicago");
                correctGuesses++;
                
            } else {
                // if guess is wrong
                System.out.println("Sorry, " + capital + " is the capitol of " + state + " and it is " + chicagoToCapital + " miles from Chicago.");
            }
            
            // increment guess counter
            numberOfGuesses++;
            
            // ask to continue
            System.out.print("Would you like to continue? (Y/N) ");
            String temp = input.nextLine();
            playAgain = Character.toUpperCase(temp.charAt(0));
        }
        
        System.out.println("You guessed " + correctGuesses + " capital(s) correctly");
    }
    
}
