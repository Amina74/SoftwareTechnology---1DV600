package HangmanGame;

import java.util.Scanner;

/**
 * Plays a multiplayer game of hangman. Ask one player to enter a word and the
 * other to play a game with this word. Display result when game is over and
 * then return to main menu.
 * 
 * @author Amina Hamza
 *
 */
public class MultiplayerGame {

	private Game game;
	private Scanner sc;
	private boolean startGame;
	private String word;

	public MultiplayerGame() {
		game = new Game();
		sc = new Scanner(System.in);
		startGame = false;
	}

	/**
	 * Plays a multiplayer game of hangman. Ask one player to enter a word and the
	 * other to play a game with this word.
	 */
	public void playGame() {
		Main.printEmptyLines();
		System.out.println("Multiplayer version mean that one player enter a word and the other player");
		System.out.println("get to guess the letters of the word. If player 2 manage to guess the word");
		System.out.println("that means he won, however if he does not player 1 win!\n");

		while (startGame == false) {
			System.out.print("Player 1 enter a word:");
			word = sc.next();

			while (checkWord(word) == false) {
				System.out.println("Not a valid word, word must only contain letters!");
				System.out.print("Enter a new word: ");
				word = sc.next();
			}

			Main.printEmptyLines();

			System.out.println("Player 1 have now entered a word!\n");
			System.out.println("Press 1 to play game with this word");
			System.out.println("Press 2 to change the entered word");

			Main.checkIntInput(sc);
			int input = sc.nextInt();
			while (!(input == 1 | input == 2)) {
				System.out.print("Invalid input enter a menu choice: ");
				Main.checkIntInput(sc);
				input = sc.nextInt();
			}
			Main.printEmptyLines();
			if (input == 1) {
				System.out.println("Player 2 should now guess:");
				System.out.println("Enter any character to start game");
				sc.next();
				startGame = true;
				game.setWord(word);
				game.playGame();
			}
		}
		Main.printEmptyLines();
		if (game.gameSucceded()) {
			System.out.println("Player 2 won the game! Congratulations!");
		} else {
			System.out.println("Player 1 won the game! Congratulations!");
		}
		System.out.println("Enter any character to continue");
		sc.next();
	}

	/**
	 * Check that word only consist of letters and '-'
	 * 
	 * @param word
	 *            String to be checked
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

}
