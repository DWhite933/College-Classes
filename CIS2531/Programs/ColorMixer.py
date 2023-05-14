# David White
# 9/6/2022
# CIS-2531
# Instructor: Carolyn England
# Assignment: Programming Exercise #7: Color Mixer
# Description: The colors red, blue, and yellow are know as the primary colors because they
# cannot be made by mixing other colors. When you mix two primary colors, you get a secondary
# color, as shown here:
#   When you mix red and blue, you get purple.
#   When you mix red and yellow, you get orange.
#   When you mix blue and yellow, you get green.
# Design a program that prompts the user to enter the names of two primary colors to mix. If
# the user enters anything other than "red," "blue," or "yellow," the program should display
# an error message. Otherwise, the program should display the name of the secondary color.
# that results.

# Named Constants
RED = "red"
BLUE = "blue"
YELLOW = "yellow"

# Ask user for colors
firstColor = input("Enter first Primary color: ")
secondColor = input("Enter second Primary color: ")

# check for only primary colors
if (((firstColor != RED) and (firstColor != BLUE) and (firstColor != YELLOW)) or
        ((secondColor != RED) and (secondColor != BLUE) and (secondColor != YELLOW))):
    print("Please enter 2 primary colors.")
    exit(1)

# check for duplicate color
if firstColor == secondColor:
    print("Duplicate Colors")
    exit(2)

# check purple
if (((firstColor == RED) and (secondColor == BLUE)) or
        ((firstColor == BLUE) and (secondColor == RED))):
    print("Purple")

# check orange
if (((firstColor == RED) and (secondColor == YELLOW)) or
        ((firstColor == YELLOW) and (secondColor == RED))):
    print("Orange")

# check green
if (((firstColor == BLUE) and (secondColor == YELLOW)) or
        ((firstColor == YELLOW) and (secondColor == BLUE))):
    print("Green")

# Enter first Primary color: yellow
# Enter second Primary color: blue
# Green
#
# Process finished with exit code 0
