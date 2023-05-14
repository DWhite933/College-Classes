package chapter20;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Name: David White
Class: CIS2572
Instructor:  Mohammad Morovati
Assignment: Programming exercise 20.21
File: Main.java
Description:
Write a test program that creates an array of 10 GeometricObjects and invokes
this method using the GeometricObjectComparator introduced in Listing 20.4 to
sort the elements. Display the sorted elements.
Additionally, write a program that stores six strings by their last character
 */

public class Main {



    public static void main(String[] args) {
	    // Create array of 10 GeometricObjects
        GeometricObject[] list1 = {new Circle(5), new Rectangle(4, 5),
                new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5),
                new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
                new Circle(6.5), new Rectangle(4, 5)};

        // sort array using GeometricObjectComparator
        selectionSort(list1, new GeometricObjectComparator());

        // Display sorted array
        System.out.println("Sorted Areas: ");
        for (GeometricObject e: list1) {
            System.out.printf("%.3f", e.getArea());
            System.out.println();
        }

        // new line for clarity
        System.out.println();

        // create string array
        List<String> list2 = Arrays.asList("red", "blue", "green", "orange", "yellow", "pink");

        // sort array
        list2.sort(Comparator.comparingInt(s -> s.charAt(s.length() - 1)));

        // display array
        System.out.println("Sorted Colors: ");
        for (String e: list2)
            System.out.println(e);


    }

    // Generic selection sort method
    public static <E> void selectionSort(E[] list, Comparator<? super E> comparator){
        for (int i = 0; i < list.length - 1; i++) {
            E currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if (comparator.compare(currentMin, list[j]) > 0) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            // swap list[i] with list[currentMinIndex] if necessary
            if (currentMinIndex != i){
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }


    }


}
