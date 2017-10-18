package kata.tests.java;

import static org.junit.Assert.*;

import org.junit.Test;

import kata.dev.java.bean.TennisMatch;
import kata.dev.java.rules.Rules;

public class RulesTestPlayerWinSet {
	
	@Test
	public void testSetNoWinner() {
				
		assertEquals(0,Rules.playerWinSet(new TennisMatch (3, 18, 3, 0, 0, 0, 0, 0)));
				
		assertEquals(0,Rules.playerWinSetTieBreakMode(new TennisMatch (10, 60, 6, 0, 2, 6, 0, 5)));	
			
		assertEquals(0,Rules.playerWinSetTieBreakMode(new TennisMatch (11, 66, 5, 0, 0, 6, 0, 0)));	
	}
	
			
	@Test
	public void testSprint2UserStory1PlayerWinSet() {
		
		assertEquals(1,Rules.playerWinSet(new TennisMatch (10, 60, 6, 0, 0, 1, 0, 0)));		
		
		assertEquals(2,Rules.playerWinSet(new TennisMatch (13, 78, 6, 0, 0, 7, 0, 0)));		
		
		assertEquals(1,Rules.playerWinSetTieBreakMode(new TennisMatch (10, 60, 7, 0, 0, 6, 0, 0)));	
		
		assertEquals(2,Rules.playerWinSetTieBreakMode(new TennisMatch (10, 60, 1, 0, 0, 6, 0, 0)));		
				
	}
	
	
	@Test
	public void testSprint2UserStory2PlayerWinSet() {
						
		assertEquals(1,Rules.playerWinSetTieBreakMode(new TennisMatch (13, 78, 6, 0, 7, 6, 0, 5)));	
		
		assertEquals(2,Rules.playerWinSetTieBreakMode(new TennisMatch (13, 78, 6, 0, 15, 6, 0, 17)));	
	}
	
		
	
	
}
