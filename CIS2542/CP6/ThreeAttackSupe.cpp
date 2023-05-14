#include "ThreeAttackSupe.h"

ThreeAttackSupe::ThreeAttackSupe(int health, int stamina)
	:SP(stamina), TwoAttackSupe(health)
{
	// Nothing here
}

void ThreeAttackSupe::GetPunched()
{
	SP += 2;
	HP -= SP;
}

void ThreeAttackSupe::GetKicked()
{
	SP += 1;
	HP += SP;
}

void ThreeAttackSupe::GetSuperPowered()
{
	SP == 0;
	HP -= 20;
}
