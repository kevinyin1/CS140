package lab06;

public class SavingsAccount extends BankAccount {

	private double rate;

	public SavingsAccount(double balance, double rate) {
		super(balance);
		if(rate < 0) throw new IllegalArgumentException("rate cannot be negative");
		this.rate = rate / 100;
	}

	@Override
	public void deposit(double amount) {
		super.deposit(amount * (1 + rate));
	}
	
	public double getRate() {
		return rate;
	}
	
	@Override
	public String toString() {
		return super.toString() + " @ " + rate * 100 + "%";
	}
}
