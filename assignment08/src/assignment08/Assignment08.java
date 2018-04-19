package assignment08;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Assignment08 {

	public static List<String> selectFrom(List<String> lst,char letter) {
		return lst.stream()
				.filter(e -> e.toLowerCase().charAt(0) == (letter))
				.collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		System.out.println(selectFrom(Arrays.asList("Alpha", "Beta", "Gamma", "delta", "Binghamton", "academic", "business"), 'b'));
	}
	
}
