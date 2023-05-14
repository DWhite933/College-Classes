#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: Lab 10-4
# File:       lab10-4.py
# Purpose:    energy efficiency savings
#######################################################

print('\n***David White***\n')  # Display author's name


# main function
def main():
    # declare variables and arrays

    # loop control var
    endProgram = "no"

    # array for costs before going green
    notGreencost = [0] * 12

    # array for costs after going green
    goneGreencost = [0] * 12

    # array for savings
    savings = [0] * 12
    months = ['January', 'February', 'March', 'April', 'May', 'June', 'July',
              'August', 'September', 'October', 'November', 'December']

    # decision control
    option = int(0)

    while endProgram == "no":

        # ask user for input
        print('Enter 1 to enter data')
        print("Enter 2 to show info")
        print("Enter 3 to write to savings1.txt")
        print("Enter 4 to show savings1.txt")
        option = int(input('Enter number: '))


        if option == 1:

            # user enters data before going green
            notGreencost = getNotgreen(notGreencost, months)

            # user enters data after going green
            goneGreencost = getGonegreen(goneGreencost, months)

            # calculate savings
            savings = energySaved(notGreencost, goneGreencost, savings)
            # end if

        elif option == 2:
            printInfo(notGreencost, goneGreencost, savings, months)
            # end if

        elif option == 3:
            writeToFile(months, savings)
            print('Data written to savings1.txt')
            print()
            # end if

        elif option == 4:
            readFromFile(months, savings)
            print()
            # end if

        endProgram = input("Do you want to end program? Enter yes or no: ")
        print()

        while not (endProgram == 'yes' or endProgram == 'no'):
            print('Please enter yes or no')
            endProgram = input('Do you want to end program? (Enter no or yes): ')
            print()


# get cost before going green
def getNotgreen(notGreencost, months):
    # reset counter
    counter = 0

    while counter < len(months):
        print("Enter NOT GREEN energy costs for", months[counter])
        notGreencost[counter] = input("--> ")

        # increment counter
        counter = counter + 1

        # extra line for separation
        print()

        # end while

    return notGreencost


# get cost after going green
def getGonegreen(goneGreencost, months):
    # reset counter
    counter = 0

    while counter < len(months):
        print("Enter GONE GREEN energy costs for", months[counter])
        goneGreencost[counter] = input("--> ")

        # increment counter
        counter = counter + 1

        # extra line for separation
        print()

        # end while

    return goneGreencost


# calculate savings
def energySaved(notGreencost, goneGreencost, savings):
    # reset counter
    counter = 0

    while counter < len(savings):
        savings[counter] = float(notGreencost[counter]) - float(goneGreencost[counter])

        # increment counter
        counter = counter + 1
        # end while

    return savings


def writeToFile(months, savings):
    # reset counter
    counter = int(0)

    # open savings1.txt in append mode
    outFile = open("savings1.txt", "a")

    # write "savings" in savings.txt
    outFile.write("Savings\n")

    # write each months savings to savings1.txt
    while counter < 12:
        outFile.write(months[counter] + '\n')
        outFile.write(str(savings[counter]) + '\n')

        # increment counter
        counter = counter + 1
        # end while
    # close savings.txt
    outFile.close()


def readFromFile(months, savings):
    # open savings1.txt in read mode
    inFile = open("savings1.txt", "r")
    str1 = inFile.read()
    print(str1)
    months = inFile.read()
    print(months)
    savings = inFile.read()
    print(savings)
    inFile.close()


# show info
def printInfo(notGreencost, goneGreencost, savings, months):
    # reset counter
    counter = 0

    while counter < 12:
        # print extra line for separation
        print()

        # displays month
        print("Information for", months[counter])

        # displays savings for current month
        print("Savings: $", savings[counter])

        # displays cost before going green
        print("Not Green Costs: $", notGreencost[counter])

        # displays cost after going green
        print("Gone Green Costs: $", goneGreencost[counter])

        # extra line for separation
        print()

        # increment counter
        counter = counter + 1

        # end while


# call main
main()
