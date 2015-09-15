/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karim.timesheet.web;

import com.karim.timesheet.model.Book;
import com.karim.timesheet.model.Timesheet;
import com.karim.timesheet.model.User;
import com.karim.timesheet.service.TimesheetService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author karim
 */
@Controller
@RequestMapping("/print/*")
public class PrintController {
    
    @Autowired
    private TimesheetService timesheetService;
    /**
     * Handle request to download a PDF document
     */
    @RequestMapping(value = "/EmpTimesheetPDF/{idT}", method = RequestMethod.GET)
    public ModelAndView downloadEmpPDF(@PathVariable("idT") Integer idT) {
        // create some sample data
        Timesheet timesheet = timesheetService.getTimesheetById(idT);
 
        // return a view which will be resolved by an excel view resolver
        return new ModelAndView("printEmpTimesheetPDF", "timesheet", timesheet);
    }
    
    @RequestMapping(value = "/MangerTimesheetPDF/{idM}", method = RequestMethod.GET)
    public ModelAndView downloadManagerPDF(@PathVariable("idM") Integer idM) {
        // create some sample data
        Timesheet timesheet = timesheetService.getTimesheetById(idM);
 
        // return a view which will be resolved by an excel view resolver
        return new ModelAndView("printEmpTimesheetPDF", "timesheet", timesheet);
    }
    
    @RequestMapping(value = "/MangerAllTimesheetPDF/{idM}", method = RequestMethod.GET)
    public ModelAndView downloadManagerAllPDF(@PathVariable("idM") Integer idM, HttpSession session) {
        // create some sample data
        List<Timesheet> timesheets = timesheetService.getTimesheetByIdManger(((User) session.getAttribute("user_logged_in")).getId_u());
 
        // return a view which will be resolved by an excel view resolver
        return new ModelAndView("printManagerAllTimesheetPDF", "timesheets", timesheets);
    }
    
    
}
