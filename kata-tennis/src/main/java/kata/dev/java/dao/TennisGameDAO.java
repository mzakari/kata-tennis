package kata.dev.java.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import org.springframework.stereotype.Repository;

import kata.dev.java.bean.TennisGame;

@Repository
public class TennisGameDAO implements ITennisGameDAO {

	@PersistenceContext
	private EntityManager entityManager;
	 
	public List<TennisGame> getAllTennisGame() {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<TennisGame> lCriteriaQuery = lCriteriaBuilder.createQuery(TennisGame.class);
        final Root<TennisGame> lRoot = lCriteriaQuery.from(TennisGame.class);
        lCriteriaQuery.select(lRoot);
        final TypedQuery<TennisGame> lTypedQuery = entityManager.createQuery(lCriteriaQuery);

        return lTypedQuery.getResultList();
	}

	public void createGameDAO(final TennisGame pTennisGame) {
		// TODO Auto-generated method stub
		entityManager.persist(pTennisGame);
	}

	public List<TennisGame> searchTennisGameBySetIdDAO(int setId) {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<TennisGame> lCriteriaQuery = lCriteriaBuilder.createQuery(TennisGame.class);
        
        final Root<TennisGame> lRoot = lCriteriaQuery.from(TennisGame.class);
        lCriteriaQuery.where(lCriteriaBuilder.equal(lRoot.get("idSet"), setId));
        
        lCriteriaQuery.select(lRoot);
        final TypedQuery<TennisGame> lTypedQuery = entityManager.createQuery(lCriteriaQuery);

        return lTypedQuery.getResultList();
	}

	public void deleteLastGameDAO(final TennisGame pTennisGame) {
		 final TennisGame temp = entityManager.getReference(TennisGame.class, pTennisGame.getIdGame());
	        entityManager.remove(temp);	        
	}

}
