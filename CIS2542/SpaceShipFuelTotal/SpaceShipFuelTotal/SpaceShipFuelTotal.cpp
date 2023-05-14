/*
Name: David White
Class: CIS2542
Instructor: Bradley Sward
File: SpaceShipFuelTotal.cpp
Description:
Calculate the total amount of fuel for a spaceship launch

 */
#include <iostream>

int main()
{
    // mass of spaceship
    int mass = 0;


    // ask user for mass of space ship
    std::cout << "Enter mass of spaceship [-1 to quit]: ";
    std::cin >> mass;

    while (mass != -1) 
    {


        // calculate total amount of fuel

        int totalfuel = mass / 5;
        totalfuel -= 22;

        if (totalfuel > 0) 
        {
            std::cout << "The total mass of fuel required for launch is: " << totalfuel << std::endl;
        }
        else
        {
            std::cout << "The total mass of fuel required for launch is: " << mass << std::endl;
        }
       

        // ask user for mass of space ship
        std::cout << "Enter mass of spaceship [-1 to quit]: ";
        std::cin >> mass;

    }
   

    return 0;
}


