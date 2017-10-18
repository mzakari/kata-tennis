package kata.dev.java.dao;

import java.util.List;

import kata.dev.java.bean.TennisMatch;


public interface ITennisMatchDAO {

	List<TennisMatch> getAllTennisPlayDAO();
	
	List<Object[]> getAllTennisGameDAO();
	
	public List<TennisMatch> searchTennisPlayBySetIdDAO( int setId);
	
	void addPlayDAO(final TennisMatch pTennisGame);
	
	void deleteLastPlayDAO(final TennisMatch pTennisGame);
	
	void deleteAllPlayDAO();
}
