
# David White
# 2023/03/13
# CIS-2532
# Instructor: Mohammad Morovati
# Assignment: Homework 5
# Description:
# Write or search a program on the Internet that implements a stack algorithm using the
# linked-list concept. The program should store full names and phone numbers and print
# them in ascending order. Modify the program to fit your needs.

# the base program is from geekforgeeks.org. I've modified it so it prints in ascending order
class Node:
  
    # Class to create nodes of linked list
    # constructor initializes node automatically
    def __init__(self, data):
        self.data = data
        self.next = None
  
  
class Stack:
  
    # head is default NULL
    def __init__(self):
        self.head = None
  
    # Checks if stack is empty
    def is_empty(self):
        if self.head == None:
            return True
        else:
            return False
  
    # Method to add data to the stack
    # adds to the start of the stack
    def push(self, data):
  
        if self.head == None:
            self.head = Node(data)
  
        else:
            newnode = Node(data)
            newnode.next = self.head
            self.head = newnode
  
    # Remove element that is the current head (start of the stack)
    def pop(self):
  
        if self.is_empty():
            return None
  
        else:
            # Removes the head node and makes
            # the preceding one the new head
            poppednode = self.head
            self.head = self.head.next
            poppednode.next = None
            return poppednode.data
  
    # Returns the head node data
    def peek(self):
  
        if self.is_empty():
            return None
  
        else:
            return self.head.data
  
# Prints and empties out the stack
def printSortedStack(stack: Stack):
    temp_stack = Stack()

    while not stack.is_empty():
        # Pop an item from the original stack
        item = stack.pop()

        # Move items from temp_stack to original stack if they are smaller
        while not temp_stack.is_empty() and temp_stack.peek() > item:
            stack.push(temp_stack.pop())

        # Push the item onto the temp_stack
        temp_stack.push(item)

    # Print the items in ascending order
    while not temp_stack.is_empty():
        item = temp_stack.pop()
        print(f"{item[0]}: {item[1]}")

if __name__ == "__main__":
    # Example
    stack = Stack()

    # is_empty?
    print(stack.is_empty())

    # Push
    stack.push(("John Smith", "123-456-7890"))
    stack.push(("Michael Hunt", "234-567-8901"))
    stack.push(("Charlie Brown", "345-678-9012"))
    stack.push(("David White", "456-789-0123"))

    # print
    printSortedStack(stack)

    # refill stack
        # Push
    stack.push(("John Smith", "123-456-7890"))
    stack.push(("Michael Hunt", "234-567-8901"))
    stack.push(("Charlie Brown", "345-678-9012"))
    stack.push(("David White", "456-789-0123"))

    # Peek 
    print(stack.peek())
    
    # pop
    stack.pop()
    stack.pop()
    
    printSortedStack(stack)
