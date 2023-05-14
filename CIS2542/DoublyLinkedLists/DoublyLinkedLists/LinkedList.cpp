#include "LinkedList.h"
#include <limits>

LinkedListNode::LinkedListNode(signed short value,
	LinkedListNode* PREVIOUS,
	LinkedListNode* NEXT)
	: data(value),
	previous(PREVIOUS),
	next(NEXT)
{
}

LinkedList::LinkedList()
	:head(nullptr)
{
}

LinkedList::~LinkedList()
{
	while (Empty() == false)
		PopFront();
}

bool LinkedList::Empty()
{
	return head == nullptr;
}

void LinkedList::PushFront(int VALUE)
{
	if (Empty() == true)
	{
		// no elements
		head = new LinkedListNode(VALUE);
	}
	else
	{
		// min one element
		LinkedListNode* newNode = new LinkedListNode(VALUE, nullptr, head);
		head->previous = newNode;
		head = newNode;
	}
}

void LinkedList::PopFront()
{
	if (Empty() == false)
	{
		// Size?
		if (Size() == 1)
		{
			// 1
			delete head;
			head = nullptr;
		}
		else
		{
			// 2 or more
			LinkedListNode* ToDelete = head;
			head->next->previous = nullptr;
			head = head->next;
			delete ToDelete;
		}
	}
}

int LinkedList::Size() const
{
	int count = 0;
	LinkedListNode* current = head;

	while (current != nullptr)
	{
		++count;
		current = current->next;
	}


	return count;
}

int LinkedList::Find(int value)
{
	int index = 0;
	LinkedListNode* current = head;
	while (current != nullptr)
	{
		if (value == current->data)
		{
			return index;
		}
		++index;
		current = current->next;
	}

	return -1;
}

void LinkedList::Insert(int Index, signed short Value)
{
	if ((Empty() == true) || (Index <= 0))
	{
		// first element
		PushFront(Value);
	}
	else if (Index >= Size() - 1)
	{
		LinkedListNode* prev = nullptr;
		LinkedListNode* current = head;
		while (current != nullptr)
		{
			prev = current;
			current = current->next;
		}
		// current is pointing to the node
		LinkedListNode* newNode = new LinkedListNode(Value, prev);
		prev->next = newNode;
	}
	else
	{
		// anything in between

		// i don't know why, but this keeps inserting one AFTER the specified index
		// it's the exact same code as in the homework video!
		LinkedListNode* current = head;
		for (int i=1; i<=Index; ++i)
		{
			current = current->next;
		}
		LinkedListNode* newNode = new LinkedListNode(Value, current->previous, current);
		current->previous->next = newNode;
		current->previous = newNode;
	}
}

void LinkedList::Erase(int Index)
{
	if ((Size()<= 1) || (Index <= 0))
	{
		PopFront();
	}
	else if (Index >= Size() - 1)
	{
		// has to be a previous element
		LinkedListNode* prev = nullptr;
		LinkedListNode* current = head;
		while (current != nullptr)
		{
			prev = current;
			current = current->next;
		}
		prev->previous->next = nullptr;
		delete prev;
	}
	else
	{
		LinkedListNode* current = head;
		for (int i = 0; i < Index; ++i)
		{
			current = current->next;
		}
		current->previous->next = current->next;
		current->next->previous = current->previous;
		delete current;
	}
}

signed short LinkedList::operator[](int INDEX)
{
	if ((INDEX < 0) || (INDEX >= Size()))
	{
		return std::numeric_limits<signed short>::min();
	}
	LinkedListNode* current = head;
	for (int i = 0; i < INDEX; ++i)
		current = current->next;

	return current->data;
}

std::ostream& operator<<(std::ostream& ostr, const LinkedList& rhs)
{
	ostr << "List: ";
	LinkedListNode* current = rhs.head;
	while (current != nullptr)
	{
		ostr << " " << current->data;
		current = current->next;
	}

	ostr << " Size: "<< rhs.Size() <<  std::endl;
	return ostr;
}
