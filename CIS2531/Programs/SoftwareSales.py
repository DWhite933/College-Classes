# David White
# 9/6/2022
# CIS-2531
# Instructor: Carolyn England
# Assignment: Programming Exercise #12: Software Sales
# Description:
# A software company sells a package that retails for $99. Quantity discounts are given
# according to the following table:
#   Quantity       Discount
#    10-19           10%
#    20-49           20%
#    50-99           30%
#    100+            40%
# Write a program that asks the user to enter the number of packages purchased. The program
# should then display the amount of the discount (if any) and the total amount of the
# purchase after the discount.

# ask user for the number of packages purchased
# ask user for info
numberPurchased = int(input("Enter number of packages: "))

discountPercent = 0.0

# set discount
if numberPurchased >= 100:
    discountPercent = .40
elif numberPurchased >= 50:
    discountPercent = .30
elif numberPurchased >= 20:
    discountPercent = .20
elif numberPurchased >= 10:
    numberPurchased = .10

# calculate total
total = 99 * numberPurchased
amountSaved = 0
if discountPercent > 0:
    amountSaved = (99 * numberPurchased) * discountPercent
    total -= amountSaved

# print info
print(f'Purchase total: ${total:.2f}')
print(f'You saved: ${amountSaved:.2f}')

# Enter number of packages: 75
# Purchase total: $5197.50
# You saved: $2227.50
#
# Process finished with exit code 0
