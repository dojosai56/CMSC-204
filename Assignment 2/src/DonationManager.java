/**
 * 
 * @author Sairam Soundararajan
 *
 */
public class DonationManager implements DonationManageInterface{

	private Container container1;
	private VolunteerLine volunteer;
	private RecipientLine recipient;
	private Volunteer vclient;
	private Recipient rclient;
	/**
	 * Stacks a new donation package  in to the container
	 * @param dPackage Donation package that is stacked to the container
	 * Return true if the package is stacked, false if the container is full
	 * @throws ContainerException if container is full
	 */
	
	public DonationManager()
	{
		container1 = new Container();
		volunteer = new VolunteerLine();
		recipient = new RecipientLine();
	}
	
	/**
	 * Stacks a new donation package  in to the container
	 * @param dPackage Donation package that is stacked to the container
	 * Return true if the package is stacked, false if the container is full
	 * @return 
	 * @throws ContainerException if container is full
	 */
	public boolean managerLoadContainer(DonationPackage newPackage) throws ContainerException {
		boolean status;
		try { 
			status = container1.loadContainer(newPackage);
		}
		catch (ContainerException ce) {
			throw new ContainerException("Container is Full!");
		}
		return status;

		
	}

	/**
	 * Returns an array of DonationPackages
	 * @return an array of Donation Packages
	 */
	public Object[] managerArrayPackage() {
		
		return container1.toArrayPackage();
	}

	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully
	 * @throws VolunteerException("Volunteer Line is full") if the Volunteer Line queue is full
	 */
	public boolean managerQueueVolunteer(Volunteer newVolunteer) throws VolunteerException {
		boolean Vqueue;
		try {
			Vqueue = volunteer.addNewVolunteer(newVolunteer);
		}
		catch(VolunteerException ve) {
			throw new VolunteerException("Volunteer Line is full!");
		}
		return Vqueue;
		
	}

	/**
	 * Returns an array of Volunteers
	 * @return an array of Volunteers
	 */
	
	public Object[] managerArrayVolunteer() {
		
		return volunteer.toArrayVolunteer();
	}

	/**
	 * adds a new Recipient to the queue of the Recipient line
	 * @param rc a Recipient
	 * @return 
	 * @return true if recipient is queued successfully , false if queue is full
	 * @throws RecipientException("Recipient Line is full") if the Recipient line is full
	 */
	public boolean managerQueueRecipient(Recipient newRec) throws RecipientException {
		boolean recQueue;
		try {
			recQueue = recipient.addNewRecipient(newRec);
		}
		catch(RecipientException re) {
			throw new RecipientException("Recipient Line is full");
		}
		return recQueue;
		
	}

	/**
	 * Returns an array of Recipients
	 * @return an array of Recipients
	 */
	public Object[] managerArrayRecipient() {
		
		return recipient.toArrayRecipient();
	}

	/**
	 * Simulates donating a DonationPackage from the container stack by the volunteer from the volunteer queue line to the 
	 * recipients from the recipients queue line. As a result the package is removed from the container, volunteer will be dequeued
	 * from  volunteer line and QUEUED BACK to the volunteer line and recipient will be dequeued from the recipient line.
	 * @return 
	 * @throws VolunteerException("Volunteer Queue is empty") if there are no volunteers
	 * @throws ContainerExcpetion("Contain is empty") if the container is empty
	 * @throws RecipientException("Recipient Queue is empty") if there are no recipients
	 * 
	 */
	public int donatePackage() throws ContainerException, VolunteerException, RecipientException{
		
		try {
		container1.removePackageFromContainer();
		}
		catch(ContainerException ce)
		{
			throw new ContainerException("Container is Empty");
		}
		
			try {
			vclient = volunteer.volunteerTurn();
			} catch(VolunteerException volexp)
			{
				throw new VolunteerException("VolunteerLine is Empty");
			}
			try {
				volunteer.addNewVolunteer(vclient);
			} catch(VolunteerException volexp) {
				throw new VolunteerException("VolunteerLine is Full");
			}
			
		      try { recipient.recipientTurn();
		      }
		      catch(RecipientException re)
		      {
		    	  throw new RecipientException("RecipientLine is Empty");
		      
			}
			return 1;
		}

		
	
		
		
	}


