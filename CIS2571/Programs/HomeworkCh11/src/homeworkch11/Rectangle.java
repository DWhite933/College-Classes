/*
 * Name: 
 * Date:
 * Assignment: HomeworkCh11
 *
 * Description: Rectangle
 */
package homeworkch11;

/**
 * Rectangle Class extends GeometricObject
 * 
 * @author 
 */
public class Rectangle 
    extends GeometricObject {
    
    private double width = 1.0;
    private double height = 1.0;

    /**
     * No argument constructor
     */
    public Rectangle() {
    }

    /**
     * Constructs a Rectangle of specified width, height, color and filled state
     * 
     * @param width width of the Rectangle
     * @param height height of the Rectangle
     * @param color color of the Rectangle
     * @param filled filled state of the Rectangle
     */
    public Rectangle(double width, double height, String color, boolean filled) {
        this.width = width;
        this.height = height;
        setColor(color);
        setFilled(filled);
    }

    /**
     * Gets the Rectangle's width
     * @return width of Rectangle
     */
    public double getWidth() {
        return width;
    }

    /**
     * Gets the Rectangle's height
     * @return height of Rectangle
     */
    public double getHeight() {
        return height;
    }
    
    /**
     * Gets the area of the Rectangle
     * @return area of Rectangle
     */
    public double getArea() {
        return width * height;
    }
    
    /**
     * Gets the perimeter of the Rectangle
     * @return perimeter of Rectangle
     */
    public double getPerimeter() {
        return 2 * (width + height);
    }

    /**
     * Rectangle's toString method
     * @return 
     */
    @Override
    public String toString() {
        return "Rectangle:\n" + super.toString() + "\nwidth: " + width + ", height: " + height;
    }
    
}
