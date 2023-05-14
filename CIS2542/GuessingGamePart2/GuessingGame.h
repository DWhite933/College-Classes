#pragma once

class GuessingGame
{
public:
	// Constructor
	// Randomize the TargetValue member variable like you did before
	// Set GuessesMade to 0
	GuessingGame(int LargestPossibleTargetValue);
	
	// Copy constructor
	// Copy all member data from rhs into the new object
	GuessingGame(const GuessingGame& rhs);

	// Copy assignment operator
	// Copy all member data from rhs into this object
	GuessingGame& operator =(const GuessingGame& rhs);

	// Remember "copy constructor" is not the same as "copy assignment operator"
	// GuessGame a;  
	// GuessingGame b = a;  // Uses copy constructor (b doesn't exist yet!)
	// b = a;               // Uses copy assignment operator (b exists!)

	// Simply increment the GuessesMade variable and nothing more
	void IncrementGuessCounter();

	// Simple get function
	int GetGuessesMade() const;

	// Is guess less than the target value?
	friend bool operator < (int guess, const GuessingGame& game);
	
	// Is guess greater than the target value?
	friend bool operator > (int guess, const GuessingGame& game);
	
	// Is guess not equal to the target value?
	friend bool operator !=(int guess, const GuessingGame& game);

private:
	// What number is the player trying to guess?
	int TargetValue;
	
	// How many guesses has the player made so far?
	int GuessesMade;
};