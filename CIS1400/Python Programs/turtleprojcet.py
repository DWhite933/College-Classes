#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: Project 1
# File:       turtleproject.py
# Purpose:    
#######################################################

print('\n***David White***\n')  # Display author's name

import turtle

scr = turtle.Screen()


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
        turtle.circle(rad)
        turtle.penup()
        turtle.fd(rad)
        turtle.lt(360 / cirCount)
        turtle.fd(rad / 2)
        turtle.pendown()


# call main
main()
