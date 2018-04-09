package assignment07;

import java.util.Set;
import java.util.List;
import java.util.TreeSet;
import java.util.ArrayList;

public class SubstringGenerator {

	public static void main(String[] args) {
//		System.out.println(subStrings("rum"));
//		System.out.println(subStrings1("rum"));
	}
	
	public static Set<String> subStrings(String base) {
		Set<String> set = new TreeSet<String>();
		if(base.length() == 0) {
			set.add(base);
			return set;
		}
		set.addAll(subStrings(base.substring(0, base.length() - 1)));
		set.add(base);
		set.addAll(subStrings(base.substring(1)));
		return set;
	}
	
	public static List<String> subStrings1(String base) {
		List<String> list = new ArrayList<String>();
		if(base.length() == 0) {
			list.add("");
			return list;
		}
		list.addAll(subStringsHelper(base));
		list.addAll(subStrings1(base.substring(1)));
		return list;
	}
	
	public static List<String> subStringsHelper(String base) {
		List<String> temp = new ArrayList<String>();
		if(base.length() == 1) {
			temp.add(base);
			return temp;
		}
		temp.addAll(subStringsHelper(base.substring(0, base.length() - 1)));
		temp.add(base);
		return temp;
	}
}
