from abc import ABC, abstractmethod
from math import pi

"""
    This Module contains the definition for the Shape, Circle, Square, and Cube classes
    CIS-2532
    Name: David White
    Date: 2023/01/23
    Prog: Shapes.py
"""


class Shape(ABC):
    """
    This is the base class for the Circle, Square, and Cube classes. It contains
    the color attribute, the display() function, and the find_area() and find_volume()
    abstract functions.
    """

    def __init__(self):
        self.__color = "Red"

    @property
    def color(self): return self.__color

    @color.setter
    def color(self, val): self.__color = val

    def display(self):
        return f'Color: {self.__color}'

    @abstractmethod
    def find_area(self): pass

    @abstractmethod
    def find_volume(self): pass


class Circle(Shape):
    """
    This is the Circle subclass of the abstract Shape class. It contains
    the radius attribute in addition to the color attribute inherited from
    the Shape class. It also implements the find_area abstract method.
    """

    def __init__(self):
        super().__init__()
        self.__radius = 1

    @property
    def radius(self): return self.__radius

    @radius.setter
    def radius(self, value): self.__radius = value

    def display(self): return "Circle"

    def find_area(self):
        return pi * self.__radius * self.__radius

    def find_volume(self):
        # Assignment does not specify whether to implement this function in this class
        pass


class Square(Shape):
    """
    This is the Square subclass of the abstract Shape class. It contains
    the side attribute in addition to the color attribute inherited from
    the Shape class. It also implements the find_area abstract method.
    """

    def __init__(self):
        super().__init__()
        self.__side = 2.3

    @property
    def side(self): return self.__side

    @side.setter
    def side(self, value): self.__side = value

    def display(self): return "Square"

    def find_area(self):
        return self.__side * self.__side

    def find_volume(self):
        # Assignment does not specify whether to implement this function in this class
        pass


class Cube(Shape):
    """
    This is the Cube subclass of the abstract Shape class. It contains
    the length, width, and height attributes in addition to the color attribute inherited from
    the Shape class. It also implements the find_volume abstract method.
    """

    def __init__(self):
        super().__init__()
        self.__length = 2
        self.__width = 3
        self.__height = 4

    @property
    def length(self): return self.__length

    @length.setter
    def length(self, value): self.__length = value

    @property
    def width(self): return self.__width

    @width.setter
    def width(self, value): self.__width = value

    @property
    def height(self): return self.__height

    @height.setter
    def height(self, value): self.__height = value

    def display(self): return "Cube"

    def find_volume(self):
        return self.__length * self.__width * self.__height

    def find_area(self):
        # Assignment does not specify whether to implement this function in this class
        pass

