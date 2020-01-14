#include <iostream>

// we have to declare functions ABOVE the main method

void println() {
   std::cout << "I'm inside a separate function!" << std::endl;
}

int main() {
   println();
   return 0;
}