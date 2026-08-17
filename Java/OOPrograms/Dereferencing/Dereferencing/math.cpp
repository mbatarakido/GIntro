
#include <iostream>
#include "math.h"
using namespace std;
using namespace MyMath;

MyMath::math::math()
{
}
MyMath::math::~math()
{
    
}

int MyMath::math::pow(int value, int exp)
{
    cout << "In MyMath::math::pow" << endl;
    
    int result = 1;
    if( exp > 0)
    {
        for(int x = 0; x < exp; x++)
        {
            result = result * value;
        }
    }
    else
    {
        cout << "Enter only positive values for the exponent" << endl;
        result = 0;
    }
    return result;
}
