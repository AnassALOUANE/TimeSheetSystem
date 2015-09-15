package com.karim.timesheet.security;

import com.karim.timesheet.model.User;
import com.karim.timesheet.service.CompteService;
import com.karim.timesheet.service.TimesheetService;
import com.karim.timesheet.service.UserService;
import com.karim.timesheet.web.LoginController;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


@Component
public class PGP_UrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private static final Logger log = Logger.getLogger(LoginController.class);
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
    @Autowired
    private CompteService compteService;
    @Autowired
    private UserService utilisateurService;
    @Autowired
    private TimesheetService timesheetService;
	
	
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,ServletException {
		handle(request, response, authentication);
        clearAuthenticationAttributes(request);
		// TODO Auto-generated method stub
		
	}
	
	
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
		String targetUrl = determineTargetUrl(request, authentication);

		if (response.isCommitted()) {
			log.debug("Response has already been committed. Unable to redirect to " + targetUrl);
			return;
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}
	
	 /** Determiner la page d'acceuil de l'utilisateur connecte. */
    protected String determineTargetUrl(HttpServletRequest request, Authentication authentication) {
    	boolean isEmployee = false;
    	boolean isManager = false;
    	boolean isComptable = false;
        boolean isExecutif = false;
        
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        
        /** get username(login) of user logged in */
        String login = authentication.getName();
        /** get  l'Id of user logged in */
	    Integer id_compte = compteService.getIdCompteByLogin(login);
	    User user_logged_in= (User)utilisateurService.getUtilisateurByIdCompte(id_compte);
	    HttpSession session = request.getSession();
	    session.setAttribute("user_logged_in", user_logged_in);
    	session.setAttribute("user", user_logged_in.getName()); 
	    
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_EMPLOYEE")) {
            	isEmployee = true;
                log.info(" _______________________ Employee "+ user_logged_in.getName() +" connected to the system at  "+ new Date() +"_____________________");
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_MANAGER")) {
            	isManager = true;
                log.info(" _______________________ Manager "+ user_logged_in.getName() +" connected to the system at  "+ new Date() +"_____________________");
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_COMPTABLE")) {
            	isComptable = true;
            	log.info(" _______________________ Accounting "+ user_logged_in.getName()+" connected to the system at  "+ new Date() +"_____________________");
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_EXECUTIF")) {
            	isExecutif = true;
            	log.info(" _______________________ Executif "+ user_logged_in.getName()+" connected to the system at  "+ new Date() +"_____________________");
                break;
            }
        }
        
        if (isEmployee) {
            
            return "/employee/";  /** redirect employee to  home page*/
        	
        } else if (isManager) {
            session.setAttribute("count_timesheet_for_manager", timesheetService.getTimesheetByIdManger(((User) session.getAttribute("user_logged_in")).getId_u())); 
            return "/manager/";  /** redirect manager to  home page*/
        	
        } else if (isComptable) {
            
        	return "/comptable/"; /** redirect comptable to home page of project chief */
        	
        } else if(isExecutif){
                return "/executif/"; /** redirect comptable to home page of project chief */
        } else {
            throw new IllegalStateException();
        }
    }
    
    protected void clearAuthenticationAttributes(HttpServletRequest request) {
    	HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
 
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
	

}
