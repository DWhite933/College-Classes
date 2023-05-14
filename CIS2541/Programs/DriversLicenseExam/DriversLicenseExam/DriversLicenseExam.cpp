/*
Name: David White
Class: CIS2541
Instructor: Louis Christakes
Chapter: 7
Problem: 10
Page: 457
File: DriversLicenseExam.cpp
Description:
The local Driver's License Office has asked you to write a program
that grades the written portion of the driver's license exam. The
exam has 20 multiple questions. Your program should store the
correct answers in an array. It should ask the user to enter the
student's answers for each of the 20 question, and the answers
should be stored in another array. After the studen's aswers have
been entered, the program should display a message indicating whether
the student passed or failed the exam. A student must correctly answer
15 of the 20 questions to pass the exam. It should then display the
total number of correctly answered questions, the total number of
incorrectly answered questions, and a list showing the question
numbers of the incorrectly answered questions.

You are to have 3 functions for this assignment:

readAnswers: takes an array and fills it with the student's answers.
this function should validate the student answers.

gradeExam: compares answers and returns the  number of correct answers

printResults: Prints whether the studented passed the exam or not,
also the amount of correct and incorrect answers and then prints out
all answers and correct answers

*/

#include <iostream>
#include <iomanip>
#include <cctype>
#include <vector>

using namespace std;

// Function Prototypes
void readAnswers(char[]);
int gradeExam(const char[], const char[]);
void printResults(int, const char[], const char[]);

int main()
{
	// the total number of questions
	const int NUMBER_OF_QUESTIONS = 20;

	// array for the correct answers
	char correctAnswers[NUMBER_OF_QUESTIONS] =
	{ 'A', 'D', 'B', 'B', 'C', 'B', 'A', 'B', 'C', 'D',
	  'A', 'C', 'D', 'B', 'D', 'C', 'C', 'A', 'D', 'B' };

	// array for the student's answers
	char studentAnswers[NUMBER_OF_QUESTIONS];

	// number of correct answers
	int numCorrect = 0;

	readAnswers(studentAnswers);

	numCorrect = gradeExam(studentAnswers, correctAnswers);

	printResults(numCorrect, studentAnswers, correctAnswers);
}

void readAnswers(char studentAnswers[])
{
	for (int i = 0; i < 20; i++)
	{
		cout << "Please enter answer for question #" << (i + 1) << ": ";
		cin >> studentAnswers[i];

		// input validation
		if (!(isalpha(studentAnswers[i]) &&
			(toupper(studentAnswers[i]) == 'A' ||
				toupper(studentAnswers[i]) == 'B' ||
				toupper(studentAnswers[i]) == 'C' ||
				toupper(studentAnswers[i]) == 'D')))
		{
			cout << "Please enter A, B, C or D.\n";
			cout << "Please enter the student's answer for question #" << (i + 1) << ": ";
			cin >> studentAnswers[i];
		}

		studentAnswers[i] = toupper(studentAnswers[i]);
	}
}

int gradeExam(const char studentAnswers[], const char correctAnswers[])
{
	int numCorrect = 0;
	for (int i = 0; i < 20; i++)
	{
		if (studentAnswers[i] == correctAnswers[i]) {
			numCorrect++;
		}
	}

	return numCorrect;
}

void printResults(int numCorrect, const char studentAnswers[], const char correctAnswers[])
{
	if (numCorrect > 15)
	{
		cout << "\nYou passed the Driver's Lincense Exam! :)\n";
	}
	else
	{
		cout << "\nYou failed the Driver's Lincense Exam. :(\n";
	}

	cout << "You had " << numCorrect << " right anwers and " << (20 - numCorrect) << " wrong answers.\n";
	cout << "\n*** Displaying Score Sheet ***\n\n";

	cout << "Your" << setw(13) << "Correct" << endl;
	cout << "Answer" << setw(10) << "Answer" << setw(10) << "Remark" << endl;
	cout << "------" << setw(10) << "------" << setw(10) << "------" << endl;

	for (int i = 0; i < 20; i++)
	{
		cout << setw(3) << studentAnswers[i] << setw(10) << correctAnswers[i];
		if (correctAnswers[i] != studentAnswers[i])
		{
			cout << "\t   *** Wrong ***\n";
		}
		else
		{
			cout << "\n";
		}
	}
}

/*

Please enter answer for question #1: d
Please enter answer for question #2: d
Please enter answer for question #3: a
Please enter answer for question #4: c
Please enter answer for question #5: c
Please enter answer for question #6: a
Please enter answer for question #7: c
Please enter answer for question #8: a
Please enter answer for question #9: c
Please enter answer for question #10: b
Please enter answer for question #11: a
Please enter answer for question #12: c
Please enter answer for question #13: d
Please enter answer for question #14: a
Please enter answer for question #15: d
Please enter answer for question #16: c
Please enter answer for question #17: b
Please enter answer for question #18: b
Please enter answer for question #19: d
Please enter answer for question #20: c

You failed the Driver's Lincense Exam. :(
You had 9 right anwers and 11 wrong answers.

*** Displaying Score Sheet ***

Your      Correct
Answer    Answer    Remark
------    ------    ------
  D         A      *** Wrong ***
  D         D
  A         B      *** Wrong ***
  C         B      *** Wrong ***
  C         C
  A         B      *** Wrong ***
  C         A      *** Wrong ***
  A         B      *** Wrong ***
  C         C
  B         D      *** Wrong ***
  A         A
  C         C
  D         D
  A         B      *** Wrong ***
  D         D
  C         C
  B         C      *** Wrong ***
  B         A      *** Wrong ***
  D         D
  C         B      *** Wrong ***

C:\Users\gamer\Desktop\College Classes\C++ Programming CIS2541\Programs\DriversLicenseExam\x64\Debug\DriversLicenseExam.exe (process 21556) exited with code 0.
Press any key to close this window . . .

*/