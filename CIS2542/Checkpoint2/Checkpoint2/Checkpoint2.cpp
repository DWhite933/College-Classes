#include <iostream>

// ------
// Part 1
// ------
// - Develop a C++ template function called ThreeQuarters() that does the following:
//       - Has one single T type input parameter
//       - Has a T type return value
//       - Continually multiplies the input parameter by 3/4 until it is reduced to less than 1
//       - Sum up all the individual values computed along the way
//       - See Blackboard for many different examples of this function being used

// ------
// Part 2
// ------
// - As you work your value down to below 1, if at any time the value ends up
//   between 3.14 and 3.15, throw an std::exception
// - Put the new code into the same function you developed for the first part

template <typename T>
T ThreeQuarters(T x)
{
	T sum = x;
	std::cout << x;
	while (x > 1)
	{
		x = (x * 3) / 4;
		std::cout << " + " << x;
		if ((x >= 3.14) && (x <= 3.15))
			throw std::exception("I specifically asked for no pie!");

		sum += x;
	}
	std::cout << " = " << sum << std::endl;
	return sum;
}

int main()
{
	// ------
	// Part 3
	// ------
	// - Wrap up the code below in a proper try/catch block
	// - The goal of course is to run through this code without issue
	// - But if an exception gets caught, print "I specifically asked for no pie!" instead
	try {


		std::cout << "PART 1 - Enter an integer value: ";
		int x;
		std::cin >> x;
		std::cout << "The transformed value is: " << ThreeQuarters<int>(x) << std::endl;

		std::cout << "PART 1 - Enter a double value:   ";
		double y;
		std::cin >> y;
		std::cout << "The transformed value is: " << ThreeQuarters<double>(y) << std::endl;



		// ------
		// Part 4
		// ------
		// Find any other input value (nothing close to 7.459) that actually triggers the exception case

		ThreeQuarters<double>(17.648);
	}
	catch (const std::exception e)
	{
		std::cout << std::endl << e.what() << std::endl;
	}

	return 0;
}