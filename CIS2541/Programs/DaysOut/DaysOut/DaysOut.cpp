/*
Name: David White
Class: CIS2541
Instructor: Louis Christakes
Chapter: 6
Problem: 13
Page: 376
File: DaysOut.cpp
Description:
Write a program that calculates the average number of days a company's employees are absent
The program should have the following functions:

A function callled by main that asks the user for the number of employees in the company
this value should be returned as an int (The function accepts no args)

A function called by main that accepts one arg: the number of employees in the company
The function should ask the user to enter the number of days each employee missed during
the past year. The total of these days should be returned as an int.

A fuction called by main that takes two arguments: the number of employees in the company
and the total number of days absent for all employees during the year
the function sould return, as a double, the average number of days abesent.
 */

#include <iostream>
#include <iomanip>
using namespace std;

// function prototypes
int askForNumEmployees();
int askForNumDaysOff(int);
double calcAverageDaysOff(int, int);

int main()
{
	int numEmployees, // number of employees
		numDaysOff; // total number of days off taken
	double averageDaysOff; // average number of days off taken

	// ask user for the number of employees
	numEmployees = askForNumEmployees();

	// ask the user for the total number of days off taken
	numDaysOff = askForNumDaysOff(numEmployees);

	// calculate the average number of days off
	averageDaysOff = calcAverageDaysOff(numEmployees, numDaysOff);

	// show user info
	cout << setprecision(2) << fixed;
	cout << "Your employees take an average of " << averageDaysOff << " days off." << endl;

}

// this function asks the user for the number of employees
int askForNumEmployees() {
	int empNumber;
	cout << "Enter the number of employees: ";
	cin >> empNumber;

	if (empNumber < 1)
	{
		cout << "Please enter a positive number." << endl;
		cout << "Enter the number of employees: ";
		cin >> empNumber;
	}

	return empNumber;
}

// this function asks for the number of days off
int askForNumDaysOff(int employees) {
	int daysOff,
		totalDaysOff = 0;

	for (int i = 0; i < employees; i++)
	{
		cout << "Enter the number of days off taken by employee #" << (i + 1) << ": ";
		cin >> daysOff;

		if (daysOff < 0)
		{
			cout << "Please enter a positve number" << endl;
			cout << "Enter the nuber of days off taken by employee #" << (i + 1) << ": ";
			cin >> daysOff;
		}

		totalDaysOff += daysOff;


	}

	return totalDaysOff;
}

// this function calculates the average number of days off
double calcAverageDaysOff(int employees, int daysOff) {
	double employeeDouble = employees,
		daysOffDouble = daysOff;

	return daysOffDouble / employeeDouble;
}

/*
Enter the number of employees: -11
Please enter a positive number.
Enter the number of employees: 11
Enter the number of days off taken by employee #1: -13
Please enter a positve number
Enter the nuber of days off taken by employee #1: 13
Enter the number of days off taken by employee #2: 2
Enter the number of days off taken by employee #3: 4
Enter the number of days off taken by employee #4: 6
Enter the number of days off taken by employee #5: 14
Enter the number of days off taken by employee #6: 9
Enter the number of days off taken by employee #7: 12
Enter the number of days off taken by employee #8: 3
Enter the number of days off taken by employee #9: 16
Enter the number of days off taken by employee #10: 19
Enter the number of days off taken by employee #11: 7
Your employees take an average of 9.55 days off.

C:\Users\gamer\Desktop\College Classes\C++ Programming CIS2541\Programs\DaysOut\Debug\DaysOut.exe (process 20864) exited with code 0.
Press any key to close this window . . .
*/
