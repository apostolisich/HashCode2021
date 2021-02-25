
public class Street {

	private String name;
	private int intersectionOnOneEnd;
	private int intersectionOnSecondEnd;
	private int requiredTimeToPassThrough;
	private int passThroughRate;
	
	public Street(String name, int intersection1, int intersection2, int requiredTimeToPassThrough) {
		this.name = name;
		this.intersectionOnOneEnd = intersection1;
		this.intersectionOnSecondEnd = intersection2;
		this.requiredTimeToPassThrough = requiredTimeToPassThrough;
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

	@Override
	public String toString() {
		return "Street [name=" + name + ", intersectionOnOneEnd=" + intersectionOnOneEnd + ", intersectionOnSecondEnd="
				+ intersectionOnSecondEnd + ", requiredTimeToPassThrough=" + requiredTimeToPassThrough
				+ ", passThroughRate=" + passThroughRate + "]";
	}
	
}
