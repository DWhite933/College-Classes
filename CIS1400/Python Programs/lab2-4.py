#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: Lab 2
# File:       Lab2-4.py
# Purpose:    Demonstrate various ways to use functions in python
#######################################################

print('\n***David White***\n')  # Display author's name


# main fuction
def main():
    welcomeMessage()  # causes weleome message to run
    goodbye()  # says goodbye
    return


# This function is to welcome people to my program
def welcomeMessage():
    print('Welcome to my program using functions')
    print('My name is David White')
    return


# This function signals the end of my program
def goodbye():
    print('This is the end, goodbye!')
    return


# This is  the main fuction that starts the program
main()  # calls main
