//============================================================================
// Name        : learnding.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
class Obj {
public:
	int operator+(int a) {return b+=a;};
	Obj(int a) { b=a;};
	int b;
};
int main() {
	Obj a(10);
	cout << a.b << a+10;
	return 0;
}
