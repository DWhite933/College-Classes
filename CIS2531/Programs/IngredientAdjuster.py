# David White
# 8/29/2022
# CIS-2531
# Instructor: Carolyn England
# Programming Exercise 10: Ingredient Adjuster
# Description: A Cookie recipe calls for the following ingredients:
# 1.5 cups of sugar
# 1 cup of butter
# 2.75 cups of flour
#
# The recipe produces 48 cookies with this amount of the ingredients. Write a program that
# asks th user how many cookies he or she wants to make, then displays the number of cups
# of each ingredient needed for the specified number of cookies.

# Constants
SUGAR_PER_COOKIE = 1.5 / 48
BUTTER_PER_COOKIE = 1 / 48
FLOUR_PER_COOKIE = 2.75 / 48

# Ask for number of cookies to make.
num_cookies = int(input("Number of cookies to make: "))

# Calculate amount of ingredients
sugar_needed = SUGAR_PER_COOKIE * num_cookies
butter_needed = BUTTER_PER_COOKIE * num_cookies
flour_needed = FLOUR_PER_COOKIE * num_cookies

# Show ingredient amounts
print(f'You will need:\n {sugar_needed:.1f} cups of sugar\n'
      f'{butter_needed:.1f} cups of flour\n'
      f'{flour_needed:.1f} cups of flour')

# OUTPUT:
# Number of cookies to make: 25
# You will need:
# 0.8 cups of sugar
# 0.5 cups of flour
#  1.4 cups of flour
#
# Process finished with exit code 0
