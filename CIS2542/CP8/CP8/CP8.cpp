#include <map>
#include <iostream>
#include <list>

int main()
{
    std::map<int, int> m ;

    for (int i = 2; i <= 18; ++i)
    {
        if (i % 2 == 0)
            m[i] = i * i;
    }

    std::list<int> list;
    int input;

    do
    {
        std::cout << "Input: [-1 to quit]: ";
        std::cin >> input;
        list.push_back(input);
    }while (input != -1);

    for (int num : list)
    {
        std::map<int, int>::iterator iter = m.begin();
        while (iter != m.end())
        {
            if (iter->first == num)
            {
                std::cout << "{" << iter->first << ", " << iter->second << "} ";
            }
            ++iter;
        }
    }
 
    system("PAUSE");
    return 0;
}


