
//this class determines whether to freeze an account or unfreeze to determine if deposit
//and withdrawal are allowed
//It uses pure virtual functions

class Freezable
{
public:
    virtual void freeze() = 0;
    virtual void unfreeze() = 0;
    
};
