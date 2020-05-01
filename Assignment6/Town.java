import java.util.ArrayList;

public class Town implements Comparable<Town>{

	private String name;
	private Town templateTown;
	private ArrayList<Road> roadset;
	
	public Town(String name) {
		this.name = name;
		roadset = new ArrayList<Road>();
	}
	
	public Town(String name, ArrayList<Road> roadset)
	{
		this.name = name;
		this.roadset = roadset;
	}
	public Town(Town templateTown)
	{
		this.templateTown = templateTown;
	}
	
	/**public boolean equals(Town town) {
		if(this.name.equals(town.name))
		{
		return true;
		}
		else
		{
			return false;
		}
		}
	**/
	
	public boolean equals(Object obj)
	{
		Town t = (Town) obj;
		return this.name.equals(t.name);
		
	}
	public void setRoadSet(ArrayList<Road> roadset)
	{
		this.roadset = roadset;
	}
	
	public int hashCode() {
		return name.hashCode();
		}
	
	public ArrayList<Road> getRoadSet()
	{
		return roadset;
	}
	
	public String getName() {
		
		return name;
	}
	
	public String toString()
	{
		return name;
		}

	public int compareTo(Town object) {

		if(name.equals(object.name))
		{
			return 1;
		}
		else
			return 0;
		
		
		
	}

	public void addRoad(Road roadobject) {
		// TODO Auto-generated method stub
		roadset.add(roadobject);
	}


}
