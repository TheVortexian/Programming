#include <iostream>

int main() {
   int userVariable = 0;
   
   while (userVariable >= 0) {
      std::cout << "\nEnter a number (-1 to exit): ";
      std::cin >> userVariable;
      std::cout << "I got " << 2*userVariable << std::endl;
   }
   
   return 0;
}