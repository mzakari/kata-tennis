package kata.tests.java;

import static org.junit.Assert.*;

import org.junit.Test;

import kata.dev.java.bean.TennisGame;
import kata.dev.java.rules.Rules;

public class RulesTestPlayerWinGame {

	@Test
	public void testAddGame() {
		
		TennisGame game = new TennisGame (1, 0, 0, 0, 0, 0, 0, 0);
		assertEquals(1,Rules.addGame(1, game).getIdGame());
		assertEquals(1,Rules.addGame(1, game).getIdSet());
		
		assertEquals(1,Rules.addGame(1, game).getGamePoint_1());
		assertEquals(15,Rules.addGame(1, game).getGameScore_1());
		assertEquals(0,Rules.addGame(1, game).getSetScore_1());
		
		assertEquals(0,Rules.addGame(1, game).getGamePoint_2());		
		assertEquals(0,Rules.addGame(1, game).getGameScore_2());
		assertEquals(0,Rules.addGame(1, game).getSetScore_2());	
		
	}

	@Test
	public void testPlayerWinGameFisrt() {		
		
		TennisGame game = new TennisGame (1, 1, 0, 0, 0, 0, 0, 0);
		
		assertEquals(15, Rules.addGame(1, game).getGameScore_1());
		assertEquals(1, Rules.addGame(1, game).getGamePoint_1());
	}
	
	@Test
	public void testPlayerWinGameSecond() {		
		
		TennisGame game = new TennisGame (1, 1, 0, 15, 1, 0, 0, 0);
		
		assertEquals(30, Rules.addGame(1, game).getGameScore_1());
		assertEquals(2, Rules.addGame(1, game).getGamePoint_1());
	}
	
	@Test
	public void testPlayerWinGameThird() {		
		
		TennisGame game = new TennisGame (1, 1, 0, 15, 0, 0, 30, 2);
		
		assertEquals(40, Rules.addGame(2, game).getGameScore_2());
		assertEquals(3, Rules.addGame(2, game).getGamePoint_2());
	
	}
	
	@Test
	public void testPlayerWinGameFourthAndMore() {		
	
		TennisGame game = new TennisGame (1, 1, 0, 15, 0, 0, 40, 5);
		
		assertEquals(40, Rules.addGame(2, game).getGameScore_2());
		assertEquals(6, Rules.addGame(2, game).getGamePoint_2());
	}

}
