// CharacterVectorMagic.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <vector>
#include <algorithm>

void PrintCharVector(const std::vector<char>& vec)
{
    for (char character : vec) {
        std::cout << character;
    }
    std::cout << std::endl;
}

void PrintCharVectorPointer(const std::vector<char*>& vec)
{
    for (char* character : vec) {
        std::cout << *character;
    }
    std::cout << std::endl;
}
int main()
{

    std::vector<char> c{ 'a', 'b', 'c', 'd', 'e' };
    c.reserve(26);

    for (char character = 'f'; character <= 'z'; ++character)
    {
        c.push_back(character);
    }

    PrintCharVector(c);

    std::random_shuffle(c.begin(), c.end());

    PrintCharVector(c);


    std::vector<char>::iterator it = std::find(c.begin(), c.end(),'z');
    if (it != c.end()) {
        c.erase(it);
    }

    PrintCharVector(c);

    for (int i = 1; i <= 5; ++i)
    {
        int index = rand() % c.size();
        c.erase(c.begin() + index);
    }

    PrintCharVector(c);

    std::sort(c.begin(), c.end());

    PrintCharVector(c);

    std::vector<char*> p;


    p.reserve(5);


    for (int i = 0; i < 5; i++)
    {
        char toPush = c[i];
        p.push_back(new char(toPush));
    }




    PrintCharVectorPointer(p);

    std::random_shuffle(p.begin(), p.end());

    PrintCharVectorPointer(p);

    std::sort(p.begin(), p.end(), [](char* a, char* b) { return *a < *b; });

    PrintCharVectorPointer(p);

    for (char* point : p)
    {
        delete point;
    }

    p.clear();
    PrintCharVectorPointer(p);

    std::cout << "Done It!" << std::endl;

    system("PAUSE");
    return 0;
}

