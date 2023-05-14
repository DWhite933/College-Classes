// David White
// CIS2542 - Exam 2


#include <iostream>
#include <deque>
#include <vector>

template <typename T>
void printVector(char letter, std::vector<T>& v)
{

    std::cout << letter << ": ";
    for (T t : v)
    {
        std::cout << t << " ";
    }

    std::cout << std::endl;
}

void PartOne()
{
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // 1A
    // PROPERLY SET UP VECTOR a WITH 500000 ELEMENTS IN ORDER 1, 2, 3, 4, ..., 500000
    // PUT EACH ELEMENT IN THE FRONT AS YOU ADD THEM TO THE VECTOR
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    std::vector<int> a;

    for (int i = 0; i < 50000; ++i)
        a.insert(a.begin(), i);

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // 1B
    // PROPERLY SET UP DEQUE b WITH 500000 ELEMENTS IN ORDER 1, 2, 3, 4, ..., 500000
    // PUT EACH ELEMENT IN THE FRONT AS YOU ADD THEM TO THE DEQUE
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    std::deque<int> b;
    for (int i = 0; i < 50000; ++i)
        b.push_front(i);
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // 1C
    // FULLY DESCRIBE WHICH OF THE TWO OPERATIONS IS FASTER THAN THE OTHER AND WHY
    // EITHER USE A COMMENT, OR PRINT YOUR DESCRIPTION TO THE SCREEN
    // UP TO 5 POINTS (MAXIMUM 10 OVERALL) EXTRA CREDIT IF YOU CAN SHOW EVIDENCE OF
    // YOUR DESCRIPTION USING C++ CODE
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // deque is faster at inserting in the front because deque never invalidates pointers or references to the rest of the elements.
}

void PartTwo()
{
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // 2A
    // SET UP VECTOR a WITH 500000 ELEMENTS IN ORDER 1, 2, 3, 4, ..., 500000
    // PUT EACH ELEMENT IN THE BACK AS YOU ADD THEM TO THE VECTOR
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    std::vector<int> a;
    for (int i = 0; i < 50000; ++i)
        a.push_back(i);

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // 2B
    // SET UP DEQUE b WITH 500000 ELEMENTS IN ORDER 1, 2, 3, 4, ..., 500000
    // PUT EACH ELEMENT IN THE BACK AS YOU ADD THEM TO THE DEQUE
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    std::deque<int> b;
    for (int i = 0; i < 50000; ++i)
        b.push_back(i);

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // 2C
    // FULLY DESCRIBE WHICH OF THE TWO OPERATIONS IS FASTER THAN THE OTHER AND WHY
    // EITHER USE A COMMENT, OR PRINT YOUR DESCRIPTION TO THE SCREEN
    // UP TO 5 POINTS (MAXIMUM 10 OVERALL) EXTRA CREDIT IF YOU CAN SHOW EVIDENCE OF
    // YOUR DESCRIPTION USING C++ CODE
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // vector is faster becuase it stores the data contiguously
}

void PartThree()
{
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // 3A
    // 1) INSERT RANDOMLY 5-10 VALUES OF 8 BETWEEN THE 2 AND THE 3 VALUE IN THE a VECTOR
    //    FOR EXAMPLE 1,2,3,4,5 BECOMES 1,2,8,8,8,8,8,8,3,4,5 (6 WAS RANDOMLY GENERATED)
    // 2) EMPTY/CLEAR OUT THE VECTOR BY ONLY USING EITHER erase() OR pop_back()
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    std::vector<int> a{ 1, 2, 3, 4, 5 };

    int g = 0;

    while (g < 5)
        g = rand() % 10;

    for (int i = 0; i < g; ++i)
    {
        a.insert(a.begin() + 2, 8);
    }

    while (a.empty() == false)
        a.pop_back();
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // 3B
    // 1) INSERT RANDOMLY 5-10 VALUES OF 8 BETWEEN THE 2 AND THE 3 VALUE IN THE b DEQUE
    //    FOR EXAMPLE 1,2,3,4,5 BECOMES 1,2,8,8,8,8,8,8,3,4,5 (6 WAS RANDOMLY GENERATED)
    // 2) PROPERLY EMPTY/CLEAR OUT THE DEQUE
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    std::deque<int*> b{ new int(1), new int(2), new int(3), new int(4), new int(5) };

    std::deque<int*>::iterator iter = b.begin();
    iter = iter + 3;

    b.insert(iter, g, new int(8));

    b.clear();
}

// You may not touch this code below
int main()
{
    // Add some variability to the random number generator
    srand(static_cast<unsigned int>(NULL));

    // Work with the fronts of the vector and deque data structures
    PartOne();

    // Work with the backs of the vector and deque data structures
    PartTwo();

    // Work with inserting and clearing the vector and deque data structures
    PartThree();

    // Cleanup
    system("PAUSE");
    return 0;
}