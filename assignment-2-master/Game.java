package HangmanGame;

import java.util.Scanner;

/**
 * Represent a single game of hangman where the player guess a word and
 * either win or lose and then proceed to the next level. The player also
 * has the opportunity to go back to the main menu or terminate the program during
 * the game.
 * 
 * @author Amina Hamza
 *
 */
public class Game {

	private int numberOfGuessesLeft;
	private Words list;
	private String theWord;
	private String[] underscores;
	private GuessedLetters guessedLetters;
	Stickman stickman;
	private Scanner scan;
	private boolean continueGame;

	public Game() {

		numberOfGuessesLeft = 9;
		stickman = new Stickman();
		list = new Words();
		setWord(list.getRandomWord());
		guessedLetters = new GuessedLetters();
		scan = new Scanner(System.in);
		continueGame = true;

	}

	/**
	 * Play a game of hangman. User is able to return to main menu or terminate the
	 * game.
	 */
	public void playGame() {
		continueGame = true;

		while (gameSucceded() == false & numberOfGuessesLeft > 0 & continueGame == true
				& Main.continueProgram() == true) {
			Main.printEmptyLines();

			System.out.println("Press 1 to return to the Menu");
			System.out.println("Press 2 to terminate program");

			System.out.println(underscoresToString());

			stickman.drawStickman();
			System.out.print("Guessed letters: " + guessedLetters.toString());
			System.out.print("\nEnter menu choice or guess a letter:");

			String input = scan.next();
			while (input.length() != 1
					| !(Character.isLetter(input.charAt(0)) | input.charAt(0) == '1' | input.charAt(0) == '2')) {
				System.out.println("Invalid input, enter a letter or a menu choice:");
				input = scan.next();
			}

			if (input.charAt(0) == '1') {
				this.returnToMenu();
			} else if (input.charAt(0) == '2') {
				Main.terminateProgram();
			} else if (Character.isLetter(input.charAt(0))) {
				guessLetter(input);
			}
		}

		Main.printEmptyLines();
		if (gameSucceded() == true) {
			stickman.drawHappyStickman();
			System.out.println("Yay, the man survived! Correct word: " + theWord);
		} else if (numberOfGuessesLeft == 0) {
			Main.stopPlaying();
			stickman.drawStickman();
			System.out.println("Oh no, he died! Correct word: " + theWord);
		}
	}

	/**
	 * Sets the correct word of the game
	 * 
	 * @param word
	 *            
	 */
	public void setWord(String word) throws IllegalArgumentException {
		if (checkWord(word)) {
			theWord = word;
			underscores = new String[theWord.length()];
			for (int i = 0; i < theWord.length(); i++) {
				if (theWord.charAt(i) == '-') {
					underscores[i] = " -";
				} else {
					underscores[i] = " _";
				}

			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Returns the correct word
	 * 
	 * @return the solution to the game
	 */
	public String getWord() {
		return theWord;
	}

	/**
	 * If the gussed letter is correct it stored in the underscored position
	 *  If the letter is incorrect it is added to guessed letters and
	 * a part of the hangman figure is added.
	 * 
	 * @param input
	 *            letter to be guessed
	 */
	public void guessLetter(String input) {
		Boolean correct = false;
		char guess = Character.toLowerCase(input.charAt(0));
		for (int i = 0; i < theWord.length(); i++) {
			if (guess == Character.toLowerCase(theWord.charAt(i))) {
				underscores[i] = " " + theWord.charAt(i);
				correct = true;
			}
		}
		if (!correct) {
			if (guessedLetters.letterAlreadyGuessed(guess) == false) {
				guessedLetters.addLetter(guess);
				stickman.addPart();
				numberOfGuessesLeft--;
			}
		}
	}

	/**
	 * Check if all letters in the word is guessed
	 * 
	 * @return true if all correct letters are guessed, otherwise false
	 */
	public boolean gameSucceded() {
		for (int i = 0; i < underscores.length; i++) {
			if (underscores[i] == " _") {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if the player is out of guesses
	 * 
	 * @return true if the game is lost, otherwise false
	 */
	public boolean gameLost() {
		return numberOfGuessesLeft == 0;
	}

	/**
	 * Return array of underscores/letters as a string
	 * 
	 * @return underscores which either consist of underscores and/or letters
	 */
	public String underscoresToString() {
		String underscoresString = "";
		for (int i = 0; i < underscores.length; i++) {
			underscoresString += underscores[i];
		}
		return underscoresString;
	}

	/**
	 * Check if it is a valid word which only consist of letters and dashes
	 * 
	 * @param word
	 *            Word to be checked
	 * @return True if word is valid, otherwise false
	 */
	public boolean checkWord(String word) {
		for (int i = 0; i < word.length(); i++) {
			if (!Character.isLetter(word.charAt(i)) & word.charAt(i) != '-') {
				return false;
			}
		}
		return true;
	}

	/**
	 * Ask if user want to return to menu, returns if user chooses to, otherwise
	 * return to the game
	 */
	private void returnToMenu() {
		Main.printEmptyLines();
		System.out.println("Are you sure you want to go back to the menu?");
		System.out.println("Your game will be saved until a new game is started. ");
		System.out.println("1. Yes");
		System.out.println("2. No");
		Main.checkIntInput(scan);
		int confirmation = scan.nextInt();
		while (!(confirmation == 1 | confirmation == 2)) {
			System.out.print("Invalid input enter 1 or 2: ");
			Main.checkIntInput(scan);
			confirmation = scan.nextInt();
		}
		if (confirmation == 1) {
			continueGame = false;
			Main.stopPlaying();
		}
	}
}
