package lab07;

public abstract class Carnivore extends Animal {

	private String prey;
	private int predatoryLevel;

	abstract void prowl();

	public Carnivore(String prey, int predatoryLevel) {
		this.prey = prey;
		this.predatoryLevel = predatoryLevel;
	}
	
	public String getPrey() {
		return prey;
	}
	
	public int getPredatoryLevel() {
		return predatoryLevel;
	}
	
	@Override
	public String toString() {
		return "A carnivore only eats meat. It can additionally perform the action prowl, and has prey it eats";
	}
	
}
