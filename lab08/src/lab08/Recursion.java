package lab08;

import java.util.ArrayList;
import java.util.List;

public class Recursion {

	public static final double DELTA = 1e-6;
	
	public static int factorial(int n) {
		if(n < 0) throw new IllegalArgumentException("can't calculate negative facotorial number");
		
		if(n == 0 || n == 1) return 1;
		return n * factorial(n - 1);
	}
	
	public static double squareRoot(double n) {
		return squareRootHelper(n, n/2);
	}
	
	public static double squareRootHelper(double n, double approx) {
		if(n == 0) return 0;
		double new_approx = (approx + n/approx) / 2;
		if((int)(n * 1000000) == (int)(new_approx * new_approx * 1000000))
			return new_approx;
		return squareRootHelper(n, new_approx);
	}
	
	public static int sum(ArrayList<Integer> nums) {
		if(nums == null || nums.size() == 0) throw new IllegalArgumentException("cannot compute the sum of a null or empty arraylist");
		return sumHelper(nums, nums.size());
	}
	
	public static int sumHelper(List<Integer> num, int index) {
		if(index == 1) return num.get(0);
		return num.get(index - 1) + sumHelper(num, index - 1);
	}
	
	public static int sum(int[] nums) {
		if(nums == null || nums.length == 0) throw new IllegalArgumentException("cannot compute the sum of a null or empty array");
		return sumHelper(nums, nums.length);
	}
	
	public static int sumHelper(int[] nums, int index) {
		if(index == 1) return nums[0];
		return nums[index - 1] + sumHelper(nums, index - 1);
	}
	
	public static int binomialCoefficient(int n, int k) {
		if(k == 0) return 1;
		if(k > (n / 2)) return binomialCoefficient(n, n - k);
		return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
	}
}
