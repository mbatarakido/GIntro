
#include <iostream>
#include "Student.h"

Student::Student():course("[Unsigned course]")
{
    std::cout << "In Student::Student()" << std::endl;
}
Student::~Student()
{
    
}
Student::Student(const std::string &name, int age, const std::string &course): Person(name, age),course(course)
{
    std::cout << "In Student::Student(string, int, string)" << std::endl;
}
void Student::displayCourse() const
{
    std::cout << course << std::endl;
}
