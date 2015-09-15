/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karim.timesheet.dao;

import com.karim.timesheet.model.Manager;
import java.util.List;

import com.karim.timesheet.model.User;

/**
 *
 * @author karim
 */
public interface UtilisateurDao {

	// authentification methods
	public User getUtilisateurById(int idU);

	public User getUtilisateurByIdCompte(int idCompte);
	public List<User> getAllUtilisateur();
        public List<Integer> getAllIdUtilisateur();
        public List<Integer> getEmplyesByIdManager(int idM);
        public User getManagerByIdEmploye(int idE);
        public List<Integer> getAllManagerId();
        public User getEmployeByIdTimesheet(int idT);
}
