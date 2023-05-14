/*
1) Develop a function that properly prints out each element of a vector of strings

Print an endline character when done to make sure the next print starts on a new line
Earn up to 5 points extra credit to make this function templated to the vector type passed in

2) Implement the following functionality using std::vector and std::string data types:

Create a second "new" vector, copying the first vector's elements using iterators
Do not copy the first two elements and the last two elements into the new vector
Print the "new" vector using your function
Sort the "new" vector alphabetically
Print the "new" vector using your function
Change every 'o' character in the "original" vector into a '@' character
Print the "original" vector using your function*/


#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

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

int main()
{
    std::vector<std::string> v = { "olleh", "ereht", "skool", "ekil", "uoy", "desrever", "gnihtyreve", "gnidrocca", "ot", "nalp", "doog", "boj" };

    printVector('v', v);

    for (int i = 0; i < v.size(); ++i)
        reverse(v.at(i).begin(), v.at(i).end());

    printVector('v', v);

    std::vector<std::string> w(v.begin() + 2, v.end() - 2);

    printVector('w', w);

    sort(w.begin(),w.end());

    printVector('w', w);

    for (int i = 0; i < v.size(); ++i)
    {
        std::replace(v.at(i).begin(), v.at(i).end(), 'o', '@');
    }

    printVector('v', v);
}


