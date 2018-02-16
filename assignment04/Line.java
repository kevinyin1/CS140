package assignment04;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Line {

	private String floor;
	private List<Passenger> line = new ArrayList<Passenger>();
	private Elevator elevator;

	public Line(String flr, Elevator elev){
		floor = flr;
		elevator = elev;
		elevator.addLine(flr, this);
	}

	public void loadElevator() {
		Iterator<Passenger> iter = line.iterator();
		int thisFloor = elevator.getFloorIndex(floor);
		if(elevator.getCurrentDir() == Direction.UP){
			while(iter.hasNext()){
				Passenger p = iter.next();
				if(elevator.getFloorIndex(p.getDestinationFloor()) > thisFloor)
					if(elevator.addOccupants(p)) iter.remove();
			}
		}
		else { 
			while(iter.hasNext()){
				Passenger p = iter.next();
				if(elevator.getFloorIndex(p.getDestinationFloor()) < thisFloor)
					if(elevator.addOccupants(p)) iter.remove();
			}
		}
		
	}

	public List<Passenger> getLine() {
		return line;
	}

	public String getFloor(){
		return floor;
	}
}
