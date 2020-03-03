/* The class that uses this  interface uses a Stack of DonationPackage to simulate stacking and removing DonationPackages
 * to and from the container.
 * @author khandan Monshi, revised by Professor Kartchner
 *
 */

import java.util.EmptyStackException;
public class Container implements ContainerInterface{
	MyStack<DonationPackage> myStack;
	private int size;
	int count;
	private int DEFAULT_SIZE = 5;

	/**
	 * Provide two constructors:
	 * Container(int size) make the internal stack this size
	 * Container() make the internal stack a default size
	 */
	public Container(int size) {
		myStack = new MyStack<DonationPackage> (size);
		count = 0;
		this.size = size;
	}

	public Container(){
	count = 0;
	size = DEFAULT_SIZE ;
	myStack = new MyStack<DonationPackage>();
	}

	/* Stacks a new donation package  in to the container
	 * @param dPackage a DonationPackage Object to be stacked to the container
	 * Return true if the package is stacked, false if the container is full
	 * @throws ContainerException("The Container is Full") if the containerSize = containerCount (stack is full)
	 */
	public boolean loadContainer(DonationPackage dpackage) throws ContainerException{
		
		boolean outcome = true;
		if (myStack.isFull())
		{
			outcome = false;
		    throw new ContainerException("The Container is Full");
		}  
		else
			{
			myStack.push(dpackage);
			}
		return outcome;
	}

	/**
	 * Removes  a DonationPackage from the stack of packages in the container
	 * @return a DonationPackage from the stack of Packages in the container
	 * @throws ContainerException("The Container is Empty") if there is no package in the container
	 */
	public DonationPackage removePackageFromContainer() throws ContainerException{
		
		
		if(myStack.isEmpty()) 
		{
			throw new ContainerException("The Container is Empty");
		}
		return myStack.pop();
	}

	/**
	 * Returns an array of the DonationPackages in the stack.  
	 * Because of type erasure by the JVM at run-time, the array of type T that the generic stack returns is an array of 
	 * type Object , i.e., Object[] temp. But since the individual elements of the array are still DonationPackages,
	 * we can copy them one by one into a new array	of type DonationPackage and cast each one to DonationPackage. 
	 * So create a new array of DonationPackages of the same length as temp, run a for-loop that casts each element 
	 * of temp to DonationPackage, and copies it to the corresponding position in the new array.  Then return the new array.
	 * 
	 * @return an array of the DonationPackages in the stack
	 */
	public DonationPackage[] toArrayPackage() {
		 
		Object[] tempArray = new Object[myStack.size()];
		tempArray = myStack.toArray();
		
		DonationPackage tempdpArray[] = new DonationPackage[myStack.size()];
				
		for(int counter = 0; counter < myStack.size(); counter++)
		{
			tempdpArray[counter] = (DonationPackage)tempArray[counter];
		}
		return tempdpArray;
	}

}
