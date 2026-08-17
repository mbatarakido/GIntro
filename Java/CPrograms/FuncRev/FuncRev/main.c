


#include <stdio.h>


//function prototypes
int addition();
void display();
double triple(double number);

int main()
{
    double number = 15.0;
    int answer = addition();
    double tripled = triple(number);
    
    printf("%d\n",answer);
    
    printf("%f\n",triple(number));
    printf("%f\n",tripled);
    
    display();
    return 0;
}

//functions
//addition function
int addition()
{
    int a = 3, b= 5;
    int result;
    
    result = a+b;
    
    return result;
}
//display name function
void display()
{
    
    printf("Noble Tinashe\n");
    
}
//function to triple a number.
double triple(double number)
{
    double result;
    result =  number*3;
    return result;
}

