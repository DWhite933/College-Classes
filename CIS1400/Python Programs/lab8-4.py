#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: Lab 8-4
# File:       lab8-4.py
# Purpose:    test average calculator with input validation
#######################################################

print('\n***David White***\n')  # Display author's name


def main():
    # declare vars
    endProgram = "no"
    totalScores = int(0)
    averageScores = int(0)
    score = int(0)
    counter = int(1)

    # loop to run again
    while endProgram == "no":
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

        endProgram = input("Do you want to end the program? (yes/no) ")
        # end while
    while endProgram != "yes" and endProgram != "no":
        print("ERROR: Please enter yes or no")
        endProgram = input("Do you want to end the program? (yes/no)")
        # end while


# get number of students
def getNum():
    num = int(input("How many students took the test: "))

    while num > 30 or num < 2:
        print("ERROR: Please enter a number between 2 and 30")
        num = int(input("How many students took the test: "))
        # end while

    return num


# get scores
def getScores(totalScores, num, score, counter):
    for counter in range(0, num):
        score = int(input("Enter their score: "))

        while score > 100 or score < 0:
            print("ERROR: please enter a number between 0 and 100")
            score = int(input("Enter their score:"))
        totalScores = int(totalScores + score)
        # end for

    return totalScores


# calculate avg
def getAverage(totalScores, num):
    averageScores = totalScores / num
    return averageScores


# show avg
def printAverage(averageScores):
    print("The average test score is: " + format(averageScores, '>.2f'))
    # end mod


# call main
main()
