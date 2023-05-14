#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: Lab 1-5
# File:       lab1-5.py
# Purpose:    Calculate the avergage number of wins during a 5 year period
#######################################################

print('\n**  David White  **\n')  # Display author's name

# Declare Variables
WYear1 = int(input('Enter number of wins from year 1. '))
WYear2 = int(input('Enter number of wins from year 2. '))
WYear3 = int(input('Enter number of wins from year 3. '))
WYear4 = int(input('Enter number of wins from year 4. '))
WYear5 = float(input('Enter number of wins from year 5. '))

# calculate average
AvgWin = (WYear1 + WYear2 + WYear3 + WYear4 + WYear5) / 5

# output
print('You have won an average of', AvgWin, 'games per year.')
