package assignment07;

import java.util.ArrayList;
import java.util.List;

public class SubSetGenerator {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list = subSet("kevin");
		System.out.println(list);
	}
	
	public static List<String> subSet(String base) {
		List<String> list = subSetHelper(base, base.length(), base.length(), new ArrayList<String>());
		List<String> rlist = new ArrayList<String>();
		int n = base.length(), pos = 0, index = 0;
		String str;
		//organize list by size
		while(n >= 0) {
			str = list.get(pos);
			if(str.length() == n) rlist.add(str);
			pos++;
			if(pos == list.size()) {
				n--;
				pos = 0;
			}
		}
		pos = 0;
		//bring all the starting character of base to the front
		while(pos < rlist.size()) {
			str = rlist.get(pos);
			if(str.startsWith(base.substring(0, 1))) {
				rlist.remove(str);
				rlist.add(index, str);
				index++;
			}
			pos++;
		}
		System.out.println(list);
		return rlist;
	}
	
	public static List<String> subSetHelper(String base, int index, int delta, List<String> list) {
		if(delta == -1) return list;
		String str = base.substring(0, delta) + base.substring(index);
		if(delta == 1) { // add all the individual characters in the string
			String character = base.substring(delta, index);
			if(!list.contains(character)) list.add(0, character); 
		}
		if(!list.contains(str)) list.add(str);
		if(index - delta == 0) return subSetHelper(base, base.length(), delta - 1, list);
		return subSetHelper(base, index - 1, delta, list);
	}
	
	
}
