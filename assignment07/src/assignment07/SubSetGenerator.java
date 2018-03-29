package assignment07;

import java.util.ArrayList;
import java.util.List;

public class SubSetGenerator {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list = subSet("rum");
		System.out.println(list);
	}
	
	public static List<String> subSet(String base) {
		List<String> list = new ArrayList<String>();
		return subSetHelper(base, base.length(), 0, list);
	}
	
	public static List<String> subSetHelper(String base, int base_length, int index, List<String> list) {
		if(base.length() == 0) {
			list.add("");
			return list;
		}
		System.out.println(list + " " + base.substring(1,2));
		list.add(base.substring(0, 1) + base.substring(index, index + 1));
		if(index == base_length) {
			return subSetHelper(base.substring(1), base_length - 1, 0, list);
		}
		return subSetHelper(base, base_length, index + 1, list);
	}
	
}
