package kata.dev.java.rules;



import kata.dev.java.bean.TennisMatch;


public class Rules {

	public static int playerWinSet(TennisMatch lastGame){
		int winner = 0;
		
		if ((lastGame.getGameScore_1() == 6 && lastGame.getGameScore_2() < 5) || lastGame.getGameScore_1() == 7)
			winner = 1;
		
		else if ((lastGame.getGameScore_2() == 6 && lastGame.getGameScore_1() < 5) || lastGame.getGameScore_2() == 7) 
			winner = 2;
				
		return winner;
	}
	
	//Tie Break mode
	public static int playerWinSetWithTB(TennisMatch lastPlay){
		int winner = 0;
		
		if (lastPlay.getGameScore_1() < 6 && lastPlay.getGameScore_2() < 6 )
			return winner;
		
		else if ((lastPlay.getGameScore_1() == 6 && lastPlay.getGameScore_2() < 5) || lastPlay.getGameScore_1() == 7)
			winner = 1;
		
		else if ((lastPlay.getGameScore_2() == 6 && lastPlay.getGameScore_1() < 5) || lastPlay.getGameScore_2() == 7) 
			winner = 2;			
		
		else if (lastPlay.getGameScore_1() == 6 && lastPlay.getGameScore_2() == 6 ){
			
			 if ((lastPlay.getPlayPoint_1() - lastPlay.getPlayPoint_2() >= 1) && lastPlay.getPlayPoint_1() > 6) 
				winner = 1;
			
			else if ((lastPlay.getPlayPoint_2() - lastPlay.getPlayPoint_1() >= 1) && lastPlay.getPlayPoint_2() > 6)
				winner = 2;			
		}
		
		return winner;
	}
	
			
	public static Play addPlay(int playerId, TennisMatch g){
		Play play = new Play();
		play.setWinner(0);
		
		
		if(playerId == 1){	
						
			if( scoreAdd(g.getPlayScore_1()) == 45){
				play.setWinner(1);
				play.newPlay(g.getIdGame()+1, g.getIdPlay()+1, g.getGameScore_1()+1, 0, 0, g.getGameScore_2(), 0, 0);
			}
			else
				play.newPlay(g.getIdGame(), g.getIdPlay()+1, g.getGameScore_1(), scoreAdd(g.getPlayScore_1()), g.getPlayPoint_1()+1, g.getGameScore_2(), g.getPlayScore_2(), g.getPlayPoint_2());
		}
		
		else if(playerId == 2){
			
			if(scoreAdd(g.getPlayScore_2()) == 45){
				play.setWinner(2);
				play. newPlay(g.getIdGame()+1, g.getIdPlay()+1, g.getGameScore_1(), 0, 0, g.getGameScore_2()+1, 0, 0);
			}				
			else
				play. newPlay(g.getIdGame(), g.getIdPlay()+1, g.getGameScore_1(),  g.getPlayScore_1(), g.getPlayPoint_1(), g.getGameScore_2(), scoreAdd(g.getPlayScore_2()), g.getPlayPoint_2()+1);
		}
		
		return play;		
	}
	
