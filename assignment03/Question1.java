package assignment03;

import java.lang.IllegalArgumentException;

public class Question1 {


	/**
 	Finds the average bank balance for all the bank accounts in the
 	given array.
 	Assume accs is not null or empty an no account in accs is null.
 	@param accs the array of BankAccount1 elements to examine
 	@return the average of the balances of the accounts in accs
	@throws IllegalArgumentException if array is null, empty or all elements are null
	*/
	public static double averageBankBalance(BankAccount1[] accs) {
		if (accs == null) throw new IllegalArgumentException("Input should not be null");
		if (accs.length == 0) throw new IllegalArgumentException("Input should not be empty");
		int totalBalance = 0, nullCount = 0;
		for (int i = 0; i < accs.length; i++){
			if (accs[i] != null) {
				totalBalance += accs[i].getBalance();
				continue;
			}
			if(accs[i] == null) nullCount++;
			if (nullCount == accs.length-1) throw new IllegalArgumentException("Input should contain non-null elements");
		}		
		return totalBalance / accs.length;
	}	

	/**
 	Find the account in the array parameter that has the small
 	the smallest balance and in the case of a tie, return the
 	first such account. 
 	Assume accs is not null or empty an no account in accs is null.
 	@param accs the array of BankAccount1 elements to examine
 	@return the bank account in the array accs that has the
 	smallest balance. If there is more than one, then return the 
 	first of them.
	@throws IllegalArgumentException if array is null, empty or all elements are null
	*/
	public static BankAccount1 lowestBankBalance(BankAccount1[] accs) {
		if (accs == null) throw new IllegalArgumentException("Input should not be null");
		if (accs.length == 0) throw new IllegalArgumentException("Input should not be empty");
		BankAccount1 lowestBalance = null;
		int nullCount = 0;
		for (int i = 0; i < accs.length; i++){
			if (accs[i] != null && lowestBalance == null) lowestBalance = accs[i]; //gives lowestBalance an initial BankAccount1
			if (accs[i] != null && accs[i].getBalance() < lowestBalance.getBalance()) {
				lowestBalance = accs[i];
				continue;
			}
			if(accs[i] == null) nullCount++;
			if (nullCount == accs.length-1) throw new IllegalArgumentException("Input should contain non-null elements");
		}
		return lowestBalance;		
	}
	/**
 	In the array accs find the names of the customers and
 	return the longest name. If at least two names have the same
 	length, return the last one in the array of greatest length. 
 	@param accs the array of BankAccount1 elements to examine
 	@return the longest name of all the customerNames in
 	the customers in accs. If there is a tie for the length,
 	return the LAST name.
	@throws IllegalArgumentException if array is null, empty or all elements are null
	*/
	public static String longestName(BankAccount1[] accs) {
		if (accs == null) throw new IllegalArgumentException("Input should not be null");
		if (accs.length == 0) throw new IllegalArgumentException("Input should not be empty");
		String longest_name = "";
		int nullCount = 0;
		for (int i = 0; i < accs.length; i++){
			if(accs[i] != null && accs[i].getCustomerName().length() >= longest_name.length()) {
				longest_name = accs[i].getCustomerName();
				continue;
			}
			if(accs[i] == null) nullCount++;
			if (nullCount == accs.length-1) throw new IllegalArgumentException("Input should contain non-null elements");
		}
		return longest_name;		
	}
	/**
 	Finds the average bank balance for all the bank accounts of the
 	Customers in the given array.
 	Assume accs is not null or empty an no Customer in accs is null
 	and no account in any Customer is null.
 	@param accs the array of Customer elements to examine
 	@return the average of the balances of the customer accounts of
 	the customers in accs
	@throws IllegalArgumentException if array is null, empty or all elements are null
	*/
	public static double averageCustomerBalance(Customer[] accs) {
		if (accs == null) throw new IllegalArgumentException("Input should not be null");
		if (accs.length == 0) throw new IllegalArgumentException("Input should not be empty");
		double total_balance = 0;
		int nullCount = 0;
		for (int i = 0; i < accs.length; i++){
			if (accs[i] != null) {
				total_balance += accs[i].getBalance();
				continue;
			}
			if(accs[i] == null) nullCount++;
			if (nullCount == accs.length-1) throw new IllegalArgumentException("Input should contain non-null elements");
		}		
		return total_balance / accs.length;
	}
	/**
 	Find the Customer in the array parameter that has the largest
 	balance in their account field and in the case of a tie, return the
 	LAST such account. 
 	Assume accs is not null or empty an no Customer in accs is null
 	and no account in any Customer is null.
 	@param accs the array of Customer elements to examine
 	@return the Customer with the largest bank account in the array accs. 
 	If there is more than one, then return the last of them.
	@throws IllegalArgumentException if array is null, empty or all elements are null
	*/
	public static Customer greatestCustomerBalance(Customer[] accs) {
		if (accs == null) throw new IllegalArgumentException("Input should not be null");
		if (accs.length == 0) throw new IllegalArgumentException("Input should not be empty");
		Customer greatestBalance = null;
		int nullCount = 0;
		for (int i = 0; i < accs.length; i++){
			if (accs[i] != null && greatestBalance == null) greatestBalance = accs[i]; //gives greatestBalance an initial Customer
			if(accs[i] != null && accs[i].getBalance() >= greatestBalance.getBalance()) {
				greatestBalance = accs[i];
				continue;
			}
			if(accs[i] == null) nullCount++;
			if (nullCount == accs.length-1) throw new IllegalArgumentException("Input should contain non-null elements");
		}		
		return greatestBalance;
	}

}
