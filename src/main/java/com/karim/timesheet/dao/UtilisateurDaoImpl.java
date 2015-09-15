/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karim.timesheet.dao;


import com.karim.timesheet.model.Manager;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.karim.timesheet.model.User;

/**
 *
 * @author karim 
 */
@Repository
public class UtilisateurDaoImpl implements UtilisateurDao {
    
    @PersistenceContext 
    private EntityManager em;
    
    
    
    // authnetification methods
     
	public User getUtilisateurById(int idU) {
		return em.find(User.class, idU);
	}
    
     
   	public User getUtilisateurByIdCompte(int idCompte) {
       	Query query = em.createQuery("SELECT u FROM User AS u WHERE u.compte.id_compte=:idCompte");
       	  query.setParameter("idCompte", idCompte);
       	  return (User) query.getSingleResult();
   	}


   	@Override
	public List<User> getAllUtilisateur() {
            Query query = em.createQuery("SELECT u FROM User AS u WHERE u.compte.id_compte IS NULL ORDER BY u.nom");
            return query.getResultList();
	}

	

    @Override
    public List<Integer> getAllIdUtilisateur() {
        Query query = em.createQuery("SELECT  u.id_u FROM User as u");
        return query.getResultList();
    }
    @Override
    public List<Integer> getEmplyesByIdManager(int idM) {
        Query query = em.createQuery("SELECT u.id_u FROM User u JOIN u.manager m WHERE m.id_u=:idM");
        query.setParameter("idM", idM);
        return query.getResultList();
    }
    
    @Override
    public User getManagerByIdEmploye(int idE) {
        Query query = em.createQuery("SELECT u FROM User u JOIN u.manager m WHERE u.id_u=:idE");
        query.setParameter("idE", idE);
        return (User) query.getSingleResult();
    }
    @Override
    public User getEmployeByIdTimesheet(int idT) {
        Query query = em.createQuery("SELECT u FROM Timesheet t JOIN t.employee u WHERE t.id_timesheet=:idT");
        query.setParameter("idT", idT);
        return (User) query.getSingleResult();
    }

    @Override
    public List<Integer> getAllManagerId() {
        Query query = em.createQuery("SELECT m.id_u FROM Manager m");
        return query.getResultList();
    }


}
