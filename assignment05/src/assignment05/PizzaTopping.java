package assignment05;

public abstract class PizzaTopping implements Pizza {

	private Pizza on;

	public PizzaTopping(Pizza p) {
		this.on = p;
	}

	@Override
	public int compareTo(Pizza p) {
		if(p instanceof PizzaTopping)
			return this.getClass().getSimpleName().compareTo(p.getClass().getSimpleName()); 
		return -1;
	}

	@Override
	public String getDescription() {
		if (on instanceof PizzaTopping)
			return getClass().getSimpleName() + ", " + on.getDescription();
		return getClass().getSimpleName() + " on " + on.getDescription();
	}

	public Pizza getOn() {
		return on;
	}

	public void setOn(Pizza on) {
		this.on = on;
	}

}
