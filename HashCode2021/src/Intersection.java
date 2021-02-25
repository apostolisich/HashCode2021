import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class Intersection {

	private int id;
	private ArrayList<String> incomingStreets;
	private HashSet<String> outgoingStreets;
	private LinkedHashMap<String, Integer> scheduleMap;
	private boolean unused;
	
	public Intersection(int id) {
		this.id = id;
		incomingStreets = new ArrayList<String>();
		outgoingStreets = new HashSet<String>();
		unused = false;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean isUnused() {
		return unused;
	}
	
	public void calculateTimer(HashMap<String, Street> streets) {
		int totalCounter = 0;
		for(String street: incomingStreets) {
			totalCounter += streets.get(street).getCarCounter();
		}
		
		if(totalCounter == 0) {
			unused = true;
			return;
		}
		
		for(int k = 0; k < incomingStreets.size(); k++) {
			String street = incomingStreets.get(k);
			int carCounter = streets.get(street).getCarCounter();
			int timer = (int) Math.ceil((double) carCounter/ (double) totalCounter);
			if(timer == 0) {
				incomingStreets.remove(k);
			} else {
				streets.get(street).setLightTimer(timer);
			}
		}
	}

	public ArrayList<String> getIncomingStreets() {
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