	public static Play addPlayDEUCE(int playerId, TennisMatch g){
		Play play = new Play();
		play.setWinner(0);
		//Tie Break
		if(g.getGameScore_1() == 6 && g.getGameScore_2() == 6){
			if(playerId == 1){
				if( g.getPlayPoint_1() - g.getPlayPoint_2() == 1 ){
					play.setWinner(1);
					play.newPlay(g.getIdGame(), g.getIdPlay()+1, g.getGameScore_1(), 0, g.getPlayPoint_1()+1, g.getGameScore_2(), 0, g.getPlayPoint_2());
				}
					
				else
					play.newPlay(g.getIdGame(), g.getIdPlay()+1, g.getGameScore_1(), 0, g.getPlayPoint_1()+1, g.getGameScore_2(), 0, g.getPlayPoint_2());
			}
			
			if(playerId == 2){
				if( g.getPlayPoint_2() - g.getPlayPoint_1() == 1 ){
					play.setWinner(2);
					play.newPlay(g.getIdGame(), g.getIdPlay()+1, g.getGameScore_1(), 0, 0, g.getGameScore_2(), 0, g.getPlayPoint_2()+1);
				}
				else
					play.newPlay(g.getIdGame(), g.getIdPlay()+1, g.getGameScore_1(), 0, g.getPlayPoint_1(), g.getGameScore_2(), 0, g.getPlayPoint_2()+1);
			}
		}
		
		else{
			
			if(playerId == 1){	
				
				if( scoreAdd(g.getPlayScore_1()) == 45 && g.getPlayScore_2() < 40){
					play.setWinner(1);
					play.newPlay(g.getIdGame()+1, g.getIdPlay()+1, g.getGameScore_1()+1, 0, 0, g.getGameScore_2(), 0, 0);
				}
				
				else if(g.getPlayScore_1() == 40 && g.getPlayScore_2() == 40)
					play.newPlay(g.getIdGame(), g.getIdPlay()+1, g.getGameScore_1(), g.getPlayScore_1()+2, g.getPlayPoint_1(), g.getGameScore_2(), g.getPlayScore_2(), g.getPlayPoint_2());
				
				else if(g.getPlayScore_1() == 40 && g.getPlayScore_2() == 42)
					play.newPlay(g.getIdGame(), g.getIdPlay()+1, g.getGameScore_1(), 41, g.getPlayPoint_1(), g.getGameScore_2(), 41, g.getPlayPoint_2());
				
				else if(g.getPlayScore_1() == 41 )
					play.newPlay(g.getIdGame(), g.getIdPlay()+1, g.getGameScore_1(), 42, g.getPlayPoint_1(), g.getGameScore_2(), 40, g.getPlayPoint_2());
				
				else if( g.getPlayScore_1() == 42){
					play.setWinner(1);
					play.newPlay(g.getIdGame()+1, g.getIdPlay()+1, g.getGameScore_1()+1, 0, 0, g.getGameScore_2(), 0, 0);
				}
				
				else
					play.newPlay(g.getIdGame(), g.getIdPlay()+1, g.getGameScore_1(), scoreAdd(g.getPlayScore_1()), g.getPlayPoint_1()+1, g.getGameScore_2(), g.getPlayScore_2(), g.getPlayPoint_2());
			}
			
			else if(playerId == 2){	
							
				if( scoreAdd(g.getPlayScore_2()) == 45 && g.getPlayScore_1() < 40){
					play.setWinner(2);
					play.newPlay(g.getIdGame()+1, g.getIdPlay()+1, g.getGameScore_1(), 0, 0, g.getGameScore_2()+1, 0, 0);
				}
				
				else if(g.getPlayScore_1() == 40 && g.getPlayScore_2() == 40)
					play.newPlay(g.getIdGame(), g.getIdPlay()+1, g.getGameScore_1(), g.getPlayScore_1(), g.getPlayPoint_1(), g.getGameScore_2(), g.getPlayScore_2()+2, g.getPlayPoint_2());
				
				else if(g.getPlayScore_2() == 40 && g.getPlayScore_1() == 42)
					play.newPlay(g.getIdGame(), g.getIdPlay()+1, g.getGameScore_1(), 41, g.getPlayPoint_1(), g.getGameScore_2(), 41, g.getPlayPoint_2());
				
				else if(g.getPlayScore_2() == 41 )
					play.newPlay(g.getIdGame(), g.getIdPlay()+1, g.getGameScore_1(), 40, g.getPlayPoint_1(), g.getGameScore_2(), 42, g.getPlayPoint_2());
				
				else if( g.getPlayScore_2() == 42){
					play.setWinner(2);
					play.newPlay(g.getIdGame()+1, g.getIdPlay()+1, g.getGameScore_1(), 0, 0, g.getGameScore_2()+1, 0, 0);
				}
				
				else
					play. newPlay(g.getIdGame(), g.getIdPlay()+1, g.getGameScore_1(),  g.getPlayScore_1(), g.getPlayPoint_1(), g.getGameScore_2(), scoreAdd(g.getPlayScore_2()), g.getPlayPoint_2()+1);
				}
		}
		
		return play;		
	}
	
	
	public static int scoreAdd(int playScore){
		
		switch (playScore){
		
		case 0:
			playScore +=15;
			break;
		case 15:
			playScore +=15;
			break;
		case 30:
			playScore +=10;
			break;
		case 40:
			playScore +=5;
			break;		
		default:
			break;		
		}	
		
		return playScore;
	}		
	
}

	

