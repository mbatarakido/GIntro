
#include <iostream>
//#include "Person.h"
#include "Student.h"

using namespace std;

int main()
{
    Student std1;
    std1.displayNameAge();
    std1.displayCourse();
    
    Student std2("Jane Smith", 18, "Physics");
    std2.displayNameAge();
    std2.displayCourse();
    
    return 0;
    
}
