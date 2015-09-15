package com.karim.timesheet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karim.timesheet.dao.CompteDao;
import com.karim.timesheet.model.Compte;

@Service
@Transactional
public class CompteServiceImpl implements CompteService{

	@Autowired
	private CompteDao compteDao;
	
	 
	public void updateCompte(Compte c) {
		compteDao.updateCompte(c);		
	}

	 
	@Transactional(readOnly = true)
	public List<Compte> getAllCompte() {
		return compteDao.getAllCompte();
	}

	 
	@Transactional(readOnly = true)
	public Compte getCompteById(int idC) {
		return compteDao.getCompteById(idC);
	}
	
	 
	@Transactional(readOnly = true)
	public Integer getIdCompteByLogin(String login) {
		return compteDao.getIdCompteByLogin(login);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Compte> getCompteByCriteria(String criteria, String libelle) {
		return compteDao.getCompteByCriteria(criteria, libelle);
	}


	 
	public void deleteCompte(int idC) {
		compteDao.deleteCompte(idC);
	}


	@Override
	public Long countCompte() {
		return compteDao.countCompte();
	}

}
