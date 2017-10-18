package kata.dev.java.services;

import java.util.List;

import kata.dev.java.bean.TennisMatch;

public interface IServiceTennisMatch {
	
	List<TennisMatch> getAllTennisPlayService();
	
	public List<Object[]> getAllTennisGameService();
	
	public List<TennisMatch> searchTennisPlayBySetIdService( int setId);
	
	void createPlayService(final TennisMatch game);
	
	void deleteLastPlayService( final Integer gameId);
	
	void deleteAllPlayService();
}
