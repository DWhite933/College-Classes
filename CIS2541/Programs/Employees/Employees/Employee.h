#ifndef EMPLOYEES_H
#define EMPLOYEES_H
#include <string>
using namespace std;

// Employee class declaration
class Employee
{
private:
	string name; // employee name
	int idNumber; // employee id number
	string department; // employee's department
	string position; // employee job title
public:
	// Constructor 1 (default constructor)
	Employee()
	{// Initialize name, idNumber, department and position to default values
		setName("");
		setIDNumber(0);
		setDepartment("");
		setPosition("");
	}

	// Constructor 2
	Employee(string n, int id)
	{// Intitialize name and idNumber only
		setName(n);
		setIDNumber(id);
		setDepartment("");
		setPosition("");
	}

	// Constructor 3
	Employee(string n, int id, string deprtmnt, string pos)
	{// Initialize name, idNumber, department and position to specified values
		setName(n);
		setIDNumber(id);
		setDepartment(deprtmnt);
		setPosition(pos);
	}

	// Setter methods
	void setName(string n)
	{
		name = n;
	}

	void setIDNumber(int id)
	{
		if (id < 0)
			throw invalid_argument("Invalid ID number");
		else
			idNumber = id;
	}

	void setDepartment(string deprtmnt)
	{
		department = deprtmnt;
	}

	void setPosition(string pos)
	{
		position = pos;
	}

	// getter methods
	string getName() const
	{
		return name;
	}

	int getIdNumber() const
	{
		return idNumber;
	}

	string getDepartment() const
	{
		return department;
	}

	string getPosition() const
	{
		return position;
	}
};
#endif