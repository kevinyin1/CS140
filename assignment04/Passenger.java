package assignment04;

import java.lang.IllegalArgumentException;

public class Passenger {

	private String destinationFloor;
	private int id;
	private static int nextID = 0;

	public Passenger(String destFl, Elevator elev){
		if(destFl == null)
			throw new IllegalArgumentException("Cannot give null arguments");
		destinationFloor = destFl;
		int dest = elev.getFloorIndex(destFl);
		if (dest < 0) dest = 0;
		if (dest > elev.getNumFloors()) dest = elev.getNumFloors() - 1;
		destinationFloor = elev.getFloorName(dest);
		id = ++nextID;
	}

	public String getDestinationFloor() {
		return destinationFloor;
	}

	public int getID() {
		return id;
	}

	public String toString() {
		return "" + id;
	}	
}
