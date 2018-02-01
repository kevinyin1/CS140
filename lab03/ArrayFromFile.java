package lab03;

import java.io.File;
import java.util.Scanner;
import java.util.Arrays;


public class ArrayFromFile {

	private int[] array;

	public ArrayFromFile(String filename) {
		try (Scanner sc = new Scanner(new File(filename))) {
			int n = sc.nextInt(), pos = 0; // we assume that the file has data
			array = new int[n]; 
			while(sc.hasNext()){
				array[pos] = sc.nextInt();
				pos++;
			}
		} catch(Exception e) {
			System.out.println("File does not exist");				}
	}	
	
	public int[] getArray() {
		return array;
	}

	public String toString(){
		return Arrays.toString(array);
	}

	public void removeOddElements() {
		int num_of_even = 0, index = 0;
		for (int i: array)
			if (i % 2 == 0) num_of_even++;
		int[] new_array = new int[num_of_even];
		for (int i: array)	
			if (i % 2 == 0) {
				new_array[index] = i;
				index++;
			}
		array = new_array;
	}

}
