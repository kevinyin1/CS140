package assignment04;

import java.util.List;
import java.util.ArrayList;

public class Visualizer {

	public static void main(String[] args){

		Elevator e = new Elevator(15, 5, 10);
		Line l = new Line("G", e);
		List<Passenger> line = l.getLine();
		line.add(new Passenger("7", e));
		line.add(new Passenger("7", e));
		line.add(new Passenger("7", e));
		line.add(new Passenger("7", e));
		line.add(new Passenger("7", e));
		line.add(new Passenger("7", e));
		line.add(new Passenger("3", e));
		line.add(new Passenger("3", e));
		line.add(new Passenger("3", e));
		line.add(new Passenger("B3", e));
		line.add(new Passenger("B3", e));
		line.add(new Passenger("B3", e));
		showElev(e);
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		e.getLines().get(e.getCurrentFloor()).loadElevator();
		for(int i = 0; i < 35; i++){
			showElev(e);
			e.move();
			System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		}
	}

	public static void showElev(Elevator e) {
		for(int i = e.getNumFloors() - 1; i >= 0; i--){
			if(i == e.getCurrentFloor()){
				System.out.println(e.getFloorName(i) + " >\t\t" + e.getNumOccupants());
				continue;
			}
			System.out.println(e.getFloorName(i) + "\t\t0");
		}
	}

}
