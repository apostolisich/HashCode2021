import java.util.HashSet;
import java.util.LinkedHashMap;

public class Intersection {

	private int id;
	private HashSet<String> incomingStreets;
	private HashSet<String> outgoingStreets;
	private LinkedHashMap<String, Integer> scheduleMap;
	private int lightTimer;
	
	public Intersection(int id) {
		this.id = id;
		incomingStreets = new HashSet<String>();
		outgoingStreets = new HashSet<String>();
	}

	public int getId() {
		return id;
	}

	public HashSet<String> getIncomingStreets() {
		return incomingStreets;
	}

	public HashSet<String> getOutgoingStreets() {
		return outgoingStreets;
	}

	public LinkedHashMap<String, Integer> getScheduleMap() {
		return scheduleMap;
	}
	
	public void addToScedule(String streetName, int duration) {
		scheduleMap.put(streetName, duration);
	}
	
	public void addStreet(String street, boolean isIncomming) {
		if(isIncomming) {
			incomingStreets.add(street);
		} else {
			outgoingStreets.add(street);
		}
	}


	@Override
	public String toString() {
		return "Intersection [id=" + id + ", incomingStreets=" + incomingStreets + ", outgoingStreets="
				+ outgoingStreets + ", scheduleMap=" + scheduleMap + "]";
	}
	
	
}
