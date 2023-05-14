import Employees

# David White
# 2022/11/14
# CIS-2531
# Instructor: Carolyn England
# Assignment: Lab11
# Description: Demonstrate the Employee, ProductionWorker and ShiftSupervisor classes


def showInfo(worker: Employees.Employee):
    if isinstance(worker, Employees.Employee):
        print("\nThis is the information you provided for this employee:")
        print(worker)
        print(f'Gross pay: ${worker.calc_gross_pay():.2f}')


def createWorker():
    name = input("Enter Employee Name: ")
    id_num = input("Enter Employee ID Number: ")
    shift = input("Enter Shift Number (1=Day, 2=Night): ")
    pay_rate = float(input("Enter Pay Rate: "))

    worker = Employees.ProductionWorker(name, id_num, shift, pay_rate)
    showInfo(worker)


def createSupervisor():
    name = input("Enter Employee Name: ")
    id_num = input("Enter Employee ID Number: ")
    salary = float(input("Enter Employee salary: "))
    bonus = float(input("Enter Employee bonus: "))

    supervisor = Employees.ShiftSupervisor(name, id_num, salary, bonus)
    showInfo(supervisor)


def main():
    again = 'y'

    while again.lower() == 'y':
        print("***MENU***")
        print("1. Production Worker")
        print("2. Shift Supervisor")
        menuChoice = int(input("Enter Selection (1/2): "))
        if menuChoice == 1:
            createWorker()
        elif menuChoice == 2:
            createSupervisor()
        again = input("Would you like to enter more data? (y/n): ")


if __name__ == "__main__":
    main()

# ***MENU***
# 1. Production Worker
# 2. Shift Supervisor
# Enter Selection (1/2): 1
# Enter Employee Name: David White
# Enter Employee ID Number: 123456
# Enter Shift Number (1=Day, 2=Night): 1
# Enter Pay Rate: 18.75
#
# This is the information you provided for this employee:
# Employee name: David White
# Employee ID number: 123456
# Shift Number: 1
# Hourly pay: $18.75
#
# Gross pay: $39000.00
# Would you like to enter more data? (y/n): y
# ***MENU***
# 1. Production Worker
# 2. Shift Supervisor
# Enter Selection (1/2): 2
# Enter Employee Name: Carolyn England
# Enter Employee ID Number: 654321
# Enter Employee salary: 75000
# Enter Employee bonus: 5000
#
# This is the information you provided for this employee:
# Employee name: Carolyn England
# Employee ID number: 654321
# Salary: 75,000.00
# Bonus: $5,000.00
#
# Gross pay: $80000.00
# Would you like to enter more data? (y/n): n
