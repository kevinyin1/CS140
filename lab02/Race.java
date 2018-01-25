package lab02;

public class Race {

	public static void main(String[] args) {
		Car[] race = {new Car("Honda", 100.0), new Car("Toyota", 110.0),
new Car("Nissan", 120.0)};
		//prints all the car types
		for(int i = 0; i < race.length; i++)
			System.out.println(race[i].getCarType());
		//prints all the car topSpeeds
		for(Car car: race)
			System.out.println(car.getTopSpeed());
		//prints the average top speed
		System.out.println("Average top speed: " + averageTopSpeed(race));
		//prints the fastest car speed and the returned value of fastestSpeed method
		System.out.println("Fastest Car: " + race[2].getTopSpeed() + "\nFastest Car from fastestSpeed method: " + fastestSpeed(race));	
	}
	
	/**
	@return returns the averageTopSpeed of a given Car array
	*/
	public static double averageTopSpeed(Car[] cars) {
		double totalSpeeds = 0;
		for(Car car: cars)
			totalSpeeds += car.getTopSpeed();
		return totalSpeeds/cars.length;
	}
	
	/**
	@return returns the fastest car's speed of the given Car array	
	*/
	public static double fastestSpeed(Car[] cars) {
		double maxSpeed = cars[0].getTopSpeed();
		for(Car car: cars)
			maxSpeed = (car.getTopSpeed() >= maxSpeed) ? car.getTopSpeed() :  maxSpeed;
		return maxSpeed;
	}
}
