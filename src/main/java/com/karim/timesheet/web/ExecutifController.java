/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karim.timesheet.web;

import com.karim.timesheet.model.OverallReport;
import com.karim.timesheet.model.Timesheet;
import com.karim.timesheet.service.MailSenderService;
import com.karim.timesheet.service.TimesheetService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author karim
 */
@Controller
@RequestMapping("/executif/*")
public class ExecutifController {
    
    @Autowired
    private TimesheetService timesheetService;
    @Autowired  
    private MessageSource messageSource;
    @Autowired
    private MailSenderService  mailSenderService;
    
    @RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public String indexPaidTimesheets(Model model, HttpSession session) {
        List<Timesheet> timesheets = timesheetService.getAllTimesheets();
        int total = 0;
        int average;
        for(Timesheet t : timesheets) {
            total+=t.getTotalHours();
        }
        average=total/timesheets.size();
        model.addAttribute("timesheets", timesheets);
        model.addAttribute("average", average);
        model.addAttribute("total", total);
        model.addAttribute("timesheets", timesheetService.getAllTimesheets());
        return "executif_index";    
    
    }
    
    @RequestMapping(value = "/overallSummary", method = RequestMethod.GET)
    public String overalSummaryTimesheets(Model model, HttpSession session) {
        List<OverallReport> overall_report = timesheetService.getOverallRepport();
        int total = 0;
        int average;
        for(OverallReport rep : overall_report) {
            total+=rep.getTotalHours();
        }
        average=total/overall_report.size();
        model.addAttribute("average", average);
        model.addAttribute("total", total);
        
        model.addAttribute("list_overall_summary", overall_report);
        return "executif_overall_summary";
    }
    
}
