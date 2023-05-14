import matplotlib.pyplot as plt
from tkinter import messagebox as mb
import Shapes
from random import randint


# David White
# 2023/01/23
# CIS-2532
# Instructor: Mohammad Morovati
# Assignment: Homework 1
# Description:
# The focus of this assignment is to revisit or review Python language features that you have
# previously learned in your Introduction course such as simple I/O, selection control, loops,
# random number, functions, lists/arrays, file I/O, creating graphs, classes and objects, inheritance,
# Graphical User Interface (GUI) features, and the UML diagram.


def print_to_console(shapes):
    for _, v in enumerate(shapes):
        if isinstance(v, Shapes.Circle) or isinstance(v, Shapes.Square):
            print(f'{v.display()}: {v.find_area():.2f}')
        elif isinstance(v, Shapes.Cube):
            print(f'{v.display()}: {v.find_volume()}')


def save_to_file(shapes):
    try:
        with open('shapes.txt', 'w') as of:
            for _, v in enumerate(shapes):
                if isinstance(v, Shapes.Circle) or isinstance(v, Shapes.Square):
                    of.write(f'{v.display()}: {v.find_area():.2f}\n')
                elif isinstance(v, Shapes.Cube):
                    of.write(f'{v.display()}: {v.find_volume()}\n')
        print("Saved to shapes.txt")
    except FileNotFoundError:
        mb.showerror("ERROR", "ERROR: File not found. Unable to save data")
        exit(1)


def print_to_gui(shapes):
    result = ''
    for _, v in enumerate(shapes):
        if isinstance(v, Shapes.Circle) or isinstance(v, Shapes.Square):
            result += f'{v.display()}: {v.find_area():.2f}\n'
        elif isinstance(v, Shapes.Cube):
            result += f'{v.display()}: {v.find_volume()}\n'
    mb.showinfo("Results", result)


def pie_chart(shapes):
    numShapes = [0, 0, 0]

    for _, v in enumerate(shapes):
        if isinstance(v, Shapes.Circle):
            numShapes[0] += 1
        elif isinstance(v, Shapes.Square):
            numShapes[1] += 1
        elif isinstance(v, Shapes.Cube):
            numShapes[2] += 1

    label = ['Circles', 'Squares', 'Cubes']

    plt.pie(numShapes, labels=label)
    plt.title("Shapes")
    plt.show()


def main():
    shapes = []
    for _ in range(0, 15):
        shapeChoice = randint(1, 3)
        if shapeChoice == 1:
            shapes.append(Shapes.Circle())
        elif shapeChoice == 2:
            shapes.append(Shapes.Square())
        elif shapeChoice == 3:
            shapes.append(Shapes.Cube())

    print(f'1: Print result to console\n'
          f'2: Save result to file\n'
          f'3: Print to GUI messagebox')
    try:
        printChoice = int(input("Enter Choice: "))
    except ValueError:
        print("ERROR: Invalid Choice")
        exit(1)
    else:

        if printChoice == 1:
            print_to_console(shapes)
        elif printChoice == 2:
            save_to_file(shapes)
        elif printChoice == 3:
            print_to_gui(shapes)

        pie_chart(shapes)


if __name__ == "__main__":
    main()
