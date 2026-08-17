//
//  main.c
//  Inputs
//
//  Created by Benard Ochieng on 7/25/18.
//  Copyright © 2018 Benard Ochieng. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int correction(char *string, int length);
void emptyBuffer();
long StrToLong();

int main()
{
    
    char name[10] = {0};
    long age = 0;
    
    printf("Enter your name:\n");
    correction(name, 10);
    printf("Welcome Mr.%s!\n",name);
    
    printf("Enter your age:\n");
    age = StrToLong();
    printf("You are %d years old.\n",age);
    
    return 0;
}

//function to empty the buffer
void emptyBuffer()
{
    int c = 0;
    while( c != '\n' && c != EOF)
    {
        c = getchar();
    }
}

//function to correct the end of line character.
int correction(char *str, int length)
{
    char *position = NULL;
    if(fgets(str, length, stdin) != NULL)
    {
        position = strchr(str, '\n');
        if( position != NULL)
        {
            *position = '\0';
        }
        else
        {
            //'\n' has not been reached after copying the input from buffer into the str
            emptyBuffer();
        }
        return 1;
    }
    else
    {
        //some text remaining in the buffer
        emptyBuffer();
        return 0;
    }
}

//convert text to number
long StrToLong()
{
    char numText[100] = {0};
    if(correction(numText, 1000))
    {
        return strtol(numText, NULL, 10);
    }
    else
    {
        return 0;
    }
}




