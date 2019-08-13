#include <iostream>
using namespace std;

int main() {

  int pval = 100;
  int *paddr = &pval;

  cout << "dereference of pval is " << &pval << endl;
  cout << "deref of paddr is  " << &paddr << endl;
  cout << "value pointed to by paddr is " << *paddr;

  return 0;

}
