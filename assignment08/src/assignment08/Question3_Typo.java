package assignment08;

import java.util.ArrayList;
import java.util.Arrays;

public class Question3_Typo {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.addAll(Arrays.asList(1, 7, 2, 9, 11, 12));
		System.out.println(windowSubLists(list) + "\n" + 
"[[[1], [7], [2], [9], [11]], [[1, 7], [2], [9], [11]], [[1, 7, 2], [9], [11]],[[1, 7, 2, 9], [11]], [[1, 7, 2, 9, 11]], [[1], [7, 2], [9], [11]], [[1], [7, 2, 9], [11]],[[1], [7, 2, 9, 11]], [[1], [7], [2, 9], [11]], [[1], [7], [2, 9, 11]], [[1], [7], [2], [9, 11]]");
	}
	
	public static <T> ArrayList<ArrayList<ArrayList<T>>> windowSubLists(ArrayList<T> list) {
		return windowSubListsHelper(list, new ArrayList<ArrayList<ArrayList<T>>>(), 0, 1);
	}
	
	public static <T> ArrayList<ArrayList<ArrayList<T>>> windowSubListsHelper(ArrayList<T> origList,
			ArrayList<ArrayList<ArrayList<T>>> subLists, int beginIndex, int endIndex) {
		if(beginIndex == origList.size()) return subLists;
		if(endIndex == origList.size() + 1) return windowSubListsHelper(origList, subLists, beginIndex + 1, beginIndex + 3);
		ArrayList<ArrayList<T>> sub = new ArrayList<ArrayList<T>>();
		ArrayList<T> temp = new ArrayList<T>();
		for(int i = beginIndex; i < endIndex; i++) {
			temp.add(origList.get(i));
		}
		for(int i = 0; i < origList.size(); i++) {
			if(i == beginIndex) {
				sub.add(temp);
				i = endIndex - 1;
			} else sub.add(new ArrayList<T>(Arrays.asList(origList.get(i))));
		}
		subLists.add(sub);
		return windowSubListsHelper(origList, subLists, beginIndex, endIndex + 1);
	}
	
}
