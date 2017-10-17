package kata.dev.java.rules;

import kata.dev.java.bean.TennisMatch;

public class Play {
	private TennisMatch gPlay;
	private int winner;
	
	public TennisMatch getPlay() {
		return gPlay;
	}
	
	public void setNewPlay(TennisMatch newGame) {
		this.gPlay = (TennisMatch)newGame.clone();
	}
	public int getWinner() {
		return winner;
	}
	public void setWinner(int winner) {
		this.winner = winner;
	}
		
	
	public void newPlay(int idSet,int idGame,int setScore_1,int gameScore_1,int gamePoint_1, int setScore_2, int gameScore_2, int gamePoint_2) {		
		gPlay = new TennisMatch();	
		
		gPlay.setIdGame(idSet);
		gPlay.setIdPlay(idGame);
		
		gPlay.setPlayPoint_1(gamePoint_1);
		gPlay.setPlayScore_1(gameScore_1);
		gPlay.setGameScore_1(setScore_1);
		
		gPlay.setPlayPoint_2(gamePoint_2);
		gPlay.setPlayScore_2(gameScore_2);
		gPlay.setGameScore_2(setScore_2);			
		
	}

}
