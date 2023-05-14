/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combinetwolists;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author gamer
 */
public class CombineTwoLists {

    /**
    Name: David White
    Class: CIS2571
    Instructor: Barry Speller
    Assignment: Lab ch.11
    File: CombineTwoLists.java
    Description: Prompt the user to enter two lists, each with five integers, and displays their union
     * @param args
     */
    public static void main(String[] args) {
        //create lists
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        
        //create scanner
        Scanner input = new Scanner(System.in);
        
        //ask user for integers in list1
        System.out.print("Enter five integers for list1: ");
        
        //input integers into list1
        for (int i = 0; i < 5; i++) {
            list1.add(input.nextInt());
        }
        
        //ask user for integers in list2
        System.out.print("Enter five integers for list1: ");
        
        //input integers into list2
        for (int j = 0; j < 5; j++) {
            list2.add(input.nextInt());
        }
        
        //show combined list
        System.out.print("The combined list is ");
        
        for (Integer integer : union(list1, list2)) {
            System.out.print(integer + " ");
        }
    }
    //combine list 1 and list2 into list3
    public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2){
        //create list
        ArrayList<Integer> list3 = new ArrayList<>();
        
        //add integers from list1 into list3
        for (Integer integer : list1) {
            list3.add(integer);
        }
        
        //add integer\s from list2 into list3
        for (Integer integer : list2) {
            list3.add(integer);
        }
        
        return list3;
    } 
    
}
