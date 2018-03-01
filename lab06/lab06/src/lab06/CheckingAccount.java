package lab06;

public class CheckingAccount extends BankAccount {
	
	private int withdrawLimit = 0, withdrawCount = 0;
	
	public CheckingAccount(double balance, int withdrawLimit) {
		super(balance);
		if(withdrawLimit <  1) throw new IllegalArgumentException("withdraw limit cannot be less than 1 and positive");
		this.withdrawLimit = withdrawLimit;
	}
	
	@Override
	public double withdraw(double amount) {
		if(withdrawCount < withdrawLimit) {
			withdrawCount++;
			super.withdraw(amount);
		}
		return 0;
	}
	
	public int getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public int getWithdrawCount() {
		return withdrawCount;
	}
	
	@Override
	public String toString() {
		return super.toString() + " (" + withdrawCount + "/" + withdrawLimit + ")";
	}
}
