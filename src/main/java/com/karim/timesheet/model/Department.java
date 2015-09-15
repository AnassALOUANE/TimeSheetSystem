package com.karim.timesheet.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department implements Serializable {

    private static final long serialVersionUID = 5165L;

    @Id	
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    @Column(name = "id_dept")
    private Integer id_dept;

    @Column(name = "departmentCode")
    private String departmentCode;

    @Column(name = "name")
    private String name;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "department")
    private Set<Timesheet> timeSheets = new HashSet<Timesheet>(0);

    public Department() {
    }

    public Department(Integer id_dept, String departmentCode, String name) {
        this.id_dept = id_dept;
        this.departmentCode = departmentCode;
        this.name = name;
    }

    public void setId_dept(Integer id_dept) {
        this.id_dept = id_dept;
    }

    public Integer getId_dept() {
        return id_dept;
    }   

    public String getDepartmentCode() {
            return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
            this.departmentCode = departmentCode;
    }

    public String getName() {
            return name;
    }
    public void setName(String name) {
            this.name = name;
    }

    public Set<Timesheet> getTimeSheets() {
            return timeSheets;
    }
    public void setTimeSheets(Set<Timesheet> timeSheets) {
            this.timeSheets = timeSheets;
    }

    @Override
    public String toString() {
        return "Department{" + "id_dept=" + id_dept + ", departmentCode=" + departmentCode + ", name=" + name + '}';
    }

    

}
