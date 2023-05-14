#include "Stack.h"
#include <iostream>

int main()
{
	// constructor
	Stack s;

	// empty()
	if (s.empty() == true)
	{
		std::cout << "Stack is empty" << std::endl;
	}
	else
	{
		std::cout << "Stack is not empty" << std::endl;
	}

	// push()
	s.push(25);
	s.push(52.5);
	s.push(62.5);

	// size()
	if (s.size() == 3)
	{
		std::cout << "Stack size is 3" << std::endl;
	}
	else
	{
		std::cout << "Stack size is not 3" << std::endl;
	}

	// top()
	std::cout << s.top() << " is on top" << std::endl;

	// copy constructor
	Stack g = s;

	// equal operator
	Stack a;
	a = s;

	// swap() and pop() 
	Stack b;
	b.push(45);
	b.push(25);
	b.push(75.5);

	std::cout << "B) " << std::endl;;
	while (b.empty() == false)
	{
		std::cout << b.top() << std::endl;
		b.pop();
	}

	b.swap(a);

	std::cout << "A) " << std::endl;;
	while (b.empty() == false)
	{
		std::cout << b.top() << std::endl;
		b.pop();
	}


	system("PAUSE");


}


