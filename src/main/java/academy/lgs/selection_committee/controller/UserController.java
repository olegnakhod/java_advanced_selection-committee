package academy.lgs.selection_committee.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import academy.lgs.selection_committee.domain.User;
import academy.lgs.selection_committee.service.UserHelperDTO;
import academy.lgs.selection_committee.service.UserService;

@Controller
@SessionAttributes(types = User.class)
public class UserController {

	@Autowired
	private UserService userService;
	
	public User getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userService.getByEmail(auth.getName());
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView viewPageRegistration() {
		ModelAndView map = new ModelAndView("registration");
		return map;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView registration(
			@RequestParam String firstName,
			@RequestParam String lastName,
			@RequestParam Integer age,
			@RequestParam String email,
			@RequestParam  String password,
			@RequestParam String passwordConfirm,
			@RequestParam MultipartFile image) throws IOException {
		
		ModelAndView map = new ModelAndView("login");
		if(!userService.findByEmail(email)) {
			userService.save(UserHelperDTO.createUser(firstName, lastName, age, email, password, passwordConfirm, image));
		}else {
			map.setViewName("registration");
		}	
		return map;
	}
	
	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}
	
	@RequestMapping(value = "/changeUser", method = RequestMethod.POST)
	public void changeUser(@RequestParam String firstName, @RequestParam String lastName,@RequestParam Integer age, HttpServletRequest req) throws IOException{
		req.setAttribute("mode", "CHANGE_USER");
		userService.update(getCurrentUser(), firstName, lastName, age);
	}
	
	@RequestMapping(value = "/changeUser", method = RequestMethod.GET)
	public ModelAndView changeUser(HttpServletRequest req){
		req.setAttribute("mode", "CHANGE_USER");
		ModelAndView map = new ModelAndView("editProfile");
		return map;
	}
	
	@RequestMapping(value = "/changeFoto", method = RequestMethod.POST)
	public ModelAndView changeFoto(@RequestParam MultipartFile image,HttpServletRequest req) throws IOException {
		req.setAttribute("mode", "CHANGE_FOTO");
		userService.updateFoto(getCurrentUser(), image);
		ModelAndView map = new ModelAndView("editProfile");
		return map;
	}
	
	@RequestMapping(value = "/changeFoto", method = RequestMethod.GET)
	public ModelAndView changeFoto(HttpServletRequest req){
		req.setAttribute("mode", "CHANGE_FOTO");
		ModelAndView map = new ModelAndView("editProfile");
		return map;
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public ModelAndView changePassword(@RequestParam  String password,	@RequestParam String passwordConfirm,HttpServletRequest req) throws IOException {
		req.setAttribute("mode", "CHANGE_PASSWORD");
		userService.updatePassword(getCurrentUser(), password, passwordConfirm);
		ModelAndView map = new ModelAndView("editProfile");
		return map;
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public ModelAndView changePassword(HttpServletRequest req){
		req.setAttribute("mode", "CHANGE_PASSWORD");
		ModelAndView map = new ModelAndView("editProfile");
		return map;
	}
	
	@RequestMapping(value = "/editProfile", method = RequestMethod.GET)
	public ModelAndView viewPageEditProfile(HttpServletRequest req) {
		req.setAttribute("mode", "CHANGE_USER");
		ModelAndView map = new ModelAndView("editProfile");
		return map;
	}
	

}
