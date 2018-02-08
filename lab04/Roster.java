package lab04;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Roster {

	private List<Student> classRoster = new ArrayList<Student>();

	public void addStudent(Student s) {
		classRoster.add(s);
	}

	public void dropStudent(Student s) {
		for(Student stu: classRoster)
			if(stu.getName().equals(s.getName())) classRoster.remove(stu);
	}

	@Override
	public String toString() {
		String return_sting = "";
		Iterator iter = classRoster.iterator();
		while(iter.hasNext() 
	}

	public List<Student> getClassRoster() {
		return classRoster;
	}

}
