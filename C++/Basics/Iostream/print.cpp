#include <iostream>

int main() {
   
   std::cout << "Hello, World!" << std::endl;
   std::cout << "Hello, " << " world!" << std::endl;
   
   int x = 4;
   std::cout << x << std::endl;
   std::cout << "Enter a value for x: ";
   std::cin >> x;
   std::cout << "You entered " << x;

   return 0;
}