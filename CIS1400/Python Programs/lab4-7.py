#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: Lab 4-7
# File:       lab4-7.py
# Purpose:    calculate a tip and a 6% tax on a meal price.
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


# user input function
def inputMeal():
    mealPrice = input('Enter the meal price $')
    mealPrice = float(mealPrice)
    return mealPrice


# calculates 20% tip
def calcTip(mealPrice):
    if mealPrice >= 25.01:
        tip = mealPrice * .22
        return tip
    elif mealPrice >= 17.01:
        tip = mealPrice * .19
        return tip
    elif mealPrice >= 6:
        tip = mealPrice * .13
        return tip
    else:
        tip = mealPrice * .10
        return tip
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
    print('The tip is $' + format(tip, '>.2f'))
    print('The tax is $' + format(tax, '>.2f'))
    print('The total is $' + format(total, '>.2f'))
    return


# calls main
main()
