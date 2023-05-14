#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: Lab 2-7
# File:       Lab 2-7.py
# Purpose:    Find the amount of sales tax
#######################################################

print('\n***David White***\n')  # Display author's name


# main function
def main():
    print('Welcome to the tax calculator program')
    print()
    totalSales = inputSales()
    countyTax = calcCounty(totalSales)
    stateTax = calcState(totalSales)
    totalTax = calcTotalTax(stateTax, countyTax)
    printInfo(countyTax, stateTax, totalTax)
    return


# user input fuction
def inputSales():
    totalSales = input('Enter total sales for the month: $')
    totalSales = float(totalSales)
    return totalSales


# calculates 2% county tax
def calcCounty(totalSales):
    countyTax = float(totalSales * .02)
    return countyTax


# calculates 4% state tax
def calcState(totalSales):
    stateTax = float(totalSales * .04)
    return stateTax


# calculates the total tax
def calcTotalTax(stateTax, countyTax):
    totalTax = stateTax + countyTax
    return totalTax


# displays the totals
def printInfo(countyTax, stateTax, totalTax):
    print('The county tax is $' + format(countyTax, '>.2f'))
    print('The state tax is $' + format(stateTax, '>.2f'))
    print('The total tax owed is $', totalTax)
    return


# call main
main()
