package assignment01;

public class Driver2 {

	public static void main(String[] args) {
		Customer cust = new Customer("Jane Smith", 100.0);
		System.out.println(cust);

		//should print false
		System.out.println(cust.hasMoreFundsThan(new Customer("Bob", 123.45)));		
		//should print true
		System.out.println(cust.hasMoreFundsThan(new Customer("Alice", 10.00)));
	}

}
