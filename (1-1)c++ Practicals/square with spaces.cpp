#include<iostream>
using namespace std;
int main()
{
    int r;
    cout<<"Number of rows:";
    cin>>r;

    for(int i=1; i<=r; i++){
            for(int s=1; s<=r; s++){
                if(i==1||i==r||s==1||s==r){
                    cout<<"*";
                }
                else{
                    cout<<" ";
                }
            }
        cout<<endl;
    }
    return 0;
}
