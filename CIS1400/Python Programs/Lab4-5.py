#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: Lab 4-5
# File:       lab4-5.py
# Purpose:    
#######################################################

print('\n***David White***\n')  # Display author's name


# main function
def main():
    print('Program Start')
    monthlySales = getSales()
    salesIncrease = getIncrease()
    storeAmount = storeBonus(monthlySales)
    emplAmount = emplBonus(salesIncrease)
    printBonus(storeAmount, emplAmount)
    return


# get monthly sales
def getSales():
    monthlySales = float(input("Enter the monthly sales $"))
    return monthlySales


# get the percent increase in sales
def getIncrease():
    salesIncrease = float(input('Enter the percent of sales increase: '))
    salesIncrease = float(salesIncrease)
    salesIncrease = salesIncrease / 100
    return salesIncrease


# determine store bonus
def storeBonus(monthlySales):
    if monthlySales >= 110000:
        storeAmount = 6000
        return storeAmount
    elif monthlySales >= 100000:
        storeAmount = 5000
        return storeAmount
    elif monthlySales >= 90000:
        storeAmount = 4000
        return storeAmount
    elif monthlySales >= 80000:
        storeAmount = 3000
        return storeAmount
    else:
        storeAmount = 0
    return storeAmount


# determine employee bonus
def emplBonus(salesIncrease):
    if salesIncrease >= .05:
        emplAmount = 75
        return emplAmount
    elif salesIncrease >= .04:
        emplAmount = 50
        return emplAmount
    elif salesIncrease >= .03:
        emplAmount = 40
        return emplAmount
    else:
        emplAmount = 0
    return emplAmount


# display bonus info
def printBonus(storeAmount, emplAmount):
    print('The store bonus amount is $', storeAmount)
    print('The employee bonus amount is $', emplAmount)
    if storeAmount == 6000 and emplAmount == 75:
        print('Congrats! You have reached the highest bonus amounts possible!')
        return
    return


# call main
main()
