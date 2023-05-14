/*
Name: David White
Class: CIS2541
Instructor: Louis Christakes
Chapter: 2
Problem: 8
Page: 82
File: totalPurchase.cpp
Description: Write a program that coputes the tax ant tip on a restaurant bill for $88.67.
 */

#include <iostream>

using namespace std;

int main()
{
	// assign and declare variables
	double subtotal, tax, total;
	double item1Cost = 15.95, item2Cost = 24.95, item3Cost = 6.95, item4Cost = 12.95, item5Cost = 3.95;
	const double TAX_PERCENTAGE = .07;

	// calculate subtotal
	subtotal = item1Cost + item2Cost + item3Cost + item4Cost + item5Cost;

	// calculate tax
	tax = subtotal * TAX_PERCENTAGE;

	// calculate total
	total = subtotal + tax;

	// display info
	cout << "Item 1: $" << item1Cost << endl;
	cout << "Item 2: $" << item2Cost << endl;
	cout << "Item 3: $" << item3Cost << endl;
	cout << "Item 4: $" << item4Cost << endl;
	cout << "Item 5: $" << item5Cost << endl;
	cout << "Subtotal: $" << subtotal << endl;
	cout << "Tax: $" << tax << endl;
	cout << "Total: $" << total << endl;

	return 0;
}

/*
Item 1: $15.95
Item 2: $24.95
Item 3: $6.95
Item 4: $12.95
Item 5: $3.95
Subtotal: $64.75
Tax: $4.5325
Total: $69.2825

C:\Users\gamer\Desktop\College Classes\C++ Programming CIS2541\Programs\resturauntbill\Debug\resturauntbill.exe (process 1548) exited with code 0.
Press any key to close this window . . .

*/