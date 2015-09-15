/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karim.timesheet.service;
import com.karim.timesheet.dao.TimesheetDao;
import com.karim.timesheet.dao.UtilisateurDao;
import com.karim.timesheet.model.OverallReport;
import com.karim.timesheet.model.Timesheet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class TimesheetServiceImpl implements  TimesheetService{

    @Autowired
    private TimesheetDao timesheetDao;
    
    @Autowired
    private UtilisateurDao utilisateurDao;
    
    @Override
    public void addTimesheet(Timesheet timesheet) {
        timesheetDao.addTimesheet(timesheet);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Timesheet> getAllTimesheets() {
        return timesheetDao.getAllTimesheets();
    }

    @Override
    @Transactional(readOnly = true)
    public Timesheet getTimesheetById(int idT) {
        return timesheetDao.getTimesheetById(idT);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Timesheet> getAllTimesheetsByIdEmployee(int idE) {
        return timesheetDao.getAllTimesheetsByIdEmployee(idE);
    }

    @Override
    public void deleteTimesheet(int idT) {
        timesheetDao.deleteTimesheet(idT);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Timesheet> getTimesheetByIdManger(int idM) {
        return timesheetDao.getTimesheetByIdManger(idM);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Timesheet> getTimesheetsApprovedWeek(int idM, Date endweek) {
        return timesheetDao.getTimesheetsApprovedWeek(idM, endweek);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Timesheet> getTimesheetsDejaApprovedWeek(int idM, Date endweek) {
        return timesheetDao.getTimesheetsDejaApprovedWeek(idM, endweek);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Timesheet> getTimesheetNotPaid() {
         return timesheetDao.getTimesheetNotPaid();
    }

    @Override
     @Transactional(readOnly = true)
    public List<Timesheet> getTimesheetPaid() {
        return timesheetDao.getTimesheetPaid();
    }

    @Override
    public List<OverallReport> getOverallRepport() {
        List<OverallReport>list_overall_summary=new ArrayList<OverallReport>();
        List<Integer>empid=null;
        Map<Integer,List<Integer>> m=new HashMap<Integer, List<Integer>>(); 
         List<Integer> listIdUsers = utilisateurDao.getAllManagerId();
        for (int i = 0; i < listIdUsers.size(); i++) {
            if (listIdUsers.get(i) != null) {
                empid = utilisateurDao.getEmplyesByIdManager(listIdUsers.get(i));
//                System.out.println("###############    "+listIdUsers.get(i)+" ############# "+empid);
                m.put(listIdUsers.get(i), empid);
            }
        }
        Long paid, unpaid, approved, disapproved, totalHours;
        String name;
         Set cles = m.keySet();
        Iterator iterator = cles.iterator();
        while (iterator.hasNext()) {
            Integer cle = (Integer) iterator.next();
            List<Integer> l=m.get(cle);
            paid = 0L; unpaid = 0L;
            approved = 0L; disapproved = 0L; 
            totalHours = new Long(0);
            for(int i=0;i<l.size();i++){
                paid += timesheetDao.CountTimesshetPaidByIdUser(l.get(i));
                unpaid += timesheetDao.CountTimesshetUnPaidByIdUser(l.get(i));
                approved += timesheetDao.CountTimesshetApprovedByIdUser(l.get(i));
                disapproved += timesheetDao.CountTimesshetDisapprovedByIdUser(l.get(i));
                for (Timesheet t : getAllTimesheetsByIdEmployee(l.get(i))) {
                    totalHours += t.getTotalHours();
                }
            }
            name = utilisateurDao.getUtilisateurById(cle).getName();
            list_overall_summary.add(new OverallReport(name, paid, unpaid, approved, disapproved, totalHours));
            System.out.println(name +"### "+paid+"###"+unpaid+" "+approved+ "### "+disapproved+"#### "+totalHours);
        }
        return list_overall_summary;
    }

  
}
