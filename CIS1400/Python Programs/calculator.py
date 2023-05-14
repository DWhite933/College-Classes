#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: N/A
# File:       calculator.py
# Purpose:    basic calculator
#######################################################

print('\n***David White***\n')  # Display author's name


# main function
def main():
    again = "no"

    while again == "no":
        # initialize menu var
        operation = int(0)

        # print menu and get operation
        operation = menu()

        if operation == 1:
            add()
        elif operation == 2:
            sub()
        elif operation == 3:
            mult()
        elif operation == 4:
            div()
        else:
            print("Please enter a number between 1 and 4")
            operation = input("Enter number")


def menu():
    print("1. Add")
    print("2. Subtract")
    print("3. Multiply")
    print("4. Divide")
    menuNum = input("Enter number: ")
    return menuNum


def add():
    print("How Many number do you want to add?")
    size = int(input("Enter now: "))
    num = [0.0] * size
    total = float(0)
    for i in num:
        total = i + total

    return total


def sub():
    num1 = int(0)


def mult():
    num1 = int(0)


def div():
    num1 = int(0)


# call main
main()
