import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TownGraphManager implements TownGraphManagerInterface {

	private Graph townGraph = new Graph();
	
	public TownGraphManager()
	{
		this.townGraph = townGraph;
	}
	public ArrayList<String> allTowns() {
		
		ArrayList<String> outcome = new ArrayList();
		
		for(Town town1: townGraph.vertexSet())
		{
			outcome.add(town1.getName());
		}
		
		Collections.sort(outcome);
		
		return outcome;
	}

	public ArrayList<String> allRoads() {
		
		ArrayList<String> roadoutcome = new ArrayList();
		
		for(Road road1: townGraph.edgeSet())
		{
			roadoutcome.add(road1.getName());
		}
		
		Collections.sort(roadoutcome);
		
		return roadoutcome;
	}

	public Town getTown(String string) {
		
		for(Town t1 : townGraph.vertexSet())
		{
			if(t1.getName().equals(string))
				return t1;
		}
			
		
		return null;
	}

	public boolean addTown(String townName) {
		
		return townGraph.addVertex(new Town(townName));
	}

	public void populateTownGraph(File selectedFile) throws IOException, FileNotFoundException {
		String[] tokens;
		String currentLine;
		
		Scanner input = new Scanner(selectedFile);
		
		while(input.hasNextLine())
		{
			currentLine = input.nextLine();
			tokens = currentLine.split(";|,");
			townGraph.addEdge(new Town(tokens[2]), new Town(tokens[3]), Integer.parseInt(tokens[1]), tokens[0]);
		}//loop to read file
		
	}

	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadTitle) {
		try {	
			Town town = new Town(town1);
			Town destination = new Town(town2);
			
			townGraph.addEdge(town, destination, weight, roadTitle);
		} catch (Exception ex)
		{
			return false;
		}
		return true;
	}

	@Override
	public String getRoad(String start, String end) {
		
		return townGraph.getEdge(new Town(start),  new Town(end)).getName();
	}

	@Override
	public boolean containsTown(String v) {
		// TODO Auto-generated method stub
		return townGraph.containsVertex(new Town(v));
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		// TODO Auto-generated method stub
		return townGraph.containsEdge(new Town(town1), new Town(town2));
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {

		Town t1 = getTown(town1);
		Town t2 = getTown(town2);
		
		Road r = townGraph.getEdge(t1, t2);
		
		int degrees = r.getWeight();
		
		if(townGraph.removeEdge(new Town(town1), new Town(town2), 0, road)!= null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean deleteTown(String vertex) {
		
		return townGraph.removeVertex(new Town(vertex));
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {

		Town town = new Town(town1);
		Town destination = new Town(town2);
		
		return townGraph.shortestPath(town, destination);
	}

}
