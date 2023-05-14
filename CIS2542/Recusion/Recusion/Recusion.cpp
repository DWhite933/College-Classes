#include <iostream>
#include <string>

int Appearances(int value, int search)
{
    if (value < 10)
        return value == search;

    return Appearances(value/10, search) + (value%10 == search);
}

std::string IntegerToBase6(int value)
{
    if (value < 6)
        return std::to_string(value % 6);
    return IntegerToBase6(value / 6) + std::to_string(value % 6);
}

int main()
{
    std::cout << "1? " << Appearances(0, 0) << std::endl;
    std::cout << "0? " << Appearances(0, 1) << std::endl;
    std::cout << "0? " << Appearances(8, 7) << std::endl;
    std::cout << "1? " << Appearances(8, 8) << std::endl;
    std::cout << "3? " << Appearances(1000, 0) << std::endl;
    std::cout << "3? " << Appearances(5326822, 2) << std::endl;

    for (int i = 0; i <= 100; ++i)
    {
        std::cout << i << ": " << IntegerToBase6(i) << std::endl;
    }
    std::cout << "5324422: " << IntegerToBase6(5326822) << std::endl;

    system("PAUSE");
    return 0;
}


