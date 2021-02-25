
public class Car {

	private String path;
	private int totalTimeToDestination;
	private int numberOfStreets;
	
	public Car(String path, int numberOfStreets) {
		this.path = path;
		this.numberOfStreets = numberOfStreets;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
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

	@Override
	public String toString() {
		return "Car [path=" + path + ", totalTimeToDestination=" + totalTimeToDestination + ", numberOfStreets="
				+ numberOfStreets + "]";
	}
	
}
