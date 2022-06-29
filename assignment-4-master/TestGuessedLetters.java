package HangmanGame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestGuessedLetters {
	
	GuessedLetters sut;
	
	@BeforeEach
	public void setup() {
		sut = new GuessedLetters(); 
	}
	 
	@Test
	public void testToString() {
		sut.addLetter('a');
		String expected = "a ";
		
		String actual = sut.toString();
		
		assertEquals(expected, actual);
		
		sut.addLetter('b');
		sut.addLetter('x');
		expected = "a b x ";
		
		actual = sut.toString();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAddLetter() {
		sut.addLetter('a');
		sut.addLetter('b');
		String expected = "a b ";
		
		String actual = sut.toString();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAddLetterLetterAlreadyAdded() {
		sut.addLetter('a');
		sut.addLetter('a');
		sut.addLetter('c');
		sut.addLetter('c');
		String expected = "a c ";
		
		String actual = sut.toString();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testLetterAlreadyGuessedFalse() {
		boolean expected = false;
		sut.addLetter('s');
		sut.addLetter('q');
		
		boolean actual1 = sut.letterAlreadyGuessed('t');
		boolean actual2 = sut.letterAlreadyGuessed('a');
		boolean actual3 = sut.letterAlreadyGuessed('r');
		boolean actual4 = sut.letterAlreadyGuessed('x');
		boolean actual5 = sut.letterAlreadyGuessed('o');
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
		assertEquals(expected, actual3);
		assertEquals(expected, actual4);
		assertEquals(expected, actual5);
	}
	
	@Test
	public void testLetterAlreadyGuessedTrue() {
		sut.addLetter('a');
		sut.addLetter('x');
		sut.addLetter('o');
		boolean expected = true;
		
		boolean actual1 = sut.letterAlreadyGuessed('a');
		boolean actual2 = sut.letterAlreadyGuessed('o');
		boolean actual3 = sut.letterAlreadyGuessed('x');
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
		assertEquals(expected, actual3);
	} 

}
