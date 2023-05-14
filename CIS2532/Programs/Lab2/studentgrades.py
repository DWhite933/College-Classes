import numpy as np
import matplotlib.pyplot as plt


# David White
# 2023/01/30
# CIS-2532
# Instructor: Mohammad Morovati
# Assignment: Homework 2 Problem 1
# Description:
# Write a program to load a given dataset called Student_Grades.csv into a NumPy array. Then
# determine the following items:
# a) Display all data on screen.
# b) Determine how many students were in the dataset?
# c) Display the number of rows and columns of your numpy array.
# d) Display the array data types.
# e) Display the following Descriptive Statistics of students’ overall percentage scores:
# a. Min score
# b. Max score
# c. Mean value
# d. Median
# e. Mode
# f. Standard Deviation
# g. 25% and 75% percentile
# f) Determine how many students achieved an A grade, B, C, D and F grades.
# g) Create a pie chart based on the above grade achievements (option f)

def piechart(piedata):
    label = ["A", "B", "C", "D", "F"]
    plt.pie(piedata, labels=label)
    plt.title("Student Performance")
    plt.show()


def main():
    # import the csv file
    data = np.loadtxt("Student_Grades.csv", delimiter=",", skiprows=1)

    # display data on screen
    print(data)

    # display number of students
    print(f'There are {data.shape[0]} students in this class')

    # display number of rows and columns
    print(f'Number of rows and columns: {data.shape}')

    # display data type
    print(f'Data Type: {data.dtype}')

    # get the grades
    grades = data[:, -1]

    # determine statistics
    print(f'Statistics: \n\t'
          f'Lowest Score: {grades.min()}\n\t'
          f'Highest Score: {grades.max()}\n\t'
          f'Mean Score: {grades.mean()}\n\t'
          f'Median: {np.median(grades)}\n\t'
          f'Standard deviation: {grades.std()}\n\t'
          f'25th and 75th Percentile: {np.percentile(grades, np.array([25, 75]))}\n')

    # get a grades
    aGrade = grades[grades > 90]
    print(f'A: {aGrade.shape[0]}')

    # get b grades
    bfilter = (grades > 80) & (grades < 90)
    bGrade = grades[bfilter]
    print(f'B: {bGrade.shape[0]}')

    # get c grades
    cFilter = (grades > 70) & (grades < 80)
    cGrade = grades[cFilter]
    print(f'C: {cGrade.shape[0]}')

    # get d grades
    dfilter = (grades > 60) & (grades < 70)
    dGrade = grades[dfilter]
    print(f'D: {dGrade.shape[0]}')

    # get f grades
    fGrade = grades[grades < 60]
    print(f'F: {fGrade.shape[0]}')

    # data to send to pie chart
    piedata = [aGrade.shape[0], bGrade.shape[0], cGrade.shape[0], dGrade.shape[0], fGrade.shape[0]]

    piechart(piedata)


if __name__ == '__main__':
    main()
