import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	private static final String[] INPUT_DATA_SET = { "" };
	
	private static final String[] OUTPUT_DATA_SET = { "" };
	
	private static final int DATA_SET_INDEX = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(new File(INPUT_DATA_SET[DATA_SET_INDEX])));
		
		Scanner lineScanner = new Scanner(reader.readLine());
		
		reader.close();
	}
	
	private static void printSolution() throws IOException {
		FileWriter writer = new FileWriter(new File(OUTPUT_DATA_SET[DATA_SET_INDEX]));
		writer.write("...");
		
		writer.close();
	}

}
