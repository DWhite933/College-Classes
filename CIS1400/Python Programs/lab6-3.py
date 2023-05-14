#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: Lab 6-3
# File:       lab6-3.py
# Purpose:    practice for loops
#######################################################

print('\n***David White***\n')  # Display author's name


# main function
def main():
    # basic for loop
    print('I will display the number 1 through 5')
    for num in [1, 2, 3, 4, 5]:
        print(num)
        # end for
    print()

    # second counter code
    for seconds in range(1, 61):
        print('The second is', seconds)
        # end for
    print()

    # accumulator
    total = int(0)
    for counter in range(5):
        number = int(input('Enter a number: '))
        total = total + number
        # end for
    print('The total is:', total)
    print()

    # average age
    totalAge = int(0)
    numbers = int(input('How many ages do you want to enter: '))
    for counter in range(0, numbers):
        age = int(input('Enter an age: '))
        totalAge = totalAge + age

    averageAge = int(totalAge / numbers)
    print('the average age is:', averageAge)


# call main
main()
