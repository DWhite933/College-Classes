#include <iostream>
#include <map>

int main()
{
    std::map<int, int> m;

    for (int i = 1; i < 5; ++i)
    {
        std::cout << "Enter dice roll: ";
        int value;
        std::cin >> value;
        ++m[value];
    }

    if (m.size() == 1)
    {
        std::cout << "YAHTZEE!!!!!" << std::endl;
    }
    else if (m.size() == 2)
    {
        int x = m.begin()->second;

        if ((x == 1) || (x == 4))
        {
            std::cout << "FOUR OF A KIND!!!!" << std::endl;
        }
        else
        {
            std::cout << "FULL HOUSE!!!" << std::endl;
        }
    }
    else if (m.size() == 3)
    {
        int total = 0;

        for (const std::pair<int, int>& die : m)
        {
            if (die.second > 1)
            {
                total += die.second;
            }
        }

        if (total == 3)
        {
            std::cout << "THREE OF A KIND!!!" << std::endl;
        }
        else
        {
            std::cout << "TWO PAIR" << std::endl;
        }
    }
    else if (m.size() == 4)
    {
        int total = 0;

        for (const std::pair<int, int>& die : m)
        {
            total += die.first;
        }

        if ((total == 10) || (total == 18))
            std::cout << "LARGE STRAIGHT!" << std::endl;
        else if (total == 14)
        {
            if (m.begin()->first == 2)
                std::cout << "LARGE STRAIGHT!" << std::endl;
        }
        else
            std::cout << "YOU'VE GOT NOTHING." << std::endl;
    }
    else if (m.size() == 5)
    {
        int total = 0;

        for (const std::pair<int, int>& die : m)
        {
            total += die.first;
        }

        if ((total == 15) || (total == 20))
            std::cout << "LARGE STRAIGHT!" << std::endl;
        else if ((total == 16) || (total == 19))
            std::cout << "SMALL STRAIGHT!" << std::endl;
        else
            std::cout << "YOU'VE GOT NOTHING." << std::endl;
    }

    system("PAUSE");
    return 0;
}