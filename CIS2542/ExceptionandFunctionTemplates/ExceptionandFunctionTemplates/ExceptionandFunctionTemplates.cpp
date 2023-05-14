/*

Name: David White
Class: CIS2542
Instructor: Bradley Sward
File: ExceptionandFunctionTemplates.cpp
Description:
Develop a C++ function template called Discriminant() that calculates and returns the discriminant value
Develop a C++ main function that tests your Discriminant function

 */

#include <iomanip>
#include <cmath>
#include <iostream>

template <typename T>
T Discriminant(T a, T b, T c)
{
    T d = (b * b) - (4.0 * a * c);

    if (d < 0)
    {
        throw std::exception("Discriminant(a, b, c): Negative Discriminant Encountered");
    }
    return d;
}

int main()
{
    char contin;
    do
    {
         try
        {
            double a;
            double b;
            double c;

            std::cout << "Enter a: ";
            std::cin >> a;
            std::cout << "Enter b: ";
            std::cin >> b;
            std::cout << "Enter c: ";
            std::cin >> c;


            double d = Discriminant(a, b, c);
  
            std::cout << std::fixed << std::setprecision(2);
            std::cout << "Descriminant: " << d << std::endl;
        }
        catch (const std::exception& e)
        {
            std::cout << e.what() << std::endl;
        }

        do
        {
            std::cout << "Repeat? [Y/N]: ";
            std::cin >> contin;
            contin = toupper(contin);
        } while ((contin != 'Y') && (contin != 'N'));

    } while (contin == 'Y');
}
