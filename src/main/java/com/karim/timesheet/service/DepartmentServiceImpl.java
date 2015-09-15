/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karim.timesheet.service;

import com.karim.timesheet.model.Department;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karim.timesheet.dao.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author karim
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired 
    private DepartmentDao departmentDao;
    @Override
    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }

    @Override
    @Transactional(readOnly = true)
    public Department getDepartmentById(int idD) {
        return departmentDao.getDepartmentById(idD);
    }
    
}
