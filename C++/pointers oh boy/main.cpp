#include <iostream>
int main() {

    int x = 5;
    std::cout << x << std::endl;
    std::cout << &x << std::endl; // this means address-of operator
    std::cout << *(&x) << std::endl; // this means dereference operator, or gets the value of an address

    return 0;
}