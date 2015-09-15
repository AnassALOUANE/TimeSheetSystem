package com.karim.timesheet.dao;

import java.util.List;

import com.karim.timesheet.model.Compte;

public interface CompteDao {

	public void updateCompte(Compte c);

	public List<Compte> getAllCompte();

	public List<Compte> getCompteByCriteria(String criteria, String libelle);

	public Compte getCompteById(int idC);

	public Integer getIdCompteByLogin(String login);

	public void deleteCompte(int idC);

	public Long countCompte();

}
