package lab09;

import java.util.Comparator;

public class Bonus {

	public static void main(String[] args) {
		Comparator<String> Stringcomp = (s1, s2) -> (s1.length() - s2.length());
		BinarySearchTree<String> tree = new BinarySearchTree<String>(Stringcomp);
		tree.insert("Shawn");
		tree.insert("Bob");
		tree.insert("Nick");
		tree.insert("Ho");
		tree.insert("Michael");
		tree.insert("Christopher");
		tree.insert("Cornelius");
		tree.insert("Derrick");
		tree.insert("Kevin");
		tree.prettyPrint();
	}
	
}
