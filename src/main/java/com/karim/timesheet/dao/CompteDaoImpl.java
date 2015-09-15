package com.karim.timesheet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.karim.timesheet.model.Compte;
import com.karim.timesheet.model.User;

@Repository
public class CompteDaoImpl implements CompteDao {

	@PersistenceContext 
	private EntityManager em;
	
	 
	public void updateCompte(Compte c) {
		em.merge(c);
		em.flush();
	}
	
	 
	public List<Compte> getAllCompte() {
		Query query = em.createQuery("from Compte");
		List<Compte> listCompte = query.getResultList();
		return listCompte;
	}
	
	@Override
	public List<Compte> getCompteByCriteria(String criteria, String libelle) {
		Query query = em.createQuery("SELECT compte FROM Compte AS compte WHERE compte."+criteria+" like :libelle");
     	query.setParameter("libelle", "%"+libelle+"%");
     	return query.getResultList();
	}

	 
	public Compte getCompteById(int idC) {
		return em.find(Compte.class, idC);
	}
	
	 
	public Integer getIdCompteByLogin(String login) {
		Query query = em.createQuery("SELECT c.id_compte FROM Compte AS c WHERE c.login=:login");
     	query.setParameter("login", login);
     	return (Integer) org.springframework.dao.support.DataAccessUtils.singleResult(query.getResultList());
	}


	 
	public void deleteCompte(int idC) {
		Compte c_from_db = getCompteById(idC);
		if(c_from_db != null) {
			em.remove(c_from_db);
		}
	}


	@Override
	public Long countCompte() {
		Query query = em.createQuery("SELECT count(*) FROM Compte as compte");
		return (Long)query.getSingleResult();
	}


}
