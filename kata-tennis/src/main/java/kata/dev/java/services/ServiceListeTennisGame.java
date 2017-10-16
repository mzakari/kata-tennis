package kata.dev.java.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kata.dev.java.bean.TennisGame;
import kata.dev.java.dao.ITennisGameDAO;

@Service
public class ServiceListeTennisGame implements IServiceTennisGame {
	 @Autowired
	  private ITennisGameDAO dao;
	 
	 @Transactional(readOnly=true)
	public List<TennisGame> getAllTennisGame() {
		// TODO Auto-generated method stub
		return dao.getAllTennisGame();
	}
	 
	 @Transactional
	public void createGameService(final TennisGame game) {
		// TODO Auto-generated method stub
		/* final TennisGame g = new TennisGame();
			
			g.setIdSet(idSet);
			g.setIdGame(idGame);
			
			g.setSetScore_1(setScore_1);			
			g.setGamePoint_1(gamePoint_1);
			g.setGameScore_1(gameScore_1);
			
			g.setSetScore_2(setScore_2);
			g.setGamePoint_2(gamePoint_2);
			g.setGameScore_2(gameScore_2);*/		
			
			
			dao.createGameDAO(game);
	}

	 @Transactional
	public List<TennisGame> searchTennisGameBySetIdService(int setId) {
		// TODO Auto-generated method stub
		return dao.searchTennisGameBySetIdDAO(setId);
	}

	 @Transactional
	public void deleteLastGameService(final Integer idGame) {
		// TODO Auto-generated method stub
		 TennisGame temp = new TennisGame();
		 temp.setIdGame(idGame);
		dao.deleteLastGameDAO(temp);
	}
	


}
