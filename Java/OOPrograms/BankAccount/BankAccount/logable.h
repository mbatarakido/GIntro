

#include <string>

class logable
{
public:
    virtual void log(const std::string & message) const = 0;
    
};
