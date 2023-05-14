/*

Name: David White
Class: CIS2541
Instructor: Louis Christakes
Chapter: 9
Problem: 11 & 12
Page: 555
File: pointers.cpp
Description:

Problem 11:
Write a function that accepts an int array and the array's size as
arguments. The function should create a new array that is twice the
size of the argument array. The function should copy the contents of
the argument array to the new array and initialize the unused elements
of the second array with 0. The function sould return a pointer to the
new array.

Problem 12:
Write a function that accepts an int array and the array's size as
arguments. The function should create a new array that is one element
larger than the argument array. The first element of the new array should
be set to 0. Element of the argument array should be copied to element 1 of
the new array, element 1 of the argument array should be copied to element
2 of the new array, etc. The function should return a pointer to the new array.

 */

#include <iostream>
#include <iomanip>

using namespace std;

//function prototypes
int *arrayExpander(int[], int);
int *elementShifter(int[], int);

int main()
{
	// array size
	const int SIZE = 5;

	// int array
	int intArray[SIZE] = { 6, 9, 4, 2, 0 }; // heh nice

	// point to array
	int *arrPtr = intArray;

	// Define ptrs for function
	int *expPtr = nullptr, *shiftPtr = nullptr;

	// expand array
	expPtr = arrayExpander(intArray, SIZE);

	// shift array
	shiftPtr = elementShifter(intArray, SIZE);

	// show arrays
	cout << "intArray: ";
	for (int i = 0; i < SIZE; i++)
	{
		cout << intArray[i] << " ";
	}

	cout << "\nExpanded Array: ";
	for (int i = 0; i < (2 * SIZE); i++)
	{
		cout << expPtr[i] << " ";
	}

	cout << "\nShifted Array: ";
	for (int i = 0; i < (SIZE + 1); i++)
	{
		cout << shiftPtr[i] << " ";
	}

	// new line for clarity
	cout << '\n';

	// free memory
	delete[] expPtr;
	expPtr = nullptr;

	delete[] shiftPtr;
	shiftPtr = nullptr;
}

int * arrayExpander(int arr[], int size)
{
	// array pointer
	int *arrPtr;

	// new array size
	const int NEW_SIZE = 2 * size;

	// allocate array
	arrPtr = new int[NEW_SIZE];

	// copy array
	for (int i = 0; i < size; i++)
	{
		arrPtr[i] = arr[i];
	}

	// set rest of array to 0
	for (int i = size; i < NEW_SIZE; i++)
	{
		arrPtr[i] = 0;
	}

	return arrPtr;
}

int * elementShifter(int arr[], int size)
{
	// array ptr
	int *arrPtr;

	// size of new array
	const int NEW_SIZE = size + 1;

	// allocate array
	arrPtr = new int[NEW_SIZE];

	// set first element to 0
	arrPtr[0] = 0;

	// copy array
	for (int i = 0; i < size; i++)
	{
		arrPtr[i + 1] = arr[i];
	}

	return arrPtr;
}
/*

intArray: 6 9 4 2 0
Expanded Array: 6 9 4 2 0 0 0 0 0 0
Shifted Array: 0 6 9 4 2 0

C:\Users\gamer\Desktop\College Classes\C++ Programming CIS2541\Programs\pointers\Debug\pointers.exe (process 13260) exited with code 0.
Press any key to close this window . . .

*/