package chapter30;

/*
Name: David White
Class: CIS2572
Instructor:  Mohammad Morovati
Assignment: Programming exercise 30.17
File: Assignment13.java
Description:
Rewrite Programming Exercise 21.4 using streams

Write a program that prompts te user to enter a text file
name and displays the number of vowels and consonants in
the file. Use a set to store the vowels A,E,I,O, and U.

 */

import java.util.*;
import java.io.*;


public class Assignment13 {

    public static void main(String[] args) {

        // check for correct usage
        if (args.length != 1){
            System.out.println("Usage: java Assignment14 filename.txt");
            System.exit(1);
        }

        File file = new File(args[0]);

        // check if file exists
        if (!file.exists()){
            System.out.println(file.getName() + " does not exist.");
            System.exit(2);
        }

        // check if file is correct format
        if (!file.isFile()){
            System.out.println(file.getName() + " is not a File");
            System.exit(3);
        }

        Set<Character> vowels = new HashSet<>(Arrays.asList('A','E','I','O','U'));

        try (
                Scanner input = new Scanner(file)
        ){
            int vowelCount = 0;
            int consonantCount = 0;

            while (input.hasNext()){
                String s = input.nextLine();
                s = s.toUpperCase();

                vowelCount += s.chars().filter(Character::isLetter).filter(ch -> vowels.contains((char)ch)).count();
                consonantCount += s.chars().filter(Character::isLetter).filter(ch -> !vowels.contains((char)ch)).count();
            }
            System.out.println("Number of vowels: " + vowelCount);
            System.out.println("Number of Consonants: " + consonantCount);

        }catch(Exception e){
            System.out.println("Something went wrong. Please try again");
            System.exit(4);
        }


    }

    }



