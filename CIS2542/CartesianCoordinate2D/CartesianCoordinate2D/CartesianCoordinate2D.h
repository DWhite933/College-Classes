#pragma once
#include <iostream>

class CartesianCoordinate2D
{
public:
	CartesianCoordinate2D(double x = 0.0, double y = 0.0);
	CartesianCoordinate2D(const CartesianCoordinate2D& rhs);

	double GetX() const;
	void SetX(double x);

	double GetY() const;
	void SetY(double y);

	double GetDistance() const;
	int GetQuadrant() const;

	CartesianCoordinate2D& operator =(const CartesianCoordinate2D& rhs);
	CartesianCoordinate2D operator -(const CartesianCoordinate2D& rhs);
	CartesianCoordinate2D& operator -=(const CartesianCoordinate2D& rhs);
	

	friend std::ostream& operator<<(std::ostream& ostr, const CartesianCoordinate2D& rhs);

	bool operator >(const CartesianCoordinate2D& rhs);

private:
	double X;
	double Y;
};
