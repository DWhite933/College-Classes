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
	std::cout << "  Now with at least 10% more fun!!  " << std::endl;
	std::cout << "-- Bradley Sward, with great sarcasm" << std::endl;
	std::cout << "------------------------------------" << std::endl;
	std::cout << "Enter the largest possible number: ";
	int largestPossibleTargetValue;
	std::cin >> largestPossibleTargetValue;

	// Play a game
	GuessingGame game(largestPossibleTargetValue);

	// Last guess made by player
	int guess;

	do
	{
		// Get guess
		std::cout << std::endl << "Enter your guess [1 - ";
		std::cout << largestPossibleTargetValue << "]: ";
		std::cin >> guess;

		// Game state has changed
		game.IncrementGuessCounter();

		// But to what?
		if (guess < game)
		{
			// Testing friend < operator
			std::cout << "Too low... Try again!" << std::endl;
		}
		else if (guess > game)
		{
			// Testing friend > operator
			std::cout << "Too high... Try again!" << std::endl;
		}
	} while (guess != game);
	// Testing friend != operator

	// Celebrate a job well done
	std::cout << std::endl;
	std::cout << "You got it!  Phew!" << std::endl;
	
	std::cout << "It took you " << game.GetGuessesMade() << " tries!" << std::endl;
	std::cout << std::endl;
	
	std::cout << "Testing your copy constructor..." << std::endl;
	GuessingGame copy = game;
	std::cout << "It took you " << copy.GetGuessesMade() << " tries!" << std::endl;
	std::cout << std::endl;

	std::cout << "Testing your copy assignment operator..." << std::endl;
	copy = game;
	std::cout << "It took you " << copy.GetGuessesMade() << " tries!" << std::endl;
	std::cout << std::endl;
	
	std::cout << "See?  Even better best game of the year!" << std::endl;

	// Clean up and quit
	system("PAUSE");
	return 0;
}