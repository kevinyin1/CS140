package assignment03;

public class Customer {

	private BankAccount account;
	private String customerName;

	public Customer(String cname) {
		customerName = cname;
	}

	public Customer(String cname, double bal) {
		customerName = cname;
		account = new BankAccount();
		account.deposit(bal);
	}	

	public String getName() {
		return customerName;
	}

	public BankAccount getAccount() {
		return account;
	}

	public double getBalance() {
		return account.getBalance();
	}

	public void deposit(double amount) {
		account.deposit(amount);
	}

	public void withdraw(double amount) {
		account.withdraw(amount);
	}

	public String toString() {
		return customerName + " has " + this.getBalance() + " dollars.";
	}

	public boolean hasMoreFundsThan(Customer other) {
		return (account.getBalance() >= other.getBalance());
	}

}
		
