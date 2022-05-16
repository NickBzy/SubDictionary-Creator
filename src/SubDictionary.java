import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;

/**
 * @author Nicolas Buu
 * This program creates a Subdictionary txt file from an existing txt file
 */
public class SubDictionary {
	
	/**
	 * @param scanner Scanner that reads existing file
	 * @param writer writer to write to a text file
	 */
	public static void dictionaryCreator(Scanner scanner, PrintWriter writer) {
		String paragraph="";
		while(scanner.hasNextLine()) {
			paragraph += scanner.nextLine();
		}
		String[] words= paragraph.split(" |\\.|\\:|\\?|\\,");
		ArrayList<String> wordsList= new ArrayList<String>();
		for(int i=0; i<words.length; i++) {
			wordsList.add(words[i]);
		}
		capitalize(wordsList);
		removeRedundancy(wordsList);
		sort(wordsList);
		
		writer.println("The document produced this sub-dictionary, which includes "+wordsList.size()+" words.");
		int count=0;
		for(char i='A'; i<='Z'; i++) {
			writer.println(i);
			writer.println("===");
			while(wordsList.get(count).charAt(0)==i) {
				writer.println(wordsList.get(count));
				if(count<wordsList.size()-1) 
					count++;
				else
					break;
				}
			writer.println();
		}
		System.out.println("File created successfully.");
	}
	
	/**
	 * @param a ArrayList of strings
	 * sorts an arrayList alphabetically
	 */
	public static void sort(ArrayList<String> a) {
		String temp;
		for(int i=0; i<a.size(); i++) {
			for(int j=i+1; j<a.size(); j++) {
				if((a.get(i).compareTo(a.get(j)))>0) {
					temp= a.get(i);
					a.set(i, a.get(j));
					a.set(j, temp);
				}
			}
		}
	}
	
	/**
	 * @param a Arraylist of String
	 * capitalize every word
	 */
	public static void capitalize(ArrayList<String> a) {
		for(int i=0; i<a.size(); i++) {
			a.set(i, a.get(i).toUpperCase());
		}
	}
	
	/**
	 * @param a Arraylist of string
	 * removes all redundancies
	 */
	public static void removeRedundancy(ArrayList<String> a) {
		for(int count=0; count<2; count++) {
			for(int i=0; i<a.size(); i++) {
				if(a.get(i).contains(",") || a.get(i).contains(" ") || a.get(i).contains("?")
						|| a.get(i).contains(":") || a.get(i).contains("!") || 
						a.get(i).contains(".") || a.get(i).contains(";") || a.get(i).contains("=")) {
					a.set(i, a.get(i).replace(",", ""));
					a.set(i, a.get(i).replace(" ", ""));
					a.set(i, a.get(i).replace("?", ""));
					a.set(i, a.get(i).replace(":", ""));
					a.set(i, a.get(i).replace("!", ""));
					a.set(i, a.get(i).replace(".", ""));
					a.set(i, a.get(i).replace(";", ""));
					a.set(i, a.get(i).replace("=", ""));
				}
				
				if(a.get(i).contains("’")){
					a.set(i, a.get(i).substring(0, a.get(i).indexOf("’")));
				}
						
				if(a.get(i).matches(".*\\d.*")) {
					a.remove(i);
				}
				
			}
			for(int i=0; i<a.size(); i++) {
				for(int j=i+1; j<a.size(); j++) {
					if(a.get(i).equalsIgnoreCase(a.get(j))) {
						a.remove(j);
					}
				}
				if(a.get(i).length()<2 && !(a.get(i).equals("A")||a.get(i).equals("I"))) {
					a.remove(i);
				}
			}
		}
		}
		

	public static void main(String[] args)  {
		Scanner userInput= new Scanner(System.in);
		PrintWriter writer= null;
		Scanner scanner= null;
		System.out.println("Welcome to the Sub-Dictionary Creator Program!");
		System.out.println("==========================================================");
		System.out.println("Please enter the name of the file:");
		String fileName= userInput.nextLine();
		try {
			scanner = new Scanner(new FileInputStream(fileName));
		}
		catch(FileNotFoundException e) {
			System.out.println("File could not be found");
			System.exit(0);
		}
		try {
			writer= new PrintWriter(new FileOutputStream("SubDictionary.txt"));
		}
		catch(Exception e) {
			System.out.println("File could not be open/created.");
		}
		
		dictionaryCreator(scanner, writer);
		writer.close();
		scanner.close();
		
	}

}
