#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: Lab 2-6
# File:       lab2-6.py
# Purpose:    calculate a 20% tip and a 6% tax on a meal price.
#######################################################

print('\n***David White***\n')  # Display author's name


# This program uses functions and variables

# the main function
def main():
    print('Welcome to the meal calculator program')
    print()  # prints a blank line
    mealPrice = inputMeal()
    tip = calcTip(mealPrice)
    tax = calcTax(mealPrice)
    total = calcTotal(mealPrice, tip, tax)
    printInfo(mealPrice, tip, tax, total)
    return


# user input fuction
def inputMeal():
    mealPrice = input('Enter the meal price $')
    mealPrice = float(mealPrice)
    return mealPrice


# calculates 20% tip
def calcTip(mealPrice):
    tip = float(mealPrice * .20)
    return tip


# calculates 6% tax
def calcTax(mealPrice):
    tax = float(mealPrice * .06)
    return tax


# calculates the total
def calcTotal(mealPrice, tip, tax):
    total = mealPrice + tip + tax
    return total


# displays tip, tax and the total
def printInfo(mealPrice, tip, tax, total):
    print('The meal price is $', mealPrice)
    print('The tip is $', tip)
    print('The tax is $' + format(tax, '>.2f'))
    print('The total is $', total)
    return


# calls main
main()
