#pragma once
class Operand
{
public:
	virtual ~Operand();

};


class Number : public Operand
{
public:
	Number(double v);
	double value;
};

class Operator : public Operand
{
	// nothing here
};

class Add : public Operator
{

};

class Subtract : public Operator
{

};

class Multiply : public Operator
{

};

class Divide : public Operator
{

};

class Square : public Operator
{

};


