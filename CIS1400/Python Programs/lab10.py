#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: Week 11 homework
# File:       lab10.py
# Purpose:    sort and search names
#######################################################

print('\n***David White***\n')  # Display author's name


print("i know you said you wanted more comments")
print("so")
print("I")
print("added")
print("a")
print("ton")
print('more')


# main module
def main():
    # declare variables

    # array for list of names
    names = ["0"] * 20  # <-- that's a lotta names

    # number of array lookups during binary search
    lookUpnum = int(0)

    # function calls

    # ask user for names
    names = getNames(names)

    # sort names
    bubbleSort(names)

    # show sorted names
    showNames(names)

    # search name array
    search(names, lookUpnum)


# module for getting list of names
def getNames(names):
    # reset counter
    counter = int(0)

    # ask user for names
    while counter < 20:
        names[counter] = str(input("Enter name: "))

        # increment counter
        counter = counter + 1
    return names


# show sorted list of names
def showNames(names):
    print("the sorted names are:")

    # shows sorted names
    print(*names, sep="\n")


# sort name array
def bubbleSort(names):
    # this variable contains the subscript of the last element to compare
    maxElement = len(names) - 1

    # outer loop makes maxElement the last element to compare for each pass through the array. maxElement is initially
    # the index of the last element in the array
    while maxElement >= 0:

        # counter for inner loop
        index = 0

        # the inner loop steps through the array comparing each element with its neighbor
        while index <= maxElement - 1:
            if names[index] > names[index + 1]:
                # if two elements are out of order, they swap
                temp = names[index]
                names[index] = names[index + 1]
                names[index + 1] = temp
                # end if

            # increment index
            index = index + 1
            # end while

        # decrement maxElement
        maxElement = maxElement - 1
        # end while


def search(names, lookUpnum):
    # loop control var
    again = "Y"

    while again == "Y" or again == "y":

        # ask user for name to search for
        searchTerm = str(input("Enter a name to search: "))

        # search for name and get number of array lookups
        # module inside modules!
        # module inception!
        index, lookUpnum = binSearch(names, searchTerm, lookUpnum)

        if index == -1:
            # show that name was not found in array
            print(searchTerm, " was not found")

            # show number of array lookups
            print("Array lookups:", lookUpnum)

        else:
            # show name if found
            print("Name found:", names[index])

            # show name position in array
            print("Position:", index)

            # show number of array lookups
            print("Array Lookups:", lookUpnum)

            # end if

        # ask if user wants to search again
        again = str(input("Do you want to search again? (Y=Yes, N=No) "))

        # end while


def binSearch(names, searchTerm, lookUpnum):
    # subscript of first element
    first = 0

    # subscript of last element
    last = len(names) - 1

    # search value position
    position = -1

    # flag
    found = False

    while (not found) and (first <= last):

        # calculate midpoint
        middle = int((first + last) / 2)

        # for some reason the program won't work unless i do this
        # Thanks StackOverflow!
        # https://stackoverflow.com/questions/34327244/binary-search-through-strings
        # i even copied straight from the book and it still didn't work
        # so that might be an error on their part
        midpoint = names[middle]

        # value at midpoint?
        if midpoint == searchTerm:
            found = True
            position = middle

            # increment array lookup counter
            lookUpnum = lookUpnum + 1

            # end if

        elif midpoint > searchTerm:
            last = middle - 1

            # increment array lookup counter
            lookUpnum = lookUpnum + 1

            # end if

        else:
            first = middle + 1

            # increment array lookup counter
            lookUpnum = lookUpnum + 1

            # end if

    return position, lookUpnum


# call main
main()
