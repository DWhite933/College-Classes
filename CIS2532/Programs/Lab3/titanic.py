import numpy as np
import pandas as pd

# David White
# 2023/02/06
# CIS-2532
# Instructor: Mohammad Morovati
# Assignment: Homework 3
# Description:
# Using the titanic.csv dataset, write a program to explore and mine the following information:
# a) How many passengers were on the titanic?
# b) How many male and female passengers were in the titanic?
# c) What was the average age of all passengers?
# d) How many passengers were under 21 years of age?
# e) How many survived and how many did not? How many males and how many females?
# f) What was the youngest age that survived, and the oldest age? What were their names?
# g) Display the name of all passengers that survived.
# Save the results above into a file of your choice

filename = 'titanic.csv'
df = pd.read_csv(filename)

survivors = df[df.survived == 'yes']

try:
    with open('titanic.txt', 'w') as of:

        of.write(f'There were {len(df.Name)} passengers on the Titanic\n'
                 f'Male Passengers: {len(df[df.sex == "male"])}\n'
                 f'Female Passengers: {len(df[df.sex == "female"])}\n'
                 f'Average age: {df.age.mean():.2f}\n'
                 f'# Survived: {len(df[df.survived == "yes"])}\n'
                 f'Male: {len(survivors[survivors.sex == "male"])}\n'
                 f'female: {len(survivors[survivors.sex == "female"])}\n'
                 f'Youngest Survivor: {survivors.Name[survivors.age.idxmin()]} Age: {survivors.age.min()}\n'
                 f'Oldest Survivor: {survivors.Name[survivors.age.idxmax()]} Age: {survivors.age.max()}\n'
                 f'Survivors:\n {survivors.Name.to_string(index=False)}')
        print("Saved to titanic.txt")
except FileNotFoundError:
    print("ERROR: File not found")
