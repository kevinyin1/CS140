package assignment02;

public class Driver1 {

	public static void main(String[] args) {
		BankAccount1[] accs = {new BankAccount1("Kevin", 100.0), new BankAccount1("Bob", 120.0),
 new BankAccount1("Daniel", 20.0)};
		System.out.println(Question1.longestName(accs));

	}

}
