package assignment01;

public class Driver3 {

	public static void main(String[] args) {
		Balloon balloon = new Balloon();
		balloon.inflate(10.0);
		System.out.println("Radius: " + balloon.getRadius()
 + "\nVolume: " + balloon.getVolume()); // prints the radius and volume of the balloon
	
		balloon.inflatePct(50.0); // inflates the balloon by 50%
		System.out.println("New Radius: " + balloon.getRadius() + "\nNew Volume: "
 + balloon.getVolume()); //expect output is 15 and prints new volume
			
		System.out.println("Doubled Volume: " + 2 * balloon.getVolume()); //prints double the volume
		balloon.doubleVolume(); // doubles the volume and increases the radius
		System.out.println("New Radius: " + balloon.getRadius() + "\nNew Volume: "
 + balloon.getVolume()); //prints the new radius and new volume 
	}

}
