// ------------------------------------------------------------------------------------------------
// Create a Guesser class that works with the code found below:
//      * Member variable
//            - Holds the value you're trying to guess
//      * Appropriate constructor
//            - Sets the member variable to a random number between [1 and 15] inclusive
//      * MakeGuess function
//            - If the guess matches the member variable, do the following:
//                     - Print "You got it!  Lucky you!  I'm outta here!"
//                     - Return true
//            - If the guess is 0, do the following:
//                     - Print "Who would ever pick zero?  That would be cheating or something!"
//                     - Print "Just for that I'm going to think up a new number for you!"
//                     - Set the member variable to a new random number between [1 and 15] inclusive
//                     - Return false
//            - If the guess doesn't match the member variable, do the following:
//                     - Print "Nope!  That's not it!"
//                     - Return false
//     * Follow all encapsulation and data hiding rules discussed in lecture and previous homework
//     * Make sure to create a Guesser.h and Guesser.cpp file that works with this runner file
//     * DO NOT MODIFY ANYTHING FOUND IN THIS RUNNER FILE
// ------------------------------------------------------------------------------------------------

#include <ctime>
#include <iostream>
#include <stdlib.h>
#include "Guesser.h"

int main()
{
    srand(static_cast<unsigned int>(time(nullptr)));

    std::cout << "Guess my number, won't ya?!" << std::endl;

    int guess;
    Guesser g;
    do
    {
        std::cout << "Enter your guess: ";
        std::cin >> guess;
    } while (g.MakeGuess(guess) == false);

    return 0;
}

// EXAMPLE OUTPUT FOR THIS PROGRAM
/*
Guess my number, won't ya?!
Enter your guess: 7
Nope!  That's not it!
Enter your guess: -8
Nope!  That's not it!
Enter your guess: 0
Who would ever pick zero?  That would be cheating or something!
Just for that I'm going to think up a new number for you!
Enter your guess: 5
Nope!  That's not it!
Enter your guess: 4
Nope!  That's not it!
Enter your guess: 7
You got it!  Lucky you!  I'm outta here!
Press any key to continue . . .
*/