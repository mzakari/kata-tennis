package kata.tests.java;

import static org.junit.Assert.*;

import org.junit.Test;

import kata.dev.java.bean.TennisGame;
import kata.dev.java.rules.Rules;

public class RulesTestPlayerWinChallenge {
	
	@Test
	public void testChallengeNoWinner() {
		TennisGame lastGame = new TennisGame (3, 18, 3, 0, 0, 0, 0, 0);
		
		assertEquals(0,Rules.playerWinChallenge(lastGame));		
	}
	
	@Test
	public void testChallengeNoWinner_() {
		TennisGame lastGame = new TennisGame (10, 60, 6, 0, 0, 6, 0, 0);
		
		assertEquals(0,Rules.playerWinChallenge(lastGame));		
	}

	@Test
	public void testChallengeNoWinner2() {
		TennisGame lastGame = new TennisGame (11, 66, 5, 0, 0, 6, 0, 0);
		
		assertEquals(0,Rules.playerWinChallenge(lastGame));		
	}
	
	@Test
	public void testPlayer1WinChallenge() {
		TennisGame lastGame = new TennisGame (10, 60, 6, 0, 0, 4, 0, 0);
		
		assertEquals(1,Rules.playerWinChallenge(lastGame));		
	}
	
	@Test
	public void testPlayer1WinChallenge_() {
		TennisGame lastGame = new TennisGame (10, 60, 7, 0, 0, 6, 0, 0);
		
		assertEquals(1,Rules.playerWinChallenge(lastGame));		
	}
	
	@Test
	public void testPlayer2WinChallenge() {
		TennisGame lastGame = new TennisGame (10, 60, 4, 0, 0, 6, 0, 0);
		
		assertEquals(2,Rules.playerWinChallenge(lastGame));		
	}
	
	@Test
	public void testPlayer2WinChallenge_() {
		TennisGame lastGame = new TennisGame (13, 78, 6, 0, 0, 7, 0, 0);
		
		assertEquals(2,Rules.playerWinChallenge(lastGame));		
	}
	
	@Test
	public void testTieBreakMode() {
		TennisGame lastGame = new TennisGame (12, 97, 6, 0, 0, 6, 0, 0);
		
		assertEquals(0,Rules.playerWinChallengeWithTB(lastGame));
		
	}
	
	@Test
	public void testChallengeNoWinnerTieBreakMode() {
		TennisGame lastGame = new TennisGame (13, 78, 6, 0, 0, 7, 0, 0);		
		assertEquals(0,Rules.playerWinChallengeWithTB(lastGame));		
		
		TennisGame lastGame_ = new TennisGame (13, 78, 7, 0, 0, 6, 0, 0);		
		assertEquals(0,Rules.playerWinChallengeWithTB(lastGame_));	
	}
	
	@Test
	public void testPlayerWinChallengeTieBreakMode() {
		TennisGame lastGame = new TennisGame (14, 84, 8, 0, 0, 6, 0, 0);		
		assertEquals(1,Rules.playerWinChallengeWithTB(lastGame));		
		
		TennisGame lastGame_ = new TennisGame (20, 120, 9, 0, 0, 11, 0, 0);		
		assertEquals(2,Rules.playerWinChallengeWithTB(lastGame_));	
	}

}
