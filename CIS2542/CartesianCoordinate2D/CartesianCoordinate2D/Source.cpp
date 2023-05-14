/*
Name: David White
Class: CIS2542
Instructor: Bradley Sward
File: CartesianCoordinate2D.cpp
Description:
Develop and thouroughly test a C++ class named CartesianCoordinate2D that has the following functional characteristics:

Private double member variable for x coordinate
Private double member variable for y coordinate
Public default constructor (which initializes both x and y values to 0)
Public constructor (which takes input parameters for both x and y values)
Public get method for x coordinate
Public get method for y coordinate
Public set method for x coordinate
Public set method for y coordinate
Public function that returns the point’s distance from the origin (returns double)
    Square root of ((x squared) plus (y squared))
Public function that returns the mathematical quadrant in which the coordinate lies (returns integer)
    For example: (4, -3) would return the value 4
    For example: (-5, 1) would return the value 2
    If a point is on any axis, return the value 0
Public copy constructor (CartesianCoordinate2D c = b)
Public copy assignment operator (c = b)
Public override of the - operator to subtract CartesianCoordinate2D objects and return their difference (c = a - b)
Public override of the -= operator to subtract a CartesianCoordinate2D object from the current object (c -= b)
Public override of the << operator to display coordinate information to the screen...  For example (6.12, 2.32) on the screen
Public override of the > operator which determines if a point is closer to the origin than another
    You can use your implementation of point 9 above to do the heavy liftin
 */

#include <iostream>
#include <iomanip>
#include <cmath>
#include "CartesianCoordinate2D.h"

int main()
{
    CartesianCoordinate2D a;
    CartesianCoordinate2D b(9.0, 6.0);
    CartesianCoordinate2D c(3.0, 4.0);

    CartesianCoordinate2D d = b;
    d = b - c;

    std::cout << a << d << c << std::endl;
    
    if (d > c)
        std::cout << "D";
    else
        std::cout << "C";
    system("PAUSE");
    return 0;
}
