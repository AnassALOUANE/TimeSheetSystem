/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karim.timesheet.dao;

import com.karim.timesheet.model.Department;
import java.util.List;

/**
 *
 * @author karim
 */
public interface DepartmentDao {
    
     public List<Department> getAllDepartments();
      public Department getDepartmentById(int idD);
    
}
