package lab08;

public class Bonus {

	public static void main(String[] args) {
		printPascalsTriangle(5);
	}
	
	public static void printPascalsTriangle(int limit) {
		for(int i = 0; i < limit + 1; i++) {
			for(int j = i; j > -1; j--) {
				System.out.print(Recursion.binomialCoefficient(i, j) + " ");
			}
			System.out.println();
		}
		
	}
	
}
