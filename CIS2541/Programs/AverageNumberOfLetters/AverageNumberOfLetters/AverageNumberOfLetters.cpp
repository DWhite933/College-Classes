/*

Name: David White
Class: CIS2541
Instructor: Louis Christakes
Chapter: 10
Problem: 4
Page: 607
File: AverageNumberOfLetters.cpp
Description:
Write a function that accepts a pointer to a C-String as an argument
and returns the number of words contained in the string. For instance,
if the string argument is "Four score and and seven years ago" the function
should return the number 6. It should also display the average number of
letters in each word. Demonstrate the function in a program that asks the
user to input a string then passes it to the function.

 */

#include <iostream>
#include <iomanip>
#include <cstring>
#include <cctype>
#include <string>
using namespace std;

// function prototypes
int numWords(char *, int);

int main()
{
	// max sentance length
	const int LENGTH = 32;

	// cstr to hold sentance
	char sentance[LENGTH];

	// pointer for sentance
	char *arrptr = sentance;

	// number of words
	int numOfWords = 0;

	// ask user for string
	cout << "Enter a string: ";
	cin.getline(sentance, LENGTH);

	numOfWords = numWords(arrptr, LENGTH);

	cout << "There are " << numOfWords << " words in that sentance" << endl;
}

int numWords(char *sent, int length)
{
	// number of words
	int count = 1;

	// number of letters total
	int numLetters = 0;

	// avg number of letters
	double avgLetters;

	for (int i = 0; sent[i] != '\0'; i++)
	{
		if (sent[i] == ' ')
		{
			count++;
		}
		else if (isalpha(sent[i]))
			numLetters++;
	}

	avgLetters = (double)numLetters / count;

	cout << setprecision(1) << fixed;
	cout << "The average number of letters per word is: " << avgLetters << endl;

	return count;
}

/*

Enter a string: four score and seven years ago
The average number of letters per word is: 4.2
There are 6 words in that sentance

C:\Users\gamer\Desktop\College Classes\C++ Programming CIS2541\Programs\AverageNumberOfLetters\Debug\AverageNumberOfLetters.exe (process 13520) exited with code 0.
Press any key to close this window . . .

*/