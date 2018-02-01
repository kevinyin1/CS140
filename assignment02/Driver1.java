package assignment02;

public class Driver1 {

	public static void main(String[] args) {
		Customer[] customers = {new Customer("Kevin", 100.0), new Customer("David", 120.0), new Customer("Michael", 300)};		
		BankAccount1[] accs = {new BankAccount1("Kevin", 100.0), new BankAccount1("Bob", 120.0), new BankAccount1("Daniel", 20.0)};
		System.out.println(Question1.longestName(accs));
		System.out.println(Question1.averageBankBalance(accs));
		System.out.println(Question1.lowestBankBalance(accs));
		System.out.println(Question1.averageCustomerBalance(customers));
		System.out.println(Question1.greatestCustomerBalance(customers));
		
		
	}

}
