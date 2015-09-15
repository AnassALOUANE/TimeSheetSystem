package com.karim.timesheet.web;

import com.karim.timesheet.model.User;
import com.karim.timesheet.service.TimesheetService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/employee/*")
public class EmployeeController {

    @Autowired  
    private TimesheetService timesheetService;
    @Autowired  
    private MessageSource messageSource;
    
    @RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public String indexSprint(Model model, HttpSession session) {
        model.addAttribute("timesheets", timesheetService.getAllTimesheetsByIdEmployee(((User) session.getAttribute("user_logged_in")).getId_u()));
        return "employee_index";
    }	
	
}
