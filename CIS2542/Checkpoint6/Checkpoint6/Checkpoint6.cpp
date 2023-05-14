#include <iomanip>
#include <iostream>
#include "TwoAttackSupe.h"
#include "ThreeAttackSupe.h"

int main()
{
    // Maintain win counts
    int MusclesWins = 0;
    int BonesWins = 0;

    // Let's simulate 100000 rounds between these two
    for (int Rounds = 0; Rounds < 100000; ++Rounds)
    {
        // Initialize
        TwoAttackSupe Muscles(50);
        ThreeAttackSupe Bones(45, 40);

        // Repeat until one is defeated
        while ((Muscles.IsDefeated() == false) && (Bones.IsDefeated() == false))
        {
            // Equal chance of kick or punch
            int attack = rand() % 2;
            if (attack == 0)
                Muscles.GetKicked();
            else
                Muscles.GetPunched();

            // Equal chance of kick, punch, or superpower
            attack = rand() % 3;
            if (attack == 0)
                Bones.GetKicked();
            else if (attack == 1)
                Bones.GetPunched();
            else
                Bones.GetSuperPowered();
        }

        // Muscles gets attacked first always, so check first
        if (Muscles.IsDefeated())
            ++BonesWins;
        else
            ++MusclesWins;
    }

    double TotalRounds = BonesWins + MusclesWins;
    // Muscles should win about 72% of the time
    std::cout << "Muscles Wins: " << std::fixed << std::setprecision(1);
    std::cout << (MusclesWins / TotalRounds * 100) << std::endl;
    // Bones should win about 28% of the time
    std::cout << "Bones Wins:   " << std::setprecision(1);
    std::cout << (BonesWins / TotalRounds * 100) << std::endl;

    return 0;
}