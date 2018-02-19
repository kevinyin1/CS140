package assignment04;

public class Tester {

	public static void main(String[] args) {
		Elevator e = new Elevator(15, 5, 10);
		System.out.println("Expected: \"G\"; Output: \""+ e.getFloorName(5) + "\"");
		System.out.println("Expected: \"B2\"; Output: \""+ e.getFloorName(3) + "\"");
		System.out.println("Expected: \"3\"; Output: \""+ e.getFloorName(7) + "\"");
		System.out.println("Expected: \"5\"; Output: \""+ e.getFloorIndex("G") + "\"");
		System.out.println("Expected: \"3\"; Output: \""+ e.getFloorIndex("B2") + "\"");
		System.out.println("Expected: \"7\"; Output: \""+ e.getFloorIndex("3") + "\"");
	}

}
