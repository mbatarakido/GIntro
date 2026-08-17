//
//  main.c
//  NumberDisplayUsingFunc
//
//  Created by Benard Ochieng on 7/16/18.
//  Copyright © 2018 Benard Ochieng. All rights reserved.
//

#include <stdio.h>

//function prototype
void numbers();

int main()
{
    int x = 100;
    int y = 200;
    int temp;
    
    printf("x = %d, y = %d\n",x,y);
    
    //swap
    temp = x;
    x = y;
    y = temp;
    printf("x = %d, y = %d\n",x,y);
    
    
    //diplay numbers 0-10 using a function
    numbers();
    
    return 0;
}
//function to display numbers 0-10;
void numbers( )
{
    
    for( int i = 0; i <= 10; i++)
    {
        printf("%d ",i);
    }
    printf("\n");
}
