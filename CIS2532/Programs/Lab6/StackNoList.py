
# David White
# 2023/03/13
# CIS-2532
# Instructor: Mohammad Morovati
# Assignment: Homework 5
# Description:
# Write or search a program on the Internet that implements a stack algorithm without using the
# linked-list concept. The program should store full names and phone numbers and print
# them in ascending order. Modify the program to fit your needs.

# stack class is from geekflare.com  I've modified it so it prints in ascending order
class Stack: 
    def __init__(self): 
        self.elements = [] 
    
    def push(self, data): 
        self.elements.append(data) 
        return data 
    
    def pop(self): 
        return self.elements.pop() 
        
    def peek(self): 
        return self.elements[-1] 
        
    def is_empty(self): 
        return len(self.elements) == 0
    
    def print_sorted_stack(self):

            temp_list = self.elements.copy()
            temp_list.sort()
            for _, val in enumerate(temp_list):
                print(f"{val[0]}: {val[1]}")

    
if __name__ == "__main__":
     # Example
    testStack = Stack()

    # is_empty?
    print(testStack.is_empty())

    # Push
    testStack.push(("John Smith", "123-456-7890"))
    testStack.push(("Michael Hunt", "234-567-8901"))
    testStack.push(("Charlie Brown", "345-678-9012"))
    testStack.push(("David White", "456-789-0123"))

    # print
    testStack.print_sorted_stack()

    # Peek 
    print(testStack.peek())
    
    # pop
    testStack.pop()
    testStack.pop()
    
    testStack.print_sorted_stack()