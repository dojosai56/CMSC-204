
import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

 
/**
 * @author khandan Monshi, revised by Professor Kartchner
 *
 */
public class DonationManagerSTUDENTTest {
	DonationManager manager;

	@Before
	public void setUp() throws Exception {
	 
		manager = new DonationManager();
		
	}
 
	@After
	public void tearDown() throws Exception {
		 
		manager = null;
	}
 
	/** 
	 * Student test that a new DonationPackage is created and 
	 * the manager correctly calls load the container 
	 */
	@Test
	public void testManagerLoadcontainer()   {
		try {
			manager.managerLoadContainer(new DonationPackage("Mechanical Pencils (Penecilin)",12));
			manager.managerLoadContainer(new DonationPackage("Textbooks",12));
			manager.managerLoadContainer(new DonationPackage("Composition Book",11));
			manager.managerLoadContainer(new DonationPackage("Desks",20));
			manager.managerLoadContainer(new DonationPackage("MacBook",14));
			 
			 
		} catch (ContainerException e) {
			System.out.println("Should not throw exception ");
		}		 
	}
	 
	/**
	 * Student test that a new Volunteer is created and 
	 * the manager correctly queues the volunteer
	 */
	@Test
	public void testManagerQueueVolunteer() {
		try {
			manager.managerQueueVolunteer(new  Volunteer("Alexia"));
			manager.managerQueueVolunteer(new  Volunteer("Denyse"));
			manager.managerQueueVolunteer(new  Volunteer("Cameron"));
			manager.managerQueueVolunteer(new  Volunteer("Nicole"));
			manager.managerQueueVolunteer(new  Volunteer("Sarah"));
			manager.managerQueueVolunteer(new  Volunteer("Fabian"));
			
		} catch (VolunteerException e) {
			 
			System.out.println(e + "here");
		}
	}

	/**
	 * Student test that a new Recipient is created and 
	 * the manager correctly queues the recipient
	 */
	@Test
	public void testManagerQueueRecipient() {
		try {
			manager.managerQueueVolunteer(new  Volunteer("Alexia"));
			manager.managerQueueVolunteer(new  Volunteer("Denyse"));
			manager.managerQueueVolunteer(new  Volunteer("Cameron"));
			manager.managerQueueVolunteer(new  Volunteer("Nicole"));
			manager.managerQueueVolunteer(new  Volunteer("Sarah"));
			manager.managerQueueVolunteer(new  Volunteer("Fabian"));
			
		} catch (VolunteerException e) {
			 
			System.out.println(e + "here");
		}
	}

	/**
	 * Student test that the manager correctly calls donatePackage,
	 * testing the situations noted in the assignment document
	 */
	@Test
	public void testDonatePackage() {
		Volunteer v1;
	    Recipient r1;
	    DonationPackage d1,d2;
	    
	    v1 = new Volunteer("Odessa"); 
		r1 =  new Recipient("Alfea University");
		
		d1 =  new DonationPackage("Pencil",10);
		d2 =  new DonationPackage("MacBook",20);
		
		try {
			manager.managerLoadContainer(d1);
			manager.managerLoadContainer(d2);
			
			assertEquals(manager.donatePackage(),1 );  //Can not donate package, There are no volunteers in the queue
			
			manager.managerQueueVolunteer(v1);    //add a volunteer
			assertEquals(manager.donatePackage(),2 );  // Still Can not donate package,There are no recipients in the queue
			
			manager.managerQueueRecipient(r1);   //Add a recipient
			assertEquals(manager.donatePackage(),0);    // donation process should be successful, this should remove the package from
			                                            // the container and recipients from the queue, Volunteer is enqueued again to the 
														// Volunteer line.
			
			assertEquals(manager.donatePackage(),2); //There is no recipient in the queue
			
		} catch (ContainerException | VolunteerException | RecipientException e) {
			 
			e.printStackTrace();
		}
	 
	} 

}