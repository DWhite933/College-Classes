/*
 * Name: 
 * Date:
 * Assignment: HomeworkCh11
 *
 * Description:
 */
package homeworkch11;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author 
 */
public class HomeworkCh11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //declare variables
        double side1;
        double side2;
        double side3;
        String color;
        boolean filled;
        
        //create scannner
        Scanner input = new Scanner(System.in);
        
        //ask user for variables
        System.out.print("Enter length of side 1: ");
        side1 = input.nextDouble();
        System.out.print("Enter length of side 2: ");
        side2 = input.nextDouble();
        System.out.print("Enter length of side 3: ");
        side3 = input.nextDouble();
        System.out.print("Enter color of triangle: ");
        color = input.next();
        System.out.print("Is the triangle filled? (true/false) ");
        filled = input.nextBoolean();
        
        //create triangle with provided variables 
        Triangle triangle1 = new Triangle(side1, side2, side3, color, filled);
        
        //show user info about triangle
        System.out.println(triangle1.toString());
        System.out.println("Perimeter: " + triangle1.getPerimeter() + " Area: " + triangle1.getArea());
        
        System.out.println(); // blank line for clarity

        //create array list
        ArrayList<Object> list = new ArrayList<>();
        
        //add previously made triangle
        list.add(triangle1);
        
        //add default triangle
        list.add(new Triangle());
        
        //add string object
        list.add(new StringBuffer("Have a nice Day!"));
        
        //add default circle
        list.add(new Circle());
        
        //add random circle 
        list.add(new Circle((Math.random() * 10), "green", true));
        
        //add date object
        list.add(new Date());
        
        //add default rectangle
        list.add(new Rectangle());
        
        //add random rectangle
        list.add(new Rectangle((Math.random() * 10), (Math.random() * 10), "red", false));
        
        //display all elements
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
            
            //show perimeter
            if (list.get(i) instanceof Circle)
                System.out.println("Perimeter: " + ((Circle)list.get(i)).getPerimeter());
            
            if (list.get(i) instanceof Rectangle)
                System.out.println("Perimeter: " + ((Rectangle)list.get(i)).getPerimeter());
            
            if (list.get(i) instanceof Triangle)
                System.out.println("Perimeter: " + ((Triangle)list.get(i)).getPerimeter());
            
            System.out.println(); //blank line for clarity
        }
        
    }
    
}
