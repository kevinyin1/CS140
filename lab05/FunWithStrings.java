package lab05;

import java.util.List;
import java.util.ArrayList;
import java.lang.IllegalArgumentException;

public class FunWithStrings {
	
	public static void swapMaxes(List<String> list1, List<String> list2) {
		if((list1 == null || list1.size() == 0) || (list2 == null || list2.size() == 0)) throw new IllegalArgumentException("cannot swap maxes of empty lists, null lists, or lists with all null elements");
		int nullCount = 0;
		for(int i = 0; i < list1.size(); i++){
			if(list1.get(i) == null) nullCount++;
			if(nullCount == list1.size()-1) throw new IllegalArgumentException("cannot swap maxes of empty lists, null lists, or lists with all null elements");
		}
		for(int i = 0; i < list2.size(); i++){
			if(list2.get(i) == null) nullCount++;
			if(nullCount == list2.size()-1) throw new IllegalArgumentException("cannot swap maxes of empty lists, null lists, or lists with all null elements");
		}
		String list1LongestString = "", list2LongestString = "";
		int list1Index = 0, list2Index = 0;
		for(int i = 0; i < list1.size(); i++)
			if(list1.get(i).length() > list1LongestString.length()){
				list1LongestString = list1.get(i);
				list1Index = i;
			}
		for(int i = 0; i < list2.size(); i++)
			if(list1.get(i).length() > list2LongestString.length()){
				list2LongestString = list2.get(i);
				list2Index = i;
			}
		list1.set(list1Index, list2LongestString);
		list2.set(list2Index, list1LongestString);	
	
	}	
	
}
