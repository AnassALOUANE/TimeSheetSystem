package com.karim.timesheet.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author karim
 */
@Entity
@Table(name="manager")
@PrimaryKeyJoinColumn(name = "id_u")
public class Manager  extends User{
    private static final long serialVersionUID = 5165L;

    @OneToMany(mappedBy="manager")
    private Set<User> employees = new HashSet<User>(0);

    public void setEmployees(Set<User> employees) {
        this.employees = employees;
    }

    public Set<User> getEmployees() {
        return employees;
    }
    
    public Manager() {
    }    
    
    
}
