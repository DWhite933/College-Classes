#include <iostream>
#include "Operand.h"
#include <queue>
#include <stack>

double Calculate(std::queue<Operand*> q)
{
	std::stack<double> s;
	while (q.empty() == false)
	{
		Operand* o = q.front();
		q.pop();

		Number* n = dynamic_cast<Number*>(o);

		if (n != nullptr)
		{
			s.push(n->value);
		}
		else if (dynamic_cast<Add*>(o) != nullptr)
		{
			double a = s.top();
			s.pop();
			double b = s.top();
			s.push(a + b);
		}
		else if (dynamic_cast<Subtract*>(o) != nullptr)
		{
			double a = s.top();
			s.pop();
			double b = s.top();
			s.push(a - b);
		}
		else if (dynamic_cast<Multiply*>(o) != nullptr)
		{
			double a = s.top();
			s.pop();
			double b = s.top();
			s.push(a * b);
		}
		else if (dynamic_cast<Divide*>(o) != nullptr)
		{
			double a = s.top();
			s.pop();
			double b = s.top();
			s.push(a / b);
		}
		else if (dynamic_cast<Square*>(o) != nullptr)
		{
			double a = s.top();
			s.push(a * a);
		}
	}
	if (s.size() != 1)
		throw std::exception("Stack contains incorrect number of elements.");

	return s.top();
}

int main() {

	try {
		std::queue<Operand*> a;
		a.push(new Number(3));
		a.push(new Number(2));
		a.push(new Add());
		std::cout << Calculate(a);
	}
	catch (std::exception e)
	{
		std::cout << e.what();
	}

}