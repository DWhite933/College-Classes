#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: Lab 5-5
# File:       lab5-5.py
# Purpose:    Calculate the cost of a meal
#######################################################

print('\n***David White***\n')  # Display author's name


# main function
def main():
    endProgram = 'n'
    endOrder = 'n'
    totalBurger = 0
    totalFry = 0
    totalSoda = 0
    tax = 0
    subtotal = 0
    total = 0

    while endProgram == 'n':
        resetVariables(totalBurger, totalFry, totalSoda, total, tax, subtotal)
        while endOrder == 'n':
            print('Enter 1 for Yum Yum burger')
            print('Enter 2 for Grease Yum fries')
            print('Enter 3 for Soda Yum')
            option = int(input('Enter order number: '))
            if option == 1:
                totalBurger = getBurger()
            elif option == 2:
                totalFry = getFry()
            elif option == 3:
                totalSoda = getSoda()
            endOrder = str(input("Do you want to end the order? y/n: "))
        total = calcTotal(totalBurger, totalFry, totalSoda)
        printReceipt(total)
        endProgram = str(input('Do you want to end the program? y/n: '))


# var reset function
def resetVariables(totalBurger, totalFry, totalSoda, total, tax, subtotal):
    totalBurger = 0
    totalFry = 0
    totalSoda = 0
    total = 0
    tax = 0
    subtotal = 0
    return totalBurger, totalFry, totalSoda, total, tax, subtotal


# get burger info
def getBurger():
    burgerCount = int(input("Enter the number of burgers you want: "))
    totalBurger = burgerCount * .99
    return totalBurger


# get fry info
def getFry():
    fryCount = int(input("Enter the number of fries you want: "))
    totalFry = fryCount * .79
    return totalFry


# get soda info
def getSoda():
    sodaCount = int(input("Enter the number of sodas you want: "))
    totalSoda = sodaCount * 1.09
    return totalSoda


# calculate Total
def calcTotal(totalBurger, totalFry, totalSoda):
    subtotal = totalBurger + totalFry + totalSoda
    tax = subtotal * .06
    total = subtotal + tax
    return total, tax, subtotal


# show receipt
def printReceipt(total):
    print('Your total is $', total)
    return


# call main
main()
