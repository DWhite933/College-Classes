# David White
# 9/19/2022
# CIS-2531
# Instructor: Carolyn England
# Assignment: Prime Numbers
# Description: Implement a python program to determine all the prime numbers up to a given
# user input integer value.

def isPrime(num):
    for i in range(2, int(num/2)):
        if (num % i) == 0:
            return False
    return True


def main():
    # ask user for upper limit
    maxNumber = int(input("Enter the highest number to check for prime numbers: "))

    # the total number of prime numbers
    totalPrimes = 0

    print(f'The prime numbers in the range of 2 to {maxNumber} are: ')
    for i in range(2, maxNumber + 1):
        if isPrime(i):
            print(i, end=' ')
            totalPrimes += 1
    print(f'\nThat is {totalPrimes} prime numbers!')


main()

# Enter the highest number to check for prime numbers: 100
# The prime numbers in the range of 2 to 100 are:
# 2 3 4 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
# That is 26 prime numbers!
