"""
    This Module contains the definition for the RetailItem Class
    Name: David White
    Date: 2022/11/7
    Prog: Retail_Item.py
"""


class RetailItem:
    """
    The RetailItem class implements the representation
    for a class with item description, units in inventory,
    and price
    """

    def __init__(self, description='', stock=0, price=0.00):
        """
        The __init__ method creates the retail item
        characteristics as private data members.
        :param description: item description
        :param stock: number of units in inventory
        :param price: price of the item
        """
        self.__description = description
        self.__stock = stock
        self.__price = price

    @property
    def description(self): return self.__description
    @description.setter
    def description(self, val): self.__description = val

    @property
    def stock(self): return self.__stock
    @stock.setter
    def stock(self, val): self.__stock = val

    @property
    def price(self): return self.__price
    @price.setter
    def price(self, val): self.__price = val

    def __str__(self):
        return f'{self.description:20}{"$" + str(self.price):20}{self.stock}'
