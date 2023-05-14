package chapter27;

/*

Name: David White
Class: CIS2572
Instructor:  Mohammad Morovati
Assignment: Programming exercise 27.13
File: main.java
Description:
Design a class named Date that meets the following requirements:
Three data fields: Year, and day for representing a date
A constructor that constructs a date with specified year, month, and day
Override the equals method
Override the hashCode method

 */


public class Main {

    public static void main(String[] args) {
	    Date today = new Date();
        today.setDay(25);
        today.setMonth(10);
        today.setYear(2021);

        Date birthDate = new Date(7,6,1999);

        Date sameDay = new Date(10,25,2021);

        System.out.println("Today is: " + today);
        System.out.println("My birth day is: " + birthDate);
        System.out.println("Is today equal to sameDay? " + today.equals(sameDay));
        System.out.println("Is today equal to birthDate? " + today.equals(birthDate));
        System.out.println("The hash code for birthDate is: " + birthDate.hashCode());
        System.out.println("The hash code for today is: " + today.hashCode());

    }
}
