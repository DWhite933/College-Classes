#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: Lab 10-3
# File:       lab10-3.py
# Purpose:    energy efficiency savings
#######################################################

print('\n***David White***\n')  # Display author's name


# the main function
def main():
    endProgram = 'no'
    print()
    while endProgram == 'no':
        option = 0
        print()
        print('Enter 1 to enter in new data and store to file')
        print('Enter 2 to display data from the file')
        option = int(input('Enter now -> '))
        print()

        # declare variables
        pints = [0] * 7
        totalPints = 0
        averagePints = 0

        if option == 1:
            # function calls
            pints = getPints(pints)
            totalPints = getTotal(pints, totalPints)
            averagePints = getAverage(totalPints, averagePints)
            writeToFile(averagePints, pints)

        else:
            readFromFile(averagePints, pints)

        endProgram = input('Do you want to end program? (Enter no or yes): ')

        while not (endProgram == 'yes' or endProgram == 'no'):
            print()
            'Please enter a yes or no'
            endProgram = input('Do you want to end program? (Enter no or yes): ')


# the getPints function
def getPints(pints):
    counter = 0
    while counter < 7:
        pints[counter] = input('Enter pints collected: ')
        counter = counter + 1
    return pints


# the getTotal function
def getTotal(pints, totalPints):
    counter = 0
    while counter < 7:
        totalPints = totalPints + int(pints[counter])
        counter = counter + 1
    return totalPints


# the getAverage function
def getAverage(totalPints, averagePints):
    averagePints = float(totalPints) / 7
    return averagePints


# the writeToFile function
def writeToFile(averagePints, pints):
    outFile = open('blood.txt', 'a')
    outFile.write('Pints Each Hour\n')
    counter = 0

    while counter < 7:
        outFile.write(str(pints[counter] + '\n'))
        counter = counter + 1

    outFile.write('Average Pints\n')
    outFile.write(str(averagePints) + '\n\n')
    outFile.close()


# the readFromFile function
def readFromFile(averagePints, pints):
    inFile = open('blood.txt', 'r')
    str1 = inFile.read()
    print(str1)
    print()  # blank line for separation
    pints = inFile.read()
    print(pints)
    print()  # blank line for separation
    str2 = inFile.read()
    print(str2)
    inFile.close()


# calls main
main()
