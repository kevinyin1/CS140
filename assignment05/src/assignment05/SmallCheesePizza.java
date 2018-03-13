package assignment05;

public class SmallCheesePizza implements Pizza {

	@Override
	public int compareTo(Pizza o) {
		// TODO Auto-generated method stub
		return 1;
	}
	
	@Override
	public String getDescription() {
		return "Small cheese pizza";
	}

	@Override
	public double getCost() {
		return 7.5;
	}
	
}
