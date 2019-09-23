#pragma once

class Node {

public:
   Node* next;
   int data;
};

class LinkedList {

public:
   int length;
   Node* head;
   
   LinkedList();
   ~LinkedList();
   void add(int data);
   void print();
};