
public class Mainclasstest {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			PasswordCheckerUtility.isValidPassword("Im2cool4U");
		} catch (LengthException | NoDigitException | NoUpperAlphaException | NoLowerAlphaException
				| InvalidSequenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
