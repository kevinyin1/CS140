package assignment03;

public class Driver2 {

	public static void main(String[] args) {

		BankAccount1[] accs1 = null;
		BankAccount1[] accs2 = {};
		BankAccount1[] accs3 = {null, null, null};
		BankAccount1[] accs4 = { null, new BankAccount1("Kevin", 100.0), null, new BankAccount1("Steven", 50.0), null};

		bankAccount1_TryCatch(accs1); //should print "0.0" once and "null" twice
		bankAccount1_TryCatch(accs2); //should print "0.0" once and "null" twice
		bankAccount1_TryCatch(accs3); //should print "0.0" once and "null" twice
		bankAccount1_TryCatch(accs4); //should print "75.0", "Steven has 50.0 dollars." and "Steven" 

		Customer[] customers1 = null;
		Customer[] customers2 = {};
		Customer[] customers3 = {null, null, null};
		Customer[] customers4 = { null, new Customer("Kevin", 10000.0), null, new Customer("Albert", 200.0), null, new Customer("Santa", 1000.0)};

		customer_TryCatch(customers1); //should print "0.0" and "null"
		customer_TryCatch(customers2); //should print "0.0" and "null"
		customer_TryCatch(customers3); //should print "0.0" and "null"
		customer_TryCatch(customers4); //should print "1866.6666" and "Kevin has 10000.0 dollars."

	}

	public static void bankAccount1_TryCatch(BankAccount1[] accs) {
		try {
			System.out.println(Question2.averageBankBalance(accs));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(Question2.lowestBankBalance(accs));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(Question2.longestName(accs) + "\n");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "\n");
		}
	}

	public static void customer_TryCatch(Customer[] accs) {
		try {
			System.out.println(Question2.averageCustomerBalance(accs));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(Question2.greatestCustomerBalance(accs) + "\n");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "\n");
		}
	}
}

