package assignment08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
		
		System.out.println(getSortedList(new ArrayList<Major>(Arrays.asList(CS, EE, MATH))));
	}
	
	public static List<Student> getSortedList(List<Major> lst) {
		return lst.stream().flatMap(e -> e.getStudentsInMajor().stream()).sorted(Student.byCredits).collect(Collectors.toList());
	}
	
}
