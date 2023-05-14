/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fan;

/*
Name: David White
Class: CIS2571
Instructor: Barry Speller
Assignment: Lab ch.9
File: Fan.java
Description: Design a calss named Fan to represent a fan.
 */
public class Fan {
    // constatns to denote fan speed
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    
    // speed of the fan
    private int speed = SLOW;
    
    // indicates whether fan is on off
    private boolean on = false;
    
    // radius of the fan
    private double radius = 5;
    
    // color of the fan
    String color = "blue";
    
    // constructs default fan object
    public Fan() {
        
    }
    
    // turns fan on
    public void turnOn() {
        on = true;
    }
    
    // turns fan off
    public void turnOff(){
        on = false;
    }
    
    // sets speed of fan
    public void setSpeed(int newSpeed){
        speed = newSpeed;
    }
    
    // set the radius of the fan
    public void setRadius(double newRadius){
        radius = newRadius;
    }
    
    // set the color of the fan
    public void setColor(String newColor){
        color = newColor;
    }
    
    // checks whether or not fan is on
    public boolean isOn(){
        return on;
    }
    
    // returns speed of the fan
    public int getSpeed(){
        return speed;
    }
    
    // returns the radius of the fan
    public double getRadius(){
        return radius;
    }
    
    // returns the color of the fan
    public String getColor(){
        return color;
    }
    
    
    // returns a string description for the fan
    public String toString(){
        String fanDescription = null;
        String fanSpeed = null;
        String fanRadius = String.valueOf(getRadius());
        String fanColor = getColor();
        
        switch (getSpeed()){
            case 1: fanSpeed = "Slow";
            case 2: fanSpeed = "Medium";
            case 3: fanSpeed = "Fast";
        }
        
        if (isOn()) 
            fanDescription = "Speed: " + fanSpeed + ", Color: " + fanColor + ", Radius: " + fanRadius;
        else 
            fanDescription = "Color: " + fanColor + ", Radius: " + fanRadius + ", fan is off";
            
        return fanDescription;
    }
    
    public static void main(String[] args) {
        Fan yellowFan = new Fan();
        yellowFan.turnOn();
        yellowFan.setRadius(10);
        yellowFan.setColor("Yellow");
        yellowFan.setSpeed(3);
        
        Fan blueFan= new Fan();
        blueFan.setSpeed(2);
        blueFan.setRadius(5);
        blueFan.setColor("Blue");
        
        System.out.println(yellowFan.toString());
        System.out.println(blueFan.toString());
    }
}
