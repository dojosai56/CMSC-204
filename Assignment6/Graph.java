import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road> {

	HashSet<Town> towns;
	HashSet<Road> streets;
	ArrayList<String> quickway = new ArrayList<String>();
	Set<Town> vacant;
	HashSet<Town> blocked;
	Map <Town, Integer> distances;
	Map <Town, ArrayList<String>> llTowns;
	
	public Graph()
	{
		this.towns = new HashSet<Town>();
		this.streets = new HashSet<Road>();
		this.blocked = new HashSet<Town>();
	}
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
	/**if(!(containsEdge(sourceVertex, destinationVertex)))
		{
			System.out.println("getEdge");
			return null;
		}**/
		System.out.println(streets);
		System.out.println(edgesOf(sourceVertex).size());
		for(Road road : edgesOf(sourceVertex))
		{
			System.out.println(road.getDestination());
			if(road.getDestination().equals(destinationVertex) && road.getSource().equals(sourceVertex))
			{
				System.out.println("first");
				return road;
			}
			else if(road.getDestination().equals(sourceVertex) && road.getSource().equals(destinationVertex))
			{
				System.out.println("second");
				return new Road(sourceVertex, destinationVertex, road.getWeight(), road.getName());
			}
		}
		
		return null;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int degrees, String info) {

		Road roadobject = new Road(sourceVertex, destinationVertex, degrees,info);
		towns.add(sourceVertex);
		towns.add(destinationVertex);
		streets.add(roadobject);
		sourceVertex.addRoad(roadobject);
		destinationVertex.addRoad(roadobject);
		return roadobject;
		
	}

	@Override
	public boolean addVertex(Town vertex) throws NullPointerException
	{
		if(vertex == null) 
		{
		throw new NullPointerException();
		}
		else if(towns.contains(vertex))
		{
			return false;
		}
		else
		{
			towns.add(vertex);
		}
		return true;
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {

		if(!(containsVertex(sourceVertex)) || (!containsVertex(destinationVertex)))
		{
			return false;
		}
		
		for(Road road: edgesOf(sourceVertex))
		{
			if(road.getDestination().equals(destinationVertex))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsVertex(Town vertex) {

		Town data = vertex;
		
		if(towns.contains(data))
			return true;
		else
			return false;
	}

	@Override
	public Set<Road> edgeSet() {
		// TODO Auto-generated method stub
		return streets;
	}

	@Override
	public Set<Road> edgesOf(Town v) {

		HashSet<Road> adjacencies = new HashSet<Road>();
		for(Road r : streets)
		{
			if(r.contains(v))
			{
				adjacencies.add(r);
			}
		}
		return adjacencies;
		
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int degrees, String info) {
		// TODO Auto-generated method stub
		
		Road streetdata = new Road(sourceVertex, destinationVertex, degrees, info);
		
		System.out.println(streets.contains(streetdata));
		System.out.println(streets.remove(streetdata));
		return streetdata;
	}

	@Override
	public boolean removeVertex(Town vertex) {
		
		return towns.remove(vertex);
	}

	@Override
	public Set<Town> vertexSet() {
		// TODO Auto-generated method stub
		return towns;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) 
	
	{
		dijkstraShortestPath(sourceVertex);
		
		if(distances.get(destinationVertex) == -1) {
			return new ArrayList<String>();
		}
		
		return llTowns.get(destinationVertex);
	}

	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		Map <Town, Boolean> visitedTowns;  
		final int INFINITY = -1;
		Tuple currentVertex;
		int newdistance;
		PriorityQueue <Tuple> queue = new PriorityQueue<Tuple>();
		Set <Road> adjTowns;
		distances = new HashMap <Town, Integer>();
		visitedTowns = new HashMap <Town, Boolean>();
		llTowns = new HashMap <Town, ArrayList<String>>();
		Town tempTown, tempTown2;
		
		
		
		for(Town town: towns)
		{
			visitedTowns.put(town, false);
			distances.put(town, INFINITY);
		}
		distances.put(sourceVertex, 0);
		queue.add(new Tuple(sourceVertex, 0));
		//llTowns.put(sourceVertex, new ArrayList<String>());
		//llTowns.get(sourceVertex).add(sourceVertex.getName());
		
		System.out.println(llTowns.get(sourceVertex));
		while(!(queue.isEmpty()))
		{
			currentVertex = queue.poll();
			System.out.println(queue);
			visitedTowns.replace(currentVertex.vertex, true);
			System.out.println(currentVertex.vertex + "," + currentVertex.distanceValue);
			adjTowns = edgesOf(currentVertex.vertex);
			System.out.println(adjTowns);
			for(Road road: adjTowns)
			{
				if(currentVertex.vertex.equals(road.getDestination()))
				{
					tempTown = road.getSource();
					tempTown2 = road.getDestination();
				}
				else
				{
					tempTown = road.getDestination();
					tempTown2 = road.getSource();
				}
					System.out.println(tempTown);
				if(visitedTowns.get(tempTown) == true)
				{
					continue;
				}
				
				newdistance = distances.get(currentVertex.vertex) + road.getWeight();
				
				//System.out.println(newdistance);
				
				if(newdistance < distances.get(tempTown) || distances.get(tempTown) == INFINITY)
				{
					distances.replace(tempTown, newdistance);
					//System.out.println(llTowns.get(currentVertex));
					queue.add(new Tuple(tempTown, newdistance));
					if(llTowns.get(currentVertex.vertex) == null)
					{
						llTowns.put(tempTown, new ArrayList<String>());
						llTowns.get(tempTown).add(road.toString2(tempTown2,tempTown));
					}
					else
					{
						llTowns.put(tempTown, new ArrayList<String>(llTowns.get(currentVertex.vertex)));
						llTowns.get(tempTown).add(road.toString2(tempTown2,tempTown));
					}
					
					System.out.println(newdistance);
				}
			}
		}
		System.out.println(distances);
		
		
	}
	
	public static void main(String[] args)
	{
		Graph graph = new Graph();
		Town town1 = new Town("0");
		Town town2 = new Town("1");
		Town town3 = new Town("2");
		Town town4 = new Town("3");
		Town town5 = new Town("4");
		
		graph.addVertex(town1);
		graph.addVertex(town2);
		graph.addVertex(town3);
		graph.addVertex(town4);
		graph.addVertex(town5);
		graph.addEdge(town1, town2, 4, "Town 0 to Town 1");
		graph.addEdge(town3, town2, 2, "Town 1 to Town 2");
		graph.addEdge(town3, town4, 5, "Town 2 to Town 3");
		graph.addEdge(town4, town5, 3, "Town 3 to Town 4");
		graph.addEdge(town1, town3, 1, "Town 0 to Town 2");
		graph.addEdge(town2, town4, 1, "Town 1 to Town 3");
		
		graph.dijkstraShortestPath(town1);
		System.out.println(graph.shortestPath(town1, town2));
		
	}

}

	class Tuple implements Comparable<Tuple>
	{
		Town vertex;
		int distanceValue;
		
		Tuple(Town vertex, int distance)
		{
			this.vertex = vertex;
			this.distanceValue = distance;
		}

		@Override
		public int compareTo(Tuple arg0) {
				return Integer.valueOf(distanceValue).compareTo(Integer.valueOf(arg0.distanceValue));
		}
		
		public String toString()
		{
			return vertex + " , " + distanceValue;
		}
	}