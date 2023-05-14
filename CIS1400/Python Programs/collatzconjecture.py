#######################################################
# Name:       David White
# File:       collatzconjecture.py
# Purpose:
#######################################################

import pyinputplus as pyip
import random as rand

print('\n***David White***\n')  # Display author's name


# main function
def main():
    # ask user for the starting number
    startNumber = pyip.inputInt(prompt='Enter a number (enter zero for random number): ', min=0)
    print()
    # typecast startNumber to int
    int(startNumber)
    # choose random number
    if startNumber == 0:
        startNumber = rand.randint(0, 10_000)
    print(startNumber)
    # start collatz sequence
    beginCollatz(startNumber)


def printInfo(maxNumber, iterations):
    print()
    print("Highest number reached: " + str(maxNumber))
    print("Number of iterations: " + str(iterations))
    exit(0)


def collatz(currentNumber, maxNumber, iterations):
    if currentNumber == 1:
        printInfo(maxNumber, iterations)
    elif isEven(currentNumber):
        currentNumber //= 2
    else:
        currentNumber = 3 * currentNumber + 1
    print(currentNumber)
    # check max number
    if currentNumber > maxNumber:
        maxNumber = currentNumber
    iterations += 1
    collatz(currentNumber, maxNumber, iterations)


def beginCollatz(startNumber):
    maxNumber: int = startNumber
    currentNumber: int = startNumber
    iterations = 1
    if currentNumber == 1:
        printInfo(maxNumber, iterations)
    elif isEven(currentNumber):
        currentNumber //= 2
    else:
        currentNumber = 3 * currentNumber + 1
    print(currentNumber)
    # check max number
    if currentNumber > maxNumber:
        maxNumber = currentNumber
    collatz(currentNumber, maxNumber, iterations)


# check if number is even
def isEven(number):
    if number % 2 == 0:
        return True
    else:
        return False


# call main
if __name__ == '__main__':
    main()
