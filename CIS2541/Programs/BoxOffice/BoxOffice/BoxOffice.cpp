/*
Name: David White
Class: CIS2541
Instructor: Louis Christakes
Chapter: 3
Problem: 7
Page: 145
File: BoxOffice.cpp
Description: Write a program that calculates a theater's gross and net box office profit for a night. The program should ask for the name of the movie and how many adult and child tickets were sold and display a report
 */

#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

int main()
{
	// name of the movie
	string movieName; 

	// cost of an adult ticket
	const double adultCost = 10.00;

	// cost of a child ticket
	const double kidCost = 6.00;

	// number of adult tickets sold
	int adultSold;

	// number of child tickets sold
	int kidSold;

	double grossProfit = 0.0;
	double netProfit =  0.0;
	// amount to pay to distributor
	double distCost = 0.0;

	// ask for name of the movie
	cout <<  "Enter the name of the movie: ";
	getline(cin, movieName);

	// ask for number of adult tickets sold
	cout << "Enter the number of Adult tickets sold: ";
	cin >> adultSold;

	// ask for number of child ticket sold
	cout << "Enter number of Child tickets sold: ";
	cin >> kidSold;

	// calculate gross profit
	grossProfit = (adultSold * adultCost) + (kidCost * kidSold);

	// calculate net profit
	netProfit = grossProfit * 0.2;

	// calculate amount to be paid to distributor
	distCost = grossProfit * 0.8;

	// dislay info
	cout << "\nMovie Title:  \"" << movieName << "\"" << endl;
	cout << "Adult Tickets sold: " << adultSold << endl;
	cout << "Child Tickets sold: " << kidSold << endl;
	cout << setprecision(2) << fixed;
	cout << "Gross Box Office Profit: $" << grossProfit << endl;
	cout << "Net Box Office Profit: $" << netProfit << endl;
	cout << "Amount Paid to distributor: $" << distCost << endl;

}

/*
Enter the name of the movie: Wheels of Fury
Enter the number of Adult tickets sold: 382
Enter number of Child tickets sold: 127

Movie Title:  "Wheels of Fury"
Adult Tickets sold: 382
Child Tickets sold: 127
Gross Box Office Profit: $4582.00
Net Box Office Profit: $916.40
Amount Paid to distributor: $3665.60

C:\Users\gamer\Desktop\College Classes\C++ Programming CIS2541\Programs\BoxOffice\Debug\BoxOffice.exe (process 11096) exited with code 0.
Press any key to close this window . . .

*/