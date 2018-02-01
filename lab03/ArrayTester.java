package lab03;

import java.util.Arrays;

public class ArrayTester {

	public static void main(String[] args) {
		if (args.length == 1) {
			ArrayFromFile array_from_file = new ArrayFromFile(args[0]);
			System.out.println("Expection output: [20, 8, 13, 46, 7]");
			System.out.println(array_from_file);
			System.out.println("Expection output: [20, 8, 46]");
			array_from_file.removeOddElements();
			System.out.println(array_from_file);
		
		} else {
			throw new IllegalArgumentException("Please enter one file name");
		}

		int[] new_array = new int[5];
		System.out.println("\n" + Arrays.toString(new_array));
		int n = 0;
		for (int i: new_array) {
			i = n;
			n++;
		}
		System.out.println(Arrays.toString(new_array) + "\n");	
		
		String[] s = {"Kevin", "Memes", "CS140", "Hello World"};
		for (String str: s)
			System.out.println(str + " " + str.length());
	}

}
