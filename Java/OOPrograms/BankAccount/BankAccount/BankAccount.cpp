//
//  BankAccount.cpp
//  BankAccount
//
//  Created by Benard Ochieng on 12/28/18.
//  Copyright © 2018 Benard Ochieng. All rights reserved.
//

#include "BankAccount.h"

BankAccount::BankAccount(double initialBalance):balance(initialBalance)
{
    
}
BankAccount::~BankAccount()
{
    
}
double BankAccount::getBalance() const
{
    return balance;
}
void BankAccount::deposit(double amount)
{
    balance += amount;
}
void BankAccount::withdraw(double amount)
{
    balance -= amount;
}
