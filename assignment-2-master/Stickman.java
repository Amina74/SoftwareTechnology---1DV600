package HangmanGame;

/**
 * 
 * A stickmanfigure with 9 parts will be drawn.
 * Also a method to draw a happy stickman standing on the ground.
 * 
 * @author Amina Hamza
 *
 */
public class Stickman {

	private int numberOfPartsDrawn;
	private String[] picture;

	public Stickman() {

		numberOfPartsDrawn = 0;
		picture = new String[6];
		for (int i = 0; i < 5; i++) {
			picture[i] = "";
		}
		picture[5] = "_______";

	}

	/**
	 * Draws current parts of stickman
	 */
	public void drawStickman() {
		System.out.println();
		for (int i = 0; i < picture.length; i++) {
			System.out.println(picture[i]);
		}
	}

	/**
	 * Adds a part of the stickman. Stickman contain 9 pieces, if all parts is drawn
	 * nothing happens
	 */
	public void addPart() {
		switch (numberOfPartsDrawn) {
		case 0:
			for (int i = 1; i <= 4; i++) {
				picture[i] = "|";
			}
			picture[5] = "|_______";
			break;
		case 1:
			picture[0] = "_____";
			break;
		case 2:
			picture[1] = "|   |";
			break;
		case 3:
			picture[2] = "|   O";
			break;
		case 4:
			picture[3] = "|   |";
			break;
		case 5:
			picture[3] = "|  /|";
			break;
		case 6:
			picture[3] = "|  /|\\";
			break;
		case 7:
			picture[4] = "|  /";
			break;
		case 8:
			picture[4] = "|  / \\";
			break;
		default:
			break;
		}

		numberOfPartsDrawn++;
	}

	/**
	 * Draws a happy stickman standing on the ground
	 */
	public void drawHappyStickman() {
		System.out.println("_____");
		System.out.println("|");
		System.out.println("|");
		System.out.println("|  \\O/");
		System.out.println("|   |");
		System.out.println("|__/_\\__");
	}
}
