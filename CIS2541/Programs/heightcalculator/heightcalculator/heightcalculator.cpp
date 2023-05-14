/*
Name: David White
Class: CIS2541
Instructor: Louis Christakes
Chapter: 2
Problem: N/A
Page: N/A
File: heightcalculator.cpp
Description: Write a program that takes a person’s height in inches and converts it to feet and inches.
 */


#include <iostream>

using namespace std;

int main()
{
    // declare variables
	int heightInInches, totalinch, totalfeet;

	// ask user for height
	cout << "How tall are you in inches? ";
	cin >> heightInInches;

	// do calulations
	totalfeet = heightInInches / 12;
	totalinch = heightInInches % 12;

	// display info
	cout << "You are " << totalfeet << "\'" << totalinch << "\"";

	return 0;


}

/*How tall are you in inches? 67
You are 5'7"
C:\Users\gamer\Desktop\College Classes\C++ Programming CIS2541\heightcalculator\Debug\heightcalculator.exe (process 11872) exited with code 0.
Press any key to close this window . . .
*/