package kata.dev.java.dao;

import java.util.List;

import kata.dev.java.bean.TennisGame;

public interface ITennisGameDAO {

	List<TennisGame> getAllTennisGame();
	
	public List<TennisGame> searchTennisGameBySetIdDAO( int setId);
	
	void createGameDAO(final TennisGame pTennisGame);
	
	void deleteLastGameDAO(final TennisGame pTennisGame);
}
