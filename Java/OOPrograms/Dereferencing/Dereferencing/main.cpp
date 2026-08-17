
#include <iostream>
#include <cmath>
#include "math.h"

using namespace std;
using namespace MyMath;

int main()
{
    double sqr = sqrt(5.4);
    cout << "Square root of 5.4 = " << sqr << endl;
    
    long p = pow(2, 3);
    cout << "2 to power 3 = " << p << endl;
    
    int d = math::pow(8, 2);
    cout << d << endl;
    
    return 0;
}
