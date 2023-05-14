// TinkeringwithStlLists.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <algorithm>
#include <list>

void PrintList(char x, const std::list<int>& L)
{
    std::cout << x << ": ";
    for (int i : L) {
        std::cout << i << " ";
    }
    std::cout << std::endl;
}

bool isOdd(int x)
{
    return x & 1 == 1;
}

bool SortTwoWays(int a, int b)
{
    bool isAEven = ((a & 1) == 0);
    bool isBEven = ((b & 1) == 0);

    if (isAEven && !isBEven)
        return true;
    if (!isAEven && isBEven)
        return false;

    return a > b;
}


int main()
{
    // Create list a which is initialized to 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
    std::list<int> a{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
    PrintList('a', a);

    // Create list b which is initialized to 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1
    std::list<int> b{ 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
    PrintList('b', b);

    // Reverse list b
    b.reverse();
    PrintList('b', b);

    // Create list k which initializes with a copy of every element of a, using the copy constructor
    std::list<int> k(a);
    PrintList('k', k);

    // Create list m which initializes with a copy of every element of b, using iterators of b
    std::list<int>m(b.begin(), b.end());
    PrintList('m', m);

    // Merge list m into list k
    k.merge(m);
    PrintList('k', k);
    PrintList('m', m);

    // Remove all duplicates of consecutive elements from k
    k.unique();
    PrintList('k', k);

    // Create list d which initializes with a copy of every element of a, using the copy constructor
    std::list<int> d(a);

    // Create list c which initializes with a copy of every element of b, using iterators of b
    std::list<int> c(b.begin(), b.end());

    // Create list e as a list of 7 elements all initialized to 9
    std::list<int>e(7, 9);
    PrintList('e', e);

    // Create list f which uses a loop to set up the list into the squares of the first 30 numbers
    // 1, 4, 9, 25, 36, 49, 64, 81, 100, ...
    std::list<int> f;
    for (int i = 1; i <= 30; ++i) {
        f.insert(f.end(), i * i);
    }
    PrintList('f', f);

    // Use std::stable_partition() and std::erase() to eliminate all odd values from linked list f
    std::list<int>::iterator iter = std::stable_partition(f.begin(), f.end(), isOdd);
    PrintList('f', f);

    f.erase(f.begin(), iter);
    PrintList('f', f);

    // Create list h which uses a loop to initialize the list to the squares of the first 50 numbers
    // 1, 4, 9, 25, 36, 49, 64, 81, 100, ...
    std::list<int> h;
    for (int i = 1; i <= 20; ++i) {
        int x = 1 + (rand() % 100);
        h.insert(h.end(), x * x);
    }
    PrintList('h', h);

    h.sort(SortTwoWays);
    PrintList('h', h);

    // Find a way to use std::erase() to eliminate all odd values from linked list h
    iter = std::find_if(h.begin(), h.end(), isOdd);
    h.erase(iter, h.end());
    PrintList('h', h);

}

