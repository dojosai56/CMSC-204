import java.io.File;
import java.util.ArrayList;

import javax.tools.JavaCompiler;
/**
 * Sairam Soundararajan
 * @author saira
 *
 */
public class PasswordCheckerUtility {

	private static int counter;
	
	public PasswordCheckerUtility() {}
	
	/**
	 * 
	 * @param passwordString
	 * @return
	 * @throws LengthException
	 * @throws NoDigitException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws InvalidSequenceException
	 */
	public static boolean isValidPassword(String passwordString) throws LengthException,NoDigitException,NoUpperAlphaException,NoLowerAlphaException,InvalidSequenceException {
		if(passwordString.length() < 6)
			throw new LengthException("Password must be 6 six characters long or more!!");
		
		if(passwordString.equals(passwordString.toLowerCase()))
			throw new NoUpperAlphaException("Password must have at least one Uppercase character!!");
		else if(passwordString.equals(passwordString.toUpperCase()))
			throw new NoLowerAlphaException("Password must have at least one Lowercase character!!");
		else if(!passwordString.matches(".*[0-9].*"))
			throw new NoDigitException("Password must have at least one number!!!");
		else if(counter > 0)
			for (int counter = 1; counter < passwordString.length(); counter++)
		{
			if (passwordString.charAt(counter) == passwordString.charAt(counter - 2))
				throw new InvalidSequenceException("Password has more than 2 of the same characters!!!");
		}
			return true;
		}
	/**
	 * 
	 * @param passwordString
	 * @return
	 */
	public static boolean isWeakPassword(String passwordString) {
		if(passwordString.length() >= 6 && passwordString.length() <= 9)
		{
			return true;
		}
		else 
		return false; 
		}
		
	/**
	 * 
	 * @param passwords
	 * @return
	 */
	public static ArrayList<String> invalidPasswords(ArrayList<String> passwords){
		ArrayList<String> result = new ArrayList<String>(passwords);
		
		for(String passwords1: passwords)
		{
			try {
				if(isValidPassword(passwords1))
				{
					result.remove(passwords1);
				}
			} catch (LengthException | NoDigitException | NoUpperAlphaException | NoLowerAlphaException
					| InvalidSequenceException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
				
		}
		return result;
	}
}
	
	
	
