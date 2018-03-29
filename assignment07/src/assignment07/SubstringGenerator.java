package assignment07;

import java.util.Set;
import java.util.List;
import java.util.TreeSet;
import java.util.ArrayList;

public class SubstringGenerator {

	public static void main(String[] args) {
		Set<String> s = new TreeSet<String>();
		s = subStrings("rum");
		System.out.println(s);
		List<String> a = new ArrayList<String>();
		a = subStrings1("rum");
		System.out.println(a);
	}
	
	public static Set<String> subStrings(String base) {
		Set<String> s = new TreeSet<String>();
		return subStringsHelper(base, 1, base.length(), s);
	}
	
	public static Set<String> subStringsHelper(String base, int index,int base_index, Set<String> s) {
		if(base.length() == 0) {
			s.add(" ");
			return s;
		}
		s.add(base.substring(0, index));
		if(base_index == index) {
			return subStringsHelper(base.substring(1), 1, base_index - 1, s);
		}
		return subStringsHelper(base, index + 1, base_index, s);
	}
	
	public static List<String> subStrings1(String base) {
		ArrayList<String> s = new ArrayList<String>();
		return subStrings1Helper(base, 1, base.length(), s);
	}

	public static List<String> subStrings1Helper(String base, int index, int base_index, ArrayList<String> s) {
		if(base.length() == 0) {
			s.add("");
			return s;
		}
		s.add(base.substring(0, index));
		if(base_index == index) {
			return subStrings1Helper(base.substring(1), 1, base_index - 1, s);
		}
		return subStrings1Helper(base, index + 1, base_index, s);
	}
	
}
