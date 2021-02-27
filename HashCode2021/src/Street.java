
public class Street {

	private String name;
	private int intersectionOnOneEnd;
	private int intersectionOnSecondEnd;
	private double carCounter;
	private int lightTimer;
	
	public Street(String name, int intersection1, int intersection2, int requiredTimeToPassThrough) {
		this.name = name;
		this.intersectionOnOneEnd = intersection1;
		this.intersectionOnSecondEnd = intersection2;
		carCounter = 0;
	}
	
	/**
	 * Returns the name of the street
	 * 
	 * @return the name of the street
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the intersection id from which the street is starting
	 * 
	 * @return the starting intersection id
	 */
	public int getIntersectionOnOneEnd() {
		return intersectionOnOneEnd;
	}

	/**
	 * Returns the intersection id to which the street leads
	 * 
	 * @return the ending intersection id
	 */
	public int getIntersectionOnSecondEnd() {
		return intersectionOnSecondEnd;
	}
	
	/**
	 * Increases the counter of the cars that pass through the street by 1
	 */
	public void increaseCarCounter() {
		carCounter++;
	}
	
	/**
	 * Returns the counter of the cars that pass through the street
	 * 
	 * @return the car counter
	 */
	public double getCarCounter() {
		return carCounter;
	}

	/**
	 * Sets the given duration (in seconds) of the green light of the street
	 * 
	 * @param lightTimer the duration (in seconds) of the green light
	 */
	public void setLightTimer(int lightTimer) {
		this.lightTimer = lightTimer;
	}
	
	/**
	 * Returns the duration (in seconds) of the green light of the street
	 * 
	 * @return the green light timer
	 */
	public int getLightTimer() {
		return lightTimer;
	}
	
	@Override
	public String toString() {
		return "Street [name=" + name + ", intersectionOnOneEnd=" + intersectionOnOneEnd + ", intersectionOnSecondEnd="
				+ intersectionOnSecondEnd + "]";
	}
	
}
