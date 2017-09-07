/**
 * 
 */
package edu.ncsu.csc316.transportation_manager.util;

import edu.ncsu.csc316.transportation_manager.heap.MinHighwayHeap;
import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.list.AdjacencyList;
import edu.ncsu.csc316.transportation_manager.list.AdjacencyList.Node;
import edu.ncsu.csc316.transportation_manager.list.ArrayBasedList;
import edu.ncsu.csc316.transportation_manager.set.UpTree;
import edu.ncsu.csc316.transportation_manager.set.UpTree.UpNode;

/**
 * Kruskal's Algorithm for finding MST's
 * 
 * @author Dan Grochmal djgrochm
 *
 */
public class MinimumHighwayFinder {

	/** List to hold the Highways in the MST */
	public ArrayBasedList<Highway> hList;
	/** AdjacencyList to hold MST */
	public AdjacencyList aJList;
	
	
	/**
	 * Kruskal's Algorithm
	 * @param highways Adjacency list of all highways from the file.
	 * @param type COST or ASPHALT for finding MST
	 */
	public MinimumHighwayFinder(AdjacencyList highways, String type) {
		hList = new ArrayBasedList<Highway>();
		aJList = new AdjacencyList(hList);
		
		UpTree ut = new UpTree();
		MinHighwayHeap mhh = new MinHighwayHeap(type);
		for(int i = 0; i < highways.ajList.size(); i++){
			Node n = highways.ajList.get(i);
			while(n != null){
				mhh.insert(n.h);
				n = n.next;
			}
		}
		for(int i = 0; i < highways.ajList.size(); i++){
			//UpNode un = ut.new UpNode(i);
			ut.makeSet(i);
		}
		while(ut.size > 1){
			Highway h = mhh.deleteMin();
			UpNode x = ut.find(h.city1);
			UpNode y = ut.find(h.city2);
			if(x.key != y.key){
				ut.union(x, y);
				aJList.addNode(h.city1, h.city2, h.cost, h.asphalt);
				hList.add(hList.size(), h);
			}
		}

	}


	/**
	 * Returns the MST
	 * @return the hList containing the MST
	 */
	public ArrayBasedList<Highway> getHList() {
		return hList;
	}

	
	/**
	 * Returns the MST
	 * @return the hList containing the MST
	 */
	public AdjacencyList getaJList() {
		return aJList;
	}
}