package assignment02;

public class Driver2 {

	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.createTestAccount();
		System.out.println(bank.computeInterestToPay(3.0));
	}

}
