/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karim.timesheet.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author karim
 */
@Entity
@Table(name="accounting")
@PrimaryKeyJoinColumn(name = "id_u")
public class Accounting  extends User {
	
    private static final long serialVersionUID = 5165L;
               
    public Accounting() {
    }

    public Accounting(Integer id_u, String userCode, String name, String email, Compte compte) {
        super(id_u, userCode, name, email, compte);
    }

    
    
    

    

    
}
