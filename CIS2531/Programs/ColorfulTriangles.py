import turtle

# David White
# 9/12/2022
# CIS-2531
# Instructor: Carolyn England
# Assignment: Colorful Triangles
# Description:
# Use the turtle graphics library to create a colored triangles python program that
# uses nested loops to draw (not stamp) 3 rows of different colored equilateral
# triangles in each row. Rows can have any number of triangles in the rang of 3 to
# 12. Prompt, read, and validate user input number of columns and colors. Create a
# colorful triangles drawing when input is in the valid ranges.

# Constants
SIDE_ANGLE = 60
WINDOW_SIDE = 500
NUM_SIDES = 3
NUM_ROWS = 3

# setup turtle window
turtle.setup(WINDOW_SIDE, WINDOW_SIDE)

# ask user for number of columns
numTriangles = int(input("How many columns to display: "))
if (numTriangles < 3) or (numTriangles > 13):
    print("ERROR: Number of columns must be in range of 3 and 12")
    exit(1)

# ask user for colors
rowColor1 = input("Enter first row color: ")
rowColor2 = input("Enter second row color: ")
rowColor3 = input("Enter third row color: ")
if (rowColor1 == rowColor2) or (rowColor1 == rowColor3) or (rowColor2 == rowColor3):
    print("ERROR: Row colors must be different")
    exit(1)

# triangle side
numCols = 2 * numTriangles + 1
sideLength = WINDOW_SIDE / numCols

# determine starting coordinates
starterX = 0 - ((2 * numTriangles - 1) / 2) * sideLength
starterY = 0 - sideLength / 2

for r in range(1, NUM_ROWS + 1):
    # set fill color
    if r == 1:
        turtle.fillcolor(rowColor1)
    elif r == 2:
        turtle.fillcolor(rowColor2)
    elif r == 3:
        turtle.fillcolor(rowColor3)
    # set turtle at coordinates
    turtle.penup()
    turtle.goto(starterX, starterY)
    for x in range(numTriangles):
        # draw triangles
        turtle.pendown()
        turtle.begin_fill()
        for side in range(NUM_SIDES):
            turtle.forward(sideLength)
            turtle.left(120)
        turtle.end_fill()
        # move to next location
        turtle.penup()
        turtle.forward(2 * sideLength)
    starterY -= 2 * sideLength

turtle.done()
