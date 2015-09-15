package com.karim.timesheet.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author karim
 */
@Entity
@Table(name = "profil")
public class Profil implements Serializable{
	
	private static final long serialVersionUID = 5165L;
    
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    @Column (name="id_profil")
    private Integer id_profil;
    
    @Column (name="titre", length = 100)
    @NotEmpty(message="vous devez entrer le titre du profil")
    private String titre;
    
    @Column (name="[desc]", length = 240)
    @NotEmpty(message="vous devez entrer la discription du profil")
    private String desc; 
    
    @OneToMany(mappedBy="profil")
    private Set<User> utilisateurs = new HashSet<User>(0);

    public Profil() {
    }
    
    public Profil(Integer id_profil, String titre) {
		this.id_profil = id_profil;
		this.titre = titre;
    }

	public Profil(String titre) {
        this.titre = titre;
    }

    public void setId_profil(Integer id_profil) {
        this.id_profil = id_profil;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Integer getId_profil() {
        return id_profil;
    }

    public String getTitre() {
        return titre;
    }
    
    public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Profil [id_profil=" + id_profil + ", titre=" + titre
				+ ", desc=" + desc + "]";
	}  
    
}
