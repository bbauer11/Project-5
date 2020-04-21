import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;	

public class MorseCodeConverter {

	private static MorseCodeTree tree = new MorseCodeTree();
	
	public MorseCodeConverter() {
	}
	
	public static String printTree() {
		String toReturn = "";
		for (String s: tree.toArrayList()) {
			toReturn += s + " ";
		}
		return toReturn;
	} 
	
	public static String convertToEnglish(String code) {
		
		String toReturn = "";
		
		String[] words = code.split("/");
		
		for (String word: words) {
			String[] letters = word.split(" ");
			for (String letter: letters) {
				if (!letter.equals(""))
					toReturn += tree.fetch(letter);
			}
			toReturn += " ";
		}
		
 		return toReturn.strip();
	}
	
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		Scanner scanner = new Scanner(codeFile);
		String codeString = "";
		while (scanner.hasNextLine()) {
			codeString += scanner.nextLine();
		}
		scanner.close();
		return convertToEnglish(codeString);
	}

}
