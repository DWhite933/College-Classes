import time
import random as rng
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sb


# David White
# 2023/02/20
# CIS-2532
# Instructor: Mohammad Morovati
# Assignment: Homework 5
# Description:
# There are various sorting algorithms available to sort data of different sizes. Three of these
# algorithms are Bubble sort, Shell sort, and Quicksort. Write a program to generate random
# integer numbers of multiple sizes; 10000, 30000, 50000, 70000, and 90000, and find out which
# of these sorting algorithms perform the fastest sorting technique. You can write the sorting
# program yourself or use an existing sorting program that you can find on the Internet and modify
# them to fit your need. Provide data to prove and support your findings by plotting a line graph
# showing the time each takes to sort data of various sizes.


# Sorting algorithms obtained from geeksforgeeks.org
def shellSort(arr):
    # Start with a big gap, then reduce the gap
    n = len(arr)
    gap = int(n // 2)

    # Do a gapped insertion sort for this gap size.
    # The first gap elements a[0...gap-1] are already in gapped
    # order keep adding one more element until the entire array
    # is gap sorted
    while gap > 0:

        for i in range(gap, n):

            # add a[i] to the elements that have been gap sorted
            # save a[i] in temp and make a hole at position i
            temp = arr[i]

            # shift earlier gap-sorted elements up until the correct
            # location for a[i] is found
            j = i
            while j >= gap and arr[j - gap] > temp:
                arr[j] = arr[j - gap]
                j -= gap

            # put temp (the original a[i]) in its correct location
            arr[j] = temp
        gap = int(gap // 2)


# Function to find the partition position
def partition(array, low, high):
    # choose the rightmost element as pivot
    pivot = array[high]

    # pointer for greater element
    i = low - 1

    # traverse through all elements
    # compare each element with pivot
    for j in range(low, high):
        if array[j] <= pivot:
            # If element smaller than pivot is found
            # swap it with the greater element pointed by i
            i = i + 1

            # Swapping element at i with element at j
            (array[i], array[j]) = (array[j], array[i])

    # Swap the pivot element with the greater element specified by i
    (array[i + 1], array[high]) = (array[high], array[i + 1])

    # Return the position from where partition is done
    return i + 1


# function to perform quicksort
def quickSort(array, low, high):
    if low < high:
        # Find pivot element such that
        # element smaller than pivot are on the left
        # element greater than pivot are on the right
        pi = partition(array, low, high)

        # Recursive call on the left of pivot
        quickSort(array, low, pi - 1)

        # Recursive call on the right of pivot
        quickSort(array, pi + 1, high)


def bubbleSort(arr):
    n = len(arr)

    # Traverse through all array elements
    for i in range(n):

        # Last i elements are already in place
        for j in range(0, n - i - 1):

            # traverse the array from 0 to n-i-1
            # Swap if the element found is greater
            # than the next element
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]


def testquicksort(ranges):
    testtime = []

    for _, v in enumerate(ranges):
        # list to be sorted
        testlist = []

        print(f'Creating list of {v:,} random numbers...')
        # create random numbers
        for i in range(0, v):
            x = rng.randint(1, v)
            testlist.append(x)

        low = 0
        high = len(testlist) - 1

        print(f'Testing Quick sort with {v:,} elements...')

        # start timer
        start = time.time()

        # sort list
        quickSort(testlist, low, high)

        # stop timer
        stop = time.time() - start

        print(f'It took {stop:.3f} seconds to sort {v:,} numbers!\n')

        testtime.append(stop)
    return testtime


def testbublesort(ranges):
    testtime = []

    for _, v in enumerate(ranges):
        # list to be sorted
        testlist = []

        print(f'Creating list of {v:,} random numbers...')
        # create random numbers
        for i in range(0, v):
            x = rng.randint(1, v)
            testlist.append(x)

        print(f'Testing Bubble sort with {v:,} elements...')

        # start timer
        start = time.time()

        # sort list
        bubbleSort(testlist)

        # stop timer
        stop = time.time() - start

        print(f'It took {stop:.3f} seconds to sort {v:,} numbers!\n')

        testtime.append(stop)
    return testtime


def testshellsort(ranges):
    testtime = []

    for _, v in enumerate(ranges):
        # list to be sorted
        testlist = []

        print(f'Creating list of {v:,} random numbers...')
        # create random numbers
        for i in range(0, v):
            x = rng.randint(1, v)
            testlist.append(x)

        print(f'Testing Shell sort with {v:,} elements...')

        # start timer
        start = time.time()

        # sort list
        shellSort(testlist)

        # stop timer
        stop = time.time() - start

        print(f'It took {stop:.3f} seconds to sort {v:,} numbers!\n')

        testtime.append(stop)
    return testtime


def main():
    ranges = (10_000, 30_000, 50_000, 70_000, 90_000)

    quicktime = testquicksort(ranges)
    shelltime = testshellsort(ranges)
    bubbletime = testbublesort(ranges)

    quickdf = pd.DataFrame({'Range': ranges, 'Time in seconds': quicktime})
    plt.figure(1)
    sb.lineplot(data=quickdf, x='Range', y='Time in seconds')
    plt.savefig('quicksort.png')

    shelldf = pd.DataFrame({'Range': ranges, 'Time in seconds': shelltime})
    plt.figure(2)
    sb.lineplot(data=shelldf, x='Range', y='Time in seconds')
    plt.savefig('shellsort.png')

    bubbledf = pd.DataFrame({'Range': ranges, 'Time in seconds': bubbletime})
    plt.figure(3)
    sb.lineplot(data=bubbledf, x='Range', y='Time in seconds')
    plt.savefig('bubblesort.png')

    plt.show()


if __name__ == '__main__':
    main()
