#include <iostream>

using namespace std;
template<typename T> void Swap(T &a, T &b)
{
    T temp = a;
    a = b;
    b = temp;
}

int main()
{
    int n1 = 10, n2 = 20;
    double d1 = 10.5, d2 = 20.7;
    cout << "Before : " << n1 << "\t" << n2 << endl;
    Swap(n1, n2);
    cout << "After : " << n1 << "\t" << n2 << endl;

    cout << "Before : " << d1 << "\t" << d2 << endl;
    Swap(d1, d2);
    cout << "After : " << d1 << "\t" << d2 << endl;
    return 0;
}
