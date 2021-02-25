import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Car {

	private int id;
	private ArrayList<String> streetList;
	private int totalTimeToDestination;
	private int numberOfStreets;
	
	public Car(int id, int numberOfStreets) {
		this.id = id;
		this.numberOfStreets = numberOfStreets;
		streetList = new ArrayList<String>();
	}

	public ArrayList<String> getStreetList() {
		return streetList;
	}
	
	public void addToStreetList(String street) {
		streetList.add(street);
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
		return "Car [path=" + streetList + ", totalTimeToDestination=" + totalTimeToDestination + ", numberOfStreets="
				+ numberOfStreets + "]";
	}
	
}
