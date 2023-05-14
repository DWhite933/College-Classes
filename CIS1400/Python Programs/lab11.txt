#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: Chapter 11 program ex. 6
# File:       lab11.py
# Purpose:    Phone book
#######################################################

print('\n***David White***\n')  # Display author's name

# used for changing file name
import os


# main function
def main():
    # menu control var
    menuNum = int(0)

    # user presses 5 to end program
    while menuNum != 5:
        # shows menu
        menuNum = menu(menuNum)

        if menuNum == 1:
            # user presses 1 to add a new number
            addRecord()

            # extra line for clarity
            print()

        elif menuNum == 2:
            # user presses 2 to search for a number
            nameSearch()

            # extra line for clarity
            print()

        elif menuNum == 3:
            # user presses 3 to change a number
            changeNum()

            # extra line for clarity
            print()

        elif menuNum == 4:
            # user presses 4 to delete a number
            deleteRecord()

            # extra line for clarity
            print()

        while menuNum < 1 or menuNum > 5:
            # input validation
            print("Please enter a number between 1 and 5")
            print()
            break
            # end if


# menu function
def menu(menuNum):
    # show menu
    print("1. Add a new record")
    print("2. Search for a name")
    print("3. Modify a Phone number")
    print("4. Delete a number")
    print("5. Exit Program")

    # line separation for clarity
    print()

    # ask for user input
    menuNum = int(input("Please enter a number: "))

    return menuNum


def addRecord():
    # var for storing a name
    name = ""

    # var for storing phone numbers
    number = ""

    # number of phone numbers to be stored
    nameNum = int(0)

    # loop counter
    counter = int(0)

    # open phonebook.txt in append mode
    outFile = open("phonebook.txt", "a")

    # ask user how many number to store
    print("How many numbers do you want to store?")
    nameNum = int(input("--> "))

    while counter < nameNum:
        # user enters name
        print("Enter name #", (counter + 1))
        name = str(input("--> "))

        # user enters phone number
        print("Enter number for", name)
        number = str(input("--> "))

        # write information to phonebook.txt
        outFile.write(name + ',' + number + '\n')

        # increment counter
        counter = counter + 1
        # end while

    # close phonebook.txt
    outFile.close()

    # show where data was written to
    print("Data written to phonebook.txt")


def nameSearch():
    # var containing names
    name = ""

    # var containing phone numbers
    number = ""

    # value to search for
    searchTerm = ""

    # flag
    found = False

    # reset counter
    counter = int(0)

    # open phonebook.txt in read mode
    inFile = open("phonebook.txt", "r")

    # used to find eof
    lines = inFile.readlines()

    # ask user what to search for
    print("Enter a name to search: ")
    searchTerm = input("--> ")

    while counter < len(lines):
        # parse through line
        name, number = parseRecord(lines[counter])

        print(number)
        # if name was found display name and number
        if searchTerm == name:
            print(name, "'s phone number is", number)

            found = True
            break
        counter = counter + 1

    if not found:
        # show name was not found
        print(searchTerm, "was not found")

    # close file
    inFile.close()


def changeNum():
    # var for storing a name
    name = ""

    # var for storing phone numbers
    number = ""

    # owner of phone number to be changed
    searchTerm = ""

    # flag
    found = False

    # the number to change to
    newNum = ""

    # open phonebook.txt in read mode
    phone = open("phonebook.txt", "r")

    # creates and opens a temporary file to write to
    temp = open("temp.txt", "a")

    # used to get records
    lines = phone.readlines()

    # reset counter
    counter = int(0)

    # ask user who's number to change
    searchTerm = input("Enter owner of new number: ")

    # ask user for new number
    newNum = input("Enter new phone Number: ")

    while counter < len(lines):
        # parse through line
        name, number = parseRecord(lines[counter])

        # if name was found change number
        if searchTerm == name:
            temp.write(name + "," + newNum + '\n')

            # load next record
            lines = phone.readline()
        else:
            # otherwise write to temp
            temp.write(name + "," + number + '\n')

            # load next record
            lines = phone.readline()
            # end if

        # increment counter
        counter = counter + 1

        # end while

    # close files when done
    phone.close()
    temp.close()

    # change temp to phonebook
    os.remove("phonebook.txt")
    os.rename("temp.txt", "phonebook.txt")

    # show where data was writen to
    print("phonebook.txt updated")


def deleteRecord():
    # var for storing a name
    name = ""

    # var for storing phone numbers
    number = ""

    # owner of phone number to be changed
    searchTerm = ""

    # flag
    found = False

    # open phonebook.txt in read mode
    phone = open("phonebook.txt", "r")

    # creates and opens a temporary file to write to
    temp = open("temp.txt", "a")

    # used to get records
    lines = phone.readlines()

    # ask user who's number to change
    searchTerm = input("Enter owner of number to delete: ")

    # counter
    counter = 0


    while counter < len(lines):
        # parse through line
        name, number = parseRecord(lines[counter])

        # if name was found replace number
        if searchTerm != name:
            temp.write(name + "," + number + '\n')

        # increment counter
        counter = counter + 1

        # end while

    # close files when done
    phone.close()
    temp.close()

    # change temp to phonebook
    os.remove("phonebook.txt")
    os.rename("temp.txt", "phonebook.txt")

    # show where data was writen to
    print("phonebook.txt updated")


def parseRecord(lines):
    # parse record
    i = 0
    j = lines.find(",", i)
    names = lines[i:j]
    i = j + 1  # character after comma
    j = lines.find(",", i)
    number = lines[i:j]
    return names, number


# call main
main()
