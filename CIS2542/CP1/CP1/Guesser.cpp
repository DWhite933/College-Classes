#include "Guesser.h"
#include <cstdlib>
#include <iostream>

Guesser::Guesser(int Answer)
	:CorrectAnswer(Answer)
{
}

int Guesser::getCorrectAnswer() const
{
	return CorrectAnswer;
}

void Guesser::SetCorrectAnswer()
{
	CorrectAnswer = (std::rand() % 15) + 1;
}

bool Guesser::MakeGuess(int guess)
{
	if (guess == CorrectAnswer)
	{
		std::cout << "You got it! Lucky you! I'm outta here!" << std::endl;
		return true;
	}
	if (guess == 0)
	{
		std::cout << "Who would ever pick zero? That would be cheating!" << std::endl;
		std::cout << "Just for that I'm going to think up a new number for you!" << std::endl;
		SetCorrectAnswer();
		return false;
	}
	if (guess != CorrectAnswer)
	{
		std::cout << "Nope! That's not it!" << std::endl;
		return false;
	}

}


