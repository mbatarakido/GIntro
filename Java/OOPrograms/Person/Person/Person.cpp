
#include <iostream>
#include "Person.h"

Person::Person()
{}
Person::Person(std::string fname, std::string lname)
{
    this->firstName = fname;
    this->lastName = lname;
}
Person::Person(std::string fname, std::string lname, int age)
{
    this->firstName = fname;
    this->lastName = lname;
    
    this->m_age = age;
    std::cout << firstName <<" " << lastName <<" " << m_age << std::endl;
    
}
Person::~Person()
{
}

//getters and setters
void Person::SetFirstName(std::string fname)
{
    this->firstName = fname;
}
std::string Person::GetFirstName()
{
    return this->firstName;
}
void Person::SetLastName(std::string lname)
{
    this->lastName = lname;
}
std::string Person::GetLastName()
{
    return this->lastName;
}
void Person::SetAge(int age)
{
    if(age > 0)
    {
        this->m_age = age;
    }
    else
    {
        std::cout << "Enter a valid age." << std::endl;
        std::cin >> age;
        
        this->m_age = age;
    }
}
int Person::GetAge()
{
    return this->m_age;
}


//say hello function
void Person::sayHello()
{
    std::cout << "Hellow People!" << std::endl;
}











