package kata.dev.java.rules;


import java.util.List;

import kata.dev.java.bean.TennisGame;


public class Rules {
		
	public static TennisGame addGame(int playerId, TennisGame g){
		TennisGame game = (TennisGame)g.clone();
		
		if(playerId==1){
			game.setIdSet(game.getIdSet());
			game.setIdGame(game.getIdGame()+1);
			
			game.setSetScore_1(game.getSetScore_1());
			game.setGamePoint_1(game.getGamePoint_1()+1);
			
			game.setGamePoint_2(game.getGamePoint_2());
			game.setGameScore_2(game.getGameScore_2());
			game.setSetScore_2(game.getSetScore_2());					
						
			switch (game.getGameScore_1()){
			
			case 0:
				game.setGameScore_1(game.getGameScore_1()+15);
				break;
			case 15:
				game.setGameScore_1(game.getGameScore_1()+15);
				break;
			case 30:
				game.setGameScore_1(game.getGameScore_1()+10);
				break;
			default:
				break;		
			}
		}
		
		else if(playerId==2){
			game.setIdSet(game.getIdSet());
			game.setIdGame(game.getIdGame()+1);
			
			game.setSetScore_1(game.getSetScore_1());
			game.setGamePoint_1(game.getGamePoint_1());
			game.setGameScore_1(game.getGameScore_1());			
			
			game.setSetScore_2(game.getSetScore_2());	
			game.setGamePoint_2(game.getGamePoint_2()+1);			
			
			switch (game.getGameScore_2()){
			
			case 0:
				game.setGameScore_2(game.getGameScore_2()+15);
				break;
			case 15:
				game.setGameScore_2(game.getGameScore_2()+15);
				break;
			case 30:
				game.setGameScore_2(game.getGameScore_2()+10);
				break;
			default:				
				break;		
			}			
		}			
		return game;		
	}
	
	
	public static Winner playerWinSet(List<TennisGame> set){
		
		Winner playerWin = new Winner();
		playerWin.setWinner(0);
		playerWin.beginNewSet(0, 0, 0, 0, 0, 0, 0, 0);
		
		int newSetId = set.get(set.size()-1).getIdSet()+1;
		int newGameId = set.get(set.size()-1).getIdGame()+1;
		
		int setOldScore1 = set.get(set.size()-1).getSetScore_1();
		int setNewScore1 = setOldScore1+1;
		
		int setOldScore2 = set.get(set.size()-1).getSetScore_2();
		int setNewScore2 = setOldScore2+1;				
		
		if(set.size() < 7)
			return playerWin;
		
		else{
			if((set.get(set.size()-1).getGamePoint_1() > set.get(set.size()-1).getGamePoint_2()) && set.get(set.size()-1).getGameScore_2() < 40 ){
				playerWin.setWinner(1);	
				playerWin.beginNewSet(newSetId, newGameId, setNewScore1, 0, 0, setOldScore2, 0, 0);
			}
							
			
			else if((set.get(set.size()-1).getGamePoint_1() < set.get(set.size()-1).getGamePoint_2()) && set.get(set.size()-1).getGameScore_1() < 40 ){
				playerWin.setWinner(2);	
				playerWin.beginNewSet(newSetId, newGameId, setOldScore1, 0, 0, setNewScore2, 0, 0);
			}
							
			
			else if(set.get(set.size()-1).getGameScore_2() == 40 && set.get(set.size()-1).getGameScore_1() == 40 ){
				
				if(set.get(set.size()-1).getGamePoint_1() - set.get(set.size()-1).getGamePoint_2() == 2){
					playerWin.setWinner(1);
					playerWin.beginNewSet(newSetId, newGameId, setNewScore1, 0, 0, setOldScore2, 0, 0);
				}
					
				
				else if(set.get(set.size()-1).getGamePoint_2() - set.get(set.size()-1).getGamePoint_1() == 2){
					playerWin.setWinner(2);	
					playerWin.beginNewSet(newSetId, newGameId, setOldScore1, 0, 0, setNewScore2, 0, 0);
				}						
			}	
		}		
		return playerWin;		
	}
	
	
	public static int playerWinChallenge(TennisGame lastGame){
		int winner = 0;
		
		if ((lastGame.getSetScore_1() == 6 && lastGame.getSetScore_2() < 5) || lastGame.getSetScore_1() == 7)
			winner = 1;
		
		else if ((lastGame.getSetScore_2() == 6 && lastGame.getSetScore_1() < 5) || lastGame.getSetScore_2() == 7) 
			winner = 2;
				
		return winner;
	}
	
	//Tie Break mode
	public static int playerWinChallengeWithTB(TennisGame lastGame){
		int winner = 0;
		
		if (lastGame.getSetScore_1() == 6 && lastGame.getSetScore_2() < 5)
			winner = 1;
		
		else if (lastGame.getSetScore_2() == 6 && lastGame.getSetScore_1() < 5) 
			winner = 2;
		
		else if (lastGame.getSetScore_1() == 7 && lastGame.getSetScore_2() == 5) 
			winner = 1;
		
		else if (lastGame.getSetScore_2() == 7 && lastGame.getSetScore_1() == 5)
			winner = 2;
		
		else if (lastGame.getSetScore_1() > 7 && (lastGame.getSetScore_1() - lastGame.getSetScore_2() == 2)) 
			winner = 1;
		
		else if (lastGame.getSetScore_2() > 7 && (lastGame.getSetScore_2() - lastGame.getSetScore_1() == 2))
			winner = 2;
		
		return winner;
	}
}

	

