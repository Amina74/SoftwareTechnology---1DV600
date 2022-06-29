package HangmanGame;

import java.util.Scanner;

/**
 * This class initiate the game and present a menu with choices to play hangman.
 * User is able to initiate new games, return to previous and play a multiplayer
 * version. The player is also capable to remove words from the predefined list
 * of words.
 * 
 * @author Amina Hamza
 *
 */

public class Main {

	private static Scanner sc = new Scanner(System.in);
	private static boolean continueProgram = true;
	private static Game game = new Game();
	private static boolean playing = false;
	private static int highscore = 0;

	public static void main(String[] args) {

		while (continueProgram == true) {

			printEmptyLines();

			System.out.println("1. Play new game");
			System.out.println("2. Return to previous game");
			System.out.println("3. Play multiplayer version");
			System.out.println("4. Remove word from predefined list");
			System.out.println("5. Terminate Program");
			System.out.println("\nChoose one of the above");

			checkIntInput(sc);
			int input = getMenuChoice();

			switch (input) {
			case 1:
				if (Main.confirmPlayNewGame() == true) {
					highscore = 0;
					playing = true;
					while (playing == true) {
						game = new Game();
						playSinglePlayerGame();
					}
				}
				break;
			case 2:
				playing = true;
				playSinglePlayerGame();
				while (playing == true) {
					game = new Game();
					playSinglePlayerGame();
				}
				break;
			case 3:
				MultiplayerGame mult = new MultiplayerGame();
				mult.playGame();
				break;
			case 4:
				WordListEditor words = new WordListEditor();
				words.removeWord();
				break;
			case 5:
				terminateProgram();
				break;
			default:
				System.out.println("Invalid input");
			}
		}
		sc.close();
	}

	/**
	 * Play one game of hangman and raise highscore if the player won. Also print
	 * result of game and current highscore.
	 */
	public static void playSinglePlayerGame() {
		game.playGame();
		if (game.gameSucceded() == true) {
			highscore++;
			System.out.println("Your highscore is: " + highscore);
			System.out.println("Enter any character to continue");
			sc.next();
		} else if (game.gameLost() == true) {
			System.out.println("Your highscore was: " + highscore);
			System.out.println("Enter any character to continue");
			sc.next();
		}
	}

	/**
	 * Used to break loop of single player game to return to menu.
	 */
	public static void stopPlaying() {
		playing = false;
	}

	/**
	 * Check if the variable coninueProgram is true
	 * 
	 * @return true if variable continueProgram is true
	 */
	public static boolean continueProgram() {
		return continueProgram;
	}

	/**
	 * Print 100 empty lines to imitate that the page is updated
	 */
	public static void printEmptyLines() {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
	}

	/**
	 * Makes sure the input is an integer, if not ask player for new input until it
	 * is an integer
	 * 
	 * @param sc
	 *            Scanner which receive input
	 */
	public static void checkIntInput(Scanner sc) {
		while (!sc.hasNextInt()) {
			System.out.print("Invalid input, enter a number: ");
			sc.next();
		}
	}

	/**
	 * Method ask the user for confirmation to terminate the program. Terminates
	 * program if user confirms, otherwise return to previous state.
	 */
	public static void terminateProgram() {
		Scanner sc = new Scanner(System.in);
		printEmptyLines();
		System.out.print("Terminating the program means all previous games will be lost");
		System.out.println("\nAre you sure you want to terminate the program?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		checkIntInput(sc);
		int confirmation = sc.nextInt();
		while (!(confirmation == 1 | confirmation == 2)) {
			System.out.print("Invalid input enter 1 or 2: ");
			checkIntInput(sc);
			confirmation = sc.nextInt();
		}
		printEmptyLines();
		if (confirmation == 1) {
			Main.continueProgram = false;
			Main.stopPlaying();
		}
	}

	/**
	 * Return an integer from 1-5 entered by the user
	 * 
	 * @return an integer from 1-5
	 */
	private static int getMenuChoice() {
		int input = sc.nextInt();
		while (!(input == 1 | input == 2 | input == 3 | input == 4 | input == 5)) {
			System.out.print("Invalid input enter a menu choice: ");
			checkIntInput(sc);
			input = sc.nextInt();
		}
		return input;
	}

	/**
	 * Ask if the user want to play a new game.
	 * 
	 * @return True if player wants to play a new game, otherwise false
	 */
	private static boolean confirmPlayNewGame() {
		printEmptyLines();
		System.out.println("Initiating a new game will erase any previous game.");
		System.out.println("Are you sure you want to initiate a new game?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		Scanner sc = new Scanner(System.in);
		Main.checkIntInput(sc);
		int confirmation = sc.nextInt();
		while (!(confirmation == 1 | confirmation == 2)) {
			System.out.print("Invalid input enter 1 or 2: ");
			Main.checkIntInput(sc);
			confirmation = sc.nextInt();
		}
		if (confirmation == 1) {
			return true;
		} else {
			return false;
		}
	}
}
