/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package babynamepopularityranking;

/*
Name: David White
Class: CIS2571
Instructor: Barry Speller
Assignment: HW ch.12
File: BabyName.java
Description: Design a BabyName class
 */
public class BabyName {
    //name of the baby
    String name;
    
    //gender of the baby
    String gender;
    
    //popularity ranking of name
    int rank;
    
    //number of babies with name
    int numberOfBirths;
    
    //creates a BabyName object with specified arguments

    public BabyName(String name, String gender, int rank, int numberOfBirths) {
        this.name = name;
        this.gender = gender;
        this.rank = rank;
        this.numberOfBirths = numberOfBirths;
    }
    
    //returns name of the baby
    public String getName(){
        return name;
    }
    
    //returns gender of the baby
    public String getGender(){
        return gender;
    }
    
    //returns popularity ranking of name
    public int getRank(){
        return rank;
    }
    
    //returns number of babies with name
    public int getNumberOfBirths(){
        return numberOfBirths;
    }
    
    @Override
    public String toString(){
        return ("Name: " + name + " Gender: " + gender + " Rank: " + rank + " Number of Births: " + numberOfBirths);
    }
    
}
