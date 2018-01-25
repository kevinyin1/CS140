package assignment01;

public class Driver4 {

	public static void main(String[] args) {
		Name n = new Name("Kevin");
		Name alex = new Name("Alex");
		n.befriend(new Name("Alice"));
		n.befriend(alex);
		n.befriend(new Name("Michael"
		System.out.println("Number of Friends: " 
+ n.getFriendCount()); // expected output: 3 
		System.out.println("List of Friends: " + n.getFriendNames());
		n.unfriend(alex);
		System.out.println("New Number of Friends: "
 + n.getFriendCount()); // expected output 2
		System.out.println("New List of Friends: " + n.getFriendNames());   
	}	

}
