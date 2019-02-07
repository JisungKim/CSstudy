#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main()
{
	int i;
	vector<int> v;

	for(i=1; i<10; i++)
		v.push_back(i);

	cout << "제거 전 : ";
	for(vector<int>::iterator iter=v.begin(); iter!=v.end(); ++iter)
		cout << *iter << " ";

	cout << endl;

	vector<int>::iterator iter_end;

	for(i=0;i<5;i++)
		iter_end = remove(v.begin(), v.end(), 2*i+1);

	cout << "제거 후 : ";
	for(vector<int>::iterator iter=v.begin(); iter!=iter_end;++iter)
		cout << *iter << " ";

	cout << endl;
	return 0;
}
