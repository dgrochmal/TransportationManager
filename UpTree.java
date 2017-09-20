/**
 * 
 */
package edu.ncsu.csc316.transportation_manager.set;

import edu.ncsu.csc316.transportation_manager.list.ArrayBasedList;

/**
 * UpTrees (Disjoint sets to aid in Kruskal's algorithm)
 * 
 * @author Dan Grochmal djgrochm
 *
 */
public class UpTree {

	/** List of UpNodes that are the root of each UpTree */
	public ArrayBasedList<UpNode> tree;
	/** size of the UpTree */
	public int size;
	
	/**
	 * Constructor of UpTree object
	 */
	public UpTree() {
		tree = new ArrayBasedList<UpNode>();
	}
	
	/**
	 * Makes an individual UpTree
	 * @param k Node to become the root
	 * @return The root
	 */
	public UpNode makeSet(int k){
		UpNode n = new UpNode(k);
		tree.add(k, n);
		size++;
		return n;
	}
	
	
	/**
	 * Find the root of any node
	 * @param i Node of which we want to find the root
	 * @return The root that is found
	 */
	public UpNode find(int i){
		UpNode p = tree.get(i);
		while (p.parent != null){
			p = p.parent;
		}
		return p;
	}
	
	/**
	 * Unions two UpTrees together
	 * @param s First UpTree
	 * @param t Second Uptree
	 * @return Resulting root
	 */
	public UpNode union(UpNode s, UpNode t){
		t.parent = s;
		size--;
		return s;
	}
	
	
	/**
	 * Node object for use in UpTree
	 * @author Dan Grochmal
	 *
	 */
	public class UpNode {
		
		/** Identifier of a Node */
		public int key;
		/** The parent of a current node */
		public UpNode parent;
		
		
		/**
		 * Constructor of UpNode
		 * @param key identifier of Node
		 */
		public UpNode(int key){
			this.key = key;
			parent = null;
		}
	}

}
