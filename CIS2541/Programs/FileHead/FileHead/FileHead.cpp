/*

Name: David White
Class: CIS2541
Instructor: Louis Christakes
Chapter: 12
Problem: 1
Page: 713
File: FileHead.cpp
Description:

Write a program that asks the user for the name of a file. The program should display
the first 10 lines of the file on ht screan (the "head" of the file) If the file has fewer
than ten lines, the file should be displayed, with a message indicating the entire file
has been displayed.

 */

#include <iostream>
#include <string>
#include <fstream>

using namespace std;

// Function Prototypes

int main()
{
	ifstream inFile;
	string fileName;
	const long headLength = 10;
	string fileData;

	cout << "Enter name of file: ";
	getline(cin, fileName);

	inFile.open(fileName);

	if (inFile)
	{
		for (int i = 0; i < headLength; i++)
		{
			if (!inFile.eof()) {
				getline(inFile, fileData);
				cout << fileData << endl;
			}
			else {
				cout << "Entire file has been displayed" << endl;
				break;
			}
		}
	}
	else cout << "Something went wrong. Please try again." << endl;

	inFile.close();
}

/*
Enter name of file: testa.txt
1
2
3
4
5
6
Entire file has been displayed

C:\Users\gamer\Desktop\College Classes\C++ Programming CIS2541\Programs\FileHead\Debug\FileHead.exe (process 2488) exited with code 0.
Press any key to close this window . . .

Enter name of file: testb.txt
1
2
3
4
5
6
7
8
9
10

C:\Users\gamer\Desktop\College Classes\C++ Programming CIS2541\Programs\FileHead\Debug\FileHead.exe (process 9164) exited with code 0.
Press any key to close this window . . .

*/