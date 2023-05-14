#pragma once
#include <iostream>

class LinkedListNode
{
public:
	LinkedListNode(signed short value, LinkedListNode* PREVIOUS = nullptr, LinkedListNode* NEXT = nullptr);

	signed short data;
	LinkedListNode* previous;
	LinkedListNode* next;

};




class LinkedList
{
public:
	LinkedList();
	~LinkedList();


	bool Empty();
	void PushFront(int VALUE);
	void PopFront();
	int Size() const;
	int Find(int value);
	void Insert(int Index, signed short Value);
	void Erase(int Index);

	signed short operator[](int INDEX);

	friend std::ostream& operator <<(std::ostream& ostr, const LinkedList& rhs);


private:
	LinkedListNode* head;
};

