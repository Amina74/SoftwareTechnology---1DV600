package HangmanGame;

import java.util.ArrayList;

/**
 * This Class contains a list of letters the player has guessed which were not part of
 * the word.
 * 
 * @author Amina Hamza
 *
 */
public class GuessedLetters {

	private ArrayList<Character> guessedLetters;

	public GuessedLetters() {
		guessedLetters = new ArrayList<Character>();
	}

	/**
	 * Returns a string representation of all letters in the list
	 * 
	 * @return String representation of the letters in the list
	 */
	public String toString() {
		String result = "";
		for (int i = 0; i < guessedLetters.size(); i++) {
			result += guessedLetters.get(i) + " ";
		}
		return result;
	}

	/**
	 * Adds a letter to the list of guessed letters if it is not already part of the
	 * list
	 * 
	 * @param letter
	 *            Letter to be added
	 */
	public void addLetter(char letter) {
		if (letterAlreadyGuessed(letter) == false) {
			guessedLetters.add(letter);
		}
	}

	/**
	 * Checks if the letters are part of the list
	 * 
	 * @param letter
	 *            letter to be checked
	 * @return true if list contain letter, otherwise false
	 */
	public boolean letterAlreadyGuessed(char letter) {
		for (int i = 0; i < guessedLetters.size(); i++) {
			if (letter == guessedLetters.get(i)) {
				return true;
			}
		}
		return false;
	} 

}
