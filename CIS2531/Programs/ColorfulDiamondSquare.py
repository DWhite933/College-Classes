import turtle

# David White
# 8/29/2022
# CIS-2531
# Instructor: Carolyn England
# Colorful Diamond Square
# Description: Use the turtle graphics library to create the python program that implements the design

turtle.speed(0)
turtle.hideturtle()

# make green square
turtle.fillcolor('green')
turtle.begin_fill()
turtle.left(45)
turtle.forward(100)
turtle.left(90)
turtle.forward(100)
turtle.left(90)
turtle.forward(100)
turtle.left(90)
turtle.forward(100)
turtle.end_fill()

# make black square
turtle.fillcolor('black')
turtle.left(90)
turtle.forward(100)
turtle.begin_fill()
turtle.forward(100)
turtle.left(90)
turtle.forward(100)
turtle.left(90)
turtle.forward(100)
turtle.left(90)
turtle.forward(100)
turtle.end_fill()

# make red square
turtle.fillcolor('red')
turtle.left(180)
turtle.forward(100)
turtle.begin_fill()
turtle.forward(100)
turtle.left(90)
turtle.forward(100)
turtle.left(90)
turtle.forward(100)
turtle.left(90)
turtle.forward(100)
turtle.end_fill()

# make blue square
turtle.fillcolor('blue')
turtle.begin_fill()
turtle.forward(100)
turtle.left(90)
turtle.forward(100)
turtle.left(90)
turtle.forward(100)
turtle.left(90)
turtle.forward(100)
turtle.end_fill()

# write text
turtle.penup()
turtle.goto(-102, -25)
turtle.write('A colorful diamond square by David White')


turtle.done()
