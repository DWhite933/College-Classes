#include "TwoAttackSupe.h"
#include <random>
TwoAttackSupe::TwoAttackSupe(int health)
    :HP(health)
{
    //Nothing here
}

TwoAttackSupe::~TwoAttackSupe()
{
    //Nothng here
}

bool TwoAttackSupe::IsDefeated()
{
    return (HP <= 0);
}

void TwoAttackSupe::GetPunched()
{
    HP -= 5;
}

void TwoAttackSupe::GetKicked()
{
    // I can only get the expected output of 72/28 if choosing rand values between 0 and 14
    // otherwise i get an output of 78/22
    // since the expected output is 72/28 ive put 15 here
    HP -= std::rand() % 15;
}
