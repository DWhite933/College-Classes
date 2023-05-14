#pragma once

class GuessingGame
{
public:
	GuessingGame(int LargestTargetGuessValue);
	int MakeGuess(int Guess);

private:
	int TargetGuessValue;

};