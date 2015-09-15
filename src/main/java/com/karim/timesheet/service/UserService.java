/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karim.timesheet.service;

import com.karim.timesheet.model.Manager;
import java.util.List;

import com.karim.timesheet.model.User;

/**
 *
 * @author karim
 */
public interface UserService {

	// authentification methodes
	public User getUtilisateurById(int idU);
	public User getUtilisateurByIdCompte(int idCompte);
	public List<User> getAllUtilisateur();
        public User getManagerByIdEmploye(int idE);
        public User getEmployeByIdTimesheet(int idT);

}
