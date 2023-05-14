#include <cmath>
#include "CartesianCoordinate2D.h"

CartesianCoordinate2D::CartesianCoordinate2D(double x, double y)
	: X(x), 
	  Y(y)
{
	// Nothing here...
}

CartesianCoordinate2D::CartesianCoordinate2D(const CartesianCoordinate2D& rhs)
	: CartesianCoordinate2D(rhs.X, rhs.Y)
{
	// Nothing here...
}

double CartesianCoordinate2D::GetX() const
{
	return X;
}

void CartesianCoordinate2D::SetX(double x)
{
	X = x;
}

double CartesianCoordinate2D::GetY() const
{
	return Y;
}

void CartesianCoordinate2D::SetY(double y)
{
	y = Y;
}

double CartesianCoordinate2D::GetDistance() const
{
	return sqrt((X * X) + (Y * Y));
}

int CartesianCoordinate2D::GetQuadrant() const
{
	if (X > 0)
	{
		if (Y > 0)
		{
			return 1;
		}
		else if (Y < 0)
		{
			return 4;
		}
		return 0;
	}

	if (X < 0)
	{
		if (Y > 0)
		{
			return 2;
		}
		else if (Y < 0)
		{
			return 3;
		}
		return 0;
	}
	return 0;
}

CartesianCoordinate2D& CartesianCoordinate2D::operator =(const CartesianCoordinate2D& rhs)
{
	X = rhs.X;
	Y = rhs.Y;
	return *this;
}

CartesianCoordinate2D CartesianCoordinate2D::operator -(const CartesianCoordinate2D& rhs)
{
	return CartesianCoordinate2D(X - rhs.X, Y - rhs.Y);
}

CartesianCoordinate2D& CartesianCoordinate2D::operator-=(const CartesianCoordinate2D& rhs)
{
	X -= rhs.X;
	Y -= rhs.Y;
	return *this;
}

bool CartesianCoordinate2D::operator>(const CartesianCoordinate2D& rhs)
{
	return GetDistance() > rhs.GetDistance();
}


std::ostream& operator<<(std::ostream& ostr, const CartesianCoordinate2D& rhs)
{
	ostr << "(" << rhs.X << "," << rhs.Y << ")";
	return ostr;
}
