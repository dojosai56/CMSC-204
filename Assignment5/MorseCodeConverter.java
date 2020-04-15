import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * 
 * @author sairam
 *
 */
public class MorseCodeConverter {

	private static MorseCodeTree<String> morsecodeTree = new MorseCodeTree<String>();
	
	/**
	 * 
	 * @param text
	 * @returns the outcome
	 */
	public static String convertToEnglish(String text) {
		Scanner input = new Scanner(text);
		
		String lcharacter = "";
		
		String outcome = "";
		
		while(input.hasNext())
		{
			lcharacter = input.next();
			
			if(lcharacter.equals("/"))
			{
				outcome += " ";
			}
			
			else
			{
				outcome += morsecodeTree.fetch(lcharacter);
			}
		}
		input.close();
		
		return outcome;
	}

	/**
	 * 
	 * @param selectedFile
	 * @returns outcome
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File selectedFile) throws FileNotFoundException {
		
		Scanner scan = new Scanner(selectedFile);
		String outcome = "";
		String bar = "";
		
		do
		{
			bar = scan.nextLine();
			outcome += convertToEnglish(bar);
		} while(scan.hasNextLine());
		
		return outcome;
	}

	/**
	 * 
	 * @returns outcome
	 */
	public static String printTree() {
		String outcome = "";
		
		for(String index: morsecodeTree.toArrayList())
		{
			outcome += index + " ";
			
			System.out.println("Present merit: " + index);
		}
		return outcome;
	}
	
	/**
	 * main method for testing
	 * @param args
	 */
	public static void main(String [] args) {
		printTree();
	}//testingMethod
	
	
	}//MorseCodeConverter



