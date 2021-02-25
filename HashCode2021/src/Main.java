import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	
	private static final String[] INPUT_DATA_SET = { "a.txt" };
	
	private static final String[] OUTPUT_DATA_SET = { "a_out.txt" };
	
	private static final int DATA_SET_INDEX = 0;
	
	private static final boolean RED = false;
	private static final boolean GREEN = true;
	
	private static int simulationDuration = 0;
	private static int intersectionCount = 0;
	private static int streetCount = 0;
	private static int carCount = 0;
	private static int bonusPoints = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(new File(INPUT_DATA_SET[DATA_SET_INDEX])));
		
		Scanner lineScanner = new Scanner(reader.readLine());
		
		simulationDuration = lineScanner.nextInt();
		intersectionCount = lineScanner.nextInt();
		streetCount = lineScanner.nextInt();
		carCount = lineScanner.nextInt();
		bonusPoints = lineScanner.nextInt();
		
		Intersection[] intersections = new Intersection[intersectionCount];
		
		ArrayList<Street> streets = getStreets(reader, intersections);
		
		ArrayList<Car> cars = getCars(reader);
		
		for(int l = 0; l < streetCount; l++) {
			System.out.println(streets.get(l));
		}
		
		for(int n = 0; n < carCount; n++) {
			System.out.println(cars.get(n));
		}
		
		for(int m = 0; m < intersectionCount; m++) {
			System.out.println(intersections[m]);
		}
		
		reader.close();
	}

	private static ArrayList<Street> getStreets(BufferedReader reader, Intersection[] intersections) throws IOException {
		Scanner lineScanner;
		ArrayList<Street> streets = new ArrayList<Street>(streetCount);
		for(int i = 0; i < streetCount; i++) {
			lineScanner = new Scanner(reader.readLine());
			
			int B = lineScanner.nextInt();
			int E = lineScanner.nextInt();
			String streetName = lineScanner.next();
			int L = lineScanner.nextInt();
			
			addOrUpdateIntersection(B, intersections, streetName, false);
			addOrUpdateIntersection(E, intersections, streetName, true);
			Street street = new Street(streetName, B, E, L);
			streets.add(street);
		}
		
		return streets;
	}
	
	private static void addOrUpdateIntersection(int id, Intersection[] intersections, String streetName, boolean isIncommingStreet) {
		if(intersections[id] == null) {
			intersections[id] = new Intersection(id);
			intersections[id].addStreet(streetName, isIncommingStreet);
		} else {
			intersections[id].addStreet(streetName, isIncommingStreet);
		}
	}

	private static ArrayList<Car> getCars(BufferedReader reader) throws IOException {
		Scanner lineScanner;
		ArrayList<Car> cars = new ArrayList<Car>(carCount);
		for(int j = 0; j < carCount; j++) {
			lineScanner = new Scanner(reader.readLine());
			
			int P = lineScanner.nextInt();
			StringBuilder builder = new StringBuilder();
			for(int k = 0; k < P - 2; k++) {
				String streetName = lineScanner.next();
				builder.append(streetName);
				builder.append(" ");
			}
			String streetName = lineScanner.next();
			builder.append(streetName);
			
			Car car = new Car(builder.toString(), P);
			cars.add(car);
		}
		
		return cars;
	}
	
	private static void printSolution() throws IOException {
		FileWriter writer = new FileWriter(new File(OUTPUT_DATA_SET[DATA_SET_INDEX]));
		writer.write("...");
		
		writer.close();
	}

}
