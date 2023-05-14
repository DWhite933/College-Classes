package chapter20;

/*
Name: David White
Class: CIS2572
Instructor:  Mohammad Morovati
Assignment: Programming exercise 20.21
File: GeometricObjectComparator.java
Description: Comparator for Geometric Object class. Copied directly from Listing 20.4
 */

import java.util.Comparator;

public class GeometricObjectComparator
        implements Comparator<GeometricObject>, java.io.Serializable {
    public int compare(GeometricObject o1, GeometricObject o2) {
        double area1 = o1.getArea();
        double area2 = o2.getArea();

        if (area1 < area2)
            return -1;
        else if (area1 == area2)
            return 0;
        else
            return 1;
    }
}