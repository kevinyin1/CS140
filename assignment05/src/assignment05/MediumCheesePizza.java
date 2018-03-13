package assignment05;

public class MediumCheesePizza implements Pizza {

	@Override
	public int compareTo(Pizza o) {
		return 1;
	}

	@Override
	public double getCost() {
		return 10.0;
	}
	
	@Override
	public String getDescription() {
		return "Medium cheese pizza";
	}

}
