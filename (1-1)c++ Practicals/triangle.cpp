#include<iostream>
using namespace std;
int main()
{
    int r;
    cout<<"Number of rows:";
    cin>>r;

    for(int i=1; i<=r; i++){
            for(int s=1; s<=r-i; s++){
                cout<<" ";
            }
            for(int j=1; j<=2*i-1; j++){
                cout<<"*";
            }

        cout<<endl;
    }
    return 0;
}
