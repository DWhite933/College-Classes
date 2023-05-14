/*
Name: David White
Class: CIS2541
Instructor: Louis Christakes
Chapter: 4
Problem: 15
Page: 225
File: Shipping Charges.cpp
Description:
The Fast Freight shipping co. chares the following rates per 500 miles
	2kg or less: $1.10
	>2kg and <6kg: $2.20
	>6kg and <10kg: $3.70
	>10kg and <20kg: $4.80
Write a program that asks for the weight of the package and the distance it is to be shipped,
then displays the charges.
 */



#include <iostream>
#include <iomanip>
#include <math.h>

using namespace std;

int main()
{
	// distance traveled
	double distance;

	// weight of package
	double weight;

	// cost to ship
	double shippingCost;

	// ask user for weight of package
	cout << "Enter the weight of the package in kilograms: ";
	cin >> weight;

	// ask user for distance
	cout << "Enter the distance to be shipped in miles: ";
	cin >> distance;

	// calculate shipping cost
	if (weight <= 0 || weight > 20)
		cout << "Invalad number entered";
	else if (weight < 2)
		shippingCost = 1.1 * ceil(distance / 500);
	else if (weight > 2 && weight < 6)
		shippingCost = 2.2 * ceil(distance / 500);
	else if (weight > 6 && weight < 10)
		shippingCost = 3.7 * ceil(distance / 500);
	else if (weight > 10 && weight < 20)
		shippingCost = 4.8 * ceil(distance / 500);

	// display info
	cout << setprecision(2) << fixed;
	cout << "Shipping distance: " << distance << " miles" << endl;
	cout << "Package weight: " << weight << "kg" << endl;
	cout << "Cost to ship: $" << shippingCost << endl;

}

/*
Enter the weight of the package in kilograms: 8
Enter the distance to be shipped in miles: 2385
Shipping distance: 2385.00 miles
Package weight: 8.00kg
Cost to ship: $18.50

C:\Users\gamer\Desktop\College Classes\C++ Programming CIS2541\Programs\ShippingCharges\Debug\ShippingCharges.exe (process 17908) exited with code 0.
Press any key to close this window . . .

*/

