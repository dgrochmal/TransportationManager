/**
 * 
 */
package edu.ncsu.csc316.transportation_manager.manager;

import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.io.HighwayReader;
import edu.ncsu.csc316.transportation_manager.list.AdjacencyList;
import edu.ncsu.csc316.transportation_manager.list.AdjacencyList.Node;
import edu.ncsu.csc316.transportation_manager.list.ArrayBasedList;
import edu.ncsu.csc316.transportation_manager.util.MinimumHighwayFinder;

/**
 * Class that brings all other classes together to preform Kruskal's on a list built
 * from the file.
 * 
 * @author Dan Grochmal djgrochm
 */
public class TransportationManager {

	/** HighwayReader object */
	public HighwayReader hr = null;
	
	/**
	 * Constructs a new TransportationManager
	 * 
	 * @param pathToFile the path to the file that contains the set of highways in the graph
	 */
	public TransportationManager(String pathToFile)
	{
	    hr = new HighwayReader(pathToFile);
	}

	/**
	 * Returns a string representation of the AdjacencyList
	 * in the following format, where (for each city) the Highways are
	 * in sorted order by city1, then city2, then cost, then asphalt:
	 * 
	 * AdjacencyList[
	 *    City 0: -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X] -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X] -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X]
	 *    City 1: -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X] -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X]
	 *    City 2: -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X] -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X] -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X]
	 *    City 3: -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X]
	 * ]
	 * 
	 * @return the string representation of the AdjacencyLists
	 */
	public String getAdjacencyList()
	{
		StringBuilder sb = new StringBuilder();
		ArrayBasedList<Highway> highwayList = hr.gethList();
		ArrayBasedList<Highway> sortedList = insertionSort(highwayList);
		AdjacencyList al = new AdjacencyList(sortedList);
		sb.append("AdjacencyList[\n");
		for(int i = 0; i < al.ajList.size(); i++){
			sb.append("   City ").append(i).append(":");
			sb.append(" -> ").append(al.ajList.get(i).h.toString());
			Node n = al.ajList.get(i);
			while(n.hasNext()){
				sb.append(" -> ").append(n.next.h.toString());
				n = n.next;
			}
			sb.append("\n");
		}
		sb.append("]");
		//System.out.println(sb.toString());
		return sb.toString();
	}
	
	/**
	 * Returns a string representation of the list of Highways contained in the 
	 * minimum spanning set of Highways. The returned string is in the following format,
	 * where the Highways are in sorted order by city1, city2, then cost, then asphalt:
	 * 
	 * List[
	 *    Highway[city1=X, city2=X, cost=X.X, asphalt=X.X],
	 *    Highway[city1=X, city2=X, cost=X.X, asphalt=X.X],
	 *    Highway[city1=X, city2=X, cost=X.X, asphalt=X.X]
	 * ]
	 * 
	 * @param type the type ("COST" or "ASPHALT") of field to minimize
	 * @return a string representation of the minimum spanning set of Highways
	 */
	public String getMinimumHighways(String type)
	{
		StringBuilder sb = new StringBuilder();
		//AdjacencyList al = new AdjacencyList(hr.hList);
		AdjacencyList al = hr.getajList();
		MinimumHighwayFinder mhf = new MinimumHighwayFinder(al, type);
		//AdjacencyList minList = mhf.getaJList();
		ArrayBasedList<Highway> pList = mhf.getHList();
		//boolean check = true;
		sb.append("List[\n");
		//pList.add(0, al.ajList.get(0).h);
		ArrayBasedList<Highway> sorted = insertionSort(pList);
		
//		for(int r = 0; r < al.ajList.size(); r++){
//			for(int y = 0; y < al.ajList.size(); y++){
//				for(int t = 0; t < pList.size(); t++){
//					if(pList.get(t).city1 == r && pList.get(t).city2 == y){
//						sb.append("   ").append(pList.get(t).toString()).append(",\n");
//					}
//				}
//			}
//		}
		
		for(int i = 0; i < sorted.size(); i++){
			sb.append("   ").append(sorted.get(i).toString()).append(",\n");
		}
		
		
		String sub = sb.substring(0, sb.length() - 2);
	    sb = new StringBuilder();
	    sb.append(sub).append("\n]");
		//sb.append("]");
		//System.out.println(sb.toString());
		return sb.toString();
	    // Your code
	}

	private ArrayBasedList<Highway> insertionSort(ArrayBasedList<Highway> input){
        
        Highway temp = null;
        for (int i = 1; i < input.size(); i++) {
            for(int j = i ; j > 0 ; j--){
                if(input.get(j).compareTo(input.get(j - 1)) == 1){
                    temp = input.get(j);
                    input.set(j, input.get(j - 1));
                    input.set(j - 1, temp);
                } 

            }
        }
        return input;
    }
	
}