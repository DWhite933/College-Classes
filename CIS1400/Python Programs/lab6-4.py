#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: Lab 6-4
# File:       lab6-4.py
# Purpose:    test average calculator
#######################################################

print('\n***David White***\n')  # Display author's name


def main():
    # declare vars
    endProgram = 'n'
    totalScores = int(0)
    averageScores = int(0)
    score = int(0)
    counter = int(1)

    # loop to run again
    while endProgram == 'n':
        # reset vars
        totalScores = 0
        averageScores = 0
        counter = 1
        score = 0

        # call functions
        num = getNum()
        totalScores = getScores(totalScores, num, score, counter)
        averageScores = getAverage(totalScores, num)
        printAverage(averageScores)

        endProgram = input('Do you want to end the program? (y/n) ')
        # end while


# get number of students
def getNum():
    num = int(input('How many students took the test: '))
    return num


# get scores
def getScores(totalScores, num, score, counter):
    for counter in range(0, num):
        score = int(input('Enter their score: '))
        totalScores = int(totalScores + score)
        # end for
    return totalScores


# calculate avg
def getAverage(totalScores, num):
    averageScores = totalScores / num
    return averageScores


# show avg
def printAverage(averageScores):
    print('The average test score is: ' + format(averageScores, '>.2f'))
    # end mod


# call main
main()
