package com.karim.timesheet.web;


import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.karim.timesheet.model.User;
import com.karim.timesheet.service.CompteService;
import com.karim.timesheet.service.MailSenderService;
import com.karim.timesheet.service.UserService;

@Controller
public class LoginController {
	
	private static final Logger log = Logger.getLogger(LoginController.class);
	@Autowired
	private CompteService compteService;
	@Autowired
	private MailSenderService  mailSenderService;
	@Autowired
	private UserService utilisateurService;
	
	@RequestMapping("login")
	 public String getLoginForm(
	 @RequestParam(required = false) String authfailed, String logout, HttpSession session, String denied, Model model) {
		log.info("new user trying to connect to application at "+ new Date());
		  String message = "";
		  
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  
		  if (!(auth instanceof AnonymousAuthenticationToken)) {
		      /* get the user is logged in :) */
			  User user_connecte = (User) session.getAttribute("user_connecte");
			  Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
			  for (GrantedAuthority grantedAuthority : authorities) {
		            if (grantedAuthority.getAuthority().equals("ROLE_EMPLOYEE")) {
		            	 return "redirect:/employee/";
		            } else if (grantedAuthority.getAuthority().equals("ROLE_MANAGER")) {
		            	 return "redirect:/manager/";
		            } else if (grantedAuthority.getAuthority().equals("ROLE_COMPTABLE")) {
		            	 return "redirect:/comptable/";
		            } 
		        }
		  }
		  
		  
		  if (authfailed != null) {
		   message = "login ou mot de passe est incorrect.veuillez ressayer !";
		  } if (logout != null) {
		   message = "déconnexion avec succés , s'authentifier à nouveau pour continue !";
		  } if (denied != null) {
		   message = "vous n'avez pas la permission pour continue !";
		  }
		  
		  model.addAttribute("message", message);
	  return "login";
	 }
	
//    @RequestMapping(value = "/reminder", method = RequestMethod.POST)
//    public String reminderPassword  (@RequestParam(value="emailaddress", required = false) String emailaddress, Model model, HttpSession session) {
//		 	
//		    log.info("new user request new passwordt "+ new Date());
//			
//			Integer compteExiste = null;
//			//test est ce que le login est deja existe
//			compteExiste = compteService.getIdCompteByLogin(emailaddress);
//			if(compteExiste == null) {					
//				model.addAttribute("message", "Email n'existe pas, veuillez r�essayer.");
// 				return "login";
//				
//			} else {
//				
//				Compte compte = compteService.getCompteById(compteExiste);
//				PasswordEncoder encoder = new Md5PasswordEncoder();
//				String password="pgp12345";
//				String hashedPassword = encoder.encodePassword(password, null);
//				compte.setPassword(hashedPassword);
//				compteService.updateCompte(compte);
////				// envoyer le login et mot de passe au utilisateur 			
//				mailSenderService.reminderPassword(compte.getUtilisateur().getEmail(), compte.getLogin(), password, compte.getActive());
//	 			model.addAttribute("message", "un nouveau mot de passe envoy� � votre  email, veuilez consulter votre boite de r�c�ption.");
// 			    return "login";
//			}
//						
//    }

	

	 @RequestMapping("403")
	 public String ge403denied() {
	  return "redirect:/login?denied";
//	  return "403";
	 }
	 
	 /******************************************************************************
		this methode handling all reques in case if request is not mapping in this controller 								  
	    *******************************************************************************/
//	    @RequestMapping(method = RequestMethod.GET)
//		public String defaultPage() {
//			return "defaultPage";
//	    }

}
