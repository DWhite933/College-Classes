/*
Name: David White
Class: CIS2541
Instructor: Louis Christakes
Chapter: 7
Problem: 3
Page: 455
File: ChipsAndSalsa.cpp
Description:
Write a program that lets a maker of chips and salsa keep track of the 5 different types
of salsa: mild, medium, sweet, hot, and zesty. The program should use two parallel 5-element
arrays: an array of strings that holds the five salsa names, and an array of ints that holds
the number of jars sold during the past month for each salsa type. The salsa names should be 
stored using an initializaion list at the time the name array is created. The program should
prompt the user to enter the number of jars sold for each type. Once this sales data has been
entered, the program should produce a report that displays sales for each salsa type, total
sales and the names of the highest and lowest selling products.
*/

#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

// function prototypes
int maxSales(int[], int); // returns the index of the salsa with the highest sales
int minSales(int[], int); // returns the index of the salsa with the lowest sales

int main()
{
	const int TYPES_OF_SALSA = 5; // number of different types of sals
	string salsaName[TYPES_OF_SALSA] = { "Mild", "Medium", "Sweet", "Hot", "Zesty" }; // arr to hold the names of the different types of salsa
	int salsaSales[TYPES_OF_SALSA]; // arr to hold the number of jars sold of each type of salsa
	int totalSales = 0; // the total number of salsa jars sold


	// ask user for sales figure
	for (int i = 0; i < TYPES_OF_SALSA; i++)
	{
		cout << "Enter the number of sales for " << salsaName[i] << ": ";
		cin >> salsaSales[i];

		// input validation 
		if (salsaSales[i] < 0) {
			cout << "Please enter a positive number." << endl;
			cout << "Enter the number of sales for " << salsaName[i] << ": ";
			cin >> salsaSales[i];
		}

		totalSales += salsaSales[i];
	}

	// show total sales
	cout << "You sold a total of " << totalSales << " jars of salsa." << endl;

	// show sales for eache type
	for (int i = 0; i < TYPES_OF_SALSA; i++)
	{
		cout << "You sold " << salsaSales[i] << " jars of " << salsaName[i] << ".\n";
	}

	// show most popular salsa
	cout << "The most popular salsa is " << salsaName[maxSales(salsaSales, TYPES_OF_SALSA)] << ".\n";
	
	// show least popular salsa
	cout << "The least popular salsa is " << salsaName[minSales(salsaSales, TYPES_OF_SALSA)] << ".\n";

	

}

int maxSales(int sales[], int size)
{
	int max = 0;
	for (int i = 1; i < size; i++)
	{
		if (sales[i] > sales[max])
			max = i;
	}
	return max;
	
}

int minSales(int sales[], int size)
{
	int min = 0;
	for (int i = 1; i < size; i++)
	{
		if (sales[i] < sales[min])
			min = i;
	}
	return min;
}

/*
Enter the number of sales for Mild: 1225
Enter the number of sales for Medium: -13
Please enter a positive number.
Enter the number of sales for Medium: 1943
Enter the number of sales for Sweet: 1067
Enter the number of sales for Hot: 2453
Enter the number of sales for Zesty: 2098
You sold a total of 8786 jars of salsa.
You sold 1225 jars of Mild.
You sold 1943 jars of Medium.
You sold 1067 jars of Sweet.
You sold 2453 jars of Hot.
You sold 2098 jars of Zesty.
The most popular salsa is Hot.
The least popular salsa is Sweet.

C:\Users\gamer\Desktop\College Classes\C++ Programming CIS2541\Programs\ChipsAndSalsa\Debug\ChipsAndSalsa.exe (process 16516) exited with code 0.
Press any key to close this window . . .
*/