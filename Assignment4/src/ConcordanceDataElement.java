import java.util.LinkedList;
/**
 * 
 * @author Sairam Soundararajan
 * Date: 4-01-2020
 * Course: Computer Science II
 */
public class ConcordanceDataElement implements java.lang.Comparable<ConcordanceDataElement>{
	
	private String name;
	private LinkedList<Integer> pgNumberlist;
	
	/**
	 * 
	 * @param word
	 */
	public ConcordanceDataElement(java.lang.String word)
	{
		this.name = word;
		pgNumberlist = new LinkedList<>();
	}
	/**
	 * 
	 * @param lineNumber
	 */
	public void addPage(int lineNumber)
	{
		if(!pgNumberlist.contains(lineNumber))
			pgNumberlist.add(lineNumber);
	}

	/**
	 * @param arg0
	 */
	@Override
	public int compareTo(ConcordanceDataElement arg0) 
	{
		return name.compareTo(arg0.getWord());
	}
	
	/**
	 * 
	 * @return page number list
	 */
	public java.util.LinkedList<Integer> getList()
	{
		return pgNumberlist; // change null eventually
	}
	
	/**
	 * 
	 * @returns name
	 */
	public java.lang.String	getWord()
	{
		return name;
		
	}
	
	/**
	 * returns name in hashcode 
	 */
	public int	hashCode()
	{
		return name.hashCode();
		
	}
	
	/**
	 * @returns string
	 */
	public  java.lang.String toString()
	{
		String space = " ";
		space = name + ": ";
		String comma = ", ";
		
		for(int counter = 0; counter < pgNumberlist.size(); counter++)
		{
			if(counter < pgNumberlist.size() - 1)
				space += pgNumberlist.get(counter) + comma;
			else
				space += pgNumberlist.get(counter);
		}
		return space;
	} 
}
