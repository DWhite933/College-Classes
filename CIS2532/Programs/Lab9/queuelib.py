# queue libary examples
# from: https://www.askpython.com/python-modules/python-queue
import queue
 
# Instantiate the Queue object
q = queue.Queue()
 
# Insert elements 1 to 5 in the queue
for i in range(1, 6):
    q.put(i)
 
print('Now, q.qsize() =', q.qsize())
 
# Now, the queue looks like this:
# (First) 1 <- 2 <- 3 <- 4 <- 5
for i in range(q.qsize()):
    print(q.get())
    
    
# Instantiate the Queue object
u = queue.Queue()
 
# Insert elements 1 to 5 in the queue
for i in range(1, 6):
    u.put(i)
 
print('Now, q.qsize() =', u.qsize())
 
# Empty queue
u.empty()
 
print('After emptying, size =', u.qsize())
 
for i in range(u.qsize()):
    print(u.get())
    