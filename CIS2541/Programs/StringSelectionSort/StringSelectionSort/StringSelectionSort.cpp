/*

Name: David White
Class: CIS2541
Instructor: Louis Christakes
Chapter: 8
Problem: 6
Page: 499
File: StringSelectionSort.cpp
Description:
Modify the selectionSort function presented in this chapter
so it sorts an array of string instead of an array of ints.
Test the function with a driver program.
 */

#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

//function prototypes
void selectionSort(string[], int);

int main()
{
	int NUM_NAMES = 20;

	string names[] =
	{ "Collins, Bill", "Smith, Bart", "Allen, Jim",
	"Griffin, Jim", "Stamey, Marty", "Rose, Geri",
	"Taylor, Terri", "Johnson, Jill",
	"Allison, Jeff", "Looney, Joe", "Wolfe, Bill",
	"James, Jean", "Weaver, Jim", "Pore, Bob",
	"Rutherford, Greg", "Javens, Renee",
	"Harrison, Rose", "Setzer, Cathy",
	"Pike, Gordon", "Holland, Beth" };

	// show array
	cout << "Unsorted array: \n";
	for (int i = 0; i < NUM_NAMES; i++)
	{
		cout << names[i] << endl;
	}

	// new line for clarity
	cout << "\n";

	// sort array
	selectionSort(names, NUM_NAMES);

	// display sorted array
	cout << "The sorted values are: \n";
	for (int i = 0; i < NUM_NAMES; i++)
	{
		cout << names[i] << endl;
	}
}

// sorts string array in ascending order
void selectionSort(string array[], int size)
{
	int start, minIndex;
	string minValue;

	for (start = 0; start < (size - 1); start++) {
		minIndex = start;
		minValue = array[start];

		for (int index = start + 1; index < size; index++) {
			if (array[index] < minValue)
			{
				minValue = array[index];
				minIndex = index;
			}
		}
		array[minIndex] = array[start];
		array[start] = minValue;
	}
}

/*

Unsorted array:
Collins, Bill
Smith, Bart
Allen, Jim
Griffin, Jim
Stamey, Marty
Rose, Geri
Taylor, Terri
Johnson, Jill
Allison, Jeff
Looney, Joe
Wolfe, Bill
James, Jean
Weaver, Jim
Pore, Bob
Rutherford, Greg
Javens, Renee
Harrison, Rose
Setzer, Cathy
Pike, Gordon
Holland, Beth

The sorted values are:
Allen, Jim
Allison, Jeff
Collins, Bill
Griffin, Jim
Harrison, Rose
Holland, Beth
James, Jean
Javens, Renee
Johnson, Jill
Looney, Joe
Pike, Gordon
Pore, Bob
Rose, Geri
Rutherford, Greg
Setzer, Cathy
Smith, Bart
Stamey, Marty
Taylor, Terri
Weaver, Jim
Wolfe, Bill

C:\Users\gamer\Desktop\College Classes\C++ Programming CIS2541\Programs\StringSelectionSort\Debug\StringSelectionSort.exe (process 19460) exited with code 0.
Press any key to close this window . . .

*/