#include<iostream>
using namespace std;
int main()
{
    string a;
    cout<<"Enter:";
    getline(cin,a);

    a[0]='d';

    cout<<"No:"<<a.length()<<endl<<a;

    return 0;
}
