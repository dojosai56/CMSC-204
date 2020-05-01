
public class Road implements Comparable<Road>
{

	private Town town;
	private Town destination;
	private int degrees;
	private String name;

	public Road(Town town, Town destination, int degrees, String name) 
	{
		this.town = town;
		this.destination = destination;
		this.degrees = degrees;
		this.name = name;
	}
	
	public Road(Town town, Town destination, String name) 
	{
		this.town = town;
		this.destination = destination;
		this.name = name;
	}
	
	public boolean contains(Town town1) 
	{
		if (town.equals(town1) || destination.equals(town1))
		{
			return true;
		}
		else
			return false;
	}
	
	public boolean equals(Object obj) 
	{
		Road road = (Road) obj;
		boolean outcome;
		
		if((road == null))
		{
			return false;
		}
		else 
		{
			outcome = name.equals(road.name) && destination.equals(road.destination);
		}
		
		return outcome;
		
	}
	
	public int hashCode()
	{
		return name.hashCode();
	}
	
	public Town getDestination() 
	{
		return destination;
	}
	
	public String getName() 
	{	
		return name;
	}
	
	public Town getSource() 
	{
		return town;
	}
	
	public int getWeight() 
	{
		return degrees;
	}
	
	public String toString() 
	{
		return town.getName() + " via " + name + " to " + destination.getName() + " " + degrees + " mi";
	}
	
	public String toString2(Town src, Town dest) {
		return src.getName() + " via " + name + " to " + dest.getName() + " " + degrees + " mi";
	}

	public int compareTo(Road object) 
	{
		
		Road r = (Road) object;
		
		return this.name.compareTo(r.getName());
	}
	
	

}
