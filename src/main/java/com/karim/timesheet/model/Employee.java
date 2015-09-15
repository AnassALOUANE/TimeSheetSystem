package com.karim.timesheet.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="employee")
@PrimaryKeyJoinColumn(name = "id_u")
public class Employee extends User {
	
    private static final long serialVersionUID = 5165L;
    
    public Employee() {
    }

    public Employee(Integer id_u, String userCode, String name, String email, Compte compte) {
        super(id_u, userCode, name, email, compte);
    }

    
    
    

    

    
}
