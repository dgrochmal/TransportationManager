/**
 * 
 */
package edu.ncsu.csc316.transportation_manager.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.list.AdjacencyList;
import edu.ncsu.csc316.transportation_manager.list.ArrayBasedList;

/**
 * Input class for TransportationManager
 * @author Dan Grochmal djgrochm
 *
 */
public class HighwayReader {

	/** List constructed of all highways from the file */
	public ArrayBasedList<Highway> hList = new ArrayBasedList<Highway>();
	/** AdjacencyList constructed of all highways from the file */
	public AdjacencyList ajList = new AdjacencyList(hList);
	
	/**
	 * Constructor of HighwayReader object
	 * @param filename name of the file to be read
	 */
	public HighwayReader(String filename) {
		try(Scanner scan = new Scanner(new FileInputStream(filename), "UTF8"))
		{
			//int count = 0;
		    while(scan.hasNext())
		    {
		        int city1 = scan.nextInt();
		        int city2 = scan.nextInt();
		        double cost = scan.nextDouble();
		        double asphalt = scan.nextDouble();
		        ajList.addNode(city1, city2, cost, asphalt);
		        Highway h = new Highway(city1, city2, cost, asphalt);
		        hList.add(0, h);
		        //count++;
		    }
		    scan.close();
		} catch (FileNotFoundException e) {
			//Do nothing
		}
	}

	/**
	 * Returns the List of highways
	 * @return the hList of highways
	 */
	public AdjacencyList getajList() {

        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
		return ajList;
	}
	
	/**
	 * Returns the List of highways
	 * @return the hList of highways
	 */
	public ArrayBasedList<Highway> gethList() {

        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
        System.out.print("");
		return hList;
	}

}