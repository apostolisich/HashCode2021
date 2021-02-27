import java.util.ArrayList;
import java.util.HashMap;

public class Intersection {

	private int id;
	private ArrayList<String> incomingStreets;
	private boolean isUnused;
	private static int totalIntersectionsUsed;
	
	public Intersection(int id) {
		this.id = id;
		incomingStreets = new ArrayList<String>();
		isUnused = false;
	}
	
	/**
	 * Returns the id of the intersection
	 * 
	 * @return the id of the intersection
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns the list of the incoming streets of the intersection
	 * 
	 * @return the list of the incoming streets of the intersection
	 */
	public ArrayList<String> getIncomingStreets() {
		return incomingStreets;
	}
	
	/**
	 * Adds the given incoming Street to the intersection
	 * 
	 * @param street the Street to be added
	 */
	public void addIncomingStreet(String street) {
		incomingStreets.add(street);
	}
	
	/**
	 * Returns whether the intersection is used or not (an intersection might
	 * not be used if all the incoming streets have no cars passing through).
	 * 
	 * @return true if the intersection is not used; false otherwise
	 */
	public boolean isUnused() {
		return isUnused;
	}
	
	/**
	 * Returns the total intersections used.
	 * 
	 * @return the total intersections used
	 */
	public static int getTotalIntersectionsUsed() {
		return totalIntersectionsUsed;
	}

	/**
	 * Sets the total intersections used
	 * 
	 * @param totalIntersectionsUsed the total number of intersections
	 */
	public static void setTotalIntersectionsUsed(int totalIntersectionsUsed) {
		Intersection.totalIntersectionsUsed = totalIntersectionsUsed;
	}

	/**
	 * Calculates and sets the corresponding light timer for each one of the incoming
	 * streets
	 * 
	 * @param streets a Map with all the streets
	 */
	public void calculateTimer(HashMap<String, Street> streets) {
		double totalCounter = getTotalCounter(streets);
		if(totalCounter == -1) return;
		
		for(int k = 0; k < incomingStreets.size(); k++) {
			String street = incomingStreets.get(k);
			if(streets.get(street).getCarCounter() == 0) {
				incomingStreets.remove(k);
				k--;
			} else {
				streets.get(street).setLightTimer((int) streets.get(street).getCarCounter());
			}
		}
		
		int incomingStreetsInUse = incomingStreets.size();
		if(incomingStreetsInUse > 1) {
			for(int k = 0; k < incomingStreets.size(); k++) {
				String street = incomingStreets.get(k);
				int timer = streets.get(street).getLightTimer();
				int newTimer = (int) Math.ceil(timer/incomingStreetsInUse);
				streets.get(street).setLightTimer(newTimer == 0 ? 1 : newTimer);
			}
		}
	}
	
	/**
	 * Returns the total car counter for all the incoming streets. In case
	 * no incoming streets have cars passing through, -1 is returned.
	 * 
	 * @param streets a Map with the streets
	 * @return the total car counter
	 */
	private double getTotalCounter(HashMap<String, Street> streets) {
		double totalCounter = 0;
		for(String street: incomingStreets) {
			totalCounter += streets.get(street).getCarCounter();
		}
		
		if(totalCounter == 0) {
			isUnused = true;
			totalIntersectionsUsed--;
			return -1;
		}
		
		return totalCounter;
	}

	@Override
	public String toString() {
		return "Intersection [id=" + id + ", incomingStreets=" + incomingStreets + ", isUnused=" + isUnused + "]";
	}

}
