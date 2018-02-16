package assignment04;

import java.util.List;
import java.util.ArrayList;

public class Visualizer {

	public static void main(String[] args){

		Elevator e = new Elevator(15, 5, 10);
		Line l = new Line("G", e);
		List<Passenger> list = l.getLine();
		list.add(new Passenger("7", e));
		list.add(new Passenger("7", e));
		list.add(new Passenger("7", e));
		list.add(new Passenger("7", e));
		list.add(new Passenger("7", e));
		list.add(new Passenger("7", e));
		list.add(new Passenger("3", e));
		list.add(new Passenger("3", e));
		list.add(new Passenger("3", e));
		list.add(new Passenger("B3", e));
		list.add(new Passenger("B3", e));
		list.add(new Passenger("B3", e));
		showElev(e);
		e.getLines().get(e.getCurrentFloor()).loadElevator();
		for(int i = 0; i < 35; i++){
			showElev(e);
			e.move();
		}
	}

	public static void showElev(Elevator e) {
		for(int i = 0; i < e.getNumFloors(); i++){
			if(i == e.getNumFloors()){
				System.out.println(e.getFloorName(i) + " >\t\t" + e.getNumOccupants());
				continue;
			}
			System.out.println(e.getFloorName(i) + "\t\t0");
		}
	}

}
