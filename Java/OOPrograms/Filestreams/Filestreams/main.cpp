
#include <iostream>
#include <fstream>

using namespace std;

int main()
{
    char input[75];
    ofstream os;
    os.open("/Users/Ben/Documents/OOPrograms/Filestreams/Filestreams/testout.txt");
    
    cout << "Writing to a file" << endl;
    cout << "Please enter your name: ";
    cin.getline(input, 100);
    os << input << endl;
    cout << "Please enter your age: ";
    cin >> input;
    cin.ignore();
    os << input << endl;
    os.close();
    
    ifstream is;
    string line;
    is.open("/Users/Ben/Documents/OOPrograms/Filestreams/Filestreams/testout.txt");
    cout << "Reading from a text file" << endl;
    
    if(is.is_open())
    {
        while(getline(is, line))
        {
            cout << line << endl;
        }
        is.close();
    }
    else{
        cout << "File opening failed!" << endl;
    }
    
    return 0;
}
