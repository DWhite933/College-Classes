/*
Name: David White
Class: CIS2541
Instructor: Louis Christakes
Chapter: 8
Problem: 1
Page: 499
File: ChargeAccountValidation.cpp
Description:
Write a program that lets the user enter a charge account number.

The list of numbers should be initialized in a single-dimensional
array. A simple linear search should be used to locate the number
entered by the user. If the user enters a number that is in the
array, the program should display a message saying the numnber is
valid. If the user enters a number that is not in the array,
the program should display a message indicating the number
is invalid

 */

#include <iostream>
#include <iomanip>
using namespace std;

// function prototypes
int linearSearch(const int[], int, int);

int main()
{
	// size of array
	const int SIZE = 18;

	// valid account numbers
	int validNumbers[SIZE] = { 5658845,  4520125, 7895122, 8777541, 8451277, 1302850,
							  8080152, 4562555, 5552012, 5050552, 7825877, 1250255,
							  1005231, 6545231, 3852085, 7576651, 7881200, 4581002 };

	int accountNumber;

	// ask user for account number
	cout << "Enter Account Number: ";
	cin >> accountNumber;

	// input validaiton
	while (accountNumber < 0) {
		cout << "Please enter a postive number" << endl;
		cout << "Enter Account Number: ";
		cin >> accountNumber;
	}

	// check if number is valid
	if (linearSearch(validNumbers, SIZE, accountNumber) > 1)
	{
		cout << "This is a valid account number." << endl;
	}
	else
		cout << "This is not a valid account number" << endl;
}

int linearSearch(const int array[], int size, int value)
{
	int index = 0; // subscript
	int position = -1; // record position of search value
	bool found = false; // flag to indicat if the falue was found

	while (index < size && !found) {
		if (array[index] == value) { // if the value is found
			found = true;
			position = index;
		}
		index++; // go to nex element
	}
	return position;
}

/*
Enter Account Number: 123456
This is not a valid account number

C:\Users\gamer\Desktop\College Classes\C++ Programming CIS2541\Programs\ChargeAccountValidation\Debug\ChargeAccountValidation.exe (process 26720) exited with code 0.
Press any key to close this window . . .

Enter Account Number: 1005231
This is a valid account number.

C:\Users\gamer\Desktop\College Classes\C++ Programming CIS2541\Programs\ChargeAccountValidation\Debug\ChargeAccountValidation.exe (process 28172) exited with code 0.
Press any key to close this window . . .

*/