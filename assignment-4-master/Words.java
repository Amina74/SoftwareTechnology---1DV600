package HangmanGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Class reads a text file from scr folder with a list of nouns. File must only
 * consist of nouns and no signs.
 * 
 * 
 * @author Amina Hamza
 *
 */
public class Words {

	//private String searchCode = "/Users/mummy/Desktop/ah224uq_1dv600/Hangman/src/nounlist 2.txt"; // Real noun list Comment out during testing
	private String searchCode = "/Users/mummy/Desktop/ah224uq_1dv600/Hangman/src/test.txt"; // Use during testing fake noun list1
	
	private ArrayList<String> words;

	public Words() {

		Path path = Paths.get(searchCode);
		File file = new File(path.toAbsolutePath().toString());
		
		System.out.println(path.toAbsolutePath().toString());
		
		try {
			Scanner fileScan;
			fileScan = new Scanner(file);

			words = new ArrayList<String>();

			while (fileScan.hasNext()) {
				words.add(fileScan.next());
			}
			fileScan.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	/**
	 * Returns a randomly picked word from the textfile.
	 * 
	 * @return String with a randomly picked word.
	 */
	public String getRandomWord() {
		Random rand = new Random();
		String theWord = words.get(rand.nextInt(words.size()));
		return theWord;
	}

	/**
	 * Check which index the word has in the list of words, if not present returns
	 * -1.
	 * 
	 * @param word
	 *            Word to be checked for
	 * @return index of word, -1 if not present
	 */
	public int indexOfWord(String word) {
		String wordSmallCases = "";
		for (int i = 0; i < word.length(); i++) {
			if (Character.isLetter(word.charAt(i))) {
				wordSmallCases += Character.toLowerCase(word.charAt(i));
			} else {
				wordSmallCases += word.charAt(i);
			}
		}
		var i = 0;
		while (i < words.size()) {
			String listWord = "";
			for (int j = 0; j < words.get(i).length(); j++) {
				if (Character.isLetter(words.get(i).charAt(j))) {
					listWord += Character.toLowerCase(words.get(i).charAt(j));
				} else {
					listWord += words.get(i).charAt(j);
				}
			}
			if (listWord.equals(wordSmallCases)) {
				return i;
			}
			i++;
		}
		return -1;
	}

	/** 
	 * Remove the word from list of word and txt-file the word was recieved from.
	 * 
	 * @param word
	 *            The word to be removed
	 */
	public void removeWord(String word) {
		if (indexOfWord(word) >= 0) {
			words.remove(indexOfWord(word));
		}
		try {
			PrintWriter out = new PrintWriter(searchCode);
			for (String s : words) {
				out.println(s);
			}
			out.close();
		} catch (FileNotFoundException e) {
		}
	}

	/**
	 * Add the word to list of word and txt-file the words was recieved from.
	 * 
	 * @param word
	 *            The word to be removed
	 */
	public void addWord(String word) {
		if (indexOfWord(word) == -1) {
			words.add(word);
		}
		try {
			PrintWriter out = new PrintWriter(searchCode);
			for (String s : words) {
				out.println(s);
			}
			out.close();
		} catch (FileNotFoundException e) {
		}
	}

}
