#include <iostream>
using namespace std;

int main() {
    // Declare a string to hold user input
    string input;

    // Ask the user to enter a string
    cout << "Enter a string: ";
    getline(cin, input);

    // Display the total number of characters in the string
    cout << "Total number of characters: " << input.length() << endl;

    // Check if the string has at least 8 characters
   
        input[7] = 'S';
        
        // Display the modified string
        cout << "Modified string: " << input << endl;
   
    return 0;
}
