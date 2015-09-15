/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karim.timesheet.web;

import com.karim.timesheet.model.Timesheet;
import com.karim.timesheet.model.User;
import com.karim.timesheet.service.MailSenderService;
import com.karim.timesheet.service.TimesheetService;
import com.karim.timesheet.service.UserService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author karim
 */
@Controller
@RequestMapping("/manager/*")
public class ManagerController {

    @Autowired
    private TimesheetService timesheetService;
    @Autowired  
    private MessageSource messageSource;
    @Autowired
    private MailSenderService  mailSenderService;
    @Autowired
    private UserService  userService;
    
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String indexSprint(Model model, HttpSession session) {
        model.addAttribute("timesheets", timesheetService.getTimesheetByIdManger(((User) session.getAttribute("user_logged_in")).getId_u()));
        return "manager_index";
    }

    //____________________________________________   APPROVE TIMESHEET   ________________________________________//
    //___________________________________________________________________________________________________________//
    @RequestMapping(value = "/approve", method = RequestMethod.GET)
    public String approveTimesheeetPage(Model model, HttpSession session) {
        GregorianCalendar gc = new GregorianCalendar();
        while (gc.get(GregorianCalendar.DAY_OF_WEEK) != GregorianCalendar.SUNDAY) {
            gc.add(GregorianCalendar.DATE, 1);
        }
        System.out.println("################################## " + gc.getTime());
        List<Timesheet> timesheets = timesheetService.getTimesheetsApprovedWeek(((User) session.getAttribute("user_logged_in")).getId_u(), gc.getTime());
        model.addAttribute("timesheets", timesheets);
        for(Timesheet t: timesheets) 
                System.out.println("####################### "+t.getEmployee().getName());
        model.addAttribute("timesheets_aprroved",  timesheetService.getTimesheetsDejaApprovedWeek(((User) session.getAttribute("user_logged_in")).getId_u(), gc.getTime()));
        
        return "manager_approve";
    }

    @RequestMapping(value = "/approve", method = RequestMethod.POST)
    public String approveTimesheeet(@RequestParam(value = "checkBox_approve_timesshet", required = false) Integer[] checkBox_approve_timesshet,
                                    Model model, RedirectAttributes redirectAttributes, HttpSession session, Locale loc) {

        if (checkBox_approve_timesshet == null) {
            GregorianCalendar gc = new GregorianCalendar();
            while (gc.get(GregorianCalendar.DAY_OF_WEEK) != GregorianCalendar.SUNDAY) {
                gc.add(GregorianCalendar.DATE, 1);
            }
            List<Timesheet> timesheets = timesheetService.getTimesheetsApprovedWeek(((User) session.getAttribute("user_logged_in")).getId_u(), gc.getTime());
            model.addAttribute("timesheets", timesheets);
            
            model.addAttribute("timesheets_aprroved",  timesheetService.getTimesheetsDejaApprovedWeek(((User) session.getAttribute("user_logged_in")).getId_u(), gc.getTime()));
            model.addAttribute("msgError", messageSource.getMessage("application.error.timesheeet.approve", null, loc));
            return "manager_approve";
        }
        User user =  (User) session.getAttribute("user_logged_in");
        for (Integer id_t : checkBox_approve_timesshet) {
            Timesheet timesheet = timesheetService.getTimesheetById(id_t);
            timesheet.setStatusCode("P");
            timesheetService.addTimesheet(timesheet);
//            mailSenderService.sendInvitation(user, event_invite);
            
            mailSenderService.ManagerApproveTimesheet(user, userService.getEmployeByIdTimesheet(id_t));
            System.out.println("############### *******************"+userService.getEmployeByIdTimesheet(id_t));
        }
        redirectAttributes.addFlashAttribute("succesMessage", messageSource.getMessage("application.operation.success", null, loc));
        return "redirect:/manager/approvedTimesheet";
    }
    
    @RequestMapping(value = "/approvedTimesheet", method = RequestMethod.GET)
    public String DejaApprovedTimesheeetPage(Model model, HttpSession session) {
        GregorianCalendar gc = new GregorianCalendar();
        while (gc.get(GregorianCalendar.DAY_OF_WEEK) != GregorianCalendar.SUNDAY) {
            gc.add(GregorianCalendar.DATE, 1);
        }
        model.addAttribute("timesheets", timesheetService.getTimesheetsApprovedWeek(((User) session.getAttribute("user_logged_in")).getId_u(), gc.getTime()));
        model.addAttribute("timesheets_aprroved",  timesheetService.getTimesheetsDejaApprovedWeek(((User) session.getAttribute("user_logged_in")).getId_u(), gc.getTime()));
//       for(Timesheet tm : timesheets)
//           System.out.println("####################### ****************************"+tm);
        return "manager_approve";
    }
    
    
    //____________________________________________   APPROVE TIMESHEET   ________________________________________//
    //___________________________________________________________________________________________________________//
    
    @RequestMapping(value = "/disapprove", method = RequestMethod.POST)
    public String disApproveTimesheeet(@RequestParam(value = "checkBox_approve_timesshet", required = false) Integer[] checkBox_approve_timesshet,
                                    Model model, RedirectAttributes redirectAttributes, HttpSession session, Locale loc) {

        if (checkBox_approve_timesshet == null) {
            GregorianCalendar gc = new GregorianCalendar();
            while (gc.get(GregorianCalendar.DAY_OF_WEEK) != GregorianCalendar.SUNDAY) {
                gc.add(GregorianCalendar.DATE, 1);
            }
            List<Timesheet> timesheets = timesheetService.getTimesheetsApprovedWeek(((User) session.getAttribute("user_logged_in")).getId_u(), gc.getTime());
            model.addAttribute("timesheets", timesheets);
            model.addAttribute("timesheets_aprroved",  timesheetService.getTimesheetsDejaApprovedWeek(((User) session.getAttribute("user_logged_in")).getId_u(), gc.getTime()));
            model.addAttribute("msgError", messageSource.getMessage("application.error.timesheeet.approve", null, loc));
            return "manager_approve";
        }

        for (Integer id_t : checkBox_approve_timesshet) {
            Timesheet timesheet = timesheetService.getTimesheetById(id_t);
            timesheet.setStatusCode("D");
            timesheetService.addTimesheet(timesheet);
//            mailSenderService.sendInvitation(user, event_invite);

        }
        redirectAttributes.addFlashAttribute("succesMessage", messageSource.getMessage("application.operation.success", null, loc));
        return "redirect:/manager/approve";
    }

}
