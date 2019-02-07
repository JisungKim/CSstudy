#include <iostream>
#include <vector>
#include <cassert>
#include <numeric>
using namespace std;

int mult(int x, int y)
{
	return x*y;
}

int main()
{
	int x[5] = {2,3,5,7,11};
	vector<int> vector1(&x[0], &x[5]);

	int i;
	cout << "Vector value : ";
	for(i=0;i<vector1.size();i++){
		cout << vector1[i] << " ";
	}

	cout << endl;

	int acc, mul;

	acc = accumulate(vector1.begin(), vector1.end(), 0);
	mul = accumulate(vector1.begin(), vector1.end(), 1, mult);

	cout << "더한 값 : " << acc << endl << "곱한 값 : " << mul << endl;

	return 0;
}
