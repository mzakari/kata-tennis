package kata.dev.java.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kata.dev.java.bean.TennisMatch;
import kata.dev.java.dao.ITennisGameDAO;


@Service
public class ServiceListeTennisGame implements IServiceTennisGame {
	 @Autowired
	  private ITennisGameDAO dao;
	 
	 @Transactional(readOnly=true)
	public List<TennisMatch> getAllTennisPlayService() {
		// TODO Auto-generated method stub
		return dao.getAllTennisPlayDAO();
	}
	 
	 @Transactional
	public void createPlayService(final TennisMatch game) {
		// TODO Auto-generated method stub	
			dao.addPlayDAO(game);
	}

	 @Transactional
	public List<TennisMatch> searchTennisPlayBySetIdService(int setId) {
		// TODO Auto-generated method stub
		return dao.searchTennisPlayBySetIdDAO(setId);
	}

	 @Transactional
	public void deleteLastPlayService(final Integer idGame) {
		// TODO Auto-generated method stub
		 TennisMatch temp = new TennisMatch();
		 temp.setIdPlay(idGame);
		dao.deleteLastPlayDAO(temp);
	}

	 @Transactional
	public void deleteAllPlayService() {
		// TODO Auto-generated method stub
		dao.deleteAllPlayDAO();
	}

	 @Transactional
	public List<Object[]> getAllTennisGameService() {
		// TODO Auto-generated method stub
		return dao.getAllTennisGameDAO();
	}
	


}
