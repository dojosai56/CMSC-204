import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * 
 * @author Sairam Soundararajan
 * Date: 4-01-2020
 * Course: Computer Science II
 */

public class ConcordanceDataManager implements ConcordanceDataManagerInterface {
	private int length = 0;
	private static ConcordanceDataStructure hashingobject;

	ConcordanceDataStructure element = new ConcordanceDataStructure(length);

	int size = element.getTableSize();

	public ConcordanceDataManager() {
		hashingobject = new ConcordanceDataStructure(size);
		//System.out.println(hashingobject.getTableSize());
	}

	
	/**
	 * @param word
	 * 
	 */
	@Override
	public ArrayList<String> createConcordanceArray(String word) {

		int linenumber = 1;
		String bar;
		String[] term;

		while (!word.isEmpty()) {
			if (word.indexOf("\n") == -1) {
				bar = word;
				word = "";
			} else {
				bar = word.substring(0, word.indexOf("\n"));
				word = word.substring(word.indexOf("\n") + 1);
				//System.out.println(word);
			}

			while (!bar.isEmpty()) {
				bar = bar.toLowerCase();
				//bar = bar.replaceAll("and |the ", "");
				//System.out.println(bar);
				bar = bar.replaceAll("[,|.|?]", "");
				bar = bar.replaceAll("and", "");
				bar = bar.replaceAll("the", "");
				//System.out.println(bar);

				term = bar.split(" ");

				bar = "";

				if (term.length != 0) {
					int counter = 0;
					while (counter < term.length) {
						if (term[counter].length() > 2) {
							String subsequent;
							subsequent = term[counter];
							hashingobject.add(subsequent, linenumber);
						}
						counter++;
					}
				}

			}
			linenumber++;
		}
		return hashingobject.showAll();
	}

	/**
	 * @returns boolean value
	 */
	@Override
	public boolean createConcordanceFile(File input, File output) throws FileNotFoundException {
		Scanner scanner = new Scanner(input);
		String line = "";
		int lineNumber = 0;
		String[] tokens;
		int wordsInText = 0;
		
		while(scanner.hasNextLine()) {
			line = scanner.nextLine();
			
			tokens = line.split(" ");
			//System.out.println(tokens.length);
			for(int counter = 0; counter < tokens.length;counter++) {
				wordsInText++;
			}//read each token of the line
		}//read each line
		scanner.close();
		
		ConcordanceDataStructure struct = new ConcordanceDataStructure(wordsInText);
		
		Scanner scanner2 = new Scanner(input);
		while(scanner2.hasNextLine()) {
			line = scanner2.nextLine();
			
			tokens = line.split(" ");
			for(int counter = 0; counter < tokens.length;counter++) {
				tokens[counter] = tokens[counter].toLowerCase();
				tokens[counter] = tokens[counter].replaceAll("[,|.|?]","");
				tokens[counter] = tokens[counter].replaceAll("and", "");
				tokens[counter] = tokens[counter].replaceAll("the", "");
				
				//System.out.println(tokens[counter]);
				struct.add(tokens[counter], lineNumber);
			}//read each token of the line
			lineNumber++;
		}//read each line
		scanner2.close();
		//System.out.println("table size " +struct.getTableSize());
		
		PrintWriter fileoutput = new PrintWriter(output);
		ArrayList<String> list = struct.showAll();
		//System.out.println(list);
		for (String word : list) {
			fileoutput.print(word);
		}
		fileoutput.close();
		
		
		return true;
	}
	
	
	public static void main(String [] args) {
		System.out.println("Main method");
		ConcordanceDataManager m = new ConcordanceDataManager();
		System.out.println("Constructor called");
	}// main
}
