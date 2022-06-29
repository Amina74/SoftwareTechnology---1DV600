package HangmanGame;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestMultiplayerGame {
	
	@Test
	public void testCheckWordValidWord() {
		MultiplayerGame sut = new MultiplayerGame();
		boolean expected = true;
		
		boolean actual = sut.checkWord("Example"); 

		assertEquals(expected, actual);
	}
	
	@Test
	public void testCheckWordValidWordWithDash() {
		MultiplayerGame sut = new MultiplayerGame();
		boolean expected = true;
		
		boolean actual = sut.checkWord("Grand-parent");

		assertEquals(expected, actual);
	}
	
	@Test
	public void testCheckWordInvalidWord() {
		MultiplayerGame sut = new MultiplayerGame();
		boolean expected = false;
		
		boolean actual = sut.checkWord("*,*");
		
		assertEquals(expected, actual);
	}
	
	

}
