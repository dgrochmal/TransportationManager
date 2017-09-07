/**
 * 
 */
package edu.ncsu.csc316.transportation_manager.ui;

import java.util.Scanner;

import edu.ncsu.csc316.transportation_manager.manager.TransportationManager;

/**
 * User Interface for Transportation manager
 * @author Dan Grochmal djgrochm
 *
 */
public class TransportationManagerUI {

	/**
	 * Main method for the system
	 * @param args Command Line arguments
	 */
	public static void main(String args[]) {
		TransportationManager manager = null;
		System.out.print("Enter in name of edge file: "); 
		Scanner reader = new Scanner(System.in);
		String filename = reader.next();
		manager = new TransportationManager(filename);
		System.out.println("Select option\nMinimum cost to connect all cities(COST)\nMinimum asphalt to connect all cities(ASPHALT)");
		String choice = reader.next();
		if(choice.equals("COST")) {
			System.out.println(manager.getMinimumHighways(choice));
		} else if(choice.equals("ASPHALT")) {
			System.out.println(manager.getMinimumHighways(choice));
		} else {
			reader.close();
			throw new IllegalArgumentException("Invalid choice");
		} 
		reader.close();
	}

}