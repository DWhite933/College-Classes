import matplotlib.pyplot as plt
import seaborn as sb
#import numpy as np
import pandas as pd

# David White
# 2023/02/13
# CIS-2532
# Instructor: Mohammad Morovati
# Assignment: Homework 4
# Description:
# a) Using dataset workerstips.csv, create a scatterplot with total_bill as the x-axis and the tips
# as the y-axis.

# b) Using dataset workerstips.csv, create a scatter plot that will differentiate between smokers
# and non-smokers. Use a different color (hue) and style marker (style) to visually split the
# points of scatterplot. Because the default range sizes are limited, increase the range size.
# Try the tuple (10, 300) as the size range parameter.

# c) A simple bar plot will work well to show average tips per day of the week. Find out
# which day has the highest average tip. In this case, you may want to show the average tip
# (y-axis) per day of the week (x-axis).

# d) Repeat part (b) above but this time split the distribution by lunch and dinner. What
# information can you derive from the new visualization?

# e) Using dataset flightData.csv, create a lineplot to plot average number of passengers per
# year per month. Use the year on the x-axis and the passengers on the y-axis. Also, find
# out how to plot the total number of passengers per year.

# f) Using dataset titanic.csv, show the counts of observations in each categorical bin using
# bars plot.

# Please note that I based the graphs on the criteria above and not the samples shown in the
# assignment

# load datasets
print("Loading workerstips.csv")
tips = pd.read_csv('workerstips.csv')
print("Loading flightsData.csv")
flights = pd.read_csv('flightsData.csv')
print("Loading titanic.csv")
titanic = pd.read_csv('titanic.csv')

# Chart A
print("Showing Chart A")
sb.scatterplot(data=tips, x="total_bill", y="tip")
plt.show()

# Chart B
print("Showing Chart B")
sb.scatterplot(data=tips, x="total_bill", y="tip", hue="smoker", style="smoker")
plt.show()

# Chart C
print("Showing Chart C")
sb.barplot(data=tips, x="day", y="tip")
plt.show()

# Chart D
print("Showing Chart D")
sb.scatterplot(data=tips, x="total_bill", y="tip", hue="time", style="time")
plt.show()

# Chart E
print("Showing Chart E part 1")
sb.lineplot(data=flights, x="year", y="passengers")
plt.show()

# get the number of flights per year
flights_per_year = flights.pivot(index="year", columns="month", values="passengers")
flights_per_year = flights_per_year.sum(axis=1)
flights_per_year = pd.DataFrame(flights_per_year)
flights_per_year.rename(columns={0: 'passengers'}, inplace=True)
# Chart E
print("Chart E part 2")
sb.lineplot(data=flights_per_year, x="year", y="passengers")
plt.show()

# Chart F
print("Showing Chart F")
sb.countplot(data=titanic)
plt.show()
