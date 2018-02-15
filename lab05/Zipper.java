package lab05;

import java.util.List;
import java.util.ArrayList;
import java.lang.IllegalArgumentException;

public class Zipper {

	public static int[] zip(int[] arr1, int[] arr2){
		if((arr1 == null || arr2 == null) || arr1.length != arr2.length) throw new IllegalArgumentException("bad input");
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < arr1.length; i++) {
			list.add(arr1[i]);
			list.add(arr2[i]);
		}
		int[] return_arr = new int[list.size()];
		for(int i = 0; i < list.size(); i++)
			return_arr[i] = list.get(i);
		return return_arr;
	}
}
