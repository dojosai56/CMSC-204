
public class VolunteerLine implements VolunteerLineInterface{

	int size;
	private boolean isEmpty;
	private MyQueue myqueue; 
	Volunteer volunteer;
	VolunteerLine vline;
	
	public VolunteerLine(int size) {
		this.size = size;
		myqueue = new MyQueue(this.size);
	}
	
	public VolunteerLine() {
		this.size = 0;
		myqueue = new MyQueue(5);
		
	}

	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully
	 * @throws VolunteerException("Volunteer Queue is full") is queue is full
	 */
	public boolean addNewVolunteer(Volunteer v1) throws VolunteerException {
		if(myqueue == null)
		{
			int x = 0;
		}
		
		if (myqueue.isFull())
		{

		    throw new VolunteerException("The Recipent Queue is Full");
		}  
		
		else
		
			return myqueue.enqueue(v1);
	}

	/**
	 * removes volunteer from the volunteer queue line
	 * @return Volunteer Object
	 * @throws VolunteerException("Volunteer queue is empty") if queue is empty
	 */
	@Override
	public Volunteer volunteerTurn() throws VolunteerException {
		if(volunteer == null) //queue.isEmpty
		{
			throw new VolunteerException("Volunteer queue is empty");
		}
		else
			return (Volunteer) myqueue.dequeue();
		
	}

	/**
	 * checks if there are volunteers in line 
	 * @return true if volunteer line is empty, false otherwise
	 */
	@Override
	public boolean volunteerLineEmpty() {
		if(myqueue.isEmpty())
			return true;
		else
			return false;
	}

	@Override
	public Volunteer[] toArrayVolunteer() {
		
		Object[] outcome = new Object[myqueue.size()];
		outcome = myqueue.toArray();
		Volunteer[] volnt = new Volunteer[myqueue.size()];
		
		for(int counter = 0; counter < myqueue.size(); counter++)
		{
			volnt[counter] = (Volunteer) outcome[counter];
			
		}
		return volnt;
	}
	
	}


