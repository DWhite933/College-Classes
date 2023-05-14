/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package babynamepopularityranking;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author gamer
 */
public class BabyNamePopularityRanking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create scanner
        Scanner input = new Scanner(System.in);
        
        //ArrayList with all the female names
        ArrayList<BabyName> girlNames = getFemaleNames();
        
        //ArrayList with all the male names
        ArrayList<BabyName> boyNames = getMaleNames();
        
        //Menu control variable
        int menuNumber = 0;
        
        
        while (menuNumber != 3) {            
            //display menu
            System.out.println("1. Lookup a baby name.");
            System.out.println("2. List a baby name by rank.");
            System.out.println("3. Exit program");
            System.out.println(""); //blank line for clarity
            
            //ask user for choice
            System.out.print("Your Choice: ");
            menuNumber = input.nextInt();
            
            //menu validation
            if (menuNumber == 1) {
                babyNameSearch(boyNames, girlNames);
            } else if (menuNumber == 2) {
                babyNameRankings(boyNames, girlNames);
            } else if (menuNumber != 3){
                System.out.println("Please enter 1, 2 or 3."); // didn't use a switch here because it kept show this even if 1 or 2 was picked
                System.out.println("");//extra line for clarity
            }
        }
    }
    
    //add female names to girlNames list
    public static ArrayList getFemaleNames(){
        //create array lists
            ArrayList<BabyName> girlNames = new ArrayList<>();
            
            //Create file instance
            java.io.File namesFile = new java.io.File("babynamesrankings.txt");

            //check if file exists
            if (!namesFile.exists())
                System.out.println("babynamesrankings.txt does not exist");
            
            //create file scanner
            Scanner inputFile = null;
            try {
                inputFile = new Scanner(namesFile);
                //create BabyName objects from file
                while (inputFile.hasNext()) {
                    String gender = inputFile.next();
                    int ranking = inputFile.nextInt();
                    String name = inputFile.next();
                    int numberOfBirths = inputFile.nextInt();
                    BabyName name1 = new BabyName(name, gender, ranking, numberOfBirths);
                    if ("Female".equals(gender)) {
                        girlNames.add(name1);
                    }
                    //close file
                    inputFile.close();
                }
            } catch (FileNotFoundException ex) {
                System.out.println("Data file was not found");
            }
            
            
            
            return(girlNames);
    }
    
    //add male names to boyNames list
    public static ArrayList getMaleNames(){
        //create array lists
            ArrayList<BabyName> boyNames = new ArrayList<>();
            
            //Create file instance
            java.io.File namesFile = new java.io.File("babynamesrankings.txt");

            //check if file exists
            if (!namesFile.exists())
                System.out.println("babynamesrankings.txt does not exist");
            
            //create file scanner
            Scanner inputFile = null;
            try {
                inputFile = new Scanner(namesFile);
                //create BabyName objects from file
                while (inputFile.hasNext()) {
                    String gender = inputFile.next();
                    int ranking = inputFile.nextInt();
                    String name = inputFile.next();
                    int numberOfBirths = inputFile.nextInt();
                    BabyName name1 = new BabyName(name, gender, ranking, numberOfBirths);
                    if ("Male".equals(gender)) {
                        boyNames.add(name1);
                    } 
                    //close file
                    inputFile.close();
                }
            } catch (FileNotFoundException ex) {
                System.out.println("Data file was not found");
            }
            
            
            
            return (boyNames);
    }
    
    //Look up a baby name
    public static void babyNameSearch(ArrayList<BabyName> boyNames, ArrayList<BabyName> girlNames){
        //create scanner
        Scanner input = new Scanner(System.in);
        
        //is true if name is found
        boolean nameFound = false;
        //ask user for name
        System.out.print("Please enter a Name: ");
        String name = input.next();
        System.out.println("Searching...");
        
        for (BabyName girlName : girlNames) {
            if (girlName.getName().equalsIgnoreCase(name)) {
                System.out.println(girlName);
                nameFound = true;
            }
        }
        
        for (BabyName boyName : boyNames) {
            if (boyName.getName().equalsIgnoreCase(name))
               System.out.println(boyName.toString());
                nameFound = true;
            
        }
        if (nameFound == false){
            System.out.println("Name not found.");
        }
    }
    //look up name by rank
    public static void babyNameRankings(ArrayList<BabyName> boyNames, ArrayList<BabyName> girlNames){
        //create scanner
        Scanner input = new Scanner(System.in);
        
        //ask user for rank
        System.out.print("Please enter a Rank: ");
        int rank = input.nextInt();
        
        //blank line for clarity
        System.out.println("");
        //input validation
        if (rank > 0 || rank < 1000) {
            //show girl rank
            for (BabyName girlName : girlNames) {
                if (girlName.getRank() == rank) {
                    System.out.println(girlName);
                }
            }
            //show boy rank
            for (BabyName boyName : boyNames) {
                if (boyName.getRank() == rank) {
                    System.out.println(boyName);
                }
            }
        }
        //input validation
        if (rank > 1000) {
            System.out.println("Only top 1,000 names are available.");
            //blank line for clarity
            System.out.println("");
        }
        if (rank <= 0) {
            System.out.println("Please enter a positive number.");
            //blank line for clarity
            System.out.println("");
        }
    }
}
