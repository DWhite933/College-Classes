/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executiontime;

import java.util.Arrays;
import java.util.Scanner;

/*
 Name: David White
 Class: CIS2571
 Instructor: Barry Speller
 Assignment: Lab ch.7
 File: ExecutionTime.java
 Description: Compare the execution time of a linear search to the execution time of a binary search
 */
public class ExecutionTime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // declare variables
        int searchKey;
        
        //create scanner
        Scanner input = new Scanner(System.in);
        
        // create array
        int[] randomIntegers = new int[500000];
        
        // set array to random ints between 0 and 499,999
        for (int i = 0; i < randomIntegers.length; i++) {
           randomIntegers[i] = (int)(Math.random() * 500000);
        }
        
        //ask user for input
        System.out.print("Enter a search key: ");
        searchKey = input.nextInt();
        
        // new line for clarity
        System.out.println("");
        
        // use linear search
        linSearch(randomIntegers, searchKey);
        
        //new line for clarity
        System.out.println("");
        
        //use binary search
        binSearch(randomIntegers, searchKey);
    }
    
    public static void linSearch(int[] list, int key){
        System.out.println("Searching...");
        
        // start timer
        long startTime = System.currentTimeMillis();
        
        // find index of search key
        int index = searchLinear(list, key);
        
        // end timer
        long endTime = System.currentTimeMillis();
        
        // calculate time taken
        long executionTime = endTime - startTime;
        
        // display info
        if (index < 0)
            System.out.println("The key, " + key + ", was not found");
        else
            System.out.println("The key value, " + key + ", was found at index: " + index);
        
        System.out.println("Linear search execution time: " + executionTime + " miliseconds");
    }
    
    public static void binSearch(int[] list, int key){
         // sort the array
        Arrays.parallelSort(list);
 
        System.out.println("Searching...");
        
        // start timer
        long startTime = System.currentTimeMillis();
        
        // find index of search key
        int index = searchBinary(list, key);
        
        // end timer
        long endTime = System.currentTimeMillis();
        
        // calculate time take
        long executionTime = endTime - startTime;
        
        // disaplay info
        if (index < 0)
            System.out.println("The key, " + key + ", was not found");
        else
            System.out.println("The key value, " + key + ", was found at index: " + index);
        
        System.out.println("Binary search execution time: " + executionTime + " miliseconds");
    }
    
    public static int searchLinear(int[] list, int key) {
        // use linear search to find a key in the list
        for (int i = 0; i < list.length; i++) {
            if (key == list[i])
                return i;
        }
        return -1;
    }
    
    public static int searchBinary(int[] list, int key){
        // use binary search to find a key in the list
        int low = 0;
        int high = list.length - 1;
        
        while (high >= low) {            
            int mid = (low + high) / 2;
            if (key < list[mid])
                high = mid - 1;
            else if (key == list[mid])
                return mid;
            else 
                low = mid + 1;
        }
        return -low - 1; // Now high < low, key not found
    }
}
