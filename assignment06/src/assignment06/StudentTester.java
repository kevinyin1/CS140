package assignment06;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StudentTester {

	Student s1;
	Student s2;
	Student s3;
	Student s4;
	List<Student> test;
	List<Student> expected;
	
	@Before
	public void init() {
		s1 = new Student("Kevin", "Smiley", 22345, LocalDate.of(1999, 3, 16), 25);
		s2 = new Student("Bob", "Alpha", 12345, LocalDate.of(1997, 3, 12), 0);
		s3 = new Student("William", "Zone", 42345, LocalDate.of(2003, 4, 2), 75);
		s4 = new Student("Micheal", "Wong", 32345, LocalDate.of(2001, 3, 5), 50);
		test = new ArrayList<Student>(Arrays.asList(s1, s2, s3, s4));
		expected = new ArrayList<Student>(Arrays.asList(s2, s1, s4, s3));
	}
	
	@Test
	public void testCompareTo() {
		assertTrue(s1.compareTo(s2) > 0);
		assertFalse(this.s1.compareTo(this.s2) < 0);
	}

	@Test
	public void testComparator() {
		test.sort(Student.bySSN());
		assertEquals(expected, test);
		test.sort(Student.byDOB());
		assertEquals(expected, test);
		test.sort(Student.byGPA());
		assertEquals(expected, test);
		Collections.sort(test, (Student s1, Student s2) -> s1.compareTo(s2));
		assertEquals(expected, test);
	}

}
