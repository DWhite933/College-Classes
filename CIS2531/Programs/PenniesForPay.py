# David White
# 9/12/2022
# CIS-2531
# Instructor: Carolyn England
# Assignment: Programming Exercise #7
# Description:
# Write a program that calculates the amount of money a person would ern over a period
# of time if his or her salary is one penny the first day, two pennies the second day, and
# continues to double each day. The program should ask the user for the number of days.
# Display a table showing what the salary was for each day, then show the total pay at the
# end of the period. The output should be displayed in a dollar amount, not hte number of pennies.

# variables
dailySalary = .01
totalSalary = 0.0

# ask user of number of days
numberOfDays = int(input("Enter the number of days: "))

# table header
print('Day \tSalary')
print("======================")

for i in range(1, numberOfDays + 1):
    print(f'{i}\t\t${dailySalary:,.2f}')
    totalSalary += dailySalary
    dailySalary *= 2

print(f'The total salary for {numberOfDays} is: ${totalSalary:,.2f}')

# Enter the number of days: 30
# Day 	Salary
# ======================
# 1		$0.01
# 2		$0.02
# 3		$0.04
# 4		$0.08
# 5		$0.16
# 6		$0.32
# 7		$0.64
# 8		$1.28
# 9		$2.56
# 10	$5.12
# 11	$10.24
# 12	$20.48
# 13	$40.96
# 14	$81.92
# 15	$163.84
# 16	$327.68
# 17	$655.36
# 18	$1,310.72
# 19	$2,621.44
# 20	$5,242.88
# 21	$10,485.76
# 22	$20,971.52
# 23	$41,943.04
# 24	$83,886.08
# 25	$167,772.16
# 26	$335,544.32
# 27	$671,088.64
# 28	$1,342,177.28
# 29	$2,684,354.56
# 30	$5,368,709.12
# The total salary for 30 is: $10,737,418.23
#
# Process finished with exit code 0
