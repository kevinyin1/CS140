package assignment02;

public class Bank {

	private Customer[] customers = new Customer[2000];

	public void createTestAccount() {
		for(int i = 0; i < 2000; i++)
			customers[i] = new Customer("Name", 100 + Math.random()*10000);
	}

	public double computeInterestToPay(double rate) {
		double totalInterest = 0;
		for(Customer customer: customers)
			totalInterest += (customer.getBalance() < 1000) ? customer.getBalance() * rate / 1200 : customer.getBalance() * 1.5 * rate / 1200;
		return totalInterest;
	}

}
