#include <iostream>
#include <string>
using namespace std;

class CPoint {
    private:
    int x, y;

    public:
    CPoint(int a=0, int b=0): x(a), y(b) {}

    const int getX() const {
        return this->x;
    }

    const int getY() const {
        return this->y;
    }

    const CPoint operator+(const CPoint& arg) const {
        return CPoint(x+arg.getX(), y+arg.getY());
    }

    void Print() { cout << "(" << x << ", " << y << ")" << endl; }
};

int main()
{
    CPoint P1(1,1);
    CPoint P2(2,2);
    CPoint P3;

    P3 = P1 + P2;
    P3.Print();

    return 0;
}
