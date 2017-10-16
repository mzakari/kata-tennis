package kata.tests.java;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import kata.dev.java.bean.TennisGame;
import kata.dev.java.rules.Rules;

public class RulesTestPlayerWinSet {	
			
	@Test
	public void testNoWinner() {
		List<TennisGame> set =  new ArrayList <TennisGame>();
		set.add(new TennisGame (1, 0, 0, 15, 1, 0, 0, 0));
		set.add(new TennisGame (1, 1, 0, 30, 2, 0, 0, 0));
		set.add(new TennisGame (1, 2, 0, 40, 3, 0, 0, 0));
		set.add(new TennisGame (1, 3, 0, 40, 4, 0, 0, 0));
		set.add(new TennisGame (1, 4, 0, 40, 5, 0, 0, 0));
		
		assertEquals(0,Rules.playerWinSet(set).getWinner());
		assertEquals(0,Rules.playerWinSet(set).getNewGame().getSetScore_1());
		assertEquals(0,Rules.playerWinSet(set).getNewGame().getSetScore_2());
		
	}

	@Test
	public void testPlayer1WinSet() {
		List<TennisGame> set =  new ArrayList <TennisGame>();
		set.add(new TennisGame (1, 0, 0, 0, 0, 0, 0, 0));
		set.add(new TennisGame (1, 1, 0, 15, 1, 0, 0, 0));
		set.add(new TennisGame (1, 2, 0, 30, 2, 0, 0, 0));
		set.add(new TennisGame (1, 3, 0, 40, 3, 0, 0, 0));
		set.add(new TennisGame (1, 4, 0, 40, 4, 0, 0, 0));
		set.add(new TennisGame (1, 5, 0, 40, 5, 0, 0, 0));
		set.add(new TennisGame (1, 6, 0, 40, 6, 0, 0, 0));
		
		assertEquals(1, Rules.playerWinSet(set).getWinner());
		assertEquals(1,Rules.playerWinSet(set).getNewGame().getSetScore_1());
		assertEquals(0,Rules.playerWinSet(set).getNewGame().getSetScore_2());
		
	}
	
	@Test
	public void testPlayer2WinSet() {
		List<TennisGame> set =  new ArrayList <TennisGame>();
		set.add(new TennisGame (1, 0, 0, 0, 0, 0, 0, 0));
		set.add(new TennisGame (1, 1, 0, 0, 0, 0, 15, 1));
		set.add(new TennisGame (1, 2, 0, 0, 0, 0, 30, 2));
		set.add(new TennisGame (1, 3, 0, 0, 0, 0, 40, 3));
		set.add(new TennisGame (1, 4, 0, 15, 1, 0, 40, 3));
		set.add(new TennisGame (1, 5, 0, 30, 2, 0, 40, 3));
		set.add(new TennisGame (1, 6, 0, 30, 2, 0, 40, 4));
				
		assertEquals(2, Rules.playerWinSet(set).getWinner());
		assertEquals(0,Rules.playerWinSet(set).getNewGame().getSetScore_1());
		assertEquals(1,Rules.playerWinSet(set).getNewGame().getSetScore_2());
	}
	
	@Test
	public void testDEUCEMode() {
		List<TennisGame> set =  new ArrayList <TennisGame>();
		set.add(new TennisGame (1, 0, 0, 0, 0, 0, 0, 0));
		set.add(new TennisGame (1, 1, 0, 0, 0, 0, 15, 1));
		set.add(new TennisGame (1, 2, 0, 0, 0, 0, 30, 2));
		set.add(new TennisGame (1, 3, 0, 0, 0, 0, 40, 3));
		set.add(new TennisGame (1, 4, 0, 15, 1, 0, 40, 3));
		set.add(new TennisGame (1, 5, 0, 30, 2, 0, 40, 3));
		set.add(new TennisGame (1, 6, 0, 40, 3, 0, 40, 3));
		set.add(new TennisGame (1, 7, 0, 40, 4, 0, 40, 3));
				
		assertEquals(0, Rules.playerWinSet(set).getWinner());	
		assertEquals(0,Rules.playerWinSet(set).getNewGame().getSetScore_1());
		assertEquals(0,Rules.playerWinSet(set).getNewGame().getSetScore_2());		
		
	}
}
