/**
 * 
 */
package edu.ncsu.csc316.transportation_manager.highway;

/**
 * POJO of Highway
 * @author Dan Grochmal djgrochm
 *
 */
public class Highway {

	/** City 1 of a Highway */
	public int city1;
	/** City 2 of a Highway */
	public int city2;
	/** Cost of a Highway */
	public double cost;
	/** Asphalt of a Highway */
	public double asphalt;
	
	/**
	 * Constructs a Highway with the given information
	 * @param city1 city1 of the highway
	 * @param city2 city2 of the highway
	 * @param cost cost of building the highway
	 * @param asphalt amount (in miles) of asphalt needed to build the highway
	 */
	public Highway(int city1, int city2, double cost, double asphalt) {
	    this.city1 = city1;
	    this.city2 = city2;
	    this.cost = cost;
	    this.asphalt = asphalt;
	}
	
	/**
	 * Returns a string representation of the Highway
	 * in the format:
	 * 
	 * Highway[city1=X, city2=X, cost=X.X, asphalt=X.X]
	 * 
	 * @return the string representation of the highway
	 */
	@Override
	public String toString() {
		return "Highway[city1=" + city1 + ", city2=" + city2 + ", cost=" + cost + ", asphalt=" + asphalt + "]";
	} 

	/**
	 * Helper method for insertion sort of highways
	 * @param o highway to be compared
	 * @return int result of comparision
	 */
	public int compareTo(Highway o) {
		if (o.city1 > this.city1) {
			return 1;
		} else if ((o.city1 == this.city1) && o.city2 > this.city2) {
			return 1;
		} else {
			return 0;
		}
	}
	
}