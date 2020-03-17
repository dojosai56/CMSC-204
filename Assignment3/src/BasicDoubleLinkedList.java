/**
 * Name: Sairam Soundararajan
 * Course: CMSC204
 * Instructor: Professor Robert Alexander
 */
import java.util.ArrayList; 
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import java.util.Iterator;

public class BasicDoubleLinkedList<T> extends java.lang.Object implements java.lang.Iterable<T>{
	
	protected int Nodesize; // the amount of nodes on the list
	protected Node first;  // the sentinel before the first item
	protected Node post; // the sentinal after the final item
	
	class Node {
		
		public Node ()
		{
			this.newElement = newElement;
			next = null;
			previous = null;
		}
		
		protected T newElement; // variable to represent the data element
		protected Node next; // variable to represent the next element
		protected Node previous; // variable to represent the previous element
		
		
	}
	
	
	public BasicDoubleLinkedList() {
	
	// Both nodes initialized to default value
		
	this.first = null;
	this.post = null;
	
	// size of node list initialized to default value
	this.Nodesize = 0;
	}
	
	/**
	 * detects whether the linked list is empty or not
	 * returns a boolean value
	 */
	public boolean isEmpty()
	{
		return Nodesize == 0; // pre == post
	}
	/**
	 * 
	 * Return the size of Node list
	 */
	public int getSize() {
		// TODO Auto-generated method stub
		return Nodesize;
	}
	/**
	 * 
	 * @param newElement
	 * Adds an element to the front
	 */
	public BasicDoubleLinkedList<T> addToFront(T newElement) {
		Node newFirst = new Node(); 
		newFirst.newElement = newElement;
		
		if (first == null)
		{
			post = newFirst;
		}
		else 
		{
			newFirst.next = first;
			first.previous = newFirst;
		}
		first = newFirst; 
		Nodesize++;
		return this; 
	}

	/**
	 * 
	 * @param newElement
	 * Adds an element to the end of the linked list
	 */
	public BasicDoubleLinkedList<T> addToEnd(T newElement) {
		Node newPost = new Node();
		newPost.newElement = newElement;
		
		if(first == null)
		{
			first = newPost;
		}
		else 
		{
			post.next = newPost;
		}
		newPost.previous = post;
		post = newPost;
		Nodesize++;
		return this;
	}
	/**
	 * 
	 * Will retrieve the first element of the linked list
	 */
	public T retrieveFirstElement() {
		/**if(Nodesize == 0)
		{
			return null;
		}**/
		/**try {
		first.previous = null;
		} catch(NullPointerException ex)
	{
			ex.getMessage();
		}**/
		
		
		Node temp = first;
		first = first.next;
		Nodesize--;
		return temp.newElement;
	}

	/**
	 * 
	 * Will retrieve the last element of the linked list
	 */
	public T retrieveLastElement() {

//		if (Nodesize == 0) 
//		{
//			return null;
//		} 
		
		Node temp = post;
		post = post.previous;
//		try
//		{
//			post.next = null;
//		} catch(NullPointerException ex)
//		{
//			ex.getMessage();
//		}
			Nodesize--;
			return temp.newElement;
	}
	
	
	/**
	 * 
	 * @param element
	 * @param comparator
	 * Will remove an element from the last
	 */
	public BasicDoubleLinkedList<T> remove(T element, Comparator<T> comparator)
	{
		Node present = first;
		//present.newElement = element;
		while (present != null)
		{
			if(comparator.compare(present.newElement, element) == 0)
			{
				if(present == first)
				{
					first = first.next;
					first.previous = null;
				
				}
				else if(present == post)
				{
					post = post.previous;
					post.next = null;
					
				}
				else
				{
					present.previous.next = present.next;
					present.next.previous = present.previous;
				
				}
				Nodesize--;
			}
			present = present.next;
				
		}
		return this;
	}
	/**
	 * 
	 * Will return the last element of the linked list
	 */
	public T getLast() {

		return post.newElement;
	}
	/**
	 * 
	 * Will return the last element of the linked list
	 */
	public T getFirst() {
		return first.newElement;
	}
	
	/**
	 * 
	 * implement iterator class
	 */
	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException
	{
		return (ListIterator<T>) new BasicIteratorList();	
	}
	/**
	 * Iterator class that traverses a collection of elements
	 * @author sairam
	 *
	 */
	class BasicIteratorList implements ListIterator<T>{
		
		int nextCount; // counter variable
		Node present = first; // variable to represent current node
		Node lastTraversed = post; // variable to represent last accessed node
		
		public BasicIteratorList() {
			present.newElement = getFirst();
		}
		
		
		/**
		 * Will detect if there is an element after the current one, throws an exception on the last element
		 */
		@Override
		public boolean hasNext() {
			if(present == null) 
				throw new NoSuchElementException("There are no more elements!");
			else
				return true;
		}
		/**
		 * Will move to the next element
		 */
		@Override
		public T next() {
			
			if(hasNext())
			{
				T dataElement = present.newElement;
				present = present.next;
				return dataElement;
			}
			return null;
		}
		
		/**
		 * Will detect if there is an element behind the current element, throws an exception on the first element
		 */
		public boolean hasPrevious() {
			if(lastTraversed == null)
			{
				throw new NoSuchElementException("This is the beginning of the list");
			}
			else
				return true;
		}
		
		/**
		 * will go back to previo0us element
		 */
		public T previous() {
			if(hasPrevious()) {
				T dataElement = lastTraversed.newElement;
				lastTraversed = lastTraversed.previous;
				return dataElement;
			}
			return null;
		}
		
		
		public int nextIndex() {

			throw new UnsupportedOperationException();
		}

		
		public int previousIndex() {

			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() {

			throw new UnsupportedOperationException();
		}

		public void set(T element) {

			throw new UnsupportedOperationException();
			
		}

		public void add(T e) {

			throw new UnsupportedOperationException();
			
		}

	}

	/**
	 * 
	 * Returns an array of elements inputted
	 */
	public ArrayList<T> toArrayList() {

		ArrayList<T> finalList = new ArrayList<T>();
		Node presentNode = first;
		
		while(presentNode != null)
			{
			finalList.add(presentNode.newElement);
			presentNode = presentNode.next;
			}
		return finalList;
	}		
	}
