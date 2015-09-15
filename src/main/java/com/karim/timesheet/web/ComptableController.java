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
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author karim
 */
@Controller
@RequestMapping("/comptable/*")
public class ComptableController {
    
    @Autowired
    private TimesheetService timesheetService;
    @Autowired  
    private MessageSource messageSource;
    @Autowired
    private MailSenderService  mailSenderService;
    @Autowired
    private UserService  userService;
    
    @RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public String indexPaidTimesheets(Model model, HttpSession session) {
        model.addAttribute("timesheets", timesheetService.getTimesheetNotPaid());
        return "comptable_index";
    }
    
    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public String payementTimesheeets(@RequestParam(value = "checkBox_payment_timesshet", required = false) Integer[] checkBox_payment_timesshet,
                                    Model model, RedirectAttributes redirectAttributes, HttpSession session, Locale loc) {

        if (checkBox_payment_timesshet == null) {
             
            model.addAttribute("timesheets", timesheetService.getTimesheetNotPaid());
            model.addAttribute("msgError", messageSource.getMessage("application.error.timesheeet.payment", null, loc));
            return "comptable_index";
        }
        User user =  (User) session.getAttribute("user_logged_in");
        for (Integer id_t : checkBox_payment_timesshet) {
            Timesheet timesheet = timesheetService.getTimesheetById(id_t);
            timesheet.setPaid(Boolean.TRUE);
            timesheetService.addTimesheet(timesheet);
            mailSenderService.AccountingPaidTimesheet(user, userService.getEmployeByIdTimesheet(id_t));
//            mailSenderService.sendInvitation(user, event_invite);

        }
        redirectAttributes.addFlashAttribute("succesMessage", messageSource.getMessage("application.operation.success", null, loc));
        return "redirect:/comptable/";
    }
    
    @RequestMapping(value = "/paid", method = RequestMethod.GET)
    public String paidAccounting(Model model, HttpSession session) {
        model.addAttribute("timesheets", timesheetService.getTimesheetPaid());
        return "comptable_paid";
    }
    
    @RequestMapping(value = "/paid", method = RequestMethod.POST)
    public String paidTimesheeets(@RequestParam(value = "checkBox_payment_timesshet", required = false) Integer[] checkBox_payment_timesshet,
                                    Model model, RedirectAttributes redirectAttributes, HttpSession session, Locale loc) {

        if (checkBox_payment_timesshet == null) {
             
            model.addAttribute("timesheets", timesheetService.getTimesheetNotPaid());
            model.addAttribute("msgError", messageSource.getMessage("application.error.timesheeet.payment", null, loc));
            return "comptable_paid";
        }

        for (Integer id_t : checkBox_payment_timesshet) {
            Timesheet timesheet = timesheetService.getTimesheetById(id_t);
            timesheet.setPaid(Boolean.FALSE);
            timesheetService.addTimesheet(timesheet);
//            mailSenderService.sendInvitation(user, event_invite);

        }
        redirectAttributes.addFlashAttribute("succesMessage", messageSource.getMessage("application.operation.success", null, loc));
        return "redirect:/comptable/paid";
    }
}
