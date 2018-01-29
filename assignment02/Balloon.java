package assignment02;

public class Balloon {

	private double radius;

	public double getRadius() {
		return radius;
	}

	public void inflate(double amount) {
		radius += amount;
	}

	public void inflatePct(double amount) {
		radius += radius * (amount / 100.0);
	}

	public double getVolume() {
		return 4 * Math.PI * radius * radius * radius / 3;
	}

	public void doubleVolume() {
		radius = Math.cbrt((2 * this.getVolume()) * 3 / 4 / Math.PI); 
	}

}

