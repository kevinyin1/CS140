package lab04;
import java.util.List;
import java.util.Iterator;

public class RosterTester {

	public static void main(String[] args) {
		Roster r = new Roster();
		Student steven = new Student(0, "Steven");
		r.addStudent(new Student(1, "Kevin"));
		r.addStudent(new Student(3, "Bob"));
		r.addStudent(new Student(2, "Kalvin"));
		r.addStudent(steven);

		System.out.println(r);
		r.sortByID();
		System.out.println(r);	
		r.dropStudent(steven);
		System.out.println(r + "\n");
		
		List<Student> roster = r.getClassRoster();
		Iterator iter = roster.iterator();
		while(iter.hasNext()) { 
			Student s = (Student) iter.next();
			System.out.println("Name: " + s.getName() + " | ID: " + s.getID()); 
		}
	}

}
