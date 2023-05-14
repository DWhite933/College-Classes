/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stopwatchtest;

/*
Name: David White
Class: CIS2571
Instructor: Barry Speller
Assignment: Homework ch.9
File: StopWatchTest.java
Description: Design a class named StopWatch to represent a stopwatch and use it to calculate the execution time of selection sort
 */

public class StopWatchTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create array
        int[] randomIntegers = new int[100000];
        
        // set array to random ints
        for (int i = 0; i < randomIntegers.length; i++) {
           randomIntegers[i] = (int)(Math.random() * 100000);
        }
        
        // notify user that array has been created
        System.out.println("Array Created...");
        
        //notify user that sort is beginning
        System.out.println("Beginning Sort...");
        
        
        // instaniate stopwatch object
        StopWatch stopwatch = new StopWatch();
        
        // start stopwatch
        stopwatch.start();
        
        // sort array
        java.util.Arrays.sort(randomIntegers);
        
        // stop stopwatch
        stopwatch.stop();
        
        // print elapsed time
        System.out.println("Execution Time: " + stopwatch.getElapsedTime() + " miliseconds");
    }
    
}
