# David White
# 10/10/2022
# CIS-2531
# Instructor: Carolyn England
# Assignment: Dow Jones
# Description:
# Implement a Python program to use a data file containing the daily closing
# price for the DJIA for a given number of years to produce a yearly DJIA
# analysis report.
# DJIA_HistoricalPrices00_10.csv

def average(number_list):
    total = 0.0
    for i in number_list:
        total += i
    return total / len(number_list)


def combine_Multiples(lists):
    idx = 0
    try:
        while idx < (len(lists)):
            while lists[idx][0] == lists[idx + 1][0]:
                lists[idx].append(lists[idx + 1][1])
                del lists[idx + 1]
            idx += 1
    except IndexError:
        # if I get an index error than I know that the list is sorted
        return


def get_data_list(file):
    try:
        with open(file) as file:
            lines = file.readlines()
            for index in range(len(lines)):
                # strip new line character
                lines[index] = lines[index].rstrip('\n')

                # split records
                lines[index] = lines[index].split(',')

                # split date into month/year format
                lines[index][0] = lines[index][0].split('/')
                lines[index][0].pop(1)
                lines[index][0] = '/'.join(lines[index][0])

                # convert dollars into float
                lines[index][1] = float(lines[index][1])
    except FileNotFoundError:
        print("ERROR: FILE NOT FOUND!")
        exit(1)
    return lines


def get_Month(num):
    months = {
        1: 'January',
        2: 'February',
        3: 'March',
        4: 'April',
        5: 'May',
        6: 'June',
        7: 'July',
        8: 'August',
        9: 'September',
        10: 'October',
        11: 'November',
        12: 'December'

    }
    return months.get(num)


def get_monthly_average(data):
    for itm, ele in enumerate(data):
        temp = ele[0].split('/')
        del ele[0]
        temp.append(average(ele))
        del temp[0]
        data[itm] = [] + temp
    combine_Multiples(data)


def print_info(data):
    for ele in data:
        averages = ele[1:]
        print("DJIA closing price average for " + ele[0])
        print(f'{"Month":<20}{"Average":>10}')
        for idx, itm in enumerate(averages):
            print(f'{get_Month(idx + 1):<20}{itm:>10,.2f}')
        print()


def main():
    # get file name from user
    file_name = input("Enter File Name: ")

    # get data from file
    data_List = get_data_list(file_name)

    # organizes the data list
    combine_Multiples(data_List)

    # get the average for each month
    get_monthly_average(data_List)

    # show user info
    print_info(data_List)


if __name__ == "__main__":
    main()
