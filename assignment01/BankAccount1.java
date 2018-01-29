package assignment01;
/**
   A bank account has a balance that can be changed by 
   deposits and withdrawals.
 */
public class BankAccount1 {  
	private double balance;
	private String customerName;
	/**
      Constructs a bank account with a zero balance.
	 */
	public BankAccount1(String str) {   
		this(str, 0);
	}

	/**
      Constructs a bank account with a given balance.
      @param initialBalance the initial balance
	 */
	public BankAccount1(String str, double initialBalance) {   
		customerName = str;
		balance = initialBalance;
	}

	/**
      Deposits money into the bank account.
      @param amount the amount to deposit
	 */
	public void deposit(double amount) {  
		balance += amount;
	}

	/**
      Withdraws money from the bank account.
      @param amount the amount to withdraw
	 */
	public void withdraw(double amount) {   
		balance -= amount;
	}

	/**
	Gets the customer's name of the bank account.
	@return the name of the bank account owner
	 */

	public String getCustomerName() {
		return customerName;
	}

	/**
      Gets the current balance of the bank account.
      @return the current balance
	 */

	public double getBalance() {   
		return balance;
	}

	public String toString() {
		return customerName + " has " + balance + " dollars.";
	}
}
