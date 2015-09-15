/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karim.timesheet.dao;

import com.karim.timesheet.model.Timesheet;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author karim
 */
@Repository
public class TimesheetDaoImpl implements  TimesheetDao{

    @PersistenceContext 
    private EntityManager em;
    
    @Override
    public void addTimesheet(Timesheet timesheet) {
        em.merge(timesheet);
        em.flush(); 
    }

    @Override
    public List<Timesheet> getAllTimesheets() {
        Query query = em.createQuery("select t from Timesheet t");
        return query.getResultList();
    }

    @Override
    public Timesheet getTimesheetById(int idT) {
        return em.find(Timesheet.class, idT);
    }
    
    @Override
    public List<Timesheet> getTimesheetByIdManger(int idM) {
        Query query = em.createQuery("SELECT t FROM Timesheet t JOIN t.employee as e JOIN e.manager as m WHERE m.id_u=:idM");
        query.setParameter("idM", idM);
        return query.getResultList();
    }

    @Override
    public List<Timesheet> getAllTimesheetsByIdEmployee(int idE) {
        Query query = em.createQuery("SELECT t FROM Timesheet t WHERE t.employee.id_u=:idE");
        query.setParameter("idE", idE);
        return query.getResultList();
    }

    
    @Override
    public void deleteTimesheet(int idT) {
        Timesheet timesheet_from_db = getTimesheetById(idT);
		if(timesheet_from_db != null) {
			em.remove(timesheet_from_db);
			em.flush();
		}
    }    

    @Override
    public List<Timesheet> getTimesheetsApprovedWeek(int idM, Date endweek) {
        Query query = em.createQuery("SELECT t FROM Timesheet t JOIN t.employee as e JOIN e.manager as m WHERE (t.statusCode='N' OR t.statusCode='D') AND m.id_u=:idM");
        query.setParameter("idM", idM);
//        query.setParameter("endweek", endweek);
        return query.getResultList();
    }

    @Override
    public List<Timesheet> getTimesheetsDejaApprovedWeek(int idM, Date endweek) {
        Query query = em.createQuery("SELECT t FROM Timesheet t JOIN t.employee as e JOIN e.manager as m WHERE t.statusCode='P' AND m.id_u=:idM");
        query.setParameter("idM", idM);
//        query.setParameter("endweek", endweek);
        return query.getResultList();
    }

    @Override
    public List<Timesheet> getTimesheetNotPaid() {
        Query query = em.createQuery("SELECT t FROM Timesheet t WHERE t.paid=0");
        return query.getResultList();
    }

    @Override
    public List<Timesheet> getTimesheetPaid() {
        Query query = em.createQuery("SELECT t FROM Timesheet t WHERE t.paid=1");
        return query.getResultList();
    }

    @Override
    public List<Timesheet> getOverallRepport() {
         Query query = em.createQuery("SELECT t, (SELECT SUM(hoursMon) from Timesheet t2 WHERE t2.id_timesheet=t.id_timesheet) as t.totalHours FROM Timesheet t");
        return query.getResultList();
    }

    @Override
    public Long CountTimesshetPaidByIdUser(int idU) {
        Query query = em.createQuery("SELECT COUNT(t) FROM Timesheet t WHERE t.employee.id_u=:idU AND t.paid=1");
        query.setParameter("idU", idU);
        return (Long)query.getSingleResult();
    }

    @Override
    public Long CountTimesshetUnPaidByIdUser(int idU) {
        Query query = em.createQuery("SELECT COUNT(t) FROM Timesheet t WHERE t.employee.id_u=:idU AND t.paid=0");
        query.setParameter("idU", idU);
        return (Long)query.getSingleResult();
    }

    @Override
    public Long CountTimesshetApprovedByIdUser(int idU) {
        Query query = em.createQuery("SELECT COUNT(t) FROM Timesheet t WHERE t.employee.id_u=:idU AND t.statusCode='P'");
        query.setParameter("idU", idU);
        return (Long)query.getSingleResult();
    }

    @Override
    public Long CountTimesshetDisapprovedByIdUser(int idU) {
        Query query = em.createQuery("SELECT COUNT(t) FROM Timesheet t WHERE t.employee.id_u=:idU AND t.statusCode='D'");
        query.setParameter("idU", idU);
        return (Long)query.getSingleResult();
    }
    
    
}
