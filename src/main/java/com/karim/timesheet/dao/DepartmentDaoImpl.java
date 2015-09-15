/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karim.timesheet.dao;

import com.karim.timesheet.model.Department;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author karim
 */
@Repository
public class DepartmentDaoImpl implements DepartmentDao{

    @PersistenceContext 
    private EntityManager em;
    
    @Override
    public List<Department> getAllDepartments() {
        Query query = em.createQuery("select d from Department d");
		return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Department getDepartmentById(int idD) {
         return em.find(Department.class, idD);
    }
    
}
