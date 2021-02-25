import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	
	private static final String[] INPUT_DATA_SET = { "a.txt", "b.txt", "c.txt", "d.txt", "e.txt", "f.txt" };
	
	private static final String[] OUTPUT_DATA_SET = { "a_out.txt", "b_out.txt", "c_out.txt", "d_out.txt", "e_out.txt", "f_out.txt" };
	
	private static final int DATA_SET_INDEX = 5;
	
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
		
		HashMap<String, Street> streets = getStreets(reader, intersections);
		
		ArrayList<Car> cars = getCars(reader, streets);
		
		ArrayList<String> activeStreetNames = new ArrayList<String>();
//		for(int j = 0; j < 2; j++) {
////			turnLightsOn();
////			moveCars();
////			updateIntersection();
////			updateStreet();
//		}
		
		for(int j = 0; j < intersectionCount; j++) {
			Intersection currentIntersection = intersections[j];
			currentIntersection.calculateTimer(streets);
		}
		
		
		printSolution(intersections, streets);
		reader.close();
	}

	private static HashMap<String, Street> getStreets(BufferedReader reader, Intersection[] intersections) throws IOException {
		Scanner lineScanner;
		HashMap<String, Street> streets = new HashMap<String, Street>(streetCount);
		for(int i = 0; i < streetCount; i++) {
			lineScanner = new Scanner(reader.readLine());
			
			int B = lineScanner.nextInt();
			int E = lineScanner.nextInt();
			String streetName = lineScanner.next();
			int L = lineScanner.nextInt();
			
			addOrUpdateIntersection(B, intersections, streetName, false);
			addOrUpdateIntersection(E, intersections, streetName, true);
			Street street = new Street(streetName, B, E, L);
			streets.put(streetName, street);
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

	private static ArrayList<Car> getCars(BufferedReader reader, HashMap<String, Street> streets) throws IOException {
		Scanner lineScanner;
		ArrayList<Car> cars = new ArrayList<Car>(carCount);
		for(int j = 0; j < carCount; j++) {
			lineScanner = new Scanner(reader.readLine());
			
			int P = lineScanner.nextInt();
			Car car = new Car(j, P);
			for(int k = 0; k < P; k++) {
				String streetName = lineScanner.next();
				streets.get(streetName).increaseCarCounter();
				car.addToStreetList(streetName);
			}
			
			String street = car.getStreetList().get(car.getStreetList().size() - 1);
			streets.get(street).decreaseCarCounter();;
			
			cars.add(car);
		}
		
		return cars;
	}
	
	private static void printSolution(Intersection[] intersections, HashMap<String, Street> streets) throws IOException {
		FileWriter writer = new FileWriter(new File(OUTPUT_DATA_SET[DATA_SET_INDEX]));
		//TODO calculate used intersections
		writer.write(intersectionCount + "\n");
		for(int k = 0; k < intersectionCount; k++) {
			Intersection currentIntersection = intersections[k];
			if(currentIntersection.isUnused()) {
				continue;
			}
			writer.write(currentIntersection.getId() + "\n");
			ArrayList<String> incomingStreets = currentIntersection.getIncomingStreets();
			writer.write(incomingStreets.size() + "\n");
			for(String street: incomingStreets) {
				if(streets.get(street).getLightTimer() != 0 )
					writer.write(street + " " + streets.get(street).getLightTimer() + "\n");
			}
		}
		writer.close();
	}

}
