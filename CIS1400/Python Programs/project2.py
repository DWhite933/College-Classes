#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: Project 2
# File:       project2.py
# Purpose:    Grocery checkout program
#######################################################


print('\n***David White***\n')  # Display author's name


# main function
def main():
    endProgram = "N"

    while endProgram == "N":
        # declare variables

        # get number of items
        size = getNumitems()

        # arr to hold names of items
        items = [""] * size

        # arr to hold price of items
        price = [0.0] * size

        # get items and price
        items, price = getItemswPrice(items, price, size)

        # sort items arr
        mrSort = sortByLetter(items, price)

        # calculate subtotal
        subtotal = calcSubtotal(price, size)

        # calculate total
        total = calcTotal(subtotal)

        # show receipt
        printReceipt(total, subtotal, mrSort, size)

        # write to file
        writeToFile(total, subtotal, items, price, size)

        menuNum = menu()

        # ask if user wants to search items
        if menuNum == "Y":
            search(items, size)

        # otherwise ask if user wants to end program
        print("Do you want to end the program? (Y=Yes, N=No)")
        endProgram = input("---> ")

        # input validation
        if not (endProgram == "Y" or endProgram == "N"):
            print("Please enter Y for Yes or N for No")
            endProgram = input("---> ")
            # end if


def getNumitems():
    # ask user how many items are in their cart
    print("How many items are in your cart?")
    size = int(input("---> "))

    # input validation
    if size > 10 or size < 1:
        print("Please enter a number between 1 and 10")
        size = int(input("---> "))

    return size


def getItemswPrice(items, price, size):
    # reset counter
    counter = int(0)
    while counter < size:
        # ask user to enter the name of item
        print("Enter item #", counter + 1)
        items[counter] = str(input("---> "))

        # ask user to enter price of item
        print("Enter price of item #", counter + 1)
        price[counter] = float(input("---> "))

        # input validation
        if price[counter] < 0.01 or price[counter] > 10:
            print("Please enter a number between 0.01 and 10")
            price[counter] = float(input("---> "))

        # increment counter
        counter = counter + 1

        # end while
    return items, price


def sortByLetter(items, price):
    # sort items by letter ascending
    sort = sorted(zip(items, price))
    return sort


def calcSubtotal(price, size):
    # reset counter
    counter = int(0)

    # initialize subtotal var
    subtotal = float(0)

    # calculate subtotal
    while counter < size:
        subtotal = subtotal + price[counter]

        # increment counter
        counter = counter + 1
        # end while
    return subtotal


def calcTotal(subtotal):
    # calculate total
    total = subtotal * 1.0825  # <--- actual sales tax for glen ellyn
    return total


def printReceipt(total, subtotal, mrSort, size):
    # reset counter
    counter = int(0)

    # initialize tax var
    tax = float(0)

    # calculate tax
    tax = total - subtotal

    while counter < size:
        # show item and price
        print(mrSort[counter])

        # line for separation
        print()

        # increment counter
        counter = counter + 1
        # end while

    # show subtotal
    print("Subtotal: " + format(subtotal, '>.2f'))

    # show tax
    print("Tax: " + format(tax, '>.2f'))

    # show total
    print("Total: " + format(total, '>.2f'))


def writeToFile(total, subtotal, items, price, size):
    # reset counter
    counter = int(0)

    # open receipt.txt in append mode
    rec = open("receipt.txt", "a")

    # write receipt to receipt.txt
    while counter < size:
        # write items to receipt.txt
        rec.write(str(items[counter]) + '\n')

        # write price to receipt.txt
        rec.write(str(price[counter]) + '\n')

        # increment counter
        counter = counter + 1

        # end while

    # write subtotal to receipt.txt
    rec.write("Subtotal: " + str(subtotal) + '\n')

    # write total to receipt.txt
    rec.write("Total: " + str(total) + '\n')

    # close receipt.txt
    rec.close()


def menu():
    # ask user if they want to search
    print("Do you want to search your items? (Y=Yes, N=No)")
    menuNum = str(input("---> "))

    # input validation
    while not (menuNum == "Y" or menuNum == "N"):
        print("Please enter Y for Yes or N for No")
        menuNum = str(input("---> "))
        # end while
    return menuNum


def search(items, size):
    # initialize var

    # term to search for
    searchTerm = ""

    # var to hold subscript
    index = int(0)

    # loop control var
    again = "Y"

    while again == 'Y':

        # ask user what to search for
        print("Enter item you want to search for")
        searchTerm = str(input("---> "))

        # search for item
        index = binSearch(searchTerm, items, size)

        if index != 1:
            # show item if found
            print("Item Found: ", items[index])
        else:
            # show that item was not found
            print(searchTerm, "was not found")
            # end if

        # ask if user wants to search again
        print("Do you want to search again? (Y = Yes, N = No)")
        again = input("--> ")

        # input validation
        if not (again == "Y" or again == "N"):
            print("Please enter Y for Yes or N for No")
            again = input("--> ")

    # end while


def binSearch(searchTerm, items, size):
    # subscript of first element
    first = 0

    # subscript of last element
    last = size - 1

    # search value position
    position = -1

    # flag
    found = False

    while (not found) and (first <= last):

        # calculate midpoint
        middle = int((first + last) / 2)

        midpoint = items[middle]

        # value at midpoint?
        if midpoint == searchTerm:
            found = True
            position = middle

            # end if

        elif midpoint > searchTerm:
            last = middle - 1

            # end if

        else:
            first = middle + 1

            # end if

    return position


# call main
main()
