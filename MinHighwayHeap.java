/**
 * 
 */
package edu.ncsu.csc316.transportation_manager.heap;

import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.list.ArrayBasedList;

/**
 * 
 * MinHeap of Highways
 * @author Dan Grochmal djgrochm
 *
 */
public class MinHighwayHeap {

	/**Heap of Highways represented as an Array */
	public ArrayBasedList<Highway> heap = new ArrayBasedList<Highway>();
	/** Type of Heap, COST or ASPHALT */
	public String type;
	
	/**
	* Constructs a new Highway heap
	* 
	* @param type the type of weight to consider ("COST" or "ASPHALT") when
	*         operating on the heap
	*/
	public MinHighwayHeap(String type) {
		heap = new ArrayBasedList<Highway>();
		this.type = type;
		if(!type.equals("COST") && !type.equals("ASPHALT")){
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Inserts the given Highway into the minheap
	 * @param h the Highway to insert into the minheap
	 */
	public void insert(Highway h){
		boolean check = true;
		for(int i = 0; i < heap.size(); i++){
			if((heap.get(i).cost == h.cost) && (heap.get(i).asphalt == h.asphalt)){
				check = false;
			}
		}
		if(check){
			heap.add(heap.size(), h);
			upHeap(heap.size() - 1);
		}
	}
	
	/**
	 * Shifts nodes up from the bottom
	 * @param i index where to start
	 */
	public void upHeap(int i) {
		if(type.equals("COST")){
			if((i > 0) && (heap.get((i - 1) / 2).cost > heap.get(i).cost)){
				swap((i - 1) / 2, i);
				upHeap((i - 1) / 2);
			}
		} else {
			if((i > 0) && (heap.get((i - 1) / 2).asphalt > heap.get(i).asphalt)){
				swap((i - 1) / 2, i);
				upHeap((i - 1) / 2);
			}
		}
	}
	
	/**
	 * Swaps two elements
	 * @param i first index to switch
	 * @param i2 second index to switch
	 */
	private void swap(int i, int i2) {
		Highway t = heap.get(i);
		heap.set(i, heap.get(i2));
		heap.set(i2, t);
	}

	
	/**
	 * Returns the Highway with minimum weight in the minheap
	 * @return the Highway with minimum weight in the minheap
	 */
	public Highway deleteMin(){
		if(heap.size() > 1) {
			Highway min = heap.remove(0);
		    Highway h = heap.remove(heap.size() - 1);
		    heap.add(0, h);
			downHeap(0);
			return min;
		}
		return heap.get(0);
	}
	
	/**
	 * Shifts elements down for the top
	 * @param m index where to start
	 */
	public void downHeap(int m){
		int i = 0;
		if(type.equals("COST")){
			if((2 * m) + 2 < heap.size()){
				if(heap.get((2 * m) + 2).cost <= heap.get((2 * m) + 1).cost){
					i = (2 * m) + 2;
				} else {
					i = (2 * m) + 1;
				}
			} else if ((2 * m) + 1 < heap.size()){
				i = (2 * m) + 1;
			}
			if (i > 0 && heap.get(m).cost > heap.get(i).cost){
				swap(m, i);
				downHeap(i);
			}
		} else {
			if((2 * m) + 2 < heap.size()){
				if(heap.get((2 * m) + 2).asphalt <= heap.get((2 * m) + 1).asphalt){
					i = (2 * m) + 2;
				} else {
					i = (2 * m) + 1;
				}
			} else if ((2 * m) + 1 < heap.size()){
				i = (2 * m) + 1;
			}
			if (i > 0 && heap.get(m).asphalt > heap.get(i).asphalt){
				swap(m, i);
				downHeap(i);
			}
		}
		
	}
	
	/**
	 * Returns a string representation of the level-order traversal 
	 * of the heap in the following format:
	 * 
	 * Heap[
	 *    Highway[city1=X, city2=X, cost=X.X, asphalt=X.X],
	 *    Highway[city1=X, city2=X, cost=X.X, asphalt=X.X],
	 *    Highway[city1=X, city2=X, cost=X.X, asphalt=X.X]
	 * ]
	 *
	 * @return the string representation of the minheap
	 */
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		Highway h;
		sb.append("Heap[\n");
	    for(int i = 0; i < heap.size(); i++){
	    	h = heap.get(i);
	    	sb.append("   ").append(h.toString()).append(",\n");
	    }
	    String sub = sb.substring(0, sb.length() - 2);
	    sb = new StringBuilder();
	    sb.append(sub).append("\n]");
	    return sb.toString();
	}
}