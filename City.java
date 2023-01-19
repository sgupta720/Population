/**
 *	City data - the city name, state name, location designation,
 *				and population est. 2017
 *
 *	@author	Sahil Gupta
 *	@since	Jan 10 2022
 */
public class City implements Comparable<City> {
	
	// fields
	String state;
	String name;
	int population;
	String designation;
	// constructor
	
	/**	Compare two cities populations
	 *	@param other		the other City to compare
	 *	@return				the following value:
	 *		If populations are different, then returns (this.population - other.population)
	 *		else if states are different, then returns (this.state - other.state)
	 *		else returns (this.name - other.name)
	 */
	
	/**	Equal city name and state name
	 *	@param other		the other City to compare
	 *	@return				true if city name and state name equal; false otherwise
	 */
	
	/**	Accessor methods */
	
	/**	toString */
	
	@Override
	public String toString() {
		return String.format("%-22s %-22s %-12s %,12d", state, name, designation,
						population);
	}

	@Override
	public int compareTo(City o) {
		if(this.population!=o.population)
		{
			return this.population-o.population;
		}
		else if(!this.state.equals(o.state))
		{
			return this.state.compareTo(o.state);
		}
		else
		{
			this.name.compareTo(o.name);
		}
		// TODO Auto-generated method stub
		return 0;
	}
	public boolean equals(City o)
	{
		if(name.equals(o.name)&&state.equals(o.state))
		{
			return true;
		}
		return false;
	}
	public void setter(City o)
	{
		population = o.population;
		state = o.state;
		designation = o.designation;
		name = o.name;
	}
	public City(String sta, String na, String type, int pop) {
		state = sta;
		name = na;
		population = pop;
		designation = type;
	}
}