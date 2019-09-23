#include <iostream>

using namespace std;

void segfault() {
   int *p1 = NULL;
   *p1 = 10;
}

void notsegfault(int i) {
  int pval = i;
  int *paddr = &pval;

  cout << "addr of pval is " << &pval << endl;
  cout << "addr of paddr is  " << &paddr << endl;
  cout << "value pointed to by paddr is " << *paddr;
}

int main() {
   segfault();
   return 0;
}
