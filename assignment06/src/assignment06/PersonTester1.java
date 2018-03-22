package assignment06;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

public class PersonTester1 {

	Person1 p1;
	Person1 p2;
	Person1 p3;
	Person1 p4;
	List<Person1> test;
	List<Person1> expected;
	
	@Before
	public void init() {
		p1 = new Person1("Kevin", "Smiley", 22345, LocalDate.of(1999, 3, 16));
		p2 = new Person1("Bob", "Alpha", 12345, LocalDate.of(1997, 3, 12));
		p3 = new Person1("William", "Zone", 42345, LocalDate.of(2003, 4, 2));
		p4 = new Person1("Micheal", "Wong", 32345, LocalDate.of(2001, 3, 5));
		test = new ArrayList<Person1>(Arrays.asList(p1, p2, p3, p4));
		expected = new ArrayList<Person1>(Arrays.asList(p2, p1, p4, p3));
	}
	
	@Test
	public void testCompareTo() {
		assertTrue(p1.compareTo(p2) > 0);
		assertFalse(this.p1.compareTo(this.p2) < 0);
	}

	@Test
	public void testComparator() {
		test.sort(Person1.bySSN());
		assertEquals(expected, test);
		test.sort(Person1.byDOB());
		assertEquals(expected, test);
		test.sort(new Comparator<Person1>() {
			@Override
			public int compare(Person1 p1, Person1 p2) {
				return p1.compareTo(p2);
			}
		});
		assertEquals(expected, test);
	}
	
}
