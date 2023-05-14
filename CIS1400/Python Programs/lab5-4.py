#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: Lab 5-4
# File:       lab5-4.py
# Purpose:    Bottle return program
#######################################################

print('\n***David White***\n')  # Display author's name


# main function
def main():
    endProgram = 'no'
    while endProgram == 'no':
        totalBottles = getBottles()
        totalPayout = calcPayout(totalBottles)
        printInfo(totalPayout, totalBottles)
        endProgram = input(print('Do you want to end the program? y/n'))
        # end while
    return


# get the number of bottles
def getBottles():
    totalBottles = 1
    counter = 0
    while counter < 7:
        todayBottles = int(input('Enter the number of bottles for today: '))
        totalBottles = totalBottles + todayBottles
        counter = counter + 1
    # end While
    return totalBottles


# calculate payout
def calcPayout(totalBottles):
    totalPayout = 0
    totalPayout = totalBottles * .10
    return totalPayout


# display info
def printInfo(totalBottles, totalPayout):
    print('The total number of bottles collected is', totalPayout)  # the variables are switched for some reason
    print('The total paid out is $', totalBottles)  # i've set it so it makes sense in the program
    return


# call main
main()
