#include<iostream>
using namespace std;
int main()
{
    int r;
    cout<<"Number of rows:";
    cin>>r;

    for (int i=1; i<=r; i++)
    {
        for(int k=0; k<i; k++)
        {
            cout<<"*";
        }
        cout<<endl;
    }

}
