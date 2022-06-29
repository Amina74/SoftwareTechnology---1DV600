package HangmanGame; 

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestWords {
	
	private Words sut;
	
	@BeforeEach
	public void setUp() {
		sut = new Words();
	}
	
	//getRandomWord()
	
	@Test
	public void testGetRandomWord() {
		String expected = "Test";
		
		String actual = sut.getRandomWord();
		
		assertEquals(expected, actual);
	}
	 
	//indexOfWord()
	
	@Test
	public void testIndexOfWordWhenWordPresent() {
		int expected = 0;
		
		int actual = sut.indexOfWord("Test");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIndexOfWordWhenWordNotPresent() {
		int expected = -1;
		
		int actual = sut.indexOfWord("NotPresentWord");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRemoveWord() {
		int expected = -1;
		sut.removeWord("Test");
		
		int actual = sut.indexOfWord("Test");
		
		assertEquals(expected, actual);
		
		sut = new Words();
		actual = sut.indexOfWord("Test");
		assertEquals(expected, actual);
		
		sut.addWord("Test");
		expected = 0;
		actual = sut.indexOfWord("Test");
		assertEquals(expected, actual);
		
		sut = new Words();
		actual = sut.indexOfWord("Test");
		assertEquals(expected, actual);
	}
	

}
