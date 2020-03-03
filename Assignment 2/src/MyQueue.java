public class MyQueue<T> implements QueueInterface<T>{

	private int size;
	private int itemSize;
	private int back;
	private int front;
	private T[] elements;

	public MyQueue(int size) {
		this.size = size;
		elements = (T[]) new Object[this.size];
		back = 0;
		front = 0;
		itemSize = -1;
	}
	
	public MyQueue() {
		this.size = 5;
		elements = (T[]) new Object[this.size];
		back = 0;
		front = 0;
		itemSize = -1;
	}
	
	@Override
	public boolean isEmpty() {
		if (elements[0] == null) {
		return true;
		}
		else
			return false;
		}
	

	@Override
	public boolean isFull() {
		if (elements[4] == null) {
		return false;
		}
		else
			return true;
	}

	@Override
	public boolean enqueue(T entry) {
		
		
		if(isFull())
		{
			return false;
		}
		else 
			elements[++itemSize]= entry;
		
		if(elements[itemSize] == null)
		{
			return false;
		}
		else
		return true;
	
	}
	
	@Override
	public T dequeue() {
		T dequeue;
		
		if(isEmpty())
		{
			throw new RuntimeException("Hey!! You've got an empty queue!!");
		}
		else {
		 dequeue = elements[0];
		 
		 for(int counter = 0; counter < itemSize; counter++) {
			 elements[counter] = elements[counter + 1];
		 }
		 
		 elements[itemSize] = null;
		itemSize--;
		return dequeue;
		}
		}
		

	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {
		return itemSize + 1;
	}

	

	@Override
	public T[] toArray() {
		return elements;
	}

}
