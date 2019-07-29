#include <iostream>
#include <string>
using namespace std;

string calcPi(int n) {
	double pi = atan(1) * 4;
	string stringPi = std::to_string(pi);
	string out = "";
	if (n > 20) {
		n = 20;
	}
	for (int i = 0; i < n; i++) {
		out += stringPi.at(i);
	}
	return out;
}

int main() {
	int n = 0;
	cout << "Enter N: " << endl;
	cin >> n;
	cout << calcPi(n);
}