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

import java.util.Objects;

public class Date {
    private int day; // day of month
    private int month; // month of year
    private int year;

    /**
     * no arg constructor
     */
    public Date() {
    }


    /**
     * Create a date with specified args
     */
    public Date(int month, int day, int year) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    /**
     * @return day
     */
    public int getDay() {
        return day;
    }

    /**
     * sets day
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * @return month
     */
    public int getMonth() {
        return month;
    }

    /**
     * sets month
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * sets year
     */
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return getDay() == date.getDay() && getMonth() == date.getMonth() && getYear() == date.getYear();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDay(), getMonth(), getYear());
    }

    @Override
    public String toString() {
        return getMonth() + "/" + getDay() + "/" + getYear();
    }
}
