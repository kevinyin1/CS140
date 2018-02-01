package assignment02;

public class Question1 {

	public static double averageBankBalance(BankAccount1[] accs) {
		int totalBalance = 0;
		for(BankAccount1 account: accs)
		totalBalance += account.getBalance();
		return totalBalance / accs.length;
	}	

	public static BankAccount1 lowestBankBalance(BankAccount1[] accs) {
		BankAccount1 lowestBalance = accs[0];
		for(BankAccount1 account: accs)
			if(account.getBalance() < lowestBalance.getBalance())
				lowestBalance = account;
		return lowestBalance; 
	}

	public static String longestName(BankAccount1[] accs) {
		String longest_name = "";
		for(BankAccount1 account: accs)
			if(account.getCustomerName().length() >= longest_name.length())
				longest_name = account.getCustomerName();
		return longest_name;
	}
	
	public static double averageCustomerBalance(Customer[] accs) {
		double total_balance = 0;
		for(Customer customer: accs)
			total_balance += customer.getBalance();
		return total_balance / accs.length;
	}

	public static Customer greatestCustomerBalance(Customer[] accs) {
		Customer greatestBalance = accs[0];
		for(Customer customer: accs)
			if(customer.getBalance() >= greatestBalance.getBalance())
				greatestBalance = customer;
		return greatestBalance;
	}

}
