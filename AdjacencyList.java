/**
 * 
 */
package edu.ncsu.csc316.transportation_manager.list;

import edu.ncsu.csc316.transportation_manager.highway.Highway;

/**
 * Adjacency List to represent a graph
 * @author Dan Grochmal djgrochm
 *
 */
public class AdjacencyList {

	/**List of nodes that represents AdjacencyList */
	public ArrayBasedList<Node> ajList;
	/**Amount of vertexes in a graph */
	public int count = 0;
	
	/**
	 * Constructor of adjacency list
	 * @param l HighwayList for the adjacency list to be built from
	 */
	public AdjacencyList(ArrayBasedList<Highway> l) {
		ajList = new ArrayBasedList<Node>();
		for(int i = 0; i < l.size(); i++){
			addNode(l.get(i).city1, l.get(i).city2, l.get(i).cost, l.get(i).asphalt);
		}
	}
	
	/**
	 * Adds a node to AdjacencyList
	 * @param aKey City1 of node to be added
	 * @param key City2 of node to be added
	 * @param cost Cost of node to be added
	 * @param asphalt Asphalt of node to be adder
	 */
	public void addNode(int aKey, int key, double cost, double asphalt){
		Node n = null;
		Highway h = null;
		if(ajList.get(aKey) == null){
			h = new Highway(aKey, key, cost, asphalt);
			n = new Node(h);
			ajList.addIP(aKey, n);
		} else {
			Node x = findNull(ajList.get(aKey));
			h = new Highway(aKey, key, cost, asphalt);
			n = new Node(h);
			x.next = n;
			x.count++;
		}
		if(ajList.get(key) == null){
			h = new Highway(aKey, key, cost, asphalt);
			n = new Node(h);
			ajList.addIP(key, n);
		} else {
			Node x = findNull(ajList.get(key));
			h = new Highway(aKey, key, cost, asphalt);
			n = new Node(h);
			x.next = n;
			x.count++;
		}
	}
	
	private Node findNull(Node n){
		if(n.next == null){
			return n;
		} else {
			return findNull(n.next);
		}
	}
	
	/**
	 * Node for use in AdjacencyList
	 * @author Dan Grochmal djgrochm
	 *
	 */
	public class Node {
		
		/**Highway contained within a node */
		public Highway h;
		/**The node connected to the current node */
		public Node next;
		/**Amount of Nodes on a certain level */
		public int count;
		
		
		/**
		 * Constructor of node object
		 * @param h Highway to be contained in Node
		 */
		public Node(Highway h){
			this.h = h;
			this.next = null;
		}
		
		/**
		 * Discerns if a Node has a next object
		 * @return if a node has a next object
		 */
		public boolean hasNext(){
			return (this.next != null);
		}
		
	}

}