package assignment06;

import java.time.LocalDate;
import java.util.Comparator;

public class Student1 implements Comparable<Student1> {
	private Person1 individual;
	private double gpa;

	public Student1(String fstN, String lstN, long n, LocalDate d, double g) {
		individual = new Person1(fstN, lstN, n, d);
		gpa = g;
	}

	public int compareTo(Student1 s1) {
		return individual.compareTo(s1.individual);
	}

	public static Comparator<Student1> bySSN() {
		return new Comparator<Student1>() {
			@Override
			public int compare(Student1 s1, Student1 s2) {
				if(s1.individual.getSSN() == s2.individual.getSSN()) return 0;
				else if(s1.individual.getSSN() > s2.individual.getSSN()) return 1;
				else return -1;
			}
		};
	}

	public static Comparator<Student1> byDOB() {
		return new Comparator<Student1>() {
			@Override
			public int compare(Student1 s1, Student1 s2) {
				return s1.individual.getDOB().compareTo(s2.individual.getDOB());
			}
		};
	}

	public String toSSN() {
		return individual.toSSN();
	}
	
	public static Comparator<Student1> byGPA() {
		return new Comparator<Student1>() {
			@Override
			public int compare(Student1 s1, Student1 s2) {
				if(s1.gpa == s2.gpa) return 0;
				else if(s1.gpa > s2.gpa) return 1;
				else return -1;
			}
		};
	}	
}
