package assignment04;

import java.util.List;
import java.util.ArrayList;
import java.lang.IllegalArgumentException;
import java.util.Iterator;

public class Elevator {

	private int currentFloor, groundFloor, capacity, numFloors;
	private List<Passenger> occupants = new ArrayList<Passenger>();
	private List<Line> lines = new ArrayList<Line>();
	private Direction currentDir = Direction.UP;

	public Elevator(int nf, int gf, int cap) {
		capacity = cap;
		numFloors = nf;
		groundFloor = gf;
		currentFloor = gf;
		for(int i = 0; i < nf; i++)
			lines.add(null);
	}	
	
	public String getFloorName(int index) {
		if(index < 0 || index >= numFloors)
			throw new IllegalArgumentException("Illegal floor number");
		if(index == groundFloor) return "G";
		else if(index < groundFloor)
			return "B" + (groundFloor - index);
		else return "" + (index - groundFloor);	
	}

	public int getFloorIndex(String floor) {
		if(floor.equals("G")) return groundFloor;
		else if(floor.startsWith("B")) 
			return Integer.parseInt(floor.substring(1)) + (groundFloor -Integer.parseInt(floor.substring(1)));
		else return Integer.parseInt(floor) + groundFloor;
	}

	public boolean addOccupants(Passenger p) {
		if(occupants.size() < capacity) {
			occupants.add(p);
			return true;
		}
		return false;
	}

	public void addLine(String flr, Line ln) {
		lines.set(getFloorIndex(flr), ln);
	}

	public void move() {
		if(currentDir == Direction.UP && currentFloor < numFloors - 1) currentFloor++;
		if(currentDir == Direction.UP && currentFloor == numFloors - 1){
			currentDir = Direction.DOWN;
			currentFloor--;
		}
		if(currentDir == Direction.DOWN && currentFloor > 0) currentFloor--;
		if(currentDir == Direction.DOWN && currentFloor == 0){
			currentDir = Direction.UP;
			currentFloor++;
		}
		Iterator iter = occupants.iterator();
		while(iter.hasNext()){
			Passenger p = (Passenger) iter.next();
			if(currentFloor == getFloorIndex(p.getDestinationFloor())) iter.remove();
		}
		for(Line l: lines)
			if(l.getFloor().equals(getFloorName(currentFloor))) 
				if(l.getLine() != null)
					l.loadElevator();
	}

	public int getNumFloors() {
		return numFloors;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public Direction getCurrentDir() {
		return currentDir;
	}

	public List<Line> getLines() {
		return lines;
	}

	public int getNumOccupants() {
		return occupants.size();
	}	
}
