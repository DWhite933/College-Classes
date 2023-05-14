from sorting_techniques import pysort

# pysort is a powerful python package with 15 sorting algorithms.

# create sort object
sortOrb = pysort.Sorting()

testList = [4, 14, 32, 89, 68, 20, 76, 6, 51, 10]

# bubble sort
bubble = sortOrb.bubbleSort(testList)
print(bubble)

# shell sort
shell = sortOrb.shellSort(testList)
print(shell)


# Quick sort
quick = sortOrb.quickSort(testList, 0, (len(testList)-1))
print(quick)
