package assignment05;

public class Pineapple extends PizzaTopping {
	
	public Pineapple(Pizza p) {
		super(p);
	}

	@Override
	public double getCost() {
		return 0.5 + getOn().getCost();
	}
	
}

