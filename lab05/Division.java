package lab05;

import java.util.List;
import java.util.ArrayList;
import java.lang.IllegalArgumentException;
import java.util.Iterator;

public class Division {

	private List<Double> list = new ArrayList<Double>();

	public Division(double[] array) {
		if(array == null || array.length == 0) throw new IllegalArgumentException("need to enter an array with at least one double");
		for(double num: array)
			list.add(num);
	}
	
	public void removeZeroes() {
		Iterator iter = list.iterator();
		while(iter.hasNext())
			if(((double) iter.next()) == 0) iter.remove();
	}

	public void divide(int divisor) {
		if(divisor == 0) throw new IllegalArgumentException("cannot divide by zero");
		for(int i = 0; i < list.size(); i++){
			double temp = list.get(i)/divisor;
			list.set(i, temp);
		}
	}
	
	@Override
	public String toString() {
		return list.toString();
	}
}
