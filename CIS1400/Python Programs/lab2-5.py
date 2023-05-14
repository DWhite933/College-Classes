#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: Lab 2-5
# File:       lab2-5.py
# Purpose:    Demonstrate how to use variables and functions
#######################################################

print('\n***David White***\n')  # Display author's name


# main fuction
def main():
    print('Welcome to the variable program')
    print()

    name = inputName()
    age = inputAge()
    print('Hello', name)
    print('You are', age, 'years old')
    return


# this function inputs name
def inputName():
    name = input("Enter your name: ")
    return name


# this function inputs age
def inputAge():
    age = input("Enter your age: ")
    return age


# call main
main()
