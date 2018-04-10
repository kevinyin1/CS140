package assignment07;

import java.util.ArrayList;
import java.util.Arrays;

public class SubListGenerator {

	public static void main(String[] args) {
		System.out.println(subLists(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4))));
	}
	
	public static <T> ArrayList<ArrayList<ArrayList<T>>> subLists(ArrayList<T> list) {
		ArrayList<T> clone = (ArrayList<T>)list.clone();
		return subListsHelper(clone);
	}
	
	public static <T> ArrayList<ArrayList<ArrayList<T>>> subListsHelper(ArrayList<T> list) {
		ArrayList<ArrayList<ArrayList<T>>> return_list = new ArrayList<ArrayList<ArrayList<T>>>(), empty = new ArrayList<ArrayList<ArrayList<T>>>();
		if(list.size() == 0) return return_list;
		if(list.size() == 1) {
			ArrayList<T> core = new ArrayList<T>();
			ArrayList<ArrayList<T>> sub_core = new ArrayList<ArrayList<T>>();
			core.add(list.get(0));
			sub_core.add(core);
			return_list.add(sub_core);
			return return_list;
		}
		T temp = list.remove(list.size() - 1);
		return_list.addAll(subListsHelper(list));
		for(ArrayList<ArrayList<T>> sub_list: return_list) {
			ArrayList<ArrayList<T>> clone1 = new ArrayList<ArrayList<T>>(), clone2 = new ArrayList<ArrayList<T>>();
			for(int i = 0; i < sub_list.size(); i++) {
				clone1.add(new ArrayList<T>());
				clone2.add(new ArrayList<T>());
				for(int j = 0; j < sub_list.get(i).size(); j++) {
					clone1.get(i).add(sub_list.get(i).get(j));
					clone2.get(i).add(sub_list.get(i).get(j));
				}
			}
		
			//System.out.println(clone1 + " " + clone2);
			clone1.add(new ArrayList<T>(Arrays.asList(temp)));
			empty.add(clone1);
			clone2.get(clone2.size() - 1).add(temp);
			empty.add(clone2);
		}
		return empty;
	}
	// recursive call on original and call the helper
	// new list with elemeents
}
