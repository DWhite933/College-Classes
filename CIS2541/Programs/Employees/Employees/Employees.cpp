/*

Name: David White
Class: CIS2541
Instructor: Louis Christakes
Chapter: 13
Problem: 2
Page: 808
File: Employees.cpp
Description:

Write a class name Employee that has the following member variables:

name: a string that holds the employee's name
idNumber: and int variable that holds the employee's id number
department: a string that holds the name of the department where the employee works
position: a string that holds the employee's job title

The class should also have the following constructors:

A constructor that accepts the following values as arguments and assigns them to
the appropriate member variables: employee's name, employee's id number, department,
and position.

A constructor that accepts the following values as arguments and assigns them to the
apprpriate member variables: employee's name and ID number. The department and
position fields should be assigned an empty string ("")

A default constructor that asssigns empty strings ("") to the name, department,
and position variables, and 0 to the idNumber member veriable.

Write appropriate mutotaor function that store values in these member variables and
accessor functions that return the values in these member cariables. Once you have
written the class, write a separate program that creates three Employee objects to hold
the following data:
Name			ID Number			Deparment			Position
Susan Meyers	  47899				Accounting			Vice President
Mark Jones		  39119				   IT				Programmmer
Joy Rogers		  81774				Manufacturing		Engineer

The program shoudl store this data in the three objects and then display the data for
each employee on the screen.

 */

#include <iostream>
#include "Employee.h"
using namespace std;

int main()
{
	Employee Employees[] = { Employee("Susan Meyers", 47899, "Accounting", "Vice President"), Employee("Mark Jones", 39119, "IT", "Programmer"), Employee("Joy Rogers", 81774, "Manufacturing", "Engineer") };

	for (Employee e : Employees)
	{
		cout << e.getName() << endl;
		cout << e.getIdNumber() << endl;
		cout << e.getDepartment() << endl;
		cout << e.getPosition() << endl;
		cout << '\n';
	}
}

/*
*
Susan Meyers
47899
Accounting
Vice President

Mark Jones
39119
IT
Programmer

Joy Rogers
81774
Manufacturing
Engineer

C:\Users\gamer\Desktop\College Classes\C++ Programming CIS2541\Programs\Employees\Debug\Employees.exe (process 9176) exited with code 0.
Press any key to close this window . . .

*/