#include <iostream>
using namespace std;

struct Person {
   string name;
};

int main() {
   Person *ptr = (Person*)calloc(sizeof(Person), 0);
   ptr->name = "Jonathan";
   cout << "Person name is " << (*ptr).name << endl;
   cout << "Address of Person.name is " << &ptr->name << endl;
   return 0;
}