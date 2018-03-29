package assignment07;

import java.util.ArrayList;

public class SubListGenerator {

	public static <T> ArrayList<ArrayList<ArrayList<T>>> subLists(ArrayList<T> list) {
		ArrayList<T> return_list = new ArrayList<T>();
		
		return ;
	}
	
	public static <T> ArrayList<ArrayList<ArrayList<T>>> subListsHelper(int base_size, int index, 
			ArrayList<T> list, ArrayList<ArrayList<ArrayList<T>>> return_list) {
		if(base_size == 0) {
			return return_list;
		}
		if(index == base_size) {
			return subListsHelper(base_size - 1, 0, list, return_list); 
		}
		
	}
	
}
