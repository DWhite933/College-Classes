/*
Name: David White
Class: CIS2541
Instructor: Louis Christakes
Chapter: 11
Problem: 12
Page: 661
File: CourseGrade.cpp
Description:
Write a program that uses a struture to store the following data:

Member name		Description

Name			Student Name
Idnum			Student ID number
Tests			Pointer to an array of test scores
Average			Average test score
Grade			Course Grade

The program should keep a list of test score for a group of
students. It should ask the user how many test scores there
are to be and how many students there are. It should then
dynamically allocate an array of stuctures. Each stuctures
Tests member should point to a dynamically allocated array
that will hold the test scores.

After the arrays have been dynamically allocated, the program
should ask for the ID number and all the test scores for each
student. The average test score should be calculated and stored
in the average member of each structure. The course grade should be
computed on the basis of the following grading scale:

Average Test Grade		Course Grade
	91-100					A
	81-90					B
	71-80					C
	61-70					D
  60 or less				F

 The course grade should then be stored in the Grade member of each
 structure. Once all this date is calculated, A table should be
 displayed on the screen listing each student's name, ID number,
 average test score, and course grade.
 */

#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

// Structure Definitions
struct Student
{
	string Name; // Student name
	int IDnum;	// Student ID number
	int *tests = nullptr; // poitner to an array of test scores
	int average; // Average test score
	char grade; // Course Grade
};

// Function prototypes
void getStudentInfo(Student *, int, int);
void calcGrade(Student*, int, int);
void showStudents(Student *, int, int);

#include <iostream>

int main()
{
	Student *classroom = nullptr; // arrptr to hold students
	int numTests; // number of tests
	int classSize; // number of students

	// Ask user for the number of tests
	cout << "Enter Number of Tests: ";
	cin >> numTests;

	// Ask user for the number of students
	cout << "Enter Number of Students: ";
	cin >> classSize;

	// dynamically allocate arrays
	classroom = new Student[classSize];

	for (int i = 0; i < classSize; i++)
	{
		classroom[i].tests = new int[numTests];
	}

	getStudentInfo(classroom, classSize, numTests);
	calcGrade(classroom, classSize, numTests);
	showStudents(classroom, classSize, numTests);

	// free memory
	for (int i = 0; i < classSize; i++)
	{
		delete[] classroom[i].tests;
	}

	delete[] classroom;
}

// Ask user for student info
void getStudentInfo(Student *studs, int numStudents, int numTests)
{
	for (int i = 0; i < numStudents; i++)
	{
		cout << "Enter Student ID: ";
		cin >> studs[i].IDnum;

		cout << "Enter Student Name: ";
		cin.ignore();
		getline(cin, studs[i].Name);

		for (int j = 0; j < numTests; j++)
		{
			cout << "Enter Test Score #"
				<< j + 1 << ": ";
			cin >> studs[i].tests[j];

			while (studs[i].tests[j] <= 0 || studs[i].tests[j] > 100)
			{
				cout << "Please a Number Between 0 and 100." << endl;
				cout << "Enter Test Score #"
					<< j + 1 << ": ";
				cin >> studs[i].tests[j];
			}
		}
	}
}

void calcGrade(Student *studs, int studentNum, int testNum)
{
	for (int i = 0; i < studentNum; i++)
	{
		int percentTotal = 0;

		// calc average
		for (int j = 0; j < testNum; j++)
		{
			percentTotal += studs[i].tests[j];
		}

		studs[i].average = percentTotal / testNum;

		// calc Grade
		if (studs[i].average < 91)
		{
			studs[i].grade = 'A';
		}
		else if (studs[i].average >= 81 && studs[i].average < 90)
		{
			studs[i].grade = 'B';
		}
		else if (studs[i].average >= 71 && studs[i].average < 80)
		{
			studs[i].grade = 'C';
		}
		else if (studs[i].average >= 61 && studs[i].average < 70)
		{
			studs[i].grade = 'D';
		}
		else
			studs[i].grade = 'F';
	}
}

void showStudents(Student *studs, int studentNum, int testNum)
{
	for (int i = 0; i < studentNum; i++)
	{
		// show student ID
		cout << setw(10) << left
			<< "\nStudent ID: "
			<< right << setw(5)
			<< studs[i].IDnum << endl;

		// show Student name
		cout << setw(10) << left
			<< "Student Name: "
			<< right << setw(5)
			<< studs[i].Name << endl;

		// show test results
		cout << setw(10) << left
			<< "\nTest #"
			<< right << setw(5)
			<< "Score" << endl;

		for (int j = 0; j < testNum; j++)
		{
			cout << setw(3) << left
				<< " " << (j + 1)
				<< setw(9) << right
				<< studs[i].tests[j] << endl;;
		}

		// show average
		cout << setw(10) << left
			<< "\nAverage: "
			<< right
			<< studs[i].average << endl;
	}
}

/*
Enter Number of Tests: 2
Enter Number of Students: 2
Enter Student ID: 1234
Enter Student Name: Lou
Enter Test Score #1: 89
Enter Test Score #2: 69
Enter Student ID: 234
Enter Student Name: Jane
Enter Test Score #1: 84
Enter Test Score #2: 99

Student ID:  1234
Student Name:   Lou

Test #   Score
   1       89
   2       69

Average: 79

Student ID:   234
Student Name:  Jane

Test #   Score
   1       84
   2       99

Average: 91

C:\Users\gamer\Desktop\College Classes\C++ Programming CIS2541\Programs\CourseGrade\Debug\CourseGrade.exe (process 25688) exited with code 0.
Press any key to close this window . . .

*/