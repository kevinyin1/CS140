package assignment05;

public class GreenPeppers extends PizzaTopping {

	public GreenPeppers(Pizza p) {
		super(p);
	}
	
	@Override
	public double getCost() {
		return 0.4 + getOn().getCost();
	}
	
}
