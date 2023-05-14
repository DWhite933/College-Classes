#include "Stack.h"

Stack::Stack()
	:d()
{
	// Nothing here
}

Stack::Stack(const Stack& rhs)
	:d(rhs.d)
{
	//nothing here
}

Stack& Stack::operator=(const Stack& rhs)
{
	d = rhs.d;
	return *this;
}

bool Stack::empty()
{
	return d.empty();
}

void Stack::pop()
{
	d.pop_back();
}

void Stack::push(double value)
{
	d.push_back(value);
}

int Stack::size()
{
	return d.size();
}

void Stack::swap(Stack& rhs)
{
	std::swap(d, rhs.d);
}

double Stack::top()
{
	return d.back();
}
