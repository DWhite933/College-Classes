#include <cstdlib>
#include "GuessingGame.h"

GuessingGame::GuessingGame(int LargestPossibleTargetValue)
	: TargetValue(1 + (rand() % LargestPossibleTargetValue)),
	  GuessesMade(0)
{
	// Nothing here...
}

GuessingGame::GuessingGame(const GuessingGame& rhs)
	: TargetValue(rhs.TargetValue),
	  GuessesMade(rhs.GuessesMade)
{
	// Nothing here...
}

GuessingGame& GuessingGame::operator=(const GuessingGame& rhs)
{
	TargetValue = rhs.TargetValue;
	GuessesMade = rhs.GuessesMade;
	return *this;
}

void GuessingGame::IncrementGuessCounter()
{
	 ++GuessesMade;
}

int GuessingGame::GetGuessesMade() const
{
	return GuessesMade;
}

bool operator <(int guess, const GuessingGame& game)
{
	return guess < game.TargetValue;
}

bool operator >(int guess, const GuessingGame& game)
{
	return guess > game.TargetValue;
}

bool operator !=(int guess, const GuessingGame& game)
{
	return guess != game.TargetValue;
}