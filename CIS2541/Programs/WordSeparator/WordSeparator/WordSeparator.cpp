/*

Name: David White
Class: CIS2541
Instructor: Louis Christakes
Chapter: 10
Problem: 14
Page: 609
File: WordSeparator.cpp
Description:
Write a program that accepts as input a sentence in which all of
the words are run together but the first character of each word
is uppercase. Convert the senence to a string in which the words
are separated by spaces and only the first word starts with an
uppercase letter. For example, the string "StopAndSmellTheRoses."
would be converted to "Stop and smell the roses."

 */

#include <iostream>
#include <iomanip>
#include <cstring>
#include <cctype>
#include <string>
using namespace std;

int main()
{
	// max sentance length
	const int LENGTH = 32;

	// cstr to hold sentance
	char sentance[LENGTH];

	cout << "Enter a CamelCase Sentance (ex: StopAndSmellTheRoses): ";
	cin.getline(sentance, LENGTH);

	cout << endl;

	cout << "The sentance normally: ";

	for (int i = 0; sentance[i] != '\0'; i++)
	{
		if (islower(sentance[i]) && isupper(sentance[i + 1])) {
			sentance[i + 1] = (char)tolower(sentance[i + 1]);
			cout << sentance[i] << " ";
		}
		else if (isalpha(sentance[i]))
		{
			cout << sentance[i];
		}
	}
}

/*

Enter a CamelCase Sentance (ex: StopAndSmellTheRoses): ThisIsTheWordSeparator

The sentance normally: This is the word separator
C:\Users\gamer\Desktop\College Classes\C++ Programming CIS2541\Programs\WordSeparator\Debug\WordSeparator.exe (process 17544) exited with code 0.
Press any key to close this window . . .

*/