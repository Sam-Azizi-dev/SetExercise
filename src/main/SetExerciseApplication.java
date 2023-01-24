package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class SetExerciseApplication {
	
	public static void main(String[] args) throws IOException {
		// Instantiate new HashSet
		Set<String> newset = new HashSet<>(); 
		
		// extract the data from the CSV
		newset = extractDataFromCSV("PokerHands.csv");
		printToConsole(newset);

		// remove ACE HIGH and QUEEN HIGH
		removeUsingForLoop("QUEEN HIGH", newset);
		
		//removeMethod("QUEEN HIGH",newset);
		//removeMethod("ACE HIGH",newset);
		printToConsole(newset);

		// Update PAIR to DEUCES
		removeMethod("PAIR", newset);
		newset.add("DEUCES");
		printToConsole(newset);
	}
	
	public static void removeUsingForLoop(String removeItem, Set<String> newset) {
		for (String item:newset) {
			if (item.equalsIgnoreCase(removeItem)) {
				newset.remove(removeItem);
			}
		}
	}
	public static void removeMethod(String removeItem,Set<String> newset) {
		for (Iterator<String> iterator = newset.iterator(); iterator.hasNext();) {
			String item = iterator.next();
			if (item.startsWith(removeItem)) {
				iterator.remove();
			}
		}
	}
	
	public static void printToConsole(Set<String> newset) {
		for (String element:newset ) {
			System.out.println(element);
		}
	System.out.println("");
	}
	
	public static Set<String> extractDataFromCSV(String fileName) throws IOException {
		Set<String> pokerhands = new HashSet<>();
		String lines;
		BufferedReader filereader = null;
		filereader = new BufferedReader(new FileReader(fileName));
		filereader.readLine();
		while ((lines = filereader.readLine()) != null) {
			pokerhands.add(lines.split(",")[1]);
		}
		filereader.close();
		return pokerhands;
	}

}
