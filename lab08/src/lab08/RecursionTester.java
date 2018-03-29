package lab08;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class RecursionTester {

	@Test
	public void factorialTest() {
		assertEquals(Recursion.factorial(1), 1);
		assertEquals(Recursion.factorial(0), 1);
		assertEquals(Recursion.factorial(7), 5040);
	}

	@Test
	public void squareRootTest() {
		assertEquals(Recursion.squareRoot(4), 2.0, 1e-6);
		assertEquals(Recursion.squareRoot(1), 1, 1e-6);
		assertEquals(Recursion.squareRoot(0), 0, 1e-6);
		
	}
	
	@Test
	public void sumArrayListTest() {
		assertEquals(Recursion.sum(new ArrayList<Integer>(Arrays.asList(1, 2, 3))), 6);
	}
	
	@Test
	public void sumArrayTest() {
		int[] a = {1, 2, 3};
		assertEquals(Recursion.sum(a), 6);
	}
	
	@Test
	public void binomialCoefficientTest() {
		assertEquals(Recursion.binomialCoefficient(5, 3), 10);
		assertEquals(Recursion.binomialCoefficient(7, 3), 35);
	}
	
}
