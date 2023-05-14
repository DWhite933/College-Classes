/*
Name: David White
Class: CIS2541
Instructor: Louis Christakes
Chapter: 3
Problem: 19
Page: 147-148
File: MonthlyPayments.cpp
Description: Write a program that calculates a monthly payments for a loan
 */

#include <iostream>
#include <iomanip>
#include <cmath>

using namespace std;

int main()
{
	double loanAmount, monthlyPayment = 0.0, totalPayment, intrestPayment, monthlyRate;
	int numPayment;

	// ask for loan amount
	cout << "Enter Loan amount: $";
	cin >> loanAmount;

	// ask for yearly interest rate
	cout << "Enter monthly interest rate: ";
	cin >> monthlyRate;

	// ask for number of payments
	cout << "Enter number of payments: ";
	cin >> numPayment;

	// calculate monthly payment
	monthlyPayment = ((monthlyRate / 100) * pow(1 + (monthlyRate / 100), numPayment) / (pow((1 + (monthlyRate / 100)), numPayment) - 1)) * loanAmount;

	// calculate total payment
	totalPayment = monthlyPayment * numPayment;

	// caclulate amount of interest paid
	intrestPayment = totalPayment - loanAmount;

	// display info
	cout << setprecision(2) << fixed;
	cout << "Loan Amount: $" << loanAmount << endl;
	cout << "Monthly Interest Rate: " << monthlyRate << "%" << endl;
	cout << "Number of Payments: " << numPayment << endl;
	cout << "Monthly Payment: $" << monthlyPayment << endl;
	cout << "Amount Paid Back: $" << totalPayment << endl;
	cout << "Interest Paid: $" << intrestPayment << endl;

}

/*
Enter Loan amount: $10000
Enter monthly interest rate: 1
Enter number of payments: 36
Loan Amount: $10000.00
Monthly Interest Rate: 1.00%
Number of Payments: 36
Monthly Payment: $332.14
Amount Paid Back: $11957.15
Interest Paid: $1957.15

C:\Users\gamer\Desktop\College Classes\C++ Programming CIS2541\Programs\MonthlyPayments\Debug\MonthlyPayments.exe (process 25064) exited with code 0.
Press any key to close this window . . .

*/