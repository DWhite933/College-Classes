import Retail_Item as Retail
import Cash_Register as Register


# David White
# DATE
# CIS-2531
# Instructor: Carolyn England
# Assignment: Lab 10
# Description: Demonstrate the CashRegister class in a program.


def showMenu(jacket, jeans, shirt):
    print("***MENU***")
    print(f'{"Choice":10}{"Description":20}{"Price":20}{"Stock"}')
    print("=======================================================")
    print(f'{"1":10}{jacket}')
    print(f'{"2":10}{jeans}')
    print(f'{"3":10}{shirt}')
    print("=======================================================")


def getMenuChoice():
    choice = int(input("Enter Choice or 0 to exit: "))
    while (choice > 3) or (choice < 0):
        choice = int(input("Enter Valid Choice: "))
    return choice


def checkout(reg):
    print('\nCart:')
    reg.show_items()
    print(f'Number of items purchased: {len(reg.items)}')
    print(f"Total Price: {reg.get_total():.2f}")
    print('================')
    print("Clearing cash register....")
    reg.clear()
    print(f'Number of items in register: {len(reg.items)}')


def main():
    # initialize objects
    jacket = Retail.RetailItem('Jacket', 12, 59.99)
    jeans = Retail.RetailItem('Designer Jeans', 40, 34.99)
    shirt = Retail.RetailItem('Shirt', 20, 24.99)
    reg = Register.CashRegister()

    showMenu(jacket, jeans, shirt)
    choice = getMenuChoice()
    while choice > 0:
        if choice == 1:
            reg.purchase_item(jacket)
        if choice == 2:
            reg.purchase_item(jeans)
        if choice == 3:
            reg.purchase_item(shirt)
        showMenu(jacket, jeans, shirt)
        choice = getMenuChoice()
    checkout(reg)
    

if __name__ == '__main__':
    main()

# ***MENU***
# Choice    Description         Price               Stock
# =======================================================
# 1         Jacket              $59.99              12
# 2         Designer Jeans      $34.99              40
# 3         Shirt               $24.99              20
# =======================================================
# Enter Choice or 0 to exit: 1
# ***MENU***
# Choice    Description         Price               Stock
# =======================================================
# 1         Jacket              $59.99              11
# 2         Designer Jeans      $34.99              40
# 3         Shirt               $24.99              20
# =======================================================
# Enter Choice or 0 to exit: 2
# ***MENU***
# Choice    Description         Price               Stock
# =======================================================
# 1         Jacket              $59.99              11
# 2         Designer Jeans      $34.99              39
# 3         Shirt               $24.99              20
# =======================================================
# Enter Choice or 0 to exit: 2
# ***MENU***
# Choice    Description         Price               Stock
# =======================================================
# 1         Jacket              $59.99              11
# 2         Designer Jeans      $34.99              38
# 3         Shirt               $24.99              20
# =======================================================
# Enter Choice or 0 to exit: 3
# ***MENU***
# Choice    Description         Price               Stock
# =======================================================
# 1         Jacket              $59.99              11
# 2         Designer Jeans      $34.99              38
# 3         Shirt               $24.99              19
# =======================================================
# Enter Choice or 0 to exit: 3
# ***MENU***
# Choice    Description         Price               Stock
# =======================================================
# 1         Jacket              $59.99              11
# 2         Designer Jeans      $34.99              38
# 3         Shirt               $24.99              18
# =======================================================
# Enter Choice or 0 to exit: 3
# ***MENU***
# Choice    Description         Price               Stock
# =======================================================
# 1         Jacket              $59.99              11
# 2         Designer Jeans      $34.99              38
# 3         Shirt               $24.99              17
# =======================================================
# Enter Choice or 0 to exit: 0
#
# Cart:
# Shirt, Units: 3, Price: $74.97
# Designer Jeans, Units: 2, Price: $69.98
# Jacket, Units: 1, Price: $59.99
# Number of items purchased: 6
# Total Price: 204.94
# ================
# Clearing cash register....
# Number of items in register: 0
