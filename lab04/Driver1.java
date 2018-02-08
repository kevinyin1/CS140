package lab04;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Driver1 {

	public static void main(String[] args) {
		ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1,3,4,5,6));
		ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));	
		ArrayList<Integer> array3 = new ArrayList<Integer>(Arrays.asList(1,3,4,5,6));
		ArrayList<Integer> array4 = new ArrayList<Integer>(Arrays.asList(4,5,6));

		ArrayList<Integer> nullArray = null;

		ArrayList<Integer> append_arr1 = new ArrayList<Integer>(Arrays.asList(1,2,4,6,1));
		ArrayList<Integer> append_arr2 = new ArrayList<Integer>(Arrays.asList(1,2));	
		ArrayList<Integer> append_arr3 = new ArrayList<Integer>(Arrays.asList(1,6,1));

		ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(1,2,4,6,1));
		ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,6,7));

		System.out.println("Number of integers remove: " + ArrayListPractice.intRemoveAll(arr1, 1) + "\n"); // should remove 2 integers
		System.out.println(ArrayListPractice.isEqual(array1, array3)); //should print true
		System.out.println(ArrayListPractice.isEqual(array1, array2)); //should print false
		System.out.println(ArrayListPractice.isEqual(arr1, array2) + "\n"); //should print false

//		ArrayListPractice.appendArray(nullArray, append_arr2); //Exception thrown
//		ArrayListPractice.appendArray(append_arr1, nullArray); //Exception thrown
//		ArrayListPractice.appendArray(nullArray, nullArray); //Exception thrown
		ArrayListPractice.appendArray(append_arr1, append_arr2);
		System.out.println(append_arr1); //should print [1,2,4,6,1,1,2]
		ArrayListPractice.appendArray(append_arr3, append_arr2);
		System.out.println(append_arr3 + "\n"); //should print [1,6,1,1,2]
		
//		System.out.println(ArrayListPractice.sumElementWise(nullArray, array2)); //Exception thrown
//		System.out.println(ArrayListPractice.sumElementWise(arr2, nullArray)); //Exception thrown
//		System.out.println(ArrayListPractice.sumElementWise(nullArray, nullArray)); //Exception thrown
		System.out.println(ArrayListPractice.sumElementWise(arr2, array2)); //[2,4,6,8,11,7]
		System.out.println(ArrayListPractice.sumElementWise(array3, array4)); //[5,8,10,5,6]

		

	}

}
