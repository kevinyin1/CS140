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

import assignment06.Person;
import java.util.Collections;

public class PersonTester {

	Person p1;
	Person p2;
	Person p3;
	Person p4;
	List<Person> test;
	List<Person> expected;
	
	@Before
	public void init() {
		p1 = new Person("Kevin", "Smiley", 22345, LocalDate.of(1999, 3, 16));
		p2 = new Person("Bob", "Alpha", 12345, LocalDate.of(1997, 3, 12));
		p3 = new Person("William", "Zone", 42345, LocalDate.of(2003, 4, 2));
		p4 = new Person("Micheal", "Wong", 32345, LocalDate.of(2001, 3, 5));
		test = new ArrayList<Person>(Arrays.asList(p1, p2, p3, p4));
		expected = new ArrayList<Person>(Arrays.asList(p2, p1, p4, p3));
	}
	
	@Test
	public void testCompareTo() {
		assertTrue(p1.compareTo(p2) > 0);
		assertFalse(this.p1.compareTo(this.p2) < 0);
	}

	@Test
	public void testComparator() {
		test.sort(Person.bySSN());
		assertEquals(expected, test);
		test.sort(Person.byDOB());
		assertEquals(expected, test);
		Collections.sort(test, (Person p1, Person p2) -> p1.compareTo(p2));
		assertEquals(expected, test);
	}
	
}
