

#include <string>

class BankAccount
{
protected:
    double balance;
    
public:
    BankAccount(double initialBalance);
    virtual ~BankAccount();
    
    double getBalance() const;
    
    virtual void deposit(double amount);
    virtual void withdraw(double amount);
    
    //Pure virtual functions must be overriden in subclass
    virtual std::string getTermsAndConditions() = 0;
    virtual double getGuarantteedLimit() = 0;
};
