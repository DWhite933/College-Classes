/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circle2d;

/*
Name: David White
Class: CIS2571
Instructor: Barry Speller
Assignment: HW ch.10
File: Circle2D.java
Description: Design and implement a 2D circle class called Circle2D
 */
public class Circle2D {
    //x coordinate of the center of the circle
    double x = 0;
    
    //y coordinate of the center of the circle
    double y = 0;
    
    //radius of the circle
    double radius = 0;
    
    //default construtor
    public Circle2D() {
        this(0, 0, 1);
    }
    
    //create a circle with specified x, y and radius
    public Circle2D(double x, double y, double radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    // return x coordinate of the center of the circle
    public double getX(){
        return x;
    }
    
    //return y cooridinate of the center of the circle
    public double getY(){
        return y;
    }
    
    //return radius of the circle
    public double getRadius(){
        return radius;
    }
    
    //return area of the circle
    public double getArea(){
        double area = Math.PI * Math.PI * radius;
        return area;
    }
    
    //return perimeter of the circle
    public double getPerimeter(){
        double perimeter = 2 * Math.PI * radius;
        return perimeter;
    }
    
    //returns true if specified point (x,y) is inside this circle
    public boolean contains(double x, double y){
        return Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2)) < radius;
    }
    
    //returns true if specified circle is inside this circle
    public boolean contains(Circle2D circle){
        return Math.sqrt(Math.pow(circle.getX() - x, 2) + Math.pow(circle.getY() - y, 2)) <= Math.abs(radius - circle.getRadius());
    }
    
    //returns true if specified circle overlaps with this circle
    public boolean overlaps(Circle2D circle){
        return Math.sqrt(Math.pow(circle.getX() - x, 2) + Math.pow(circle.getY() - y, 2)) <= radius + circle.getRadius();
    }
    
    public static void main(String[] args) {
        Circle2D c1 = new Circle2D(2, 2, 5.5);
        System.out.println("Area of c1 is: " + c1.getArea());
        System.out.println("Perimiter of c1 is: " + c1.getPerimeter());
        System.out.println("Is (3,3) in c1? " + c1.contains(3, 3));
        System.out.println("Is c2 inside of c1? " + c1.contains(new Circle2D(4, 5, 10.5)));
        System.out.println("Does c3 overlap c1? " + c1.overlaps(new Circle2D(3,5,2.3)));
    }
}
