package assignment06;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

public class StudentTester1 {

	Student1 s1;
	Student1 s2;
	Student1 s3;
	Student1 s4;
	List<Student1> test;
	List<Student1> expected;
	
	@Before
	public void init() {
		s1 = new Student1("Kevin", "Smiley", 22345, LocalDate.of(1999, 3, 16), 25);
		s2 = new Student1("Bob", "Alpha", 12345, LocalDate.of(1997, 3, 12), 0);
		s3 = new Student1("William", "Zone", 42345, LocalDate.of(2003, 4, 2), 75);
		s4 = new Student1("Micheal", "Wong", 32345, LocalDate.of(2001, 3, 5), 50);
		test = new ArrayList<Student1>(Arrays.asList(s1, s2, s3, s4));
		expected = new ArrayList<Student1>(Arrays.asList(s2, s1, s4, s3));
	}
	
	@Test
	public void testCompareTo() {
		assertTrue(s1.compareTo(s2) > 0);
		assertFalse(this.s1.compareTo(this.s2) < 0);
	}

	@Test
	public void testComparator() {
		test.sort(Student1.bySSN());
		assertEquals(expected, test);
		test.sort(Student1.byDOB());
		assertEquals(expected, test);
		test.sort(Student1.byGPA());
		assertEquals(expected, test);
		test.sort(new Comparator<Student1>() {
			@Override
			public int compare(Student1 s1, Student1 s2) {
				return s1.compareTo(s2);
			}
		});
		assertEquals(expected, test);
	}

}
