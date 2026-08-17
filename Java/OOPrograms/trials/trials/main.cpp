
#include <iostream>
#include <cstring>
#include <exception>

using namespace std;
namespace First{
    void sayHello()
    {
        cout <<"First" << endl;
    }
}
namespace Second{
    void sayHello()
    {
        cout << "Second namespace" << endl;
    }
}
using namespace First;

class MyException: public exception{
public:
    const char * what() const throw()
    {
        return "Attempted to divide by 0";
    }

};
float division(int, int);
int main()
{
    sayHello();
    Second::sayHello();
    
    try{
        int x, y;
        cout << "Enter the two numbers : \n";
        cin >> x >> y;
        if (y == 0)
        {
            MyException z;
            throw z;
        }
        else
        {
            cout << "x / y = " << x/y << endl;
        }
    }
    catch(exception& e){
        cout << e.what();
    }
    cout << "\n";

    return 0;
}
float division(int a, int b)
{
    return (a/b);
}
