#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: Lab 3-4
# File:       lab3-4.py
# Purpose:    Demonstrate how to use decision statements
#######################################################

print('\n***David White***\n')  # Display author's name


# main fuction
def main():
    print('This program determines if a bonus should be awarded')
    print()
    monthlySales = getSales()
    checkBonus(monthlySales)
    checkDay(monthlySales)
    return


# get the montly sales
def getSales():
    monthlySales = float(input('Enter the monthly sales: $'))
    return monthlySales


# check for bonus
def checkBonus(monthlySales):
    if monthlySales >= 100000:
        print('You have earned a $5,000 bonus!!!')
    return


# check for day off
def checkDay(monthlySales):
    if monthlySales >= 112500:
        print('You have earned a day off!!!')
    return


# call main
main()
