
public class RecipientLine implements RecipientLineInterface{

	private int size;
	private boolean isEmpty;
	MyQueue myqueue;
	Recipient recipient;
	/**
	 * Provide two constructors:
	 * RecipientLine(int size) make internal queue this size
	 * RecipientLine() make internal queue default size
	 */
	
	public RecipientLine(int size) {
		this.size = size;
		myqueue = new MyQueue(this.size);
	}
	public RecipientLine() {
		this.size = 0;
		myqueue = new MyQueue(5);
	}

	
	/* * Enqueue a new Recipient to the queue of the Recipients in the Recipient line
	 * @param rc a Recipient
	 *return true if recipient is queued successfully
	 * @throws RecipientException("The Recipent Queue is Full") if queue is full
	 */
	public boolean addNewRecipient(Recipient r1) throws RecipientException {
		
		
		if(myqueue == null)
		{
			int x = 0;
		}
		
		if (myqueue.isFull())
		{

		    throw new RecipientException("The Recipent Queue is Full");
		}  
		
		else
		
			return myqueue.enqueue(r1);
		
		
	}

	/**
	 * When it is the recipient turn, recipient will be dequeued from the recipient line
	 * @return a Recipient object
	 * @throws RecipientException("The Recipient Queue is empty") if there is no Recipient in the line
	 */
	public Recipient recipientTurn() throws RecipientException {
		
		if(myqueue.isEmpty())
		{
			throw new RecipientException("The Recipient Queue is empty");
		}
		
			return (Recipient) myqueue.dequeue();
		
	}

	/**
	 * check if Recipient  queue line is empty
	 * @return true if queue is empty, false otherwise
	 */
	@Override
	public boolean recipientLineEmpty() { 
		
		if(myqueue.isEmpty())
			return true;
		else
			return false;
	}

	/**
	 * Returns an array of the Recipients in the queue.  
	 * Because of type erasure by the JVM at run-time, the array of type T that the generic queue
	 * returns from the call to queue.toArray() is an array of type Object, i.e., Object[] temp. 
	 * But since the individual elements of the array are still Recipients, we can copy them one 
	 * by one into a new array	of type Recipient and cast each one to Recipient. 
	 * So create a new array of Recipients of the same length as temp, run a for-loop that casts each element 
	 * of temp to Recipient and copies it to the corresponding position in the new array.  Then return the new array.
	 * @return an array of the Recipients in the queue
	 */
	@Override
	public Recipient[] toArrayRecipient() {
		
		Object[] outcome = new Object[myqueue.size()];
		outcome = myqueue.toArray();
		Recipient[] recp = new Recipient[myqueue.size()];
		
		for(int counter = 0; counter < myqueue.size(); counter++)
		{
			recp[counter] = (Recipient) outcome[counter];
			
		}
		return recp;
	}

}
