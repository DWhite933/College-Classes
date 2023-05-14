#pragma once
class TwoAttackSupe
{
public:
	TwoAttackSupe(int health);

	virtual ~TwoAttackSupe();

	bool IsDefeated();

	virtual void GetPunched();
	virtual void GetKicked();
	int HP;

private:

};

