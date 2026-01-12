#include<iostream>
using namespace std;
int main()
{
    int r;
    cout<<"Number of rows:";
    cin>>r;

    for(int i=r; i>=1; i--){
            for(int s=1; s<=i; s++){
                cout<<"*";
            }
            for(int j=1; j<=i; j++){
                cout<<" ";
            }

        cout<<endl;
    }
    return 0;
}
