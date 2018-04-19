package assignment08;

import java.util.Comparator;

public class Student {

	private String name, major = "undecided";
	private int numCreditsCompleted;
	static Comparator<Student> byCredits = (s1, s2) -> s1.getNumCreditsCompleted() - s2.getNumCreditsCompleted();
	
	public Student(String name, int credits) {
		this.name = name;
		numCreditsCompleted = credits;
	}
	
	public String getName() {
		return name;
	}
	
	 public String getMajor() {
		return major;
	}
	
	public int getNumCreditsCompleted() {
		return numCreditsCompleted;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	@Override
	public String toString() {
		return name + " (" + major + " : " + numCreditsCompleted + ")";
	}
	
}
