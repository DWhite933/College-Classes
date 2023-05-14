#include "GameData.h"

GameData::GameData()
	: Shines(0),
	  Coins(0)
{
}

int GameData::GetShines() const
{
	return Shines;
}

int GameData::GetBlueCoins() const
{
	return Coins;
}

void GameData::AddShines(int shines)
{
	if (shines > 0)
	{
		Shines += shines;
	}
}

void GameData::AddBlueCoins(int coins)
{
	if (coins > 0)
	{
		Coins += coins;
	}
}

void GameData::ConvertBlueCoinsToShines()
{
	while (Coins >= 10)
	{
		Coins -= 10;
		++Shines;
	}
}

bool GameData::CanMarioGoToCoronaMountain() const
{
	return Shines >= 50;
}
