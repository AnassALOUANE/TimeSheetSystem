/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karim.timesheet.web;

import com.karim.timesheet.model.Department;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.karim.timesheet.model.Timesheet;
import com.karim.timesheet.model.User;
import com.karim.timesheet.service.DepartmentService;
import com.karim.timesheet.service.MailSenderService;
import com.karim.timesheet.service.TimesheetService;
import com.karim.timesheet.service.UserService;
import com.karim.timesheet.util.DateUtil;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/**
 *
 * @author karim
 */
@Controller
@RequestMapping("/timesheet/*")
public class TimesheetController {
    
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private TimesheetService timesheetService;
    @Autowired
    private MailSenderService  mailSenderService;
    @Autowired
    private UserService  userService;
    @Autowired  
    private MessageSource messageSource;
    
    @RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public String indexTimesheet(Model model) {
        model.addAttribute("timesheets", timesheetService.getAllTimesheets());
        return "timesheet_index";
    }
    
    @RequestMapping(value = "/detail/{idT}", method = RequestMethod.GET)
    public String viewTimesheet(@PathVariable("idT") Integer idT, Model model) {
        model.addAttribute("timesheet", timesheetService.getTimesheetById(idT));
        return "timesheet_detail";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addTimesheetPage(@ModelAttribute Timesheet timesheet, Model model) {
                model.addAttribute("timesheet", timesheet);
                model.addAttribute("periodEndingDate", DateUtil.getCurrentPeriodEndingDate());
                model.addAttribute("departments", departmentService.getAllDepartments());
                return "timesheet_add";
    }
	
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addTimesheet(@RequestParam(value="id_dept", required = false) String id_dept, @Valid @ModelAttribute("timesheet") Timesheet timesheet, BindingResult result, Model model, 
			RedirectAttributes redirectAttributes,HttpServletRequest request,
                        HttpSession session, Locale loc) {
		if (result.hasErrors()) {
		    model.addAttribute("timesheet", timesheet);
                    model.addAttribute("periodEndingDate", DateUtil.getCurrentPeriodEndingDate());
                    model.addAttribute("departments", departmentService.getAllDepartments());
                    model.addAttribute("errorTotalHours", messageSource.getMessage("application.error.timesheeet.totalHours", null, loc));
                    
                    return "timesheet_add";
		} 
                User user =  (User) session.getAttribute("user_logged_in");
		timesheet.setEmployee(user);
                timesheet.setDepartment(departmentService.getDepartmentById(Integer.parseInt(id_dept)));
                timesheet.setStatusCode("N");
                if(request.isUserInRole("ROLE_MANAGER")){
                 timesheet.setStatusCode("A");
                }
                timesheet.setPaid(Boolean.FALSE);
                timesheet.setPeriodEndingDate(DateUtil.getCurrentPeriodEndingDate());
		timesheetService.addTimesheet(timesheet);
                mailSenderService.EmployeaddTimesheet(user, userService.getManagerByIdEmploye(user.getId_u()));
		redirectAttributes.addFlashAttribute("succesMessage", messageSource.getMessage("application.operation.success", null, loc));
		return "redirect:/employee/";
		
    }
    
    @RequestMapping(value = "/update/{idT}", method = RequestMethod.GET)
    public String updateTimesheetPage(@PathVariable("idT") Integer idT, @ModelAttribute Timesheet timesheet, Model model) {
                model.addAttribute("timesheet", timesheetService.getTimesheetById(idT));
                model.addAttribute("idT", idT);
                model.addAttribute("periodEndingDate", DateUtil.getCurrentPeriodEndingDate());
                model.addAttribute("departments", departmentService.getAllDepartments());
                return "timesheet_update";
    }
    
    @RequestMapping(value = "/update/{idT}", method = RequestMethod.POST)
    public String updateTimesheet(@PathVariable("idT") Integer idT, @RequestParam(value="id_dept", required = false) String id_dept, 
                        @Valid @ModelAttribute("timesheet") Timesheet timesheet, BindingResult result, Model model, 
			RedirectAttributes redirectAttributes, HttpServletRequest request,
                        HttpSession session, Locale loc) {
		if (result.hasErrors()) {
		    model.addAttribute("timesheet", timesheet);
                    model.addAttribute("idT", idT);
                    model.addAttribute("periodEndingDate", DateUtil.getCurrentPeriodEndingDate());
                    model.addAttribute("departments", departmentService.getAllDepartments());
                    model.addAttribute("errorTotalHours", messageSource.getMessage("application.error.timesheeet.totalHours", null, loc));
                    
                    return "timesheet_update";
		} 
                timesheet.setId_timesheet(idT);
		timesheet.setEmployee((User) session.getAttribute("user_logged_in"));
                timesheet.setDepartment(departmentService.getDepartmentById(Integer.parseInt(id_dept)));
                timesheet.setStatusCode("N");
                if(request.isUserInRole("ROLE_MANAGER")){
                 timesheet.setStatusCode("A");
                }
                timesheet.setPaid(Boolean.FALSE);
                timesheet.setPeriodEndingDate(DateUtil.getCurrentPeriodEndingDate());
		timesheetService.addTimesheet(timesheet);
                
		redirectAttributes.addFlashAttribute("succesMessage", messageSource.getMessage("application.operation.success", null, loc));
		return "redirect:/employee/";
		
    }
    
    @RequestMapping(value = "/delete/{idT}", method = RequestMethod.GET)
    public String updateTimesheetPage(@PathVariable("idT") Integer idT, Model model) {
                timesheetService.deleteTimesheet(idT);
                return "redirect:/employee/";
    }
        
}
