package assignment01;

public class Name {
	
	private String name, friends = "";

	public Name(String nm) {
		name = nm;
		if(nm.indexOf(' ') >= 0) throw new IllegalArgumentException("No Spaces in Names");
	}

	public String getName() {
		return name;
	}

	public void befriend(Name n) {
		friends += n.getName() + " ";
	}
	
	public void unfriend(Name n) {
		friends = friends.replace(n.getName() + " ", "");
	}

	public String getFriendNames() {
		return friends;
	}
	
	public int getFriendCount() {
		int count = 0;
		for(char c : friends.toCharArray()) {
			if(c == ' ') count++;
		} 
		return count;
	}
	
}
