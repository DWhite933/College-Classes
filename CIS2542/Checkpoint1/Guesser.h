#pragma once
#include <cstdlib>
class Guesser
{
public:
	Guesser(int Answer = (std::rand() % 15) + 1);

	int getCorrectAnswer() const;
	void SetCorrectAnswer();

	bool MakeGuess(int) ;

private:
	int CorrectAnswer;
};

