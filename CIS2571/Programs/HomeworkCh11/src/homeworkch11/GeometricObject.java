/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeworkch11;

import java.util.Date;

/**
 *
 * @author Barry
 */
public class GeometricObject {
    private String color = "white";
    private boolean filled;
    private Date dateCreated;

    /** Construct a default GeometricObject */
    public GeometricObject() {
        dateCreated = new Date();
    }
    
    /**
     * Construct a GeometricObject with the specified color
     * and filled value
     * @param color GeometricObject's color
     * @param filled whether shape is filled
     */
    public GeometricObject(String color, boolean filled) {
        dateCreated = new Date();
        this.color = color;
        this.filled = filled;
    }

    /**
     * Gets the GeometricObject's color
     * @return the object's color
     */
    public String getColor() {
        return color;
    }

    /**
     * Gets the GeometricObject's filled state
     * @return true if the object is filled, false if the object isn't filled
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * Gets the GeometricObject's date of creation
     * @return creation date
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Sets the GeometricObject's color
     * @param color GeometricObject's new color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Sets the GeometricObject's filled state
     * @param filled true or false
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "Created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }
    
}
