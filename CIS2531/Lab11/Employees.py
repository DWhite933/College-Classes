from abc import ABC, abstractmethod

"""
    This Module contains the definition for the Employee, ProductionWorker, and ShiftSupervisor classes
    CIS-2531
    Name: David White
    Date: 2022/11/14
    Prog: Employees.py
"""


class Employee(ABC):
    """
    This is the base class for the ProductionWorker and ShiftSupervisor classes. It
    contains the work_hours, work_weeks, name and id_num attributes and the calc_gross_pay
    abstract method.
    """

    def __init__(self, employee_name='', id_num=-1, work_hours=40, work_weeks=52):
        self.__work_hours = work_hours
        self.__work_weeks = work_weeks
        self.__name = employee_name
        self.__id_num = id_num

    @property
    def work_hours(self): return self.__work_hours
    @work_hours.setter
    def work_hours(self, val): self.__work_hours = val

    @property
    def work_weeks(self): return self.__work_weeks
    @work_weeks.setter
    def work_weeks(self, val): self.__work_weeks = val

    @property
    def name(self): return self.__name
    @name.setter
    def name(self, val): self.__name = val

    @property
    def id_num(self): return self.__id_num
    @id_num.setter
    def id_num(self, val): self.__id_num = val

    def __str__(self):
        return f'Employee Name: {self.__name}\nEmployee ID: {self.__id_num}'

    @abstractmethod
    def calc_gross_pay(self):
        pass


class ProductionWorker(Employee):
    """
    This is the ProductionWorker subclass of the abstract Employee class. It
    contains shift_num and pay_rate attributes in addition to the inherited
    attributes from the Employee class. It also implements the calc_gross_pay
    abstract method.
    """

    def __init__(self, employee_name='', id_num=-1, shift_num=0,
                 pay_rate: float = 0.0, work_hours=40, work_weeks=52):
        super().__init__(employee_name, id_num, work_hours, work_weeks)
        self.__shift_num = shift_num
        self.__pay_rate = pay_rate

    @property
    def shift_num(self): return self.__shift_num

    @shift_num.setter
    def shift_num(self, val): self.__shift_num = val

    @property
    def pay_rate(self): return self.__pay_rate

    @pay_rate.setter
    def pay_rate(self, val): self.__pay_rate = val

    def __str__(self):
        return f'Employee name: {self.name}\n' \
               f'Employee ID number: {self.id_num}\n' \
               f'Shift Number: {self.__shift_num}\n' \
               f'Hourly pay: ${self.__pay_rate:,.2f}\n'

    def calc_gross_pay(self):
        return float(self.__pay_rate * self.work_hours * self.work_weeks)


class ShiftSupervisor(Employee):
    """
    This is the ShiftSupervisor subclass of the abstract Employee class. It
    contains salary and bonus attributes in addition to the inherited
    attributes from the Employee class. It also implements the calc_gross_pay
    abstract method.
    """

    def __init__(self, employee_name='', id_num=-1, salary: float = 0.0,
                 bonus: float = 0.0):
        super().__init__(employee_name, id_num)
        self.__salary = salary
        self.__bonus = bonus

    @property
    def salary(self): return self.__salary
    @salary.setter
    def salary(self, val): self.__salary = val

    @property
    def bonus(self): return self.__bonus
    @bonus.setter
    def bonus(self, val): self.__bonus = val

    def __str__(self):
        return f'Employee name: {self.name}\n' \
               f'Employee ID number: {self.id_num}\n' \
               f'Salary: {self.__salary:,.2f}\n' \
               f'Bonus: ${self.__bonus:,.2f}\n'

    def calc_gross_pay(self):
        return float(self.__salary + self.__bonus)
