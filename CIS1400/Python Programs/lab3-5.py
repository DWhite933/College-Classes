#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: Lab 3-5
# File:       lab3-5.py
# Purpose:    Guess the values
#######################################################

print('\n***David White***\n')  # Display author's name


# main funcion
def main():
    print('Program Start')
    print()
    age = getAge()
    weight = getWeight()
    birthMonth = getMonth()
    checkAnswers(age, weight, birthMonth)
    return


# ask for age
def getAge():
    age = int(input('Guess the age: '))
    return age


# ask for weight
def getWeight():
    weight = int(input('Guess the Weight: '))
    return weight


# ask for birth month
def getMonth():
    birthMonth = str(input('Guess the Birth Month: '))
    return birthMonth


# check answers
def checkAnswers(age, weight, birthMonth):
    if age <= 25:
        print('Congratulations, the age is 25 or less')
        return
    if weight >= 128:
        print('Congratulations, the weight is 128 or more')
        return
    if birthMonth == 'april' or 'April':
        print('Congratulations, the birth month is April')
        return
    return


# call main
main()
