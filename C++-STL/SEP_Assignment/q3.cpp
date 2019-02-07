#include <iostream>
#include <string>
using namespace std;

int main()
{
	string str("Hello!");

	cout << str << endl;
	cout << "0부터 2개의 문자열 : " << str.at(0) << str.at(1) << endl;
	cout << "문자 e를 검색 : " << str.find("e") << endl;
	cout << "Hello! 문자열 다음에 STL 문자열을 추가 : " << str.append("STL") << endl;

	return 0;
}
