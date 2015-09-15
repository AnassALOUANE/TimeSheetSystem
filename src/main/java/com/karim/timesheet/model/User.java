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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


import javax.persistence.OneToMany;

/**
 *
 * @author karim
 */
@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {
    

    private static final long serialVersionUID = 5165L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_u")
    private Integer id_u;
    
    @Column(name = "userCode", length = 40, nullable = false)
    @NotEmpty(message="veuillez entrer votre code")
    private String userCode;

    @Column(name = "name", length = 40, nullable = false)
    @NotEmpty(message="veuillez entrer votre nom")
    private String name;

    @Column(name = "email", length = 100, nullable = false)
    @NotEmpty(message="veuillez entrer votre e-mail")
    @Email
    private String email;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
    private Set<Timesheet> timeSheets = new HashSet<Timesheet>(0);

    
    @OneToOne(fetch = FetchType.EAGER, cascade={CascadeType.MERGE}, orphanRemoval = true)
    @JoinColumn(name="id_compte", unique = true)
    private Compte compte;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name="id_profil")
    private Profil profil ;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_manager")
    private Manager manager ;

    public User() {
    }

    public User(Integer id_u, String userCode, String name, String email, Compte compte) {
        this.id_u = id_u;
        this.userCode = userCode;
        this.name = name;
        this.email = email;
        this.compte = compte;
    }

    public void setId_u(Integer id_u) {
        this.id_u = id_u;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTimeSheets(Set<Timesheet> timeSheets) {
        this.timeSheets = timeSheets;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId_u() {
        return id_u;
    }

    public String getUserCode() {
        return userCode;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Set<Timesheet> getTimeSheets() {
        return timeSheets;
    }

    public Compte getCompte() {
        return compte;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Manager getManager() {
        return manager;
    }

    @Override
    public String toString() {
        return "User{" + "id_u=" + id_u + ", userCode=" + userCode + ", name=" + name + ", email=" + email + ", compte=" + compte + ", profil=" + profil + '}';
    }
    
}
