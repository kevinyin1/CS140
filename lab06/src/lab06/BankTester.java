package lab06;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BankTester {
	List<BankAccount> accounts;
	List<Object> objects;
	//we can initialize some objects to be used in later tests
	//using the Before keyword ensures this method is called before 
	//the test methods are called

	//Please note that this method is rerun before the start of each test,
	//which means the BankAccounts will have their numId's increased 
	//each time the account is called.

	//we will fix this issue by adding an @After method, which is run 
	//after each test ends
	@Before
	public void initialize(){
		accounts = new ArrayList<BankAccount>(
				Arrays.asList(new BankAccount(100.0), new BankAccount(200.0),
						new SavingsAccount(100.0, 1), new SavingsAccount(200.0, 2),
						new CheckingAccount(100.0, 2), new CheckingAccount(200.0, 5)));
		//prints all the bank accounts
		dynamicDispatchPrinting(accounts);
		System.out.println("\n");
		
		objects = new ArrayList<Object>(
				Arrays.asList(new BankAccount(100.0), new Integer(10),
						new SavingsAccount(100.0, 1), new String("HAHA"),
						new CheckingAccount(100.0, 2), new Double(1000.0),
						true, new Character('a')));
		//prints all the objects
		dynamicDispatchPrinting(objects);
	}

	@After
	public void resetIdNum(){
		BankAccount.reset();
		accounts.clear();
	}


	//the @Test is necessary, without it the test will not be run
	@Test
	public void testBankAccDeposit() {
		BankAccount bacc = new BankAccount(700.00);
		bacc.deposit(100);
		try {
			//when comparing two doubles, we need to give it some small value for it to see 
			//if the expected and actual value are close enough to equaling one another
			assertEquals(800.00, bacc.getBalance(), 1e-6);
		}
		//here if there is an assertion error, we can catch it 
		//and print the error message out, then throw the AssertionError
		//so that the test still fails. 
		catch(AssertionError e){
			System.out.println("BankAccount's deposit() method failed: " + e.getMessage());
			throw e;
		}
	}
	@Test
	public void testCheckingAccWithdraw(){
		CheckingAccount checking = new CheckingAccount(1000.00, 10);
		for(int i = 0; i < 3; i++) checking.withdraw(100);
		try {
			//when comparing two doubles, we need to give it some small value for it to see 
			//if the expected and actual value are close enough to equaling one another
			assertEquals(700.00, checking.getBalance(), 1e-6);
		}
		//here if there is an assertion error, we can catch it 
		//and print the error message out, then throw the AssertionError
		//so that the test still fails. 
		catch(AssertionError e){
			System.out.println("CheckingAccount's withdraw() method failed: " + e.getMessage());
			throw e;
		}
	}
	@Test
	public void testCheckingAccGetWithdrawCount(){
		CheckingAccount checking = new CheckingAccount(1000.00, 10);
		for(int i = 0; i < 3; i++) checking.withdraw(100);
		try {
			//when comparing two integers, we don't need a third argument 
			//since ints can be checked for equality
			assertEquals(3, checking.getWithdrawCount());
		}
		//here if there is an assertion error, we can catch it 
		//and print the error message out, then throw the AssertionError
		//so that the test still fails. 
		catch(AssertionError e){
			System.out.println("CheckingAccount's getWithdrawCount() method failed: " + e.getMessage());
			System.out.println("Make sure you adjust the withdrawCount in your CheckingAccount's withdraw() method!");
			throw e;
		}
	}
	//TODO: Add some of your own additional tests. Keep each test in a separate test function.
	//This isolates testing a single method or case to a single testing method. Otherwise, 
	//if you try to do too much testing in one tester method, you could throw an error
	//for a test and never find the errors of the other tests you put in that method. 

	
	//dynamicDispatchPrinting is called in the initialized method to print
	//all the bank accounts and objects.
	public <T> void dynamicDispatchPrinting(List<T> list){
		for(T b : list){
			if(b instanceof SavingsAccount){
				System.out.println("SavingsAccount: ");
			}
			else if(b instanceof CheckingAccount){
				System.out.println("CheckingAccount: ");
			}
			//note that we do this as an else block
			//since SavingsAccount and CheckingAccounts are also
			//considered to be instances of BankAccount
			//since they are subclasses of BankAccount.
			else if(b instanceof BankAccount){
				System.out.println("BankAccount: ");
			}
			System.out.println(b);

		}
	}

	@Test
	public void testDeposit() {
		for(BankAccount account: accounts) {
			account.deposit(100);
		}	
		assertEquals("Acct. #1 has $200.0", accounts.get(0).toString());
		assertEquals("Acct. #2 has $300.0", accounts.get(1).toString());
		assertEquals("Acct. #3 has $201.0 @ 1.0%", accounts.get(2).toString());
		assertEquals("Acct. #4 has $302.0 @ 2.0%", accounts.get(3).toString());
		assertEquals("Acct. #5 has $200.0 (0/2)", accounts.get(4).toString());
		assertEquals("Acct. #6 has $300.0 (0/5)", accounts.get(5).toString());
	}
	
	@Test
	public void testWithdraw() {
		for(BankAccount account: accounts) {
			if(account instanceof CheckingAccount) {
				for(int i = 0; i < 4; i++) {
					( (CheckingAccount) account).withdraw(10);
				}
				continue;
			}
			account.withdraw(10);
		}
		assertEquals("Acct. #1 has $90.0", accounts.get(0).toString());
		assertEquals("Acct. #2 has $190.0", accounts.get(1).toString());
		assertEquals("Acct. #3 has $90.0 @ 1.0%", accounts.get(2).toString());
		assertEquals("Acct. #4 has $190.0 @ 2.0%", accounts.get(3).toString());
		assertEquals("Acct. #5 has $80.0 (2/2)", accounts.get(4).toString());
		assertEquals("Acct. #6 has $160.0 (4/5)", accounts.get(5).toString());
	}
}
