#include <iostream>
using namespace std;

int main() {
    string color;
    int number;

    // Asking the user for their favorite color
    cout << "Enter your favorite color: ";
    getline(cin, color);  // Using getline to allow multi-word colors

    // Asking the user for their favorite number
    cout << "Enter your lucky number: ";
    cin >> number;

    // Displaying the combined message
    cout << "Your favorite color is " << color << ", and your lucky number is " << number << "." << endl;

    return 0;
}
