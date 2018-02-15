package assignment03;

public class Driver1 {

	public static void main(String[] args) {

		BankAccount1[] accs1 = null;
		BankAccount1[] accs2 = {};
		BankAccount1[] accs3 = {null, null, null};
		BankAccount1[] accs4 = { null, new BankAccount1("Kevin", 100.0), null, new BankAccount1("Steven", 50.0), null};

		bankAccount1_TryCatch(accs1); //should print 3 Exceptions
		bankAccount1_TryCatch(accs2); //should print 3 Exceptions
		bankAccount1_TryCatch(accs3); //should print 3 Exceptions
		bankAccount1_TryCatch(accs4); //should not print any Exceptions

		Customer[] customers1 = null;
		Customer[] customers2 = {};
		Customer[] customers3 = {null, null, null};
		Customer[] customers4 = { null, new Customer("Kevin", 10000.0), null, new Customer("Albert", 200.0), null, new Customer("Santa", 1000.0)};

		customer_TryCatch(customers1); //should print 2 Exceptions
		customer_TryCatch(customers2); //should print 2 Exceptions
		customer_TryCatch(customers3); //should print 2 Exceptions
		customer_TryCatch(customers4); //should not print any Exceptions

	}

	public static void bankAccount1_TryCatch(BankAccount1[] accs) {
		try {
			System.out.println(Question1.averageBankBalance(accs));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(Question1.lowestBankBalance(accs));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(Question1.longestName(accs) + "\n");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "\n");
		}
	}

	public static void customer_TryCatch(Customer[] accs) {
		try {
			System.out.println(Question1.averageCustomerBalance(accs));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(Question1.greatestCustomerBalance(accs) + "\n");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "\n");
		}
	}
}

