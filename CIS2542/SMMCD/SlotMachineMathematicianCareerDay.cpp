

#include <iostream>
#include <vector>



int main()
{
    std::vector<int> L{ 1, 1, 3, 4, 5, 2, 2, 3, 4, 2, 2, 5, 3, 5, 3, 4, 2, 1, 2, 5, 4, 3, 2 };
    std::vector<int> C{ 3, 1, 2, 2, 3, 5, 4, 4, 2, 2, 3, 2, 1, 5, 4, 3, 3, 2, 1, 5, 4, 1, 3, 5 };
    std::vector<int> R{ 2, 3, 5, 4, 4, 3, 1, 1, 2, 2, 3, 5, 4, 3, 2, 1, 2, 1, 5, 1, 3, 4, 1, 5, 2 };

    int spins = 0;
    int wins = 0;
    for (int a : L)
    {
        for (int b : C)
        {
            for (int c : R)
            {
                if ((a == 1) && (b == 1) && (c == 1)) wins += 2;
                if ((a == 2) && (b == 2) && (c == 2)) wins += 7;
                if ((a == 3) && (b == 3) && (c == 3)) wins += 10;
                if ((a == 3) && (b == 3) && (c == 1)) wins += 2;
                if ((a == 3) && (b == 3) && (c == 2)) wins += 2;
                if ((a == 3) && (b == 3) && (c == 4)) wins += 3;
                if ((a == 3) && (b == 3) && (c == 5)) wins += 4;
                if ((a == 4) && (b == 4) && (c == 4)) wins += 15;
                if ((a == 4) && (b == 4) && (c == 1)) wins += 5;
                if ((a == 4) && (b == 4) && (c == 2)) wins += 5;
                if ((a == 4) && (b == 4) && (c == 3)) wins += 2;
                if ((a == 4) && (b == 4) && (c == 5)) wins += 6;
                if ((a == 1) && (b == 2) && (c == 3)) wins += 2;
                if ((a == 5) && (b == 5) && (c == 1)) wins += 2;
                if ((a == 5) && (b == 5) && (c == 5)) wins += 70;

\
                ++spins;
            }
        }
    }

    std::cout << wins << std::endl;;
    std::cout << spins << std::endl;
    std::cout << wins / static_cast<double> (spins) * 100 << std::endl;

    system("PAUSE");
    return 0;
}

