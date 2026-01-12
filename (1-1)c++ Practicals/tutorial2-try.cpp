#include<iostream>
using namespace std;
int main()
{
    int row;
    cout<<"Enter the number of rows:";
    cin>>row;
    for(int i=1; i<=row/2; i++){
        for( int j=1; j<row; j++){
            cout<<" ";
        }
        for(int k=0; k<i; k++){
            cout<<"*";
        }
        cout<<endl;
    }
    for(int i=1; i<=row/2; i++){
        for(int j=i; j<row/2; j++){
            cout<<" ";
        }
        for(int k=0; k<i; k++){
            cout<<"*";
        }
        for(int j=i;j<(2*(row/2))-i; j++){
            cout<<" ";
        }
        cout<<endl;
    }
    return 0;


}
