/*
Name: David White
Class: CIS2541
Instructor: Louis Christakes
Chapter: 4
Problem: 14
Page: 224
File: BankCharges.cpp
Description: 
A bank charges $10 a month plus the following check fees for a commercial checking account
	.10 each for fewer than 20 checks
	.08 each for 20-39 checks
	.06 each for 40-59 checks
	.04 each for 60 or more checks
The bank also charges an extra $15 if the balance of the account falls below $400 (before any check fees are aplied). Write a program that asks for the beginning balance 
and the number of checks written. Compute and display the bank's service fees for the month
 */


#include <iostream>
#include <iomanip>

using namespace std;

int main()
{	
	// amount in account
	double startBalance;

	// amount after bank fees
	double endBalance;

	// number of checks
	int numChecks;

	// total amount of fees
	double bankFees = 0.0;

	// ask user for account balance
	cout << "Enter account balance: $";
	cin >> startBalance;

	// input validation
	if (startBalance < 0)
		cout << "WARNING: ACCOUNT OVERDRAWN!";
	
	// ask user for number of checks
	cout << "Enter number of checks: ";
	cin >> numChecks;

	// input validation
	if (numChecks < 0)
	{
		cout << "Negative number entered, Please enter a positve number: ";
		cin >> numChecks;
	}

	// calculate bank fees
	if (startBalance < 400)
		bankFees += 15;
	
	if (numChecks < 20)
		bankFees += (numChecks * .10) + 10;
	else if (numChecks > 20 && numChecks <= 39)
		bankFees += (numChecks * .08) + 10;
	else if (numChecks > 40 && numChecks <= 59)
		bankFees += (numChecks * .06) + 10;
	else if (numChecks > 60)
		bankFees += (numChecks * .04) + 10;

	// set end balance
	endBalance = startBalance - bankFees;

	// Display info
	cout << "\nNumber of Checks: " << numChecks << endl;
	cout << setprecision(2) << fixed;
	cout << "Start Balance: $" << startBalance << endl;
	cout << "Total Fees: $" << bankFees << endl;
	cout << "End Balance: $" << endBalance << endl;

}

/*
Enter account balance: $1000
Enter number of checks: 55

Number of Checks: 55
Start Balance: $1000.00
Total Fees: $13.30
End Balance: $986.70

C:\Users\gamer\Desktop\College Classes\C++ Programming CIS2541\Programs\BankCharges\Debug\BankCharges.exe (process 19532) exited with code 0.
Press any key to close this window . . .

*/

/*
Enter account balance: $500
Enter number of checks: 6

Number of Checks: 6
Start Balance: $500.00
Total Fees: $10.60
End Balance: $489.40

C:\Users\gamer\Desktop\College Classes\C++ Programming CIS2541\Programs\BankCharges\Debug\BankCharges.exe (process 3460) exited with code 0.
Press any key to close this window . . .

*/

/*
Enter account balance: $405
Enter number of checks: 36

Number of Checks: 36
Start Balance: $405.00
Total Fees: $12.88
End Balance: $392.12

C:\Users\gamer\Desktop\College Classes\C++ Programming CIS2541\Programs\BankCharges\Debug\BankCharges.exe (process 16312) exited with code 0.
Press any key to close this window . . .

*/