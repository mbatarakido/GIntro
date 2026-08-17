//
//  numbrs.cpp
//  Vectors
//
//  Created by Benard Ochieng on 10/2/18.
//  Copyright © 2018 Benard Ochieng. All rights reserved.
//

#include <iostream>
#include <vector>

using namespace std;

int main()
{
    vector<int> num;
    
    for( int i = 0; i < 10; i++)
        num.push_back(i);
    for( int i = 0; i < num.size(); i++)
        cout << num[i] << ", ";
    cout << endl;
}
