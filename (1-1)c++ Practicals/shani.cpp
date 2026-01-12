#include<iostream>
using namespace std;
int main()
{
    int x,rn=0;
    cout<<"enter number";
    cin>>x;

    while(x!=0)
    {
        int y=x%10;
        rn=rn*10+y;
        x=x/10;

    }
    cout<<rn;
}
