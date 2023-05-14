#######################################################
# Name:       David White
# Class:      CIS-1400
# Assignment: Ch. 12 Program ex. 2
# File:       lab12.py
# Purpose:    Sentence Capitalizer
#######################################################

print('\n***David White***\n')  # Display author's name


# main function
def main():

    # get string from user
    sentence = str(input("Please enter sentences: "))

    # size of array
    size = len(sentence)

    # array
    arr = [" "] * size



    # put string into array
    for sub in range(0, size - 1):
        arr[sub] = sentence[sub]

    # capitalize sentence
    for sub in range(0, size):
        if arr[sub] == '.' or sub == 0:
            while sub < size:
                if arr[sub].isalpha():
                    arr[sub] = arr[sub].upper()
                    break
                else:
                    sub = sub + 1

    # display capitalized sentence
    for sub in range(0, size):
        print(arr[sub])


# call main
main()
