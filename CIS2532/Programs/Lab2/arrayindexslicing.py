import numpy as np

# David White
# 2023/01/30
# CIS-2532
# Instructor: Mohammad Morovati
# Assignment: Homework 2 Problem 1
# Description:
# Create an array containing the values 1–15, reshape it into a 3-by-5 array,
# then use indexing and slicing techniques to perform each of the following operations:
# a) Select row 2.
# b) Select column 4.
# c) Select rows 0 and 1.
# d) Select columns 2–4.
# e) Select the element that is in row 1 and column 4.
# f) Select all elements from rows 1 and 2 that are in columns 0, 2 and 4

# create an array containing the values 1–15
array = np.arange(1, 16)
print("arr: ", array)

# reshape array into 3 by 5 array
array = array.reshape(3, 5)
print("arr: ", array)

# select row 2
row2 = array[2]
print("Row 2: ", row2)

# select column 4
col4 = array[:, 4]
print("Column 4: ", col4)

# select rows 0 and 1
row01 = array[[0, 1], :]
print("Rows 0 and 1:", row01)

# select columns 2-4
col24 = array[:, 2:5]
print("Columns 2-4: ", col24)

# select element at row 1 column 4
r1c4 = array[1, 4]
print("Row 1 column 4: ", r1c4)

# Select all elements from rows 1 and 2 that are in columns 0, 2 and 4
r12c024 = array[1:3, ::2]
print("Row 1 and 2, Column 0, 2 and 4: ", r12c024)

