/*
 * Name: 
 * Date:
 * Assignment: HomeworkCh11
 *
 * Description: Circle
 */
package homeworkch11;

/**
 * Circle class extends GeometricObject
 * 
 * @author 
 */
public class Circle 
    extends GeometricObject {
    
    private double radius = 1.0;

    /**
     * No argument constructor
     */
    public Circle() {
    }

    /**
     * Constructs a Circle of specified radius, color and filled state
     * 
     * @param radius radius of the Circle
     * @param color color of the Circle
     * @param filled filled state of the Circle
     */
    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        setColor(color);
        setFilled(filled);
    }

    /**
     * Gets the Circle's radius
     * @return radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the Circle's radius
     * @param radius 
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    /**
     * Gets Circle's area
     * @return area of Circle
     */
    public double getArea() {
        return radius * radius * Math.PI;
    }
    
    /**
     * Gets Circle's diameter
     * @return diameter of Circle
     */
    public double getDiameter() {
        return 2.0 * radius;
    }
    
    /**
     * Get Circle's perimeter
     * @return perimeter of Circle
     */
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    /**
     * Circle's toString method
     * @return 
     */
    @Override
    public String toString() {
        return "Circle:\n"  + super.toString() + "\nradius: " + radius;
    }
    
    
    
}
