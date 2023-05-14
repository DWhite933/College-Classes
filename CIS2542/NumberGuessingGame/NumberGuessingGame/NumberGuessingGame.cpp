// NumberGuessingGame.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <ctime>
#include <iostream>
#include "GuessingGame.h"

int main()
{
	// Different target value every time
	srand(static_cast<unsigned int>(time(nullptr)));

	// Get the constraints of the target value
	std::cout << "------------------------------------" << std::endl;
	std::cout << "The Funnest Guessing Game of 202X!!!" << std::endl;
	std::cout << "-- Bradley Sward, with great sarcasm" << std::endl;
	std::cout << "------------------------------------" << std::endl;
	std::cout << "Enter the largest possible number: ";
	int largestPossibleTargetValue;
	std::cin >> largestPossibleTargetValue;

	// Play a game
	GuessingGame game(largestPossibleTargetValue);

	// Game state of  0 means a victory
	// Game state of -1 means last guess was too low
	// Game state of +1 means last guess was too high
	int gameState;

	do
	{
		// Get guess
		std::cout << std::endl << "Enter your guess [1 - ";
		std::cout << largestPossibleTargetValue << "]: ";
		int guess;
		std::cin >> guess;

		// Give guess data to game object
		// Game state has changed
		gameState = game.MakeGuess(guess);

		// But to what...?
		if (gameState == -1)
		{
			std::cout << "Too low... Try again!" << std::endl;
		}
		else if (gameState == +1)
		{
			std::cout << "Too high... Try again!" << std::endl;
		}
	} while (gameState != 0);

	// Celebrate a job well done
	std::cout << std::endl;
	std::cout << "You got it!  Phew!" << std::endl;
	std::cout << "See?  Best game of the year!" << std::endl;
	std::cout << std::endl;

	// Clean up and quit
	system("PAUSE");
	return 0;
}
// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
