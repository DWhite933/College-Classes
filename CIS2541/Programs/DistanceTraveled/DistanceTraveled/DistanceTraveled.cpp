/*
Name: David White
Class: CIS2541
Instructor: Louis Christakes
Chapter: 5
Problem: 6
Page: 298
File: DistanceTraveled.cpp
Description:
The distance a vehicle travels can be calculated as follows:

distance = speed * time

For example, if a train travels 40 miles per hours for 3 hours, the 
distance traveled is 120 miles.

Write a program that asks the user for the speed of a vehicle (in MPH)
and how man hours it has traveled. The program should then use a loop to display
the distance the vehicle has traveled for each hour of that time period.

 */

#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
	int distance, // distance traveled
		speed, // how fast the vehicle is going
		time; // how longe the vehicle has been travelling

	// ask user for speed
	cout << "What is the speed of the vehicle in MPH? ";
	cin >> speed;

	// input validation
	while (speed < 0)
	{
		cout << "Please Enter a positive number" << endl;
		cout << "What is the speed of the vehicle in MPH? ";
		cin >> speed;
	}

	// ask user for time
	cout << "How many hours has it traveled? ";
	cin >> time;

	// input validation
	while (time <= 1)
	{
		cout << "Please enter a value greater than 1" << endl;
		cout << "How many hours has it traveled? ";
		cin >> time;
	}

	cout << "Hour" << setw(20) << "Distance Travled" << endl;
	cout << "----------------------------" << endl;

	for (int i = 1; i < time + 1; i++)
	{
		distance = speed * i;
		cout << setw(2) << i << setw(15) << distance << endl;
	}
}

/*
What is the speed of the vehicle in MPH? 40
How many hours has it traveled? 3
Hour    Distance Travled
----------------------------
 1             40
 2             80
 3            120

C:\Users\gamer\Desktop\College Classes\C++ Programming CIS2541\Programs\DistanceTraveled\Debug\DistanceTraveled.exe (process 872) exited with code 0.
Press any key to close this window . . .

*/
