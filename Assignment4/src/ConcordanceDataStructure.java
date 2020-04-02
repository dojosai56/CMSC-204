
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.List;
/**
 * 
 * @author Sairam Soundararajan
 * Date: 4-01-2020
 * Course: Computer Science II
 */
public class ConcordanceDataStructure extends java.lang.Object implements ConcordanceDataStructureInterface{
	
	private LinkedList[] events;
	private int size; // size for table
	private double factor = 1.5;
	private int numberPrime;
	
	/**
	 * Constructor that takes in an integer which 
	 * represents the estimated number of words in the text
	 * @param number
	 */
	public ConcordanceDataStructure(int number) 
	{
		int quotient = (int) Math.round(number / 1.5);
		// find 4K + 3 that is prime and greater than quotient
		int k = 1;
		//System.out.println("q " + quotient);
		size = 3;
		while(!isPrime(size) || size <= quotient) {
			//System.out.println(4 * k + 3);
			size = 4 * k + 3;
			
			k++;
			
		}
		
		this.events = new LinkedList[size];
	}
	/**
	 * 
	 * @param num
	 * @returns whether number is prime or not
	 */
	private boolean isPrime(int num) {
		for(int counter = 2; counter < num; counter++) {
			if(num % counter == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Constructor solely for testing purposes
	 * @param test
	 * @param size
	 */
	public ConcordanceDataStructure(String test, int size) 
	{
		this.size = size;
		
		this.events = new LinkedList[size];
	}
	
	/**
	 * Returns the size of the ConcordanceDataStructure 
	 * (number of indexes in the array)
	 */
	@Override
	public int getTableSize() 
	{
		return this.size;
	}

	/**
	 * If the word does not exist in the hashtable - Add the ConcordanceDataElement to the hashtable. 
	 * Puts the line number in the linked list if the word already exists in the hashtable 1. 
	 * Adds the line number to the end of the linked list in the ConcordanceDataElement (if the line number is not currently there)
	 */
	@Override
	public void add(String word, int lineNumber) 
	{
		ConcordanceDataElement data = new ConcordanceDataElement(word);
		boolean outcome = false;
		int i;
		
		i = Math.abs(data.hashCode() % size);
		
		if(events[i] != null)
		{
			for(int counter = 0; counter < events[i].size(); counter++)
			{
				if(((ConcordanceDataElement) events[i].get(counter)).compareTo(data) == 0)
				{
					((ConcordanceDataElement) events[i].get(counter)).addPage(lineNumber);
					outcome = true;
				}
			}
		}
		else
		{
			LinkedList<ConcordanceDataElement> linkedlist = new LinkedList<ConcordanceDataElement>();
			linkedlist.add(data);
			events[i] = linkedlist;
			((ConcordanceDataElement) events[i].getFirst()).addPage(lineNumber);
			outcome = true;
		}
		if(outcome == false)
		{
			events[i].add(data);
			((ConcordanceDataElement) events[i].getLast()).addPage(lineNumber);
		}
		
		
	}

	/**
	 * Display the words in Alphabetical Order followed by a :, 
	 * followed by the line numbers in numerical order, 
	 * followed by a newline here's an example: after: 129, 175 agree: 185 agreed: 37 all: 24, 93, 112, 175, 203 always: 90, 128
	 */
	@Override
	public ArrayList<String> showAll() 
	{
		ArrayList<String> arraylist = new ArrayList<String>();
		ArrayList<ConcordanceDataElement> dataelements = new ArrayList<ConcordanceDataElement>();
		
		for(int counter = 0; counter < events.length; counter++)
		{
			if(events[counter] != null)
			{
				LinkedList<ConcordanceDataElement> current = events[counter];
				for(ConcordanceDataElement element : current)
				{
					dataelements.add(element);
				}
			}
		}
		Collections.sort(dataelements);
		
		for(ConcordanceDataElement data : dataelements)
		{
			arraylist.add(data.toString() + "\n");
		}
		return arraylist;
	}
	/**
	 * Returns an ArrayList of the words at this index [0] of the ArrayList holds the first word in the "bucket" (index)
	 * [1] of the ArrayList holds the next word in the "bucket"
	 *  
	 */
	@Override
	public ArrayList<String> getWords(int i) 
	{
		ArrayList<String> wordlist = new ArrayList<String>();
		
			
		for(int count = 0; count < events[i].size(); count++)
		{
			wordlist.add(((ConcordanceDataElement) events[i].get(count)).getWord());
		}
		return wordlist;
	}

	/**
	 * Returns an ArrayList of the Linked list of page numbers for each word 
	 * at this index [0] of the ArrayList holds the LinkedList of page numbers for the first word 
	 * in the "bucket" (index) [1] of the ArrayList holds the LinkedList of page numbers for next word in the "bucket", etc.
	 */
	@Override
	public ArrayList<LinkedList<Integer>> getPageNumbers(int i) 
	{
		ArrayList<LinkedList<Integer>> numberofPages = new ArrayList<LinkedList<Integer>>();
		
		//System.out.println("LinkedList size: " + events[i].size());
		for(int counter = 0; counter < events[i].size(); counter++)
		{
			//System.out.println(counter);
			numberofPages.add(((ConcordanceDataElement) events[i].get(counter)).getList());
		}
		
		System.out.println("numberofPages: " + numberofPages.get(0).size());
		return numberofPages;
	}
	
	//Main method testing
	public static void main(String [] args) {
		System.out.println("Main method");
		ConcordanceDataStructure s = new ConcordanceDataStructure(500);
		System.out.println("Constructor called");
		System.out.println("Table size: " + s.getTableSize());
	}// main
}
