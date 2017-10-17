package kata.tests.java;

import static org.junit.Assert.*;

import org.junit.Test;

import kata.dev.java.bean.TennisMatch;
import kata.dev.java.rules.Rules;

public class RulesTestPlayerWinSet {
	
	@Test
	public void testSetNoWinner() {
		TennisMatch lastGame = new TennisMatch (3, 18, 3, 0, 0, 0, 0, 0);		
		assertEquals(0,Rules.playerWinSetWithTB(lastGame));
		
		TennisMatch lastGame_ = new TennisMatch (10, 60, 6, 0, 2, 6, 0, 5);		
		assertEquals(0,Rules.playerWinSetWithTB(lastGame_));	
		
		TennisMatch lastGame_1 = new TennisMatch (11, 66, 5, 0, 0, 6, 0, 0);		
		assertEquals(0,Rules.playerWinSetWithTB(lastGame_1));	
	}
	
			
	@Test
	public void testPlayerWinSet() {
		TennisMatch lastGame = new TennisMatch (10, 60, 6, 0, 0, 4, 0, 0);		
		assertEquals(1,Rules.playerWinSet(lastGame));		
		
		TennisMatch lastGame_ = new TennisMatch (10, 60, 4, 0, 0, 6, 0, 0);		
		assertEquals(2,Rules.playerWinSetWithTB(lastGame_));
		
		TennisMatch lastGame_1 = new TennisMatch (10, 60, 7, 0, 0, 6, 0, 0);		
		assertEquals(1,Rules.playerWinSetWithTB(lastGame_1));	
		
		TennisMatch lastGame_2 = new TennisMatch (13, 78, 6, 0, 0, 7, 0, 0);		
		assertEquals(2,Rules.playerWinSet(lastGame_2));					
	}
	
	@Test
	public void testPlayerWinSetTB() {
				
		TennisMatch lastGame = new TennisMatch (13, 78, 6, 0, 6, 6, 0, 5);		
		assertEquals(1,Rules.playerWinSetWithTB(lastGame));	
		
		TennisMatch lastGame_ = new TennisMatch (13, 78, 6, 0, 5, 6, 0, 6);		
		assertEquals(2,Rules.playerWinSetWithTB(lastGame_));	
	}
	
		
	
	
}
