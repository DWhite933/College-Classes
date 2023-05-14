/*
Name: David White
Class: CIS2541
Instructor: Louis Christakes
Chapter: 5
Problem: 11
Page: 299
File: Population.cpp
Description:
Write a program that will predict the size of a population of
organisms. Th program should ask the user for the starting number
of organisms, their average daily population increase (as a percentage)
and the number of days they will multiply. A loop should display the size
of the population for each day

 */


#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
	int startPop, // starting population
		days = 0; // number of days
	double popIncrease = 0.0; // population increase percentage

	// ask user for starting population
	cout << "Enter the starting population: ";
	cin >> startPop;

	// input validation
	while (startPop < 2)
	{
		cout << "Please ente a number greater than 2" << endl;
		cout << "Enter the starting population: ";
		cin >> startPop;
	}

	// ask user for population increase
	cout << "Please enter the population increase (as a %): ";
	cin >> popIncrease;

	// input validation
	while (popIncrease < 0)
	{
		cout << "Please enter a positive number" << endl;
		cout << "Please enter the population increase (as a %): ";
		cin >> popIncrease;
	}

	// ask for number of days
	cout << "Please enter the number of days: ";
	cin >> days;

	// input validiation
	while (days < 1)
	{
		cout << "Please enter a number greater than 1" << endl;
		cout << "Please enter the number of days: ";
		cin >> days;
	}

	// set popincrease to a percentage
	popIncrease /= 100;

	cout << "\n\tPopulation Chart" << endl;
	cout << "=======================================" << endl;
	cout << "Day #" << setw(25) << "Population" << endl;

	for (int i = 0; i < days + 1; i++)
	{
		
		cout << setw(5) << i << setw(22) << startPop << endl;
		startPop += (startPop * popIncrease);
	}
}

/*
Enter the starting population: 1000
Please enter the population increase (as a %): 25
Please enter the number of days: 10

		Population Chart
=======================================
Day #               Population
	1                  1000
	2                  1250
	3                  1562
	4                  1952
	5                  2440
	6                  3050
	7                  3812
	8                  4765
	9                  5956

C:\Users\gamer\Desktop\College Classes\C++ Programming CIS2541\Programs\Population\Debug\Population.exe (process 10924) exited with code 0.
Press any key to close this window . . .
*/
