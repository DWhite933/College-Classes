#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: Lab 9-5
# File:       lab9-5.py
# Purpose:    energy efficiency savings
#######################################################

print('\n***David White***\n')  # Display author's name


def main():
    endProgram = "no"
    print()
    while endProgram == "no":
        print()
        # declare variables and arrays
        notGreencost = [0] * 12
        goneGreencost = [0] * 12
        savings = [0] * 12
        months = ['January', 'February', 'March', 'April', 'May', 'June', 'July',
                  'August', 'September', 'October', 'November', 'December']

        # function calls
        notGreencost = getNotgreen(notGreencost, months)
        goneGreencost = getGonegreen(goneGreencost, months)
        savings = energySaved(notGreencost, goneGreencost, savings)
        printInfo(notGreencost, goneGreencost, savings, months)

        # input validation
        endProgram = input("Do you want to end program? Enter yes or no")
        while not (endProgram == "yes" or endProgram == "no"):
            print("please enter a yes or no")
            endProgram = input("Do you want to end program? Enter yes or no")
            # end while

        # end while


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
