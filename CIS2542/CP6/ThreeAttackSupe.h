#pragma once
#include "TwoAttackSupe.h"
class ThreeAttackSupe : public TwoAttackSupe
{
public:
	ThreeAttackSupe(int health, int stamina);

	virtual void GetPunched();
	virtual void GetKicked();
	virtual void GetSuperPowered();

private:
	int SP;
};

