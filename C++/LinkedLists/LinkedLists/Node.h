#pragma once

template<typename T>
class Node
{
public:
	Node(T val);
	~Node();
	void setValue(T val);
private:
	Node* before;
	Node* after;
	T value;
};