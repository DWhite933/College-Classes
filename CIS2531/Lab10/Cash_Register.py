import Retail_Item as Retail

"""
    This Module contains the definition for the CashRegister Class
    Name: David White
    Date: 2022/11/7
    Prog: Cash_Register.py
"""


class CashRegister:
    """
    This class simulates a cash register
    """

    def __init__(self, items: list = None):
        """
        The __init__ method creates the cash register
        characteristics as private data members.
        :param items: list of items in the cash register
        """

        if items is None:
            self.__items = list()
        else:
            self.__items = items

    @property
    def items(self):
        return self.__items

    def get_total(self):
        """
        returns the total of the items in the cash register
        :return: the total price of the items in the register
        """
        total = 0.00
        for i in range(len(self.__items)):
            total += self.__items[i].price
        return total

    def purchase_item(self, item: Retail.RetailItem):
        """
        adds item to the cash register and removes it from the inventory
        """
        self.__items.append(item)
        item.stock = item.stock - 1

    def show_items(self):
        """
        displays data about the items stored in the cash register
        """
        itemSet = set()
        itemList = list()
        for _, val in enumerate(self.__items):
            itemList.append(val.description)
            itemSet.add(val.description)
        for i in itemSet:
            price = 0.00
            for _, val in enumerate(self.__items):
                if val.description == i:
                    price = val.price
                    break
            print(f'{i}, Units: {itemList.count(i)}, Price: ${price * itemList.count(i):.2f}')

    def __get_price(self, item_name):
        for _, v in enumerate(self.__items):
            if v.description == item_name:
                return v.price

    def clear(self):
        self.__items.clear()

    def __str__(self):
        s = "Cart: "
        for _, val in enumerate(self.items):
            s += str(val.description) + ", "
        s += f'Total: ${self.get_total():.2f}'
        return s
