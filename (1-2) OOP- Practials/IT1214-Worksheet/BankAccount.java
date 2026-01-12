class BankAccount {
	private String accountHolderName;
	private double balance;
	
public void deposit(double amount)
 { balance += amount; }
 
 
public void withdraw(double amount)
 { if(amount<=balance)
	{balance -= amount;}
	 else
	 {System.out.println("Insufficient balance!");
		}
	}


public void displayBalance() 
{ System.out.println("Balance: "+balance); }
}


