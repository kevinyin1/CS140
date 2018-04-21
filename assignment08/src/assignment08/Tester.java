package assignment08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Tester {

	public static void main(String[] args) {
		
		Student s1 = new Student("Kevin Moore", 120);
		Student s2 = new Student("Stan Bently", 89);
		Student s3 = new Student("Gloria Garcia", 68);
		Major CS = new Major("Computer Science");
		CS.addStudent(s1);
		CS.addStudent(s2);
		CS.addStudent(s3);
		CS.setMajor();
		
		Student s4 = new Student("Matt Garber", 54);
		Student s5 = new Student("Lilly Holland", 43);
		Student s6 = new Student("Jason Chen", 98);
		Major EE = new Major("Electrical Engineering");
		EE.addStudent(s4);
		EE.addStudent(s5);
		EE.addStudent(s6);
		EE.setMajor();
		
		Student s7 = new Student("Michael West", 77);
		Student s8 = new Student("Steven Jones", 59);
		Student s9 = new Student("Jennifer Zhong", 23);
		Major MATH = new Major("Mathematics");
		MATH.addStudent(s7);
		MATH.addStudent(s8);
		MATH.addStudent(s9);
		MATH.setMajor();
		
		//Students with undecided majors
		Student s10 = new Student("Steve Jobs", 35);
		Student s11 = new Student("Alexander Borne", 67);
		Student s12 = new Student("Milly White", 111);
		
		
		System.out.println(getSortedList(new ArrayList<Major>(Arrays.asList(CS, EE, MATH))));
		System.out.println(organize(new ArrayList<Student>(Arrays.asList(s1, s2, s3, s4, s5, s6,
				 s7, s8, s9, s10, s11, s12))));
	}
	
	public static List<Student> getSortedList(List<Major> lst) {
		return lst.stream().flatMap(e -> e.getStudentsInMajor().stream()).sorted(Student.byCredits).collect(Collectors.toList());
	}
	
	public static Map<String, List<Student>> organize(List<Student> list) {
		if(list == null) throw new IllegalArgumentException("list cannot be null");
		Map<String, List<Student>> map = new HashMap<String, List<Student>>();
		for(Student s: list) {
			if(s != null) {
				if(!map.containsKey(s.getMajor())) {
					map.put(s.getMajor(), new ArrayList<Student>(Arrays.asList(s)));
				} else {
					map.get(s.getMajor()).add(s);
				}
			}
		}
		return map;
	}
	
}
