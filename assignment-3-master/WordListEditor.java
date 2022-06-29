package HangmanGame;

import java.util.Scanner;
/**
 * Method ask user to enter which word to be removed. Player is also able to
 * return to menu or terminate the program from this stage. Multiply words i
 * possible to be removed before returning to menu.
 * 
 * @author Amina Hamza
 *
 */
public class WordListEditor {

	private boolean returnToMenu;
	private Scanner sc;
	private Words words;

	WordListEditor() {
		returnToMenu = false;
		sc = new Scanner(System.in);
		words = new Words();
	}

	/**
	 * Method ask user to enter which word to be removed. Player is also able to
	 * return to menu or terminate the program from this stage. Multiply words i
	 * possible to be removed before returning to menu.
	 */
	public void removeWord() {
		while (returnToMenu == false) {
			Main.printEmptyLines();

			System.out.println("Press 1 to return to the Menu");
			System.out.println("Press 2 to terminate program");
			System.out.print("\nEnter the word to be removed or a menu choice: ");

			String input = sc.next();
			if (input.charAt(0) == '1') {
				returnToMenu = true;
			} else if (input.charAt(0) == '2') {
				Main.terminateProgram();
			} else {
				if (words.indexOfWord(input) < 0) {
					System.out.println("\nWord " + input + " is not part of the list!");
					System.out.println("Enter any character to continue: ");
					input = sc.next();
					continue;
				}
				System.out.println("\nAre you sure you want to remove the word: " + input);
				System.out.println("1. Yes\n2. No");
				checkIntInput(sc);
				int confirmation = sc.nextInt();
				while (!(confirmation == 1 | confirmation == 2)) {
					System.out.print("\nInvalid input enter 1 or 2: ");
					checkIntInput(sc);
					confirmation = sc.nextInt();
				}
				if (confirmation == 1) {
					words.removeWord(input);
					System.out.println("\nThe word " + input + " is now removed");
				} else {
					System.out.println("\nThe word " + input + " was not removed");
				}
				System.out.println("Enter any character to continue: ");
				sc.next();

			}
		}
	}

	/**
	 * Check that input is an integer, otherwise ask user for new input.
	 * @param sc Scanner to receive the input. 
	 */
	private void checkIntInput(Scanner sc) {
		while (!sc.hasNextInt()) {
			System.out.print("\nInvalid input, enter a number: ");
			sc.next();
		}
	}

	

}
