#include <iostream>
#include "LinkedList.h"

int main()
{
	LinkedList a;
	a.Insert(12, 7);
	a.Insert(-3, 2);
	a.Insert(0, 4);
	a.Insert(12, 8);
	a.Insert(3, 17);
	a.Insert(1, 22);
	std::cout << a;
	a.Insert(6, 52);
	std::cout << a;
	a.Insert(6, 76);
	std::cout << a;
	a.Erase(-1);
	std::cout << a;
	a.Erase(0);
	std::cout << a;
	a.Erase(5);
	std::cout << a;
	a.Erase(5);
	std::cout << a;
	a.Erase(2);
	std::cout << a;

	/*
	a.PushFront(30);
	std::cout << a;
	a.PushFront(76);
	std::cout << a;
	a.PushFront(99);
	std::cout << a;
	*/

	/*
	while (true)
	{
		signed short x;
		std::cout << "Enter a find value: ";
		std::cin >> x;
		std::cout << a.Find(x) << std::endl;
	}
	*/
	/*
	for (int i=-3; i<=8;++i)
		std::cout<< i << ": " << a[i] << std::endl;
		*/


	/*
	while (a.Empty() == false)
	{
		a.PopFront();
		std::cout << a;
	}
	*/

	system("PAUSE");
	return 0;
}