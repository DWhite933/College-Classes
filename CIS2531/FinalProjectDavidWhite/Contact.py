
"""
    This Module contains the definition for the Contact class
    CIS-2531
    Name: David White
    Date: 2022/11/28
    Prog: Contact.py
"""


class Contact:
    """
    This is the Contact class. It contains my_name, number,
    address, city and state attributes.
    """
    def __init__(self, name=' ', phone_number=' ',
                 address=' ', city=' ', state=' '):
        """

        :param name: Person's name
        :param phone_number: Person's phone number
        :param address: Person's street address
        :param city: The city where they live
        :param state: The state where they live
        """
        self.__my_name = name
        self.__number = phone_number
        self.__address = address
        self.__city = city
        self.__state = state

    @property
    def my_name(self): return self.__my_name
    @my_name.setter
    def my_name(self, value): self.__my_name = value

    @property
    def number(self): return self.__number
    @number.setter
    def number(self, value): self.__number = value

    @property
    def address(self): return self.__address
    @address.setter
    def address(self, value): self.__address = value

    @property
    def city(self): return self.__city
    @city.setter
    def city(self, value): self.__city = value

    @property
    def state(self): return self.__state
    @state.setter
    def state(self, value): self.__state = value

    def __str__(self):
        return f'First Name: {self.__my_name}\n' \
               f'Phone Number: {self.__number}\n' \
               f'Address: {self.__address}\n' \
               f'{self.__city}, {self.__state}'
