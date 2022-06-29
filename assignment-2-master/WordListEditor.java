package HangmanGame;

import java.util.Scanner;
/**
 * This method ask the user to enter a word to be removed. The player is also able to
 * return to menu or end game at this stage. Multiply words are
 * possible to be removed before returning to menu.
 * 
 * @author Amina Hamza
 *
 */
public class WordListEditor {

	private boolean returnToMenu;
	private Scanner scan;
	private Words words;

	WordListEditor() {
		returnToMenu = false;
		scan = new Scanner(System.in);
		words = new Words();
	}

	/**
	 * This method ask the user to enter which word to be removed. Player is also able 
	 * to return to menu or end game from this stage. It is possible 
	 * to remove multiply words before returning to the menu.
	 */
	public void removeWord() {
		while (returnToMenu == false) {
			Main.printEmptyLines();

			System.out.println("Press 1 to return to the Menu");
			System.out.println("Press 2 to terminate program");
			System.out.print("\nEnter the word to be removed or a menu choice: ");

			String input = scan.next();
			if (input.charAt(0) == '1') {
				returnToMenu = true;
			} else if (input.charAt(0) == '2') {
				Main.terminateProgram();
			} else {
				if (words.indexOfWord(input) < 0) {
					System.out.println("\nWord " + input + " is not part of the list!");
					System.out.println("Enter any character to continue: ");
					input = scan.next();
					continue;
				}
				System.out.println("\nAre you sure you want to remove the word: " + input);
				System.out.println("1. Yes\n2. No");
				checkIntInput(scan);
				int confirmation = scan.nextInt();
				while (!(confirmation == 1 | confirmation == 2)) {
					System.out.print("\nInvalid input enter 1 or 2: ");
					checkIntInput(scan);
					confirmation = scan.nextInt();
				}
				if (confirmation == 1) {
					words.removeWord(input);
					System.out.println("\nThe word " + input + " is now removed");
				} else {
					System.out.println("\nThe word " + input + " was not removed");
				}
				System.out.println("Enter any character to continue: ");
				scan.next();

			}
		}
	}

	/**
	 * Check for integer in the input, if it is an integer ask user for new input.
	 * @param scan to receive the input. 
	 */
	private void checkIntInput(Scanner scan) {
		while (!scan.hasNextInt()) {
			System.out.print("\nInvalid input, enter a number: ");
			scan.next();
		}
	}

	

}
