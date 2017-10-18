package kata.dev.java.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import org.springframework.stereotype.Repository;

import kata.dev.java.bean.TennisMatch;


@Repository
public class TennisMatchDAO implements ITennisMatchDAO {

	@PersistenceContext
	private EntityManager entityManager;
	 
	public List<TennisMatch> getAllTennisPlayDAO() {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<TennisMatch> lCriteriaQuery = lCriteriaBuilder.createQuery(TennisMatch.class);
        final Root<TennisMatch> lRoot = lCriteriaQuery.from(TennisMatch.class);
        lCriteriaQuery.select(lRoot);
        final TypedQuery<TennisMatch> lTypedQuery = entityManager.createQuery(lCriteriaQuery);

        return lTypedQuery.getResultList();
	}

	public void addPlayDAO(final TennisMatch pTennisGame) {
		// TODO Auto-generated method stub
		entityManager.persist(pTennisGame);
	}

	public List<TennisMatch> searchTennisPlayBySetIdDAO(int setId) {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<TennisMatch> lCriteriaQuery = lCriteriaBuilder.createQuery(TennisMatch.class);
        
        final Root<TennisMatch> lRoot = lCriteriaQuery.from(TennisMatch.class);
        lCriteriaQuery.where(lCriteriaBuilder.equal(lRoot.get("idSet"), setId));
        
        lCriteriaQuery.select(lRoot);
        final TypedQuery<TennisMatch> lTypedQuery = entityManager.createQuery(lCriteriaQuery);

        return lTypedQuery.getResultList();
	}

	public void deleteLastPlayDAO(final TennisMatch pTennisGame) {
		 final TennisMatch temp = entityManager.getReference(TennisMatch.class, pTennisGame.getIdPlay());
	        entityManager.remove(temp);	        
	}

	public void deleteAllPlayDAO() {
				
		Query query = entityManager.createQuery("DELETE FROM TennisMatch t WHERE t.idPlay > ?");
		query.setParameter(1, 0).executeUpdate();
	}

	public List<Object[]> getAllTennisGameDAO() {
		
		TypedQuery<Object[]> query =
			entityManager.createQuery("SELECT DISTINCT t.idGame, t.gameScore_1, t.gameScore_2 FROM TennisMatch t WHERE t.idGame > 1", Object[].class);			  
			  
			  return query.getResultList();
	}

}
