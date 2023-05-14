#include <fstream>
#include <iostream>
#include <list>
#include <string>
#include <algorithm>
#include <cctype>

int main()
{
    std::ifstream file("word_list.txt");
    if (file.fail() == true)
    {
        std::cout << "file not found";
        exit(1);
    }
    std::list<std::string> list;

    while (file.eof() == false)
    {
        std::string a;
        file >> a;
        if (a.size() == 6)
            list.push_back(a);
    }
    file.close();

    for (std::string s : list)
    {
        std::transform(s.begin(), s.end(), s.begin(), tolower);
    }

    std::list<std::string>::iterator iter = list.begin();

    while (iter != list.end())
    {
        std::string s = *iter;
        int check = 0;

        for (int i = 0; i = s.length() - 1; ++i)
        {
            if (std::isalpha(s.at(i)))
                ++check;
        }

        if (check < 1)
            list.erase(iter);

        ++iter;
    }

    for (std::string s : list)
    {
        std::cout << s << " ";
    }
    system("PAUSE");
    return 0;
}


