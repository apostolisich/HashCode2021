import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	private static final String[] INPUT_DATA_SET = { "a.txt", "b.txt", "c.txt", "d.txt", "e.txt", "f.txt" };
	
	private static final String[] OUTPUT_DATA_SET = { "a_out.txt", "b_out.txt", "c_out.txt", "d_out.txt", "e_out.txt", "f_out.txt" };
	
	private static final int DATA_SET_INDEX = 5;
	
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
		Intersection.setTotalIntersectionsUsed(intersectionCount);
		
		Intersection[] intersections = new Intersection[intersectionCount];
		HashMap<String, Street> streets = new HashMap<String, Street>(streetCount);
		fillStreetsAndIntersections(reader, lineScanner, streets, intersections);
		
		updateStreetsCarCounters(reader, lineScanner, streets);
		
		for(int j = 0; j < intersectionCount; j++) {
			Intersection currentIntersection = intersections[j];
			currentIntersection.calculateTimer(streets);
		}
		
		printSolution(intersections, streets);
		
		lineScanner.close();
		reader.close();
	}

	/**
	 * Fills the given streets and intersections structures with the data from the input file.
	 * 
	 * @param reader the file reader used to parse the file
	 * @param lineScanner the scanner that parses of the readers lines
	 * @param streets a Map containing the streets
	 * @param intersections an array containing the intersections
	 * @throws IOException
	 */
	private static void fillStreetsAndIntersections(BufferedReader reader, Scanner lineScanner, HashMap<String, Street> streets, Intersection[] intersections) throws IOException {
		for(int i = 0; i < streetCount; i++) {
			lineScanner = new Scanner(reader.readLine());
			
			int B = lineScanner.nextInt();
			int E = lineScanner.nextInt();
			String streetName = lineScanner.next();
			int L = lineScanner.nextInt();
			
			addOrUpdateIntersection(E, intersections, streetName);
			Street street = new Street(streetName, B, E, L);
			streets.put(streetName, street);
		}
	}
	
	/**
	 * Adds an intersection in the array with the given street, or adds the given Street to the
	 * intersection if it already exists in the array.
	 * 
	 * @param id the id of the intersection
	 * @param intersections the array of the intersections
	 * @param streetName the name of the Street to be added
	 * @param isIncommingStreet a boolean indicating if the street is incoming or not
	 */
	private static void addOrUpdateIntersection(int id, Intersection[] intersections, String streetName) {
		if(intersections[id] == null) {
			intersections[id] = new Intersection(id);
			intersections[id].addIncomingStreet(streetName);
		} else {
			intersections[id].addIncomingStreet(streetName);
		}
	}

	/**
	 * Updates the streets by increasing their car counter for each car that needs to pass through
	 * 
	 * @param reader the file reader used to parse the file
	 * @param lineScanner the scanner that parses of the readers lines
	 * @param streets a Map containing the streets
	 * @throws IOException
	 */
	private static void updateStreetsCarCounters(BufferedReader reader, Scanner lineScanner, HashMap<String, Street> streets) throws IOException {
		for(int j = 0; j < carCount; j++) {
			lineScanner = new Scanner(reader.readLine());
			
			int P = lineScanner.nextInt();
			for(int k = 0; k < P - 1; k++) {
				String streetName = lineScanner.next();
				streets.get(streetName).increaseCarCounter();
			}
		}
	}
	
	/**
	 * Prints the solution to the specified output file
	 * 
	 * @param intersections the array of intersections
	 * @param streets the map of the Streets
	 * @throws IOException
	 */
	private static void printSolution(Intersection[] intersections, HashMap<String, Street> streets) throws IOException {
		FileWriter writer = new FileWriter(new File(OUTPUT_DATA_SET[DATA_SET_INDEX]));
		writer.write(Intersection.getTotalIntersectionsUsed() + "\n");
		for(int k = 0; k < intersectionCount; k++) {
			Intersection currentIntersection = intersections[k];
			if(currentIntersection.isUnused()) {
				continue;
			}
			
			writer.write(currentIntersection.getId() + "\n");
			ArrayList<String> incomingStreets = currentIntersection.getIncomingStreets();
			writer.write(incomingStreets.size() + "\n");
			for(String street: incomingStreets) {
				writer.write(street + " " + streets.get(street).getLightTimer() + "\n");
			}
		}
		writer.close();
	}

}
