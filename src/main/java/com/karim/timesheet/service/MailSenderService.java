package com.karim.timesheet.service;

import com.karim.timesheet.model.Manager;
import com.karim.timesheet.model.User;

public interface MailSenderService {

//	public void sendPassword(String email, String login, String password, Boolean active);
//	public void reminderPassword(String email, String login, String password, Boolean active);
//	public void sendUpdatePassword(String email, String login, String password, Boolean active);
//	public void inscriptionConfirmation(String email, String resp_f, String formation);
//	public void correspondance(User client, String msg);
        public void EmployeaddTimesheet(User user, User manager);
        public void ManagerApproveTimesheet(User manager, User employee);
        public void  AccountingPaidTimesheet(User accounting, User employee);
	
}
