package lab04;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.IllegalArgumentException;

public class ArrayListPractice {

	public static int intRemoveAll(List<Integer> arr, int e) {
		int count = 0;
		Iterator<Integer> iter = arr.iterator();
		while(iter.hasNext()) {
			if((iter.next().equals(e))){
				iter.remove();
				count++;
			}
		}
		return count;
	}

	public static boolean isEqual(List<Integer> alpha, List<Integer> other) {
		if (alpha.size() != other.size()) return false;
		for (int i = 0; i < alpha.size(); i++) {
			if (alpha.get(i) != other.get(i)) return false;
		}
		return true;
	} 
		
	public static void appendArray(List<Integer> arrList, List<Integer> arr) {
		if (arrList ==null || arr == null) throw new IllegalArgumentException("arrList or arr cannot be null");
		for(int i = 0; i < arr.size(); i++) {
			arrList.add(arr.get(i));
		}
	}

	public static ArrayList<Integer> sumElementWise(List<Integer> arr1, List<Integer> arr2) {
		if (arr1 == null || arr2 == null) throw new IllegalArgumentException("arr1 or arr2 cannon be null");
		ArrayList<Integer> sumArr = new ArrayList<Integer>();
		if(arr2.size() <= arr1.size()) {
			for(int i = 0; i < arr1.size(); i++) {
				if(i < arr2.size()) sumArr.add(arr1.get(i) + arr2.get(i));
				else sumArr.add(arr1.get(i)); 
			}
		}
		if(arr2.size() > arr1.size()) {
			for(int i = 0; i < arr2.size(); i++) {
				if(i < arr1.size()) sumArr.add(arr1.get(i) + arr2.get(i));
				else sumArr.add(arr2.get(i)); 
			}
		}
		return sumArr;
	}
}
