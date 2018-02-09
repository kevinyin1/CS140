package lab04;
import java.util.List;
import java.util.ArrayList;

public class Roster {

	private List<Student> classRoster = new ArrayList<Student>();

	public void addStudent(Student s) {
		classRoster.add(s);
	}

	public void dropStudent(Student s) {
		for(int i = 0; i < classRoster.size(); i++)		
			if(classRoster.get(i).getName().equals(s.getName())) classRoster.remove(i);
	}

	@Override
	public String toString() {
		String return_string = "";
		for(int i = 0; i < classRoster.size(); i++) {
			if(i == classRoster.size() - 1) {
				return_string += classRoster.get(i).getName();
				continue;
			}
			return_string += classRoster.get(i).getName() + ", ";
		}
		return "[" + return_string + "]";
	}

	public List<Student> getClassRoster() {
		return classRoster;
	}

	public void sortByID() {
		for(int i = 0; i < classRoster.size(); i++)
			for(int index = 1; index < classRoster.size() - i; index++)
				if(classRoster.get(index-1).getID() > classRoster.get(index).getID()){
					Student temp = classRoster.get(index-1);
					classRoster.set(index-1,classRoster.get(index));
					classRoster.set(index, temp);
				}

	}

}
