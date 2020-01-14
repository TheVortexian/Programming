#include <iostream>
 
void doNothing(const int &x) // Don't worry about what &x is for now, we're just using it to trick the compiler into thinking variable x is used
{
}
 
int main()
{
    // define an integer variable named x
    int x; // this variable is uninitialized
 
    doNothing(x); // make compiler think we're using this variable
 
    // print the value of x to the screen (who knows what we'll get, because x is uninitialized)
    std::cout << x;
 
    return 0;
}