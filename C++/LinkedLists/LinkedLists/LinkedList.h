#pragma once
#include "Node.h"

template <typename T>
class LinkedList
{
public:
	int size;
	void add(Node<T>* obj);
	void remove(int index);
	long getPrevious(int index);
	long getNext(int index);
private:
	vector<Node> list;
};