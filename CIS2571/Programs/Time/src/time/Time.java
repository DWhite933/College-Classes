/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package time;


/*
Name: David White
Class: CIS2571
Instructor: Barry Speller
Assignment: Lab ch.10
File: Time.java
Description: Design a class named time to represent the time
 */
public class Time {

    //current hour
    private long hour;
    
    //current minutue
    private long minute;
    
    //current second
    private long second;
    
    //default constructor
    public Time(){
        long totalMiliseconds = System.currentTimeMillis();
        long totalSeconds = totalMiliseconds / 1000;
        second = totalSeconds % 60;
        long totalMinutes = totalSeconds / 60;
        minute = totalMinutes % 60;
        long totalHours = totalMinutes / 60;
        hour = totalHours % 24;
        
    }
    
    //Creates a Time object with a specified elapsed time in miliseconds
    public Time(long elapsedTime){
        long totalMiliseconds = elapsedTime;
        long totalSeconds = totalMiliseconds / 1000;
        this.second = totalSeconds % 60;
        long totalMinutes = totalSeconds / 60;
        this.minute = totalMinutes % 60;
        long totalHours = totalMinutes / 60;
        this.hour = totalHours % 24;
    }
    
    //creates a Time object with the specified hour, minute, and second
    public Time(long hour, long minute, long second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    
    //creates a time object from another time object
    public Time(Time oldTime){
        this.hour = oldTime.hour;
        this.minute = oldTime.minute;
        this.second = oldTime.second;
    }
    
    //returns current hour
    public long getHour(){
        return hour;
    }
    
    //returns current minute
    public long getMinute(){
        return minute;
    }
    
    //returns current second
    public long getSecond(){
        return second;
    }
    
    //sets new time using sepcified elapsed time
    public void setTime(long elapsedTime){
        long totalMiliseconds = elapsedTime;
        long totalSeconds = totalMiliseconds / 1000;
        second = totalSeconds % 60;
        long totalMinutes = totalSeconds / 60;
        minute = totalMinutes % 60;
        long totalHours = totalMinutes / 60;
        hour = totalHours % 24;
    }
    
    public static void main(String[] args) {
        Time time1 = new Time();
        Time time2 = new Time(555550000);
        Time time3 = new Time(10, 25, 35);
        
        System.out.println("Time1 is: " + time1.hour + ":" + time1.minute + ":" + time1.second);
        System.out.println("Time2 is: " + time2.hour + ":" + time2.minute + ":" + time2.second);
        System.out.println("Before setTime, Time3 is: " + time3.hour + ":" + time3.minute + ":" + time3.second);
        time3.setTime((long)(Math.random() * 77142857));
        System.out.println("After setTime, Time3 is: " + time3.hour + ":" + time3.minute + ":" + time3.second);
        Time time4 = new Time(time3);
        System.out.println("Time4 is: " + time4.hour + ":" + time4.minute + ":" + time4.second);
 
    }
    
}