#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: Project 1
# File:       colorproject.py
# Purpose:
#######################################################

print('\n***David White***\n')  # Display author's name

import turtle
import random

col = ['red', 'green', 'blue', 'gold', 'orange', 'purple', 'magenta',
       'turquoise', 'chocolate', 'black', 'grey', 'white']
scr = turtle.Screen()
turtle.pensize(2)
turtle.shape('classic')
turtle.speed(10)


# main function
def main():
    cirCount = getCir()
    rad = getRad()
    makeCirc(rad, cirCount)
    # end main


# ask for circle size
def getRad():
    radius = int(input('How big do you want the circles? '))
    return radius


def getCir():
    circles = int(input('How many circles do you want? '))
    return circles


def makeCirc(rad, cirCount):
    for i in range(cirCount):
        turtle.fillcolor(random.choice(col))
        turtle.pencolor(random.choice(col))
        turtle.begin_fill()
        turtle.circle(rad)
        turtle.end_fill()
        turtle.penup()
        turtle.fd(rad)
        turtle.lt(360 / cirCount)
        turtle.fd(rad / 2)
        turtle.pendown()


# call main
main()
