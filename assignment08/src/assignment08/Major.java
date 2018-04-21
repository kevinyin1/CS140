package assignment08;

import java.util.ArrayList;
import java.util.List;

public class Major {

	private String name;
	private List<Student> studentsInMajor;
	
	public Major(String name) {
		this.name = name;
		studentsInMajor = new ArrayList<Student>();
	}
	
	public void addStudent(Student student) {
		studentsInMajor.add(student);
	}
	
	public void setMajor() {
		studentsInMajor.stream().peek(e -> e.setMajor(name)).count();
	}
	
	public String getName() {
		return name;
	}
	
	public List<Student> getStudentsInMajor() {
		return studentsInMajor;
	}
	
}
