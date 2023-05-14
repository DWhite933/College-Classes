/*
Name: David White
Class: CIS2541
Instructor: Louis Christakes
Chapter: 6
Problem: 1
Page: 372
File: Markup.cpp
Description:
Write a program that asks the user to enter an item's wholesale cost
and its markup percentange. It should then display the item;s retail price.
For Example:
If an item's wholesale cost is $5.00 and its markup percentage is 100%,
then the items retail price is $10.00

If an item's wholesale cost is $5.00 and its markup percentage is 50%,
then the item's retail price is $7.50

The program should hava function named calculateRetail that recieves
the wholesale cost and the markup percenatage as arguments and returns
retail price of the item
 */

#include <iostream>
#include <iomanip>

using namespace std;

// Function prototype
double calculateRetail(double, double);

int main()
{
	double wholesaleCost, // cost to store
		markupPercentage,
		retailPrice; // cost to customer

	// ask user for wholesale cost
	cout << "Enter the wholesale cost: $";
	cin >> wholesaleCost;

	// input validaiton
	if (wholesaleCost < 0.0)
	{
		cout << "Please enter a positive number" << endl;
		cout << "Enter the wholesale cost: $";
		cin >> wholesaleCost;
	}

	// ask user for markup percentage
	cout << "Enter markup percentage (as a %): ";
	cin >> markupPercentage;

	// input validaiton
	if (markupPercentage < 0.0)
	{
		cout << "Please enter a positive number" << endl;
		cout << "Enter markup percentage (as a %): ";
		cin >> markupPercentage;
	}

	// set markupPercentage to percentage
	markupPercentage /= 100;

	// calculate retail price
	retailPrice = calculateRetail(wholesaleCost, markupPercentage);

	// show user info
	cout << setprecision(2) << fixed;
	cout << "The item's retail price is: $" << retailPrice;
}

// this function calculates retail price of an item when givin the wholesale cost and the markup percentage
double calculateRetail(double wholesaleCost, double markupPercentage) {
	return (wholesaleCost * markupPercentage) + wholesaleCost;
}

/*
Enter the wholesale cost: $15
Enter markup percentage (as a %): 34
The item's retail price is: $20.10
C:\Users\gamer\Desktop\College Classes\C++ Programming CIS2541\Programs\Markup\Debug\Markup.exe (process 13564) exited with code 0.
Press any key to close this window . . .

Enter the wholesale cost: $88
Enter markup percentage (as a %): 22
The item's retail price is: $107.36
C:\Users\gamer\Desktop\College Classes\C++ Programming CIS2541\Programs\Markup\Debug\Markup.exe (process 8412) exited with code 0.
Press any key to close this window . . .

*/