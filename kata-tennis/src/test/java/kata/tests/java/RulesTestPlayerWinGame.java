package kata.tests.java;

import static org.junit.Assert.*;

import org.junit.Test;

import kata.dev.java.bean.TennisMatch;
import kata.dev.java.rules.Rules;

public class RulesTestPlayerWinGame {


	@Test
	public void testAddPlay() {
		
		TennisMatch play = new TennisMatch (1, 0, 0, 0, 0, 0, 0, 0);
		
		assertEquals(1,Rules.addPlayDEUCE(1, play).getPlay().getIdGame());
		assertEquals(1,Rules.addPlayDEUCE(1, play).getPlay().getIdGame());
		assertEquals(0,Rules.addPlayDEUCE(1, play).getPlay().getGameScore_1());
		assertEquals(15,Rules.addPlayDEUCE(1, play).getPlay().getPlayScore_1());
		assertEquals(1,Rules.addPlayDEUCE(1, play).getPlay().getPlayPoint_1());
		assertEquals(0,Rules.addPlayDEUCE(1, play).getPlay().getGameScore_2());
		assertEquals(0,Rules.addPlayDEUCE(1, play).getPlay().getPlayScore_2());
		assertEquals(0,Rules.addPlayDEUCE(1, play).getPlay().getPlayPoint_2());
		
		assertEquals(1,Rules.addPlayDEUCE(2, play).getPlay().getIdGame());
		assertEquals(1,Rules.addPlayDEUCE(2, play).getPlay().getIdGame());
		assertEquals(0,Rules.addPlayDEUCE(2, play).getPlay().getGameScore_1());
		assertEquals(0,Rules.addPlayDEUCE(2, play).getPlay().getPlayScore_1());
		assertEquals(0,Rules.addPlayDEUCE(2, play).getPlay().getPlayPoint_1());
		assertEquals(0,Rules.addPlayDEUCE(2, play).getPlay().getGameScore_2());
		assertEquals(15,Rules.addPlayDEUCE(2, play).getPlay().getPlayScore_2());
		assertEquals(1,Rules.addPlayDEUCE(2, play).getPlay().getPlayPoint_2());		
		
	}	
	
	@Test
	public void testAddPlay_() {
		
		assertEquals(1,Rules.addPlay(1, new TennisMatch (1, 3, 6, 40, 3, 2, 30, 2)).getWinner());
		
		assertEquals(2,Rules.addPlay(2, new TennisMatch (1, 3, 6, 30, 3, 2, 40, 3)).getWinner());
	}
	
	

	@Test
	public void testAddPlayDEUCEMode() {		
		
		assertEquals(42,Rules.addPlayDEUCE(1, new TennisMatch (1, 6, 0, 40, 3, 0, 40, 3)).getPlay().getPlayScore_1());
		assertEquals(41,Rules.addPlayDEUCE(2, new TennisMatch (1, 7, 0, 42, 4, 0, 40, 3)).getPlay().getPlayScore_1());	
		assertEquals(42,Rules.addPlayDEUCE(1, new TennisMatch (1, 8, 0, 41, 4, 0, 41, 4)).getPlay().getPlayScore_1());
		assertEquals(1,Rules.addPlayDEUCE(1, new TennisMatch (1, 9, 0, 42, 3, 0, 40, 3)).getWinner());
		
		assertEquals(40,Rules.addPlayDEUCE(1, new TennisMatch (1, 6, 0, 41, 3, 0, 41, 3)).getPlay().getPlayScore_2());	
	}	

	
	@Test
	public void testAddPlayTieBreak() {
		
		assertEquals(0,Rules.addPlayDEUCE(1, new TennisMatch (1, 1, 6, 0, 0, 6, 0, 0)).getWinner());
		
		assertEquals(0,Rules.addPlayDEUCE(1, new TennisMatch (1, 1, 6, 0, 4, 6, 0, 6)).getWinner());
		
		assertEquals(1,Rules.addPlayDEUCE(1, new TennisMatch (1, 1, 6, 0, 6, 6, 0, 5)).getWinner());
		
		assertEquals(0,Rules.addPlayDEUCE(2, new TennisMatch (1, 1, 6, 0, 15, 6, 0, 15)).getWinner());
		
		assertEquals(2,Rules.addPlayDEUCE(2, new TennisMatch (1, 1, 6, 0, 15, 6, 0, 16)).getWinner());
		
	}
}
