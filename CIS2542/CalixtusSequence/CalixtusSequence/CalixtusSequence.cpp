/*
Name: David White
Class: CIS2542
Instructor: Bradley Sward
File: CalixtusSequence.cpp
Description:
Develop a C++ program that fulfills the following requirements:

Generate the first 100 values in the Calixtus sequence following the sequencing rules
Store all of the first 100 values of the Calixtus sequence in an integer array (or vector)
Using your array/vector, output each of the 100 values to the screen, with tabs separating each value
Using your array/vector, output each of the 100 values to a text file, with spaces separating each value
 */

#include <iostream>
#include <vector>

int main()
{
    // initialize vector
    std::vector<int> calx{ 1, 3 };

    // put seequence into vector
    for (int i = 2; i < 100; ++i) 
    {
        if (i % 3 == 0)
        {
            calx.push_back(calx[i - 1] + calx[i - 2]);
        }
        else if (i % 2 == 0)
        {
            calx.push_back(calx[(i - 1) / 2]);
        }
        else
        {
            calx.push_back(i);
        }
    }

    // display vector with tabs
    for (int i : calx)
    {
        std::cout << i << "\t";
    }

    std::cout << std::endl;

    // display vector with spaces
    for (int i : calx)
    {
        std::cout << i << " ";
    }
}


