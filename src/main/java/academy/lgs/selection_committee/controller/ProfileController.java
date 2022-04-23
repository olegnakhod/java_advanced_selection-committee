package academy.lgs.selection_committee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import academy.lgs.selection_committee.domain.User;
import academy.lgs.selection_committee.domain.UserRole;
import academy.lgs.selection_committee.service.CertificateService;
import academy.lgs.selection_committee.service.UserService;

@Controller
public class ProfileController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CertificateService certificateService;
	
	public User getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userService.getByEmail(auth.getName());
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView viewProfile() {
		ModelAndView map = new ModelAndView("home");
		map.addObject("userViewer",  getCurrentUser());
		
		if( getCurrentUser().getUserRole().equals(UserRole.ROLE_CANDIDATE) && certificateService.getByUserId(getCurrentUser().getId()) != null){
			map.addObject( "subjectsViewer", certificateService.getByUserId(getCurrentUser().getId()).getSubject());
		}
		
		return map;
	}
}
