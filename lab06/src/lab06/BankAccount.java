package lab06;

public class BankAccount {
	private double balance;
	private int idNum;
	static int numAccounts = 0;

	public BankAccount(double balance) {
		if(balance < 0) throw new IllegalArgumentException("balance cannot be negative");
		this.balance = balance;
		idNum = ++numAccounts;
	}

	public void deposit(double amount) {
		if(amount < 0) throw new IllegalArgumentException("deposits must be postiive");
		balance += amount;
	}
	
	public double withdraw(double amount) {
		if(amount < 0) throw new IllegalArgumentException("withdrawals must be positive");
		if(amount > balance) {
			double temp = balance;
			balance = 0;
			return temp;
		}
		balance -= amount;
		return amount;
	}
	
	static void reset() {
		numAccounts = 0;
	}
	
	public double getBalance() {
		return balance;
	}

	public int getIdNum() {
		return idNum;
	}
	
	@Override
	public String toString() {
		return "Acct. #" + idNum + " has $" + balance;
	}
}
