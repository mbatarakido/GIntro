
public class BankAccount {
	private int accNum;
	private double balance;
	public BankAccount(int num, double bal)
	{
		accNum = num;
		balance  = bal;
	}
	public String toString()
	{
		String info = "Bank Account = "+accNum+" the balance = "+balance;
		return info;
	}
	public boolean equals(BankAccount secondAccount)
	{
		boolean result;
		if(accNum == secondAccount.accNum && balance == secondAccount.balance)
			result = true;
		else
			result = false;
		return result;
	}

}
