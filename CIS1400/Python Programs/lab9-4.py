#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: Lab 9-4
# File:       lab9-4.py
# Purpose:    calculate avg number of pints of blood donated
#######################################################

print('\n***David White***\n')  # Display author's name


# the main function
def main():
    endProgram = 'no'
    print()
    while endProgram == 'no':
        print()
        # declare variables
        pints = [0] * 7

        # function calls
        pints = getPints(pints)
        totalPints = getTotal(pints)
        avgPints = getAvg(totalPints)
        maxPints = getMax(pints)
        minPints = getMin(pints)
        printInfo(maxPints, avgPints, minPints)

        # input validation
        endProgram = input('Do you want to end program? (Enter no or yes): ')
        while not (endProgram == 'yes' or endProgram == 'no'):
            print('Please enter a yes or no')
            endProgram = input('Do you want to end program? (Enter no or yes): ')


# the getPints function
def getPints(pints):
    # reset counter
    counter = 0

    while counter < 7:
        # get pints
        pints[counter] = int(input("Enter pints collected: "))

        # increment counter
        counter = counter + 1

        # end while
    return pints


# get total number of pints
def getTotal(pints):
    # reset counter
    counter = 0

    # initialize variable
    totalPints = 0

    # get total
    while counter < 7:
        totalPints = totalPints + pints[counter]

        # increment counter
        counter = counter + 1

        # end while
    return totalPints


# get average number of pints
def getAvg(totalPints):
    # calculate average
    avgPints = totalPints / 7
    return avgPints


# get highest number of pints
def getMax(pints):
    minPints = pints[0]

    # reset counter
    counter = 1

    while counter < 7:
        if pints[counter] > minPints:
            minPints = pints[counter]

            # end if

        # increment counter
        counter = counter + 1
    # end while
    return minPints


# get lowest number of pints
def getMin(pints):
    minPints = pints[0]

    # reset counter
    counter = 1

    while counter < 7:
        if pints[counter] < minPints:
            minPints = pints[counter]
            # end if

        # increment counter
        counter = counter + 1

        # end while
    return minPints


# the displayInfo function
def printInfo(maxPints, avgPints, minPints):
    print()
    print("the average number of pints donated is", avgPints)
    print("the highest pints donated is", maxPints)
    print("the lowest pints donated is", minPints)


# calls main
main()
