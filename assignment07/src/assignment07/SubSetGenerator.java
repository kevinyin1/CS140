package assignment07;

import java.util.ArrayList;
import java.util.List;

public class SubSetGenerator {

	public static void main(String[] args) {
		//System.out.println(subSet("abcd"));
	}
	
	public static List<String> subSet(String base) {
		List<String> list = new ArrayList<String>();
		list.add(""); // default value
		return subSetHelper(base, list);
	}
	//                              String base = rum;
	//                                      ""
	//                                  /        \  
	//          add "r"           "r"                  ""
	//                          /      \            /       \ 
	//          add "u"     "ru"        "r"       "u"        ""
	//                      /    \     /   \      /  \      /    \ 
	//          add "m" "rum"   "ru" "rm"  "r"  "um"  "u" "m"     ""
	//
	public static List<String> subSetHelper(String base, List<String> list) {
		if(base.length() == 0) return list;
		List<String> clone = (List<String>) ((ArrayList<String>) list).clone();
		list.set(0, list.get(0) + base.substring(0, 1));
		subSetHelper(base.substring(1), list);
		List<String> temp = subSetHelper(base.substring(1), clone);
		list.removeAll(temp); //remove the duplicates from the original array
		list.addAll(temp); //add the clone values
		return list;
	}
	
}
