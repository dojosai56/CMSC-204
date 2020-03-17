/**
 * Name: Sairam Soundararajan
 * Course: CMSC204
 * Instructor: Professor Robert Alexander
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> implements java.lang.Iterable<T>{
	Comparator<T> comparator;
	

	public SortedDoubleLinkedList(Comparator comparator) {
		super();
		this.comparator = comparator;
	}
	/**
	 * Adds a new element to the sorted list
	 * @param newElement
	 * @return
	 */
	public SortedDoubleLinkedList<T> add(T newElement) {
		if (newElement == null)
		{
			return this;
		}
		
		 Node temp = new Node();
		 temp.newElement = newElement;
		if(first == null) 
		{
			first = post = temp;
			Nodesize++;
			return this;
		}
		
		if(comparator.compare(first.newElement, newElement) > 0)
			{
				temp.next = first;
				first.previous = temp;
				first = temp;
				Nodesize++;
				return this;
			}
		if(comparator.compare(post.newElement, newElement) < 0)
			{
				post.next = temp;
				temp.previous = post;
				post = temp;
				Nodesize++;
				return this;
			}
			 Node curr = first.next;
			 //Node previous = first;
			 while(curr != null){
			 	if(comparator.compare(curr.newElement, newElement) > 0)
			{ 	
				temp.next = curr;
				curr.previous.next = temp;
				temp.previous = curr.previous;
				curr.previous = temp;
				Nodesize++;
				return this;
			 }
			 curr = curr.next;
			}
			 Nodesize++;
			 return this;
		}
		
			
		
	
	public BasicDoubleLinkedList<T> addToEnd(T newElement) throws java.lang.UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
		
	}

	public BasicDoubleLinkedList<T> addToFront(T newElement) throws java.lang.UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 
	 * implement iterator class
	 */
	@Override
	public ListIterator<T> iterator()
	{
		return super.iterator();
	}
	
	
	public SortedDoubleLinkedList<T> remove(T newElement, Comparator<T> comparator) {
		super.remove(newElement, comparator);
		return this;
		
	}

}
