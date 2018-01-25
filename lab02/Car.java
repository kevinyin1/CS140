package lab02;

public class Car {

	private String carType;
	private double topSpeed;

	public Car(String aCarType, double aTopSpeed) {
		carType = aCarType;
		topSpeed = aTopSpeed;
	}

	/**
	@return returns the car type
	*/
	public String getCarType() {
		return carType;
	}
	
	/**
	@return returns the topSpeed of the car
	*/
	public double getTopSpeed() {
		return topSpeed;
	}
}
