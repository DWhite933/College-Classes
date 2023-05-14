#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: Lab 8-5
# File:       lab8-5.py
# Purpose:    calculate data overage charges
#######################################################

print('\n***David White***\n')  # Display author's name


# main function
def main():
    endProgram = "no"

    while endProgram == "no":

        # reset vars
        GBAllowed = int(0)
        GBUsed = int(0)
        totalDue = float(0)
        GBOver = int(0)

        # call functions
        GBAllowed = getAllowed()
        GBUsed = getUsed()
        totalDue, GBOver = calcTotal(GBAllowed, GBUsed)
        printData(GBAllowed, GBUsed, totalDue, GBOver)

        # check if user wants to end program
        endProgram = str(input("Do you want to end the program? yes or no:"))

        # input validation
        while endProgram != "yes" and endProgram != "no":
            print("Please enter yes or no")
            endProgram = str(input("Do you want to edn the program? yes or no:"))
            # end while

        # end while


# get number of GBs allowed
def getAllowed():
    GBAllowed = int(input("How many GBs are allowed:"))

    # input validation
    while GBAllowed < 10 or GBAllowed > 50:
        print("Please enter a number between 10 and 50")
        GBAllowed = int(input("How many GBs are allowed:"))
        # end while

    return GBAllowed


# get number of GBs used
def getUsed():
    GBUsed = int(input("How many GBs were used:"))


    # input validation
    while GBUsed < 0:
        print("Please enter a number of at least 0")
        GBUsed = int(input("How many GBs were used:"))
        # end while
    return GBUsed


# calculate total
def calcTotal(GBAllowed, GBUsed):
    if GBUsed <= GBAllowed:
        totalDue = float(74.99)
        GBOver = 0
        print("You were not over your GBs for the month")
    else:
        GBOver = GBUsed - GBAllowed
        extra = float(GBOver * 4.44)
        totalDue = float(74.99 + extra)
        print("You were over your GBs by", GBOver)
        # end if
    return totalDue, GBOver


# show info
def printData(GBAllowed, GBUsed, totalDue, GBOver):
    print("----------------MONTHLY USE REPORT----------------------")
    print("GBs allowed were", GBAllowed)
    print("GBs used were", GBUsed)
    print("GBs over were", GBOver)
    print("Total due is $", totalDue)


# call main
main()
