// David White
// David White
// David White
// CIS2542 - Summer 2022 - Checkpoint 05

#include <iostream>
#include <deque>
#include <queue>
#include <stack>
#include <string>

int main()
{
    // Here is your input string
    std::string passcode = "LLSNEEIRUIGNUL-CHXUADUPUGD-RTYI61IE-GDD5E0-607325-8576A598DFJ-EH8IKD7E037FJKE87--54625B6870-FJE941597---FHE7FHJ8KEN436-471369073C8767DFE-7KO8FLKE6895-8934";

    // Create an empty stack
    std::stack<char> s;

    // The first 15 characters of the string get pushed into the stack in order
    for (int i = 0; i < 15; ++i)
    {
        s.push(passcode.at(0));
        passcode.erase(passcode.begin());
    }

    // Create an empty queue
    std::queue<char> q;

    // The next 16 characters of the string get pushed into the queue in order
    for (int i = 0; i < 16; ++i)
    {
        q.push(passcode.at(0));
        passcode.erase(passcode.begin());
    }

    // Create an empty deque
    std::deque<char> deq;

    int max = passcode.size();

    // For the remaining characters of the string in order:
    for (int i = 0; i < max; ++i)
    {
        // 1 - Pop the stack
        // gives out of range exception if i used at(i)
        if (passcode[i] == '1')
            s.pop();

        // 2 - Pop the queue
        if (passcode.at(i) == '2')
            q.pop();

        // 3 - Pop the front of the deque
        if (passcode.at(i) == '3')
            deq.pop_front();

        // 4 - Pop the back of the deque
        if (passcode.at(i) == '4')
            deq.pop_back();

        // 5 - Move the top element of the stack to the back of queue
        if (passcode.at(i) == '5')
        {
            q.push(s.top());
            s.pop();
        }
        // 6 - Move the front element of the queue to the top of stack
        if (passcode.at(i) == '6')
        {
            s.push(q.front());
            q.pop();
        }
        // 7 - Move the top element of the stack to the front of deque
        if (passcode.at(i) == '7')
        {
            deq.push_front(s.top());
            s.pop();
        }
        // 8 - Move the front element of the queue to the front of deque
        if (passcode.at(i) == '8')
        {
            deq.push_front(q.front());
            q.pop();
        }
        // Anything else - Do nothing and move on
    }

    std::cout << "How might you feel when you get this encryption scheme working properly?" << std::endl;

    // The deque will have the secret phrase in it, listed from front to back, so print it out
    max = deq.size();
    for (int i = 0; i < max; ++i)
    {
        std::cout << deq[i];
    }
    std::cout << std::endl;

    // Cleanup
    system("PAUSE");
    return 0;
}