#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: 
# File:       .py
# Purpose:    
#######################################################

print('\n***David White***\n')  # Display author's name

# Sales with control break logic
from pathlib import Path
import sys


def parseRecord(line):
    # parse record
    i = 0
    j = line.find(",", i)
    storeNumber = line[i:j]
    i = j + 1  # character after comma
    j = line.find(",", i)
    state = line[i:j]
    i = j + 1
    sales = float(line[i:len(line) - 1])  # move the CR
    return storeNumber, state, sales


# Check if salesFile exists
my_file = Path("sales.dat")
if not (my_file.is_file()):
    print("sales.dat does not exist program terminated")
    sys.exit(0)

# open salesFile for output
salesFile = open("sales.dat", "r")

# print headings
print("Store Number", '\t', "State", '\t', "    Sales")
print("-------------------------------------")

stateTotal = 0
line = salesFile.readline()  # first read outside loop
if line == "":
    print("sales.dat empty - program terminated")
    sys.exit(0)
storeNumber, state, sales = parseRecord(line)
breakState = state  # first state

while not (line == ""):  # line == "" then EOF
    if breakState != state:  # on control break change of state or end of file
        print("\t   Total Sales for", breakState, ":", '${:11,.2f}'.format(stateTotal))
        stateTotal = 0.0
        breakState = state

    print("   ", storeNumber, '\t  ', state, '   ${:10,.2f}'.format(sales))
    stateTotal = stateTotal + sales

line = salesFile.readline()
if line != "":
    storeNumber, state, sales = parseRecord(line)

# EOF print last break total
print("\t   Total Sales for", breakState, ":", '${:11,.2f}'.format(stateTotal))
salesFile.close()

# For this last one, you have to read in the entire line from the file into a string.
# Then, parse it into appropriate fields (see parse routine).
# Then, move each parsed field into an array element.  For this you’ll have to use a loop.


