package kata.dev.java.rules;

import kata.dev.java.bean.TennisGame;

public class Winner {
	private TennisGame newGame;
	private int winner;
	
	public TennisGame getNewGame() {
		return newGame;
	}
	public void setNewGame(TennisGame newGame) {
		this.newGame = (TennisGame)newGame.clone();
	}
	public int getWinner() {
		return winner;
	}
	public void setWinner(int winner) {
		this.winner = winner;
	}
	
	public void beginNewSet(int idSet,int idGame,int setScore_1,int gameScore_1,int gamePoint_1, int setScore_2, int gameScore_2, int gamePoint_2) {		
		newGame = new TennisGame();	
		
		newGame.setIdSet(idSet);
		newGame.setIdGame(idGame);
		
		newGame.setGamePoint_1(gamePoint_1);
		newGame.setGameScore_1(gameScore_1);
		newGame.setSetScore_1(setScore_1);
		
		newGame.setGamePoint_2(gamePoint_2);
		newGame.setGameScore_2(gameScore_2);
		newGame.setSetScore_2(setScore_2);			
		
	}

}
