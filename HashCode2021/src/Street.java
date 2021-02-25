import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Street implements Comparable<Street> {

	private String name;
	private int intersectionOnOneEnd;
	private int intersectionOnSecondEnd;
	private int requiredTimeToPassThrough;
	private int passThroughRate;
	private Queue<ArrayList<Integer>> carsQueue;
	
	public Street(String name, int intersection1, int intersection2, int requiredTimeToPassThrough) {
		this.name = name;
		this.intersectionOnOneEnd = intersection1;
		this.intersectionOnSecondEnd = intersection2;
		this.requiredTimeToPassThrough = requiredTimeToPassThrough;
		carsQueue = new LinkedList<ArrayList<Integer>>();
	}

	public String getName() {
		return name;
	}

	public int getIntersectionOnOneEnd() {
		return intersectionOnOneEnd;
	}

	public int getIntersectionOnSecondEnd() {
		return intersectionOnSecondEnd;
	}

	public long getRequiredTimeToPassThrough() {
		return requiredTimeToPassThrough;
	}
	
	public void addToCarQueue(int carId) {
		ArrayList<Integer> cars = new ArrayList<Integer>();
		cars.add(carId);
		carsQueue.add(cars);
	}
	
	public Queue<ArrayList<Integer>> getCarsQueue() {
		return carsQueue;
	}

	@Override
	public String toString() {
		return "Street [name=" + name + ", intersectionOnOneEnd=" + intersectionOnOneEnd + ", intersectionOnSecondEnd="
				+ intersectionOnSecondEnd + ", requiredTimeToPassThrough=" + requiredTimeToPassThrough
				+ ", passThroughRate=" + passThroughRate + "]";
	}

	@Override
	public int compareTo(Street otherStreet) {
		if(this.carsQueue.size() < otherStreet.getCarsQueue().size()) {
			return -1;
		} else if(this.carsQueue.size() > otherStreet.getCarsQueue().size()) {
			return +1;
		}
		return 0;
	}
	
}
