#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: Lab 1-4
# File:       lab1-4.py
# Purpose:    Average 3 test scores
#######################################################

print('\n**  David White  **\n')  # Display author's name

# Declare variables
StudentName = str(input('Enter student name. '))
DegreeName = str(input('Enter Degree name. '))
CreditsDegree = int(input('Enter the number of credits required for the degree. '))
CreditsTaken = int(input('Enter the number of credits taken. '))

# Process
CreditsLeft = CreditsDegree - CreditsTaken

# output
print('The student\'s name is ', StudentName)
print('The Degree name is ', DegreeName)
print('There are', CreditsLeft, 'credits left until graduation')
