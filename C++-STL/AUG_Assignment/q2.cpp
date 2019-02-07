#include <iostream>
#include <string.h>
using namespace std;

class A {
    friend bool operator==(const A& a1, const A& a2);

    private:
    int value;

    public:
    A(int a): value(a) { }
    A(const char *a) { value = strlen(a); }

   const int get() const {
        return this->value;
    }

    const bool operator==(const A& a1) {
        return a1.value == this->value;
    }
};

int main() {
    A a(2);

    a = 3;
    cout << a.get() << endl;

    a = "Korea";
    cout << a.get() << endl;

    return 0;
}
