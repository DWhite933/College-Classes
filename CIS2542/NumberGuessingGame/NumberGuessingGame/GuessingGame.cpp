#include <cstdlib>
#include "GuessingGame.h"

GuessingGame::GuessingGame(int LargestTargetValue)
	: TargetGuessValue(1 + (rand() % LargestTargetValue))
{
	// The lights are on but no ones home...
}

int GuessingGame::MakeGuess(int Guess)
{
	if (Guess < TargetGuessValue)
	{
		return -1;
	}
	if (Guess > TargetGuessValue) {
		return 1;
	}

	return 0;
}