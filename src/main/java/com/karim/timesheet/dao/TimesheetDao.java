/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karim.timesheet.dao;

import com.karim.timesheet.model.Timesheet;
import java.util.Date;
import java.util.List;

/**
 *
 * @author karim
 */
public interface TimesheetDao {
    
      public void addTimesheet(Timesheet timesheet);
      public List<Timesheet> getAllTimesheets();
      public Timesheet getTimesheetById(int idT);
      public List<Timesheet> getTimesheetByIdManger(int idM);
      public List<Timesheet> getAllTimesheetsByIdEmployee(int idE);
      public void deleteTimesheet(int idT);
      public List<Timesheet> getTimesheetsApprovedWeek(int idM, Date endweek);
      public List<Timesheet> getTimesheetsDejaApprovedWeek(int idM, Date endweek);
      public List<Timesheet> getTimesheetNotPaid();
      public List<Timesheet> getTimesheetPaid();
      //___________________ EXECUTIF _____________//
      public List<Timesheet> getOverallRepport();
      public Long CountTimesshetPaidByIdUser(int idU);
      public Long CountTimesshetUnPaidByIdUser(int idU);
      public Long CountTimesshetApprovedByIdUser(int idU);
      public Long CountTimesshetDisapprovedByIdUser(int idU);
}
