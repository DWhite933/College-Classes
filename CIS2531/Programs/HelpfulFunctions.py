import math
# David White
# Last Update: 9/27/2022
# Description: Some helpful functions


def isInt(x: float):
    """
    Checks if x is an integer (has no decimal point)
    :param x: A float
    :return: True if x is an integer
    """
    if abs(math.cos(math.pi * x)) == 1:
        return True
    else:
        return False
