package kata.dev.java.services;

import java.util.List;

import kata.dev.java.bean.TennisGame;

public interface IServiceTennisGame {
	
	List<TennisGame> getAllTennisGame();
	
	public List<TennisGame> searchTennisGameBySetIdService( int setId);
	
	void createGameService(final TennisGame game);
	
	void deleteLastGameService( final Integer gameId);
}
