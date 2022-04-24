package academy.lgs.selection_committee.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import academy.lgs.selection_committee.domain.Certificate;
import academy.lgs.selection_committee.domain.Faculty;
import academy.lgs.selection_committee.domain.Statment;
import academy.lgs.selection_committee.domain.User;
import academy.lgs.selection_committee.service.CertificateService;
import academy.lgs.selection_committee.service.FacultyService;
import academy.lgs.selection_committee.service.StatmentService;
import academy.lgs.selection_committee.service.UserService;

@Controller
public class StatmentController {
	
	@Autowired
	private StatmentService statmentService;
	
	@Autowired
	private FacultyService facultyService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private CertificateService certificateService;
	
	public User getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userService.getByEmail(auth.getName());
	}
	
	@RequestMapping(value = "/applyToFaculty", method = RequestMethod.GET)
	private ModelAndView getFaculty() {
		ModelAndView map = new ModelAndView("applyToFaculty");
		map.addObject("facultyes", facultyService.getAll());
		return map;
	}

	@RequestMapping(value = "/applyToFaculty", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView addCandidate(@RequestParam Integer facultyId) {

		Statment statment = new Statment();
		User user =  getCurrentUser();
		Faculty faculty = facultyService.getFacultyById(facultyId);
		Certificate certificate = certificateService.getByUserId(user.getId());
		
		boolean findCreateStatmentForUser = statmentService.getAllByUserId(user.getId()).stream().filter(x->x.getFaculty().getId().equals(faculty.getId())).findFirst().isEmpty();
		
		statment.setFaculty(faculty);
		statment.setUser(user);

		if(certificate.getSubject().getTotalGrades() > faculty.getMinimumPassingScore() & 
				findCreateStatmentForUser) {
			
			statmentService.add(statment);
		}
		return new ModelAndView("redirect:/applyToFaculty");
		
	}
	
	@RequestMapping(value = "/viewCandidatesInFaculty", method = RequestMethod.GET)
	private ModelAndView viewCandidatesInFaculty(@RequestParam Integer facultyId,HttpServletRequest req) {
		ModelAndView map = new ModelAndView("statment");
		req.setAttribute("mode", "VIEW_CANDIDATE");
		map.addObject("candidates", statmentService.getUsersByFacultyId(facultyId));
		return map;
	}
	
	@RequestMapping(value = "/viewCandidateInFaculty", method = RequestMethod.GET)
	private ModelAndView viewFaculty(HttpServletRequest req) {
		ModelAndView map = new ModelAndView("statment");
		req.setAttribute("mode", "VIEW_FACULTY");
		map.addObject("faculityes",  facultyService.getAll());
		return map;
	}
	
	@RequestMapping(value = "/viewProfileCandidates", method = RequestMethod.GET)
	private ModelAndView viewProfileCandidates(@RequestParam Integer userId, HttpServletRequest req) {
		req.setAttribute("mode", "VIEW_CANDIDATE");
		ModelAndView map = new ModelAndView("home");
		map.addObject("userViewer",  userService.getById(userId));
		map.addObject( "subjectsViewer", certificateService.getByUserId(userId).getSubject());
		return map;
	}
	
	@RequestMapping(value = "/viewActiveApplyes", method = RequestMethod.GET)
	private ModelAndView viewActiveApplyes(HttpServletRequest req) {
		req.setAttribute("mode", "VIEW_APPLYES");
		ModelAndView map = new ModelAndView("statment");
		map.addObject("usersFacultyes",  statmentService.getFacultyesByUserId(getCurrentUser().getId()));
		return map;
	}
	
	@RequestMapping(value = "/deleteCandidate", method = RequestMethod.GET)
	private ModelAndView deleteCandidate(@RequestParam Integer userId,HttpServletRequest req) {
		req.setAttribute("mode", "VIEW_CANDIDATE");
		statmentService.deleteByUserId(userId);
		return new ModelAndView("redirect:/viewCandidateInFaculty");
	}
	
	@RequestMapping(value = "/deleteFaculty", method = RequestMethod.GET)
	private ModelAndView deleteFaculty(@RequestParam Integer facultyId,HttpServletRequest req) {
		req.setAttribute("mode", "VIEW_APPLYES");
		statmentService.deleteByFacultyId(facultyId);
		return new ModelAndView("redirect:/viewActiveApplyes");
	}
	
}
