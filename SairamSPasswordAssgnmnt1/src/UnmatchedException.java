/**
 * Sairam Soundararajan
 * 
 *Handles passwords that are NOT identical
 */
public class UnmatchedException extends Exception {
	/**
	 * 
	 * @param message
	 */
	public UnmatchedException(String message)
	{
		super(message);
	}
}
