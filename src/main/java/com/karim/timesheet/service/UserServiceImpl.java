/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karim.timesheet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karim.timesheet.dao.UtilisateurDao;
import com.karim.timesheet.model.Manager;
import com.karim.timesheet.model.User;
import javax.persistence.Query;

/**
 *
 * @author karim
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired 
    private UtilisateurDao utilisateurDao;
    
    
    @Override
    @Transactional(readOnly = true)
	public User getUtilisateurById(int idU) {
		return utilisateurDao.getUtilisateurById(idU);
	}
    
    @Override 
    @Transactional(readOnly = true)
    public User getUtilisateurByIdCompte(int idCompte) {
		return utilisateurDao.getUtilisateurByIdCompte(idCompte);
    }
    @Override
    public User getManagerByIdEmploye(int idE) {
        return utilisateurDao.getManagerByIdEmploye(idE);
    }

    @Override
    public User getEmployeByIdTimesheet(int idT) {
         return utilisateurDao.getEmployeByIdTimesheet(idT);
    }

	@Override
	@Transactional(readOnly = true)
	public List<User> getAllUtilisateur() {
		return utilisateurDao.getAllUtilisateur();
	}
    
       
}
