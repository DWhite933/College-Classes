#include "Oven.h"

Oven::Oven()
	: CurrentTemp(72),
	  SetTemp(350),
	  RoomTemp(72),
	  IsOvenOn(false),
	  MaxTemp(550),
	  MinTemp(200)	  
{
	// Nothing Here
}

int Oven::GetCurrentTemperature() const
{
	return CurrentTemp;
}

int Oven::GetSetTemperature() const
{
	return SetTemp;
}

void Oven::SetSetTemperature(int Temp)
{
	if ((Temp >= MinTemp) && (Temp <= MaxTemp))
	{
		SetTemp = Temp;
	}
}

void Oven::TurnOn(int SetTemperature)
{
	IsOvenOn = true;
	SetSetTemperature(SetTemperature);
}

void Oven::TurnOff()
{
	IsOvenOn = false;
}

bool Oven::IsOn() const
{
	return IsOvenOn;
}

int Oven::GetMinimumTemperature() const
{
	return MinTemp;
}

int Oven::GetMaximumTemperature() const
{
	return MaxTemp;
}

int Oven::GetRoomTemperature() const
{
	return RoomTemp;
}

void Oven::SimulatePassingOfTime(int TimeInMinutes)
{
	if (IsOvenOn == true)
	{
		CurrentTemp += (25 * TimeInMinutes);
		if (CurrentTemp > SetTemp)
		{
			CurrentTemp = SetTemp;
		}
	}
	else
	{
		CurrentTemp += (15 * TimeInMinutes);
		if (CurrentTemp < RoomTemp)
		{
			CurrentTemp = RoomTemp;
		}
	}
}
