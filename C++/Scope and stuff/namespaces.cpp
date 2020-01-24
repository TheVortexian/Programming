namespace foo {
    int doSomething(int x, int y) {
        return x+y;
    }
}

 namespace goo {
     int doSomething(int x, int y) {
         return x-y;
     }
 }

#include <iostream>

 int main() {
     std::cout << foo::doSomething(104, -2);
     std::cout << goo::doSomething(foo::doSomething(3, 81), -9);
 }