import java.util.LinkedList;
import java.util.Queue;

public class Car {

	private int id;
	private Queue<String> streetQueue;
	private int totalTimeToDestination;
	private int numberOfStreets;
	
	public Car(int id, int numberOfStreets) {
		this.id = id;
		this.numberOfStreets = numberOfStreets;
		streetQueue = new LinkedList<String>();
	}

	public Queue<String> getStreetQueue() {
		return streetQueue;
	}

	public void setStreetQueue(Queue<String> streetQueue) {
		this.streetQueue = streetQueue;
	}
	
	public void addToStreetQueue(String street) {
		streetQueue.add(street);
	}

	public int getTotalTimeToDestination() {
		return totalTimeToDestination;
	}

	public void setTotalTimeToDestination(int totalTimeToDestination) {
		this.totalTimeToDestination = totalTimeToDestination;
	}

	public int getNumberOfStreets() {
		return numberOfStreets;
	}

	public void setNumberOfStreets(int numberOfStreets) {
		this.numberOfStreets = numberOfStreets;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Car [path=" + streetQueue + ", totalTimeToDestination=" + totalTimeToDestination + ", numberOfStreets="
				+ numberOfStreets + "]";
	}
	
}
