/*
Name: David White
Class: CIS2541
Instructor: Louis Christakes
Chapter: 2
Problem: 18
Page: 84
File: energydrinkconsumption.cpp
Description: A soft drink company recently surveyed 16,500 of its customers and found that approximately 15% of those surveyed purchased one or more energy drinks per week.
Of those customers who purchase energy drinks, approximately 58% of them prefer citrus- flavored energy drinks.
Write a program that displays:
The approximate number of customers in the survey who purchase one or more energy drinks per week
the approximate number of customers in the survey who prefer citrus-flavored energy drinks.
 */

#include <iostream>

using namespace std;

int main()
{
	// assign and declare variables
	int numPeople = 16500, numDrink, numCitrus;

	// calculate number of people who purchase energy drinks
	numDrink = numPeople * .15;

	// calculate number of people who prefer citrus
	numCitrus = numDrink * .58;

	// display info
	cout << "Number of people who purchase one or more energy drinks per week: " << numDrink << endl;
	cout << "Number of people who prefer citrus-flavored energy drinks: " << numCitrus << endl;

	return 0;
}
/*
Number of people who purchase one or more energy drinks per week: 2475
Number of people who prefer citrus-flavored energy drinks: 1435

C:\Users\gamer\Desktop\College Classes\C++ Programming CIS2541\Programs\energydrinkconsuption\Debug\energydrinkconsuption.exe (process 11824) exited with code 0.
Press any key to close this window . . .
*/